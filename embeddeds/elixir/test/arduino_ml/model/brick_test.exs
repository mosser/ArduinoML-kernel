defmodule ArduinoML.BrickTest do
  use ExUnit.Case
  doctest ArduinoML.Action

  test "Should return the structure" do
    led = %ArduinoML.Brick{label: :led, pin: 1}
    application = %ArduinoML.Application{actuators: [led]}

    assert ArduinoML.Brick.enhanced(:led, application.actuators) == led
  end

end
