# ArduinoML Kernel implementation for the JVM

  * Author: [Sebastien Mosser](mailto?mosser@i3s.unice.fr)
  * Version: 1.0

This is a quick and dirty implementation of the ArduinoML kernel, using the Java language.

## Organization

  * `kernel` contains the `App' concept, which is the root of the abstract syntax.
  * `kernel.structural` defines the concept of `Brick`s, as `Sensor`s and `Actuator`s. It also defines the available
     signals.
  * `kernel.behavioral` implements classes for `State`s, `Action`s and `Transition`s.
  * `kernel.generator` maps a Visitor pattern to the ArduinoML kernel, and provides an implementation for such a visitor
    that generates Wiring code
  * `kernel.samples` contains sample code using the kernel.

## How to work with the kernel

The kernel is shipped as a maven artifact. To compile the kernel into a JAR file (`target/kernel-jvm-1.0.jar`), simply
run the following command (it assumes maven 3 installed on your computer).

    mosser@azrael jvm$ mvn clean package

To install the kernel on your computer and make it available to other maven artifacts, use the following command:

    mosser@azrael jvm$ mvn install

