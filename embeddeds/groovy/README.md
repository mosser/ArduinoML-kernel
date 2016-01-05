# ArduinoML implementation using Groovy

This project is a quick and dirty implementation of the ArduinoML language using Groovy as a host language.

## Intentions

  * loading the DSL should be as easy as mixing a trait
  * we create apps one at a time
  * compatible with classical code completion from the IDE

## Syntax example

```Groovy
sensor "button" on pin 9
actuator "led" on pin 12

state "on" led is high
initial state "off" led is low

from on to off when button is high
from off to on when button is high

export "Switch!"