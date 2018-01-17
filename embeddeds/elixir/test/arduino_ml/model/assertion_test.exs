defmodule ArduinoML.AssertionTest do
  use ExUnit.Case
  doctest ArduinoML.Assertion

  test "Should replace the sensor and the signal" do
    assertion = %ArduinoML.Assertion{sensor: :button1, signal: :button2, comparison: :equals}
    button1 = %ArduinoML.Brick{label: :button1, pin: 1}
    button2 = %ArduinoML.Brick{label: :button2, pin: 2}
    application = %ArduinoML.Application{sensors: [button1, button2]}

    assert ArduinoML.Assertion.enhanced(assertion, application) ==
      %ArduinoML.Assertion{sensor: button1, signal: button2, comparison: :equals}
  end
  
end
