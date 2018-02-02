module ArduinoML.Model

import Data.Union

%access public export
%default total

data SIGNAL = LOW | HIGH

Show SIGNAL where
  show LOW = "LOW"
  show HIGH = "HIGH"

record Sensor where
  constructor MkSensor
  name : String
  pin : Integer

record Actuator where
  constructor MkActuator
  name : String
  pin : Integer

Brick : Type
Brick = Union [Sensor, Actuator]

public export
name : Brick -> String
name = foldUnion [name, name]

public export
pin : Brick -> Integer
pin = foldUnion [pin, pin]

record Action where
  constructor MkAction
  actuator : Actuator
  value : SIGNAL

mutual

  record State where
    constructor MkState
    name : String
    transition : Transition
    actions : List Action

  record Transition where
    constructor MkTransition
    sensor : Sensor
    value : SIGNAL
    next : State

record Application where
  constructor MkApp
  name : String
  initial : State
  states : List State
  bricks : List Brick
