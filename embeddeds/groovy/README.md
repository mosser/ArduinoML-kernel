# GroovuinoML

# ArduinoML implementation using Groovy

This project is a quick and dirty implementation of the ArduinoML language using Groovy as a host language.
*(Note: groovy means fashionable and exciting)*

## Get started (quickly)

The bundled `run.sh` script will build and run the project in a single command. It will also download and install the
required dependencies if they are missing from your system. It's the perfect way to get started quickly! Here are some examples of usage:
```bash
# Run the project with the scripts/Switch.groovy and the first found JAR file
./run.sh

# Run the project with a specific Groovy script file and the first found JAR file
./run.sh <path to the Groovy script file>

# Run the project with a specific Groovy script file and a specific JAR file
./run.sh [-p <path to the project .jar file>] <path to the Groovy script file>
```

> Please note that if your script is named `Example.groovy`, then a file `Example.ino` will be generated in the current
working directory.

That's it! Now you can then upload the file to your Arduino board and have fun.

## Bump to Java 17 🕺

In order to provide a more current implementation of this project with the latest Groovy and Java LTS version, the
project has been bumped to Java 17 and Groovy 4.0.6 (from Java 8 and Groovy 2.3.10, *sic*). The project is now
compatible with the JDK17 which most students run nowadays.

### Maven

As a consequence of bumping the Java version of the kernel and this project to release 17, the compilation methods
described at the end of this README are not up-to-date due to an incompatibility between Java 17 and the Eclipse Maven
Compiler (required for Groovy). Therefore, Maven has been removed from the project.

### Gradle

For reasons given above, this project has been switched over to Gradle. The Gradle build file is located in
the `build.gradle` file.

To build (and package) the project manually, you can build the project and package it through an IDE (Eclipse, IntelliJ,
etc.), as usual, or you can use the Gradle wrapper:

```bash
# Compile and assemble a (fat) JAR with all dependencies
./gradlew shadowJar
```

Alternatively, you can use the `build.sh` script, as it will also install the kernel in your local Maven repository and
package the project in ``build/libs/dsl-groovy-all.jar``.

```bash
# Optional if you plan to use run.sh
./build.sh
```

Then, once the (fat) jar has been assembled, you can run it with:

```bash
# Run the project directly from the JAR
java -jar build\libs\dsl-groovy-all.jar scripts\Switch.groovy > Switch.ino

# Run from the run.sh script (redirects the output to a file named after the script basename)
./run.sh scripts\Switch.groovy
```

## Intentions

* Have the easiest syntax possible, understandable by any "domain" person (ie. knows what is a sensor, button...)
* Mix Java and Groovy code to prove it can be used in a Java based application
* Use method chaining and Groovy's flexible syntax
* The code could have been shorter in a single file, but it is always better to separate the different key parts of the
  DSL

## Limitations

* Code completion will not be supported by default by Eclipse. But it is possible to create the associated DSL
  Descriptor (https://spring.io/blog/2011/05/09/better-dsl-support-in-groovy-eclipse). The DSLD file that you can find
  in this project works but is not complete. This is more an example than a perfect implementation.
* The syntax could be improved by using some meta-programming capabilities of Groovy and redefining some reserved
  keywords like
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

### Current

* **Java 17 (or higher)**
* The project is delivered as a Graddle 7 artefact
* The code relies on the [JVM kernel](https://github.com/mosser/ArduinoML-kernel/tree/master/kernels/jvm) defined in
  this repository
    * `mvn install` it before compiling or running this example
* (The code can be compiled using `./gradlew ./gradlew compileGroovy compileJava`)
* Or an executable jar can be built using `./gradlew shadowJar`
* Then, to run the Switch example:
    * `java -jar build\libs\dsl-groovy-all.jar scripts\Switch.groovy`
* ...it is also possible to use the .bat files build.bat and run.bat (Windows)
* ...and the .sh files build.sh and/or run.sh (macOS/Linux)

### Deprecated

* Java 1.8
* The project is delivered as a Maven 3 artefact
* The code relies on the [JVM kernel](https://github.com/mosser/ArduinoML-kernel/tree/master/kernels/jvm) defined in
  this repository
    * `mvn install` it before compiling or running this example
* (The code can be compiled using `mvn clean install`)
* Or an executable jar can be built using `mvn clean compile assembly:single`
* Then, to run the Switch example:
    * `java -jar target\dsl-groovy-1.0-jar-with-dependencies.jar scripts\Switch.groovy`
* ... it is also possible to use the .bat files build.bat and run.bat (Windows)

> ⚠️ See "Bump to Java 17" section for more information about the new build process.

## Known issues

* You need to apply a chmod +x to the `build.sh` and `run.sh` scripts if you are on Linux or macOS;
* You may need to edit the `build.sh` and `run.sh` scripts to change the path to the `kernels` directory if you are not
  using the whole cloned repository;
* You need to delete the `build` directory if you want to rebuild the kernel (`run.sh` does that for you)