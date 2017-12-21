defmodule ArduinoML do
  @moduledoc """
  Contains the definition of the DSL API.
  """

  use Agent

  alias ArduinoML.Application, as: Application
  alias ArduinoML.Brick, as: Brick
  alias ArduinoML.Action, as: Action
  alias ArduinoML.Assertion, as: Assertion
  alias ArduinoML.State, as: State
  alias ArduinoML.Transition, as: Transition
  alias ArduinoML.CodeProducer, as: CodeProducer

  @doc """
  Initializes the application and names it.
  """
  def application(name) do
    Agent.start_link(fn -> %Application{name: name} end, name: __MODULE__)

    :ok
  end

  @doc """
  Adds a sensor to the application.
  """
  def sensor([{label, pin}]) do
    sensor = %Brick{label: label, pin: pin}

    Agent.update(__MODULE__, fn app -> Application.with_sensor(app, sensor) end)

    :ok
  end

  @doc """
  Adds an actuator to the application.
  """
  def actuator([{label, pin}]) do
    actuator = %Brick{label: label, pin: pin}

    Agent.update(__MODULE__, fn app -> Application.with_actuator(app, actuator) end)

    :ok
  end

  @doc """
  Adds a state to the state machine inside the application.
  This version adds a state with only one "on entry" action.
  """
  def state(label, on_entry: action = %Action{}) do
    state(label, on_entry: [action])
  end

  @doc """
  Adds a state to the state machine inside the application.
  This version adds a state with multiple "on entry" actions.
  """
  def state(label, on_entry: actions) when is_list(actions) do
    state = %State{label: label, actions: actions}

    Agent.update(__MODULE__, fn app -> Application.with_state(app, state) end)

    :ok
  end

  @doc """
  Setup the initial state of the inner state machine of the application.
  If this is not used, the initial state is the first declared state.
  """
  def initial(label) do
    Agent.update(__MODULE__, fn app -> Application.with_initial(app, label) end)

    :ok
  end

  @doc """
  Builds an action "set the actuator to the given signal".
  """
  def actuator ~> signal when is_atom(actuator) and is_atom(signal) do
    %Action{actuator_label: actuator, signal: signal}
  end

  @doc """
  Builds an assertion "is the sensor at the given signal?".
  """
  def sensor <~> signal when is_atom(sensor) and is_atom(signal) do
    %Assertion{sensor_label: sensor, signal: signal}
  end

  @doc """
  Builds an assertion "is the sensor at HIGH signal?".
  """
  def is_high?(label), do: label <~> :high

  @doc """
  Builds an assertion "is the sensor at LOW signal?".
  """
  def is_low?(label), do: label <~> :low

  @doc """
  Adds a transition to the state machine inside the application.
  This version adds a transition which is triggered when only one condition is validated.
  """
  def transition(from: from, to: to, when: condition = %Assertion{}) do
    transition(from: from, to: to, when: [condition])
  end

  @doc """
  Adds a transition to the state machine inside the application.
  This version adds a transition which is triggered when multiple conditions are validated.
  """
  def transition(from: from, to: to, when: conditions) when is_list(conditions) do
    transition = %Transition{from: from, to: to, on: conditions}

    Agent.update(__MODULE__, fn app -> Application.with_transition(app, transition) end)
  end

  @doc """
  Validates the described application. Will raise errors if it is not valid.
  """
  def validate! do
    get_application()
    |> validate_application
  end

  @doc """
  Translates the described application into C Arduino code.
  """
  def to_code! do
    case validate!() do
      :ok -> get_application() |> CodeProducer.to_code
      :error -> "// The structure presents defects. The code cannot be generated."
    end
  end

  @doc """
  Translates and displays the described application.
  """
  def finished! do
    to_code!()
    |> IO.puts
  end

  defp get_application do
    Agent.get(__MODULE__, fn app -> app end)
  end

  defp validate_application(app) do
    # TODO Implement the validation.
    :ok
  end
  
end
