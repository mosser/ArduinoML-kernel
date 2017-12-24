use ArduinoML

application "Very simple alarm"

sensor button: 9
actuator led: 12
actuator buzzer: 13

state :released, on_entry: [:led ~> :low, :buzzer ~> :low]
state :pushed, on_entry: [:led ~> :high, :buzzer ~> :high]

initial :released

transition from: :released, to: :pushed, when: is_high?(:button)
transition from: :pushed, to: :released, when: is_low?(:button)

finished!
