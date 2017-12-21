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

  @doc """
  Adds a sensor to the given application.
  """
  def with_sensor(app, sensor = %Brick{}) do
    %ArduinoML.Application{app | sensors: [sensor | app.sensors]}
  end

  @doc """
  Adds an actuator to the given application.
  """
  def with_actuator(app, actuator = %Brick{}) do
    %ArduinoML.Application{app | actuators: [actuator | app.actuators]}
  end

  @doc """
  Adds a state to the given application.
  """
  def with_state(app, state = %State{}) do
    %ArduinoML.Application{app | states: [state | app.states]}
  end

  @doc """
  Adds a transition to the given application.
  """
  def with_transition(app, transition = %Transition{}) do
    %ArduinoML.Application{app | transitions: [transition | app.transitions]}
  end

  @doc """
  Setup the initial state of the given application.
  """
  def with_initial(app, label) do
    %ArduinoML.Application{app | initial: label}
  end
    
  @doc """
  Returns the label of the initial state of the application.
  """
  def initial(app) when is_map(app) do
    app.initial || app.states[0].label
  end
  
end
