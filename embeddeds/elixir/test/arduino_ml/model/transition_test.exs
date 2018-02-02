defmodule ArduinoML.TransitionTest do
  use ExUnit.Case
  doctest ArduinoML.Transition

  test "Should replace from, to and assertion" do
    transition = %ArduinoML.Transition{from: :released, to: :pushed,
				       on: [%ArduinoML.Assertion{sensor: :button, signal: :high}]}
    button = %ArduinoML.Brick{label: :button, pin: 1}
    released = %ArduinoML.State{label: :released}
    pushed = %ArduinoML.State{label: :pushed}
    application = %ArduinoML.Application{states: [pushed, released], sensors: [button]}

    enhanced_assertion = %ArduinoML.Assertion{sensor: button, signal: :high}
    assert ArduinoML.Transition.enhanced(transition, application) == %ArduinoML.Transition{from: released,
											   to: pushed,
											   on: [enhanced_assertion]}
  end

end
