use ArduinoML

application "Switch!"

sensor button: 9
actuator led: 12

state :on, on_entry: :led ~> :high
state :off, on_entry: :led ~> :low

initial :off

transition from: :on, to: :off, when: is_high?(:button)
transition from: :off, to: :on, when: is_high?(:button)

finished!
