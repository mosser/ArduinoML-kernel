use ArduinoML

application "Multi-state alarm"

sensor button: 9
actuator led: 12
actuator buzzer: 13

state :ready, on_entry: [:led ~> :low, :buzzer ~> :low]
state :noise, on_entry: :buzzer ~> :high
state :light, on_entry: [:buzzer ~> :low, :led ~> :high]

transition from: :ready, to: :noise, when: is_high?(:button)
transition from: :noise, to: :light, when: is_high?(:button)
transition from: :light, to: :ready, when: is_high?(:button)

finished!
