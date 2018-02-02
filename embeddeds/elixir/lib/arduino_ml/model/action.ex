defmodule ArduinoML.Action do
  defstruct actuator: nil, signal: nil

  def enhanced(%{actuator: actuator_label, signal: signal_label}, application) do
    actuator = ArduinoML.Brick.enhanced(actuator_label, application.actuators)
    signal = ArduinoML.Signal.enhanced(signal_label, application)

    %ArduinoML.Action{actuator: actuator, signal: signal}
  end
    
end
