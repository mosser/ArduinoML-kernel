defmodule ArduinoML do
  @moduledoc """
  Contains the definition of the DSL API.
  """

  alias ArduinoML.Application, as: Application
  alias ArduinoML.Brick, as: Brick
  alias ArduinoML.Action, as: Action
  alias ArduinoML.Assertion, as: Assertion
  alias ArduinoML.State, as: State
  alias ArduinoML.Transition, as: Transition

  @doc """
  Initializes an Arduino application.

  Returns an ArduinoML.Application structure.

  ## Examples

    iex> ArduinoML.application("app")
    %ArduinoML.Application{name: "app", sensors: [], actuators: [], states: [], transitions: [], initial: nil}
  
  """
  def application(name), do: %Application{name: name}

  @doc """
  Replaces the known bindings "sensors ~ pins" for an application.

  Returns the updated ArduinoML.Application.

  ## Examples
  
    iex> ArduinoML.application("app") |> ArduinoML.sensors(button1: 2, button2: 5)
    %ArduinoML.Application{name: "app", sensors: [%ArduinoML.Brick{label: :button1, pin: 2}, %ArduinoML.Brick{label: :button2, pin: 5}], actuators: [], states: [], transitions: [], initial: nil}
    
  """
  def sensors(app, sensors) when is_list(sensors) do
    %Application{app | sensors: to_bricks(sensors)}
  end

  @doc """
  Replaces the known bindings "actuators ~ pins" for an application.

  Returns the updated ArduinoML.Application.
  """
  def actuators(app, actuators) when is_list(actuators) do
    %Application{app | actuators: to_bricks(actuators)}
  end

  defp to_bricks(tokens) when is_list(tokens) do
    Enum.map(tokens, fn {label, pin} -> %Brick{label: label, pin: pin} end)
  end

  @doc """
  Defines a state with no action on opening.

  Returns the updated ArduinoML.Application.
  """
  def state(app, [named: label]) do
    state(app, [named: label, execute: []])
  end

  @doc """
  Defines a state with the lonely action that is executed on state trigger.

  Returns the updated ArduinoML.Application.
  """
  def state(app, [named: label, execute: action]) when is_map(action) do
    state(app, [named: label, execute: [action]])
  end

  @doc """
  Defines a state with the actions that are executed on state trigger.

  Returns the updated ArduinoML.Application.
  """
  def state(app, [named: label, execute: actions]) when is_list(actions) do
    state = %State{label: label, actions: actions}
    
    %Application{app | states: [state | app.states]}
  end

  @doc """
  Specifies the initial state of the application. If not used, the first state is the first specified one.

  Returns the updated ArduinoML.Application.
  """
  def initial(app, label) do
    %Application{app | initial: label}
  end

  @doc """
  Register a new transition from one state to another on the given condition.

  Returns the updated ArduinoML.Application.
  """
  def transition(app, [from: from, to: to, on: assertion]) when is_map(assertion) do
    transition(app, [from: from, to: to, on: [assertion]])
  end

  @doc """
  Register a new transition from one state to another on given conditions.

  Returns the updated ArduinoML.Application.
  """
  def transition(app, [from: from, to: to, on: assertions]) when is_list(assertions) do
    transition = %Transition{from: from, to: to, on: assertions}

    %Application{app | transitions: [transition | app.transitions]}
  end

  @doc """
  Defines an actuator's state changement.

  Returns an ArduinoML.Action which correspond to the expected changement.
  """
  def a ~> b, do: %Action{label: a, signal: b}

  @doc """
  Defines the evaluation of an actuator's state.

  Returns an ArduinoML.Assertion which correspond to this evaluation.
  """
  def a <~> b, do: %Assertion{label: a, signal: b}

  @doc """
  Returns an ArduinoML.Assertion which check if the actuator is in HIGH level.
  """
  def is_high?(label), do: label <~> :high

  @doc """
  Returns an ArduinoML.Assertion which check if the actuator is in LOW level.
  """
  def is_low?(label), do: label <~> :low

  @doc """
  Transpile a ArduinoML.Application structure into a C code string.

  Return the string which correspond to the C code for the application.
  """
  def to_code(app) do
    ArduinoML.CodeProducer.to_code(app)
  end
  
end
