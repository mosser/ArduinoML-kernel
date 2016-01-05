# ArduinoML implementation using Groovy

This project is a quick and dirty implementation of the ArduinoML language using Groovy as a host language.

## Intentions

  * Have the easiest syntax possible, undestandable by any "domain" person (ie. knows what is a sensor, button...)

## Limitations

  * Code completion will not be supported by default by Eclipse

## Syntax example

```Groovy
sensor "button" on pin 9
actuator "led" on pin 12

state "on" led is high
initial state "off" led is low

from on to off when button is high
from off to on when button is high

export "Switch!"