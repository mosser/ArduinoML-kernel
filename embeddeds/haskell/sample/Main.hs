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

pressed :: Signal
pressed = High

main :: IO ()
main = either print print . fmap generate $ buildApp "example" $ do
  addSensor button $ onPin 9
  addActuator light $ onPin 12
  defineStates [offline, online]
  actionsWhen offline `execute` [ set light `to` off ]
  actionsWhen online  `execute` [ set light `to` on ]
  transitionsFrom online  `are` [ when button `is` pressed $ goto offline ]
  transitionsFrom offline `are` [ when button `is` pressed $ goto online ]
  start offline
