# Java implementation

  * Author: Sébastien Mosser
  * Version: 1.0 (July 2017)

## Prerequisites

The `pom.xml` file models this project as a Maven one. It reliez on the `kernel-jvm` dependency, which must be installed (as in `mvn install`) before compiling this project. The code also uses lambda-expressions, ans thus requires Java 8.

To run the code, considering the kernel available in the local maven repository:

```
azrael:java mosser$ mvn -q clean package
azrael:java mosser$ mvn -q exec:java
```

## Building a Fluent API

The idea here is to support the definition of an ArduimoML `App` using a fluent syntax, such as :

```java
App myApp = 
    application("red_button")
        .uses(sensor("button", 9))
        .uses(actuator("led", 12))
        .hasForState("on")
            .setting("led").toHigh()
        .endState()
        .hasForState("off").initial()
            .setting("led").toLow()
        .endState()
        .beginTransitionTable()
            .from("on").when("button").isHigh().goTo("off")
            .from("off").when("button").isHigh().goTo("on")
        .endTransitionTable()
    .build();
```

This is supported by a hierarchy of `Builder`s, located in the `dsl` package. To support going up in the hierarchy, a builder often contains a `parent` attribute.
  
## Tricks used inside the DSL

### Builder Visibility

We need to control the way keywords are called in the language. This is done by leveraging the `public` / `package` / `private` visibility available in Java (protected is not used in this example). 

  - We expose as `public` the methods one will use in the API;
  - We expose as `package` the methods that allows a builder to interact with the others, as the code is isolated in a dedicated package;
  - We expose as `private` internal methods (which is classic).

### Static functions

To create the root builder (`AppBuilder`), we expose publicly a static function named `application`. As a consequence, the function can access to the private constructor of `AppBuilder`, and we control the way the builder is initialised. 

We also define two functions (`sensor` and `actuator`) to instantiate the associated instances of the `Brick` concept directly in the API, without requiring a `new` keyword.

### Function nesting vs Builder Chaining


We mainly use _chaining_ here for API definition. However, in the `uses` construction, we rely on two static functions that saves us some verbosity: `sensor` and `actuator`. 

To support chaining, each function defined inside a `Builder` return a `Builder` instance as a pattern (`this` when working at the same level, another sub-builder when going down, and its `parent` when going up).

### Symbol Table vs object handling

In the state definition part, the code in the `StateBuilder` and the one in the `InstructionBuilder` need access to the `App` under construction, breaking the _Law of Demeter_ (for the sake of demonstration). 

In the transition table part, we explicitly instantiate _symbol tables_ that avoid such accesses. 



