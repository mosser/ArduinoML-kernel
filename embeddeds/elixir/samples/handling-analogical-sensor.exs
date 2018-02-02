use ArduinoML

application "Handling analogical sensor"

sensor temperature: 9, type: :analogic
actuator alarm: 12

state :normal, on_entry: :alarm ~> :low
state :burning, on_entry: :alarm ~> :high

transition from: :normal, to: :burning, when: :temperature > 57
transition from: :burning, to: :normal, when: :temperature < 57

finished! :show_me
