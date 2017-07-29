(* Christophe Papazian 28 Jul 2017 OCaml 4.05.0 *)

type ibrick = Sensor of {name:string; pin:int} | Actuator of {name:string; pin:int}
type 'a brick = ibrick
type action = {set: [`Actuator] brick; at: bool}
type transition = {when_brick : [`Sensor] brick; is : bool; goto: state}
and state = {name : string; actions : action list; transitions : transition list}
type app = {name : string; bricks : [`Any] brick list; states:state list}

let sensor name pin = Sensor {name;pin}
let actuator name pin = Actuator {name;pin}

let ($) l b = b::l

let name = function Sensor {name} | Actuator {name} -> name

let action b o = {set=b; at=o}

let app name bricks states = {name; bricks; states}


let ws b = if b then "HIGH" else "LOW"

let write_action action =
	Printf.printf "\tdigitalWrite(%s,%s);\n" (name action.set) (ws action.at)

let write_transition transition =
	Printf.printf "\tif (digitalRead(%s) == %s && guard) {\n\t\ttime = millis(); state_%s();\n\t} else " (name transition.when_brick) (ws transition.is) (transition.goto.name)

let write_state (state:state) =
	Printf.printf "void state_%s(){\n" state.name;
	List.iter write_action state.actions;
	if List.length state.transitions = 0 then Printf.printf "\tstate_%s();\n" state.name
	else begin
		Printf.printf "\tboolean guard =  millis() - time > debounce;\n";
		List.iter write_transition state.transitions;
		Printf.printf "{\n\t\tstate_%s();\n\t}\n" state.name
	end;
	Printf.printf "}\n\n"

let write_app app =
	List.iter (function Sensor {name;pin} | Actuator {name;pin} -> Printf.printf "int %s=%i;\n" name pin) app.bricks;
	Printf.printf "\nvoid setup() {\n";
	List.iter (function Sensor {name} -> Printf.printf "\tpinMode(%s,INPUT);\n" name
				      | Actuator {name} -> Printf.printf "\tpinMode(%s,OUTPUT);\n" name) app.bricks;
	Printf.printf "}\n\nint state = LOW; int prev = HIGH;\nlong time = 0; long debounce = 200;\n\n";
	List.iter write_state app.states;
	Printf.printf "void loop() { state_%s(); }\n\n" (List.hd app.states).name
