defmodule ArduinoML.ActionTest do
  use ExUnit.Case
  doctest ArduinoML.Action
  
  test "Should replace the actuator label" do
    action = %ArduinoML.Action{actuator: :led, signal: :low}
    led = %ArduinoML.Brick{label: :led, pin: 1}
    application = %ArduinoML.Application{actuators: [led]}
    
    assert ArduinoML.Action.enhanced(action, application) == %ArduinoML.Action{actuator: led, signal: :low}
  end

  test "Should replace both the actuator and the signal" do
    action = %ArduinoML.Action{actuator: :led, signal: :temperature}
    led = %ArduinoML.Brick{label: :led, pin: 1, type: :analogic}
    temperature = %ArduinoML.Brick{label: :temperature, pin: 2, type: :analogic}
    application = %ArduinoML.Application{actuators: [led], sensors: [temperature]}

    assert ArduinoML.Action.enhanced(action, application) == %ArduinoML.Action{actuator: led, signal: temperature}
  end
  
end

    
