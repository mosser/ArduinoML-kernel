# ArduinoML implementation using Scala

This project is a quick and dirty implementation of the ArduinoML language using Scala as an host language.

## Intentions

  * loading the DSL should be as easy as mixing a trait
  * we create apps one at a time
  * compatible with classical code completion from the IDE

## Syntax example

```Scala
object Switch extends App with ArduinoML {

  this hasForName "Switch!"

  // Declaring the bricks involved in the application
  val button = declare aSensor()    named "button" boundToPin  9
  val led    = declare anActuator() named "led"    boundToPin 12

  // Declaring the two states used to support the behavior
  val on  = state named "on"  executing led --> high
  val off = state named "off" executing led --> low

  // Setting the initial state
  off.isInitial

  // Declaring the transition system
  transitions {
    on -> off when (button is high)
    off -> on when (button is high)
  }

  // Running the code generation tool
  exportToWiring

}
```
## Requirements

  * the project is delivered as a maven 3 artefact
  * The code relies on the [JVM kernel](https://github.com/mosser/ArduinoML-kernel/tree/master/kernels/jvm) defined in this repository 
    * `mvn install` it before compiling or running this example
  * The code can be compiled using `mvn clean package`
  * To run the Switch example:
    * ` mvn -q scala:run -DmainClass=io.github.mosser.arduinoml.samples.Switch`

## Todo list

  * implements checkers in the DSL to verify what we are building
  * update documentation
  * implement more examples
