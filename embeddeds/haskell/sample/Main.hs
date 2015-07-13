module Main where

import ArduinoHS

offline :: String
offline = "offline"

online :: String
online = "online"

button :: String
button = "button"

light :: String
light = "light"

on :: Signal
on = High

off :: Signal
off = Low

pushed :: Signal
pushed = High

released :: Signal
released = Low

main :: IO ()
main = either print (print . generate) $ buildApp "example" $ do
  addSensor button $ onPort 9
  addActuator light $ onPort 12
  initialState offline
  defineState online
  actionsWhen offline `execute` [ set light `to` off ]
  actionsWhen online  `execute` [ set light `to` on ]
  transitionsFrom online  `are` [ when button `is` pushed $ goto offline ]
  transitionsFrom offline `are` [ when button `is` released $ goto online ]
