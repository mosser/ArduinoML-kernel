use ArduinoML

application "Handling analogical actuator"

sensor button: 9
actuator led: 12, type: :analogic

state :off, on_entry: :led ~> 0
state :on, on_entry: :led ~> 100

transition from: :off, to: :on, when: is_high?(:button)
transition from: :on, to: :off, when: is_low?(:button)

finished! :show_me
