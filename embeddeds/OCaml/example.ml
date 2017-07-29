open ArduinoML

let button = sensor "Button" 9
let led = actuator "LED" 12

let rec on_state = {name="on"; actions=[action led true];
	transitions=[{when_brick=button;is=true;goto=off_state}]}
and off_state = {name="off"; actions=[action led false];
	transitions=[{when_brick=button;is=true;goto=on_state};]}

let app= app "Switch!" ([]$button$led) [off_state; on_state]

let _ = write_app app
