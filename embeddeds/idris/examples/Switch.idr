module Main

import ArduinoML

%access public export

button : Sensor
button = MkSensor "button" 9

light : Actuator
light = MkActuator "light" 12

mutual

  offline : State
  offline = state "offline" startsWith [ set light to LOW ]
              and when button is HIGH goto online


  online : State
  online = state "online" startsWith [ set light to HIGH ]
              and when button is HIGH goto offline

switchApp : Application
switchApp = app "Switch" withStates [offline, online]
                         andBricks [member button, member light]
                         startsAs offline
main : IO ()
main = putStrLn (appToWire switchApp)
