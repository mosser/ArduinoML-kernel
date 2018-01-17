defmodule ArduinoML.SignalTest do
  use ExUnit.Case
  doctest ArduinoML.Action

  test "Should not replace an integer" do
    assert ArduinoML.Signal.enhanced(2, %ArduinoML.Application{}) == 2
  end

  test "Should not replace LOW or HIGH" do
    assert ArduinoML.Signal.enhanced(:low, %ArduinoML.Application{}) == :low
    assert ArduinoML.Signal.enhanced(:high, %ArduinoML.Application{}) == :high
  end

  test "Should replace the labelled signal" do
    button = %ArduinoML.Brick{label: :button, pin: 1}
    application = %ArduinoML.Application{sensors: [button]}

    assert ArduinoML.Signal.enhanced(:button, application) == button
  end

  test "Should recognize a constant digital signal" do
    assert ArduinoML.Signal.digital?(:low)
    assert ArduinoML.Signal.digital?(:high)
    assert not ArduinoML.Signal.digital?(1)
  end

  test "Should recognize a variable digital signal" do
    assert ArduinoML.Signal.digital?(%ArduinoML.Brick{label: :button, pin: 1})
  end
  
  test "Should recognize a constant analogic signal" do
    assert not ArduinoML.Signal.analogic?(:low)
    assert not ArduinoML.Signal.analogic?(:high)
    assert ArduinoML.Signal.analogic?(4)
  end

  test "Should recognize a variable analogic signal" do
    assert ArduinoML.Signal.analogic?(%ArduinoML.Brick{label: :temperature, pin: 1, type: :analogic})
  end
    
end

