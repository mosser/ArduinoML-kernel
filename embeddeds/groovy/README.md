# GroovuinoML 
# ArduinoML implementation using Groovy

This project is a quick and dirty implementation of the ArduinoML language using Groovy as a host language.
(Note: groovy means fashionable and exciting)

## Intentions

  * Have the easiest syntax possible, undestandable by any "domain" person (ie. knows what is a sensor, button...)
  * Mix Java and Groovy code to proove it can be used in a Java based application
  * Use method chaining and Groovy's flexible syntax
  * The code could have been shorter in a single file but it is always better to separate the different key parts of the DSL

## Limitations

  * Code completion will not be supported by default by Eclipse. But it is possible to create the associated DSL Descriptor (https://spring.io/blog/2011/05/09/better-dsl-support-in-groovy-eclipse). The DSLD file that you can find in this project works but is not complete. This is more an example than a perfect implementation.
  * The syntax could be improved by using some meta-programming capabilities of Groovy and redefining some reserved keywords like 
  `is`

## Syntax example

```Groovy
sensor "button" pin 9
actuator "led" pin 12

state "on" means led becomes high
state "off" means led becomes low

initial off

from on to off when button becomes high
from off to on when button becomes high

export "Switch!"
```

## Another example
```Groovy
sensor "button" pin 9
actuator "led1" pin 12
actuator "led2" pin 13
actuator "led3" pin 14

state "on" means led1 becomes high and led3 becomes high
state "off" means led1 becomes low and led2 becomes low and led3 becomes low

initial off

from on to off when button becomes high
from off to on when button becomes high

export "Switch!"
```

## An even better example with latest commit, to allow using "" to access values, making the syntax more homogeneous:
```Groovy
sensor "button" pin 9
actuator "led1" pin 12
actuator "led2" pin 13
actuator "led3" pin 14

state "on" means "led1" becomes "high" and "led3" becomes "high"
state "off" means "led1" becomes "low" and "led2" becomes "low" and "led3" becomes "low"

initial "off"

from "on" to "off" when "button" becomes "high"
from "off" to "on" when "button" becomes "high"

export "Switch!"
```

## Requirements

  * The project is delivered as a maven 3 artefact
  * The code relies on the [JVM kernel](https://github.com/mosser/ArduinoML-kernel/tree/master/kernels/jvm) defined in this repository 
    * `mvn install` it before compiling or running this example
  * (The code can be compiled using `mvn clean install`)
  * Or an executable jar can be built using `mvn clean compile assembly:single`
  * Then, to run the Switch example:
    * `java -jar target\dsl-groovy-1.0-jar-with-dependencies.jar scripts\Switch.groovy`
  * ... it is also possible to use the .bat files build.bat and run.bat (Windows)