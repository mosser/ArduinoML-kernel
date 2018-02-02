defmodule ArduinoML.StateTest do
  use ExUnit.Case
  doctest ArduinoML.State

  test "Should replace the action" do
    action = %ArduinoML.Action{actuator: :led, signal: :low}
    led = %ArduinoML.Brick{label: :led, pin: 1}
    state = %ArduinoML.State{label: :released, actions: [action]}
    application = %ArduinoML.Application{states: [state], actuators: [led]}

    enhanced_action = %ArduinoML.Action{actuator: led, signal: :low}
    
    assert ArduinoML.State.enhanced(:released, application) ==
      %ArduinoML.State{label: :released, actions: [enhanced_action]}
  end
  
end
