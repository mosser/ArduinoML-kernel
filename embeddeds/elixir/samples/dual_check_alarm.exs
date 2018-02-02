use ArduinoML

application "Dual-check alarm"

sensor button1: 9
sensor button2: 10
actuator buzzer: 12

state :released, on_entry: :buzzer ~> :low
state :pushed, on_entry: :buzzer ~> :high

transition from: :released, to: :pushed, when: is_high?(:button1) and is_high?(:button2)
transition from: :pushed, to: :released, when: is_low?(:button1)
transition from: :pushed, to: :released, when: is_low?(:button2)

finished! :show_me
