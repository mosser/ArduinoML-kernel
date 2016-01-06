# GroovuinoML: ArduinoML implementation using Groovy

This project is a quick and dirty implementation of the ArduinoML language using Groovy as a host language.

## Intentions

  * Have the easiest syntax possible, undestandable by any "domain" person (ie. knows what is a sensor, button...)

## Limitations

  * Code completion will not be supported by default by Eclipse. But it is possible to create the associated DSL Descriptor (https://spring.io/blog/2011/05/09/better-dsl-support-in-groovy-eclipse).

## Syntax example

```Groovy
sensor "button" on pin 9
actuator "led" on pin 12

state "on" led is high
initial state "off" led is low

from on to off when button is high
from off to on when button is high

export "Switch!"
```

## Requirements

  * the project is delivered as a maven 3 artefact
  * The code relies on the [JVM kernel](https://github.com/mosser/ArduinoML-kernel/tree/master/kernels/jvm) defined in this repository 
    * `mvn install` it before compiling or running this example
  * (The code can be compiled using `mvn clean install`)
  * Or an executable jar can be built using `mvn clean compile assembly:single`
  * Then, to run the Switch example:
    * `java -jar target\dsl-groovy-1.0-jar-with-dependencies.jar scripts\Switch.groovy`