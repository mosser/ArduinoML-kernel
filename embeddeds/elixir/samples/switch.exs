import ArduinoML

application("Switch!")
|> sensors(button: 9)
|> actuators(led: 12)

|> state(named: :on, execute: :led ~> :high)
|> state(named: :off, execute: :led ~> :low)
|> initial(:off)

|> transition(from: :on, to: :off, on: is_high?(:button))
|> transition(from: :off, to: :on, on: is_high?(:button))

|> to_code
|> IO.puts
