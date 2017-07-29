type 'a brick
type action = { set : [ `Actuator ] brick; at : bool; }
type transition = {
  when_brick : [ `Sensor ] brick;
  is : bool;
  goto : state;
}
and state = {
  name : string;
  actions : action list;
  transitions : transition list;
}
type app
val ($) : [`Any] brick list -> 'a brick -> [`Any] brick list
val sensor : string -> int -> [`Sensor ] brick
val actuator : string -> int -> [`Actuator ] brick
val action : [ `Actuator ] brick -> bool -> action
val app : string -> [ `Any ] brick list -> state list -> app

val write_app : app -> unit
