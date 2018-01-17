defmodule ArduinoMLTest do
  use ExUnit.Case
  doctest ArduinoML

  use ArduinoML

  setup _context do
    application "Testing!"

    :ok
  end
  
  test "Should have the specified name" do
    assert application!().name == "Testing!"
  end

  test "Should add a sensor" do
    sensor button: 1
    
    assert application!().sensors == [%ArduinoML.Brick{label: :button, pin: 1}]
  end

  test "Should add an actuator" do
    actuator led: 1
    
    assert application!().actuators == [%ArduinoML.Brick{label: :led, pin: 1}]
  end

  test "Should add a state without 'on-entry' action" do
    state :pressed

    assert application!().states == [%ArduinoML.State{label: :pressed}]
  end
  
  test "Should add a state with one 'on-entry' action" do
    state :pressed, on_entry: :led ~> :high

    assert application!().states == [%ArduinoML.State{label: :pressed, actions: [:led ~> :high]}]
  end

  test "Should add a state with multiple 'on-entry' actions" do
    state :pressed, on_entry: [:led ~> :high, :buzzer ~> :low]

    assert application!().states == [%ArduinoML.State{label: :pressed, actions: [:led ~> :high, :buzzer ~> :low]}]
  end

  test "Should set up the initial state" do
    initial :pressed

    assert application!().initial == :pressed
  end
  
  test "Should build an action with the operator ~>" do
    assert :led ~> :high == %ArduinoML.Action{actuator: :led, signal: :high}
  end

  test "Should build an assertion with the operator <~>" do
    assert :button <~> :high == %ArduinoML.Assertion{sensor: :button, signal: :high, comparison: :equals}
  end

  test "Should build an assertion verifying that the sensor is HIGH" do
    assert is_high?(:button) == %ArduinoML.Assertion{sensor: :button, signal: :high, comparison: :equals}
  end

  test "Should build an assertion verifying that the sensor is LOW" do
    assert is_low?(:button) == %ArduinoML.Assertion{sensor: :button, signal: :low, comparison: :equals}
  end

  test "Should build an assertion verifying that the sensor is less than 2" do
    assert :button < 2 == %ArduinoML.Assertion{sensor: :button, signal: 2, comparison: :lower_than}
  end

  test "Should build an assertion verifying that the sensor is greater than 2" do
    assert :button > 2 == %ArduinoML.Assertion{sensor: :button, signal: 2, comparison: :greater_than}
  end

  test "Should build an assertion verifying that the sensor is at 2" do
    assert :temperature <~> 2 == %ArduinoML.Assertion{sensor: :temperature, signal: 2, comparison: :equals}
  end
  
  test "Should build a list of two assertions with the 'and' operator" do
    given = is_low?(:button1) and is_high?(:button2)

    assert given == [is_low?(:button1), is_high?(:button2)]
  end

  test "Should build a list of three assertions with the 'and' operator" do
    given = is_low?(:button1) and is_high?(:button2) and is_high?(:button3)

    assert given == [is_low?(:button1), is_high?(:button2), is_high?(:button3)]
  end

  test "Should add a transition which is triggered when one condition is validated" do
    transition from: :on, to: :off, when: is_high?(:button)

    assert application!().transitions == [%ArduinoML.Transition{from: :on, to: :off, on: [is_high?(:button)]}]
  end

  test "Should add a transition which is triggered when two conditions are validated" do
    transition from: :on, to: :off, when: is_high?(:button1) and is_low?(:button2)

    assert application!().transitions == [%ArduinoML.Transition{from: :on, to: :off, on: [is_high?(:button1), is_low?(:button2)]}]
  end
  
end
