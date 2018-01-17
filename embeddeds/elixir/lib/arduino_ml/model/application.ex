defmodule ArduinoML.Application do

  alias ArduinoML.Brick, as: Brick
  alias ArduinoML.State, as: State
  alias ArduinoML.Transition, as: Transition
  
  defstruct name: nil,
    sensors: [],
    actuators: [],
    states: [],
    transitions: [],
    initial: nil


  def state_position(app, state_name), do: app.states |> Enum.find_index(&(&1.label == state_name))
  
  @doc """
  Adds a sensor to the given application.

  Returns the updated application. The new sensor is enqueued to the sensors list.
  
  ## Examples
  
    iex> ArduinoML.Application.with_sensor(%ArduinoML.Application{}, %ArduinoML.Brick{label: :button, pin: 1})
    %ArduinoML.Application{sensors: [%ArduinoML.Brick{label: :button, pin: 1}]}

    iex> ArduinoML.Application.with_sensor(%ArduinoML.Application{sensors: [%ArduinoML.Brick{label: :button, pin: 1}]}, %ArduinoML.Brick{label: :sensor, pin: 2})
    %ArduinoML.Application{sensors: [%ArduinoML.Brick{label: :sensor, pin: 2}, %ArduinoML.Brick{label: :button, pin: 1}]}

  """
  def with_sensor(app, sensor = %Brick{}) do
    %ArduinoML.Application{app | sensors: [sensor | app.sensors]}
  end

  @doc """
  Adds an actuator to the given application.

  Returns the updated application. The new actuator is enqueued to the actuators list.
  
  ## Examples
  
    iex> ArduinoML.Application.with_actuator(%ArduinoML.Application{}, %ArduinoML.Brick{label: :led, pin: 1})
    %ArduinoML.Application{actuators: [%ArduinoML.Brick{label: :led, pin: 1}]}

    iex> ArduinoML.Application.with_actuator(%ArduinoML.Application{actuators: [%ArduinoML.Brick{label: :led, pin: 1}]}, %ArduinoML.Brick{label: :buzzer, pin: 2})
    %ArduinoML.Application{actuators: [%ArduinoML.Brick{label: :buzzer, pin: 2}, %ArduinoML.Brick{label: :led, pin: 1}]}

  """
  def with_actuator(app, actuator = %Brick{}) do
    %ArduinoML.Application{app | actuators: [actuator | app.actuators]}
  end

  @doc """
  Adds a state to the given application.

  Returns the updated application. The new state is enqueued to the states list.
  
  ## Examples
  
    iex> ArduinoML.Application.with_state(%ArduinoML.Application{}, %ArduinoML.State{label: :pressed})
    %ArduinoML.Application{states: [%ArduinoML.State{label: :pressed}]}

    iex> ArduinoML.Application.with_state(%ArduinoML.Application{states: [%ArduinoML.State{label: :pressed}]}, %ArduinoML.State{label: :released})
    %ArduinoML.Application{states: [%ArduinoML.State{label: :released}, %ArduinoML.State{label: :pressed}]}

  """
  def with_state(app, state = %State{}) do
    %ArduinoML.Application{app | states: [state | app.states]}
  end

  @doc """
  Adds a transition to the given application.

  Returns the updated application. The new transition is enqueued to the transitions list.
  
  ## Examples
  
    iex> ArduinoML.Application.with_transition(%ArduinoML.Application{}, %ArduinoML.Transition{to: :pressed})
    %ArduinoML.Application{transitions: [%ArduinoML.Transition{to: :pressed}]}

    iex> ArduinoML.Application.with_transition(%ArduinoML.Application{transitions: [%ArduinoML.Transition{to: :pressed}]}, %ArduinoML.Transition{to: :released})
    %ArduinoML.Application{transitions: [%ArduinoML.Transition{to: :released}, %ArduinoML.Transition{to: :pressed}]}

  """
  def with_transition(app, transition = %Transition{}) do
    %ArduinoML.Application{app | transitions: [transition | app.transitions]}
  end

  @doc """
  Setup the initial state of the given application.

  Returns the updated application. Overwrites the previous initial value if there is one.

  ## Examples
  
    iex> ArduinoML.Application.with_initial(%ArduinoML.Application{}, :first)
    %ArduinoML.Application{initial: :first}

    iex> ArduinoML.Application.with_initial(%ArduinoML.Application{initial: :first}, :second)
    %ArduinoML.Application{initial: :second}

  """
  def with_initial(app, label) do
    %ArduinoML.Application{app | initial: label}
  end
      
  @doc """
  Returns the label of the initial state of the application.

  ## Examples

    iex> ArduinoML.Application.initial(%ArduinoML.Application{states: [%ArduinoML.State{label: :first}]})
    %ArduinoML.State{label: :first}

    iex> ArduinoML.Application.initial(%ArduinoML.Application{initial: :second})
    nil

  """
  def initial(application = %{states: states, initial: initial}) do
    # See with_state/2, the first declared state is the last in the list.
    ArduinoML.State.enhanced(initial || List.last(states).label, application)
  end

  @doc """
  Returns the states with all the bricks references replaced by their structures.
  Basically, it means that the actuators and signals of the actions are replaced.
  """
  def enhanced_states(application) do
    application.states
    |> Enum.map(fn state -> ArduinoML.State.enhanced(state, application) end)
  end

  @doc """
  Returns the transitions with all the bricks references replaced by their structures.
  Bascially, it means that the from, to and the sensors and signals of the transitions are replaced.
  """
  def enhanced_transitions(application) do
    application.transitions
    |> Enum.map(fn transition -> ArduinoML.Transition.enhanced(transition, application) end)
  end

  def enhanced(application) do
    %ArduinoML.Application{sensors: application.sensors,
			   actuators: application.actuators,
			   states: ArduinoML.Application.enhanced_states(application),
			   transitions: ArduinoML.Application.enhanced_transitions(application),
			   initial: ArduinoML.Application.initial(application)}
  end
        
end
