defmodule ArduinoML.ModelValidatorTest do
  use ExUnit.Case
  doctest ArduinoML.ModelValidator

  import ArduinoML

  test "Should validate a minimalistic correct application" do
    application "Testing!"
    sensor button: 1
    actuator led: 2

    state :released, on_entry: :led ~> :low
    state :pressed, on_entry: :led ~> :high

    transition from: :released, to: :pressed, when: is_high?(:button)
    transition from: :pressed, to: :released, when: is_low?(:button)

    assert ArduinoML.ModelValidator.validate(application!()) == :ok
  end
  
end
