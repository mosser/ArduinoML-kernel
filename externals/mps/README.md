# SEC-Lab1, Step #8

  * M2 IF, ENS Lyon
  * Sébastien Mosser, Université Cote d'Azur, I3S, [email](mailto:mosser@i3s.unice.fr)
  * Laure Gonnord, Université Lyon 1, LIP [email](mailto:laure.gonnord@ens-lyon.fr)
  * Version: 2017.09

## Objectives

  1. Use a DSL workbench to create a language ([MPS](https://confluence.jetbrains.com/display/MPS/Download+MPS)  2017.2)
  2. Uses a template-based code generation approach (TextGen)

## The LED example using MPS

### Creating a new project

We start by creating a new project for a language named ArduinoML, associated to a a _sandbox_ solution (to write programs in ArduinoML) and a _runtime_ solution (for test purpose).

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/1_create_project.png" />
</p>

### Creating the Concepts

Each concept of the ArduinoML abstract syntax tree is modelled as a concept in MPS.

  * The `App`, `Actuator` and `State` concepts implements the `INamedConcept` interface as one can use their `name` to reference it;
  * The `App` concept is considered as a `root`, as it is the entry point of the language;
  * The `SIGNAL` concept is an Enumeration, containing the `HIGH` and `LOW` value. One can change the way the value are displayed using the _presentation_ field;
  * Modelling concepts in MPS:
    * Properties are used to model simple attributes (here the `SIGNAL` to send to a given actuator)
    * Children are used to model elements that are contained by the concept. An element can only be contained by a single container;
    * References are used to link an element to another one.

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/2_concepts.png" />
</p>

Right-click on the project name and select `Make` to synchronise the language with the other solutions (and do this operation each time the tool underlines your models stating that "_generation is required_").

### Creating models 

Using these concepts, one can create a program in ArduinoML. Right-click on the _sandbox_ project and create a new `App` (proposed as it is defined as a _root concept_). In MPS, the syntax is made by _projecting_ the AST, and a default project does exists in the tool. 

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/3_template.png" />
</p>

It is important to notice that you are not editing text, but directly the AST, using a _fill in the blanks_ (the red parts) approach. The LED example is modelled by filling these holes (we added an `isInitial` property in the `State` concept between the 2 screenshots).

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/4_LED.png" />
</p>

### Modifying the projections

The default project has the advantage of existing for free, but is not really user-friendly. To create our own projects, we define _Editors_ associated to the concepts.

MPS provides a DSL to model _editors_. The DSL relies on the definition of collections (horizontal or vertical) to assemble the attributes associated to a given concept in the proper way. This is a tabular approach (which is arguable in terms of design choices and defined syntax) where you need to think of your projection as imbricated boxes. 

One must notice that the automatic completion is mandatory (using CRTL-space) to find the right symbol while defining the projection.

  * `[/` ... `/]`: vertical collection, all elements between these elements will be displayed on a vertical way;
  *  `[>` ... `<]`: horizontal collection;
  * `[-` ... `-]`: horizontal collection supporting indentation , using `--->` to specify the indentation level;
  * `{` x `}`: refers to the property `x` defined in the current concept;
  * `(/ %` x `%` ... `/)`: vertical collection of children nodes defined in `x`.
  * `empty`: an empty line

As we are defining a set of projections, building the language automatically update the `LED` model we defined previously.

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/5_editor.png" />
</p>

### Specifying constraints

Constraints are specified as logical expressions evaluated on concept instances. For example, to specify an invariant stating that a pin associated to an actuator must be in [1,13], we associated a logical check on the `Actuator` concept.

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/6_constraint_pin.png" />
</p>


A more interesting constraints is the unique property associated to the state names. To implement it, we add a constraints that looks inside the state parent node and check for other states with the very same name

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/7_unique_name.png" />
</p>

Constraints are _hard_ properties. One can define more _soft_ guidelines. For example, a single initial state should be defined in the FSM. This is done thanks to a _checking rule_ in the type system definition.

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/8_check_unique.png" />
</p>

### Controlling Scope

Concept instances are linked together at the global level, as it is the default scope in MPS. As a consequence, if one create a second App named `led2` in the sandbox solution, it is possible to refer to actuators or states defined in `led2` inside the `led` application.

MPS provides scoping mechanisms to support this task. To state that the `State` concept must not use the default global scope but an home-made one, we add a constraint to the `State` stating that when looking to fill the `next` reference with a `State`, it must inherit it from something defined in its containment hierarchy.
 
<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/9_scope_inherit.png" />
</p>

We use the `App` concept as our scope provider (it must then implements the `ScopeProvider` interface in addition to the `INamedConcept` one). We create a behaviour associated to the `App` concept, and override (use the CTRL-O shortcut to open a list of overridable methods) the `getScope` method. The implementation is straightforward: if asking for a `State`, we return all the states defined in the App. We do something similar for the actuators, and return `null` when asked for something else.

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/10_behavior.png" />
</p>
 
### Generating code

MPS supports a template based generation mechanism named _TextGen_. It also supports language composition mechanisms, which is more expressive but also more complex. In this lab, we will rely on the simple TextGen.

For each concept, we define a `TextGenComponent` describing how the concept must be projected into plain text. For example, the actuator concept is projected by declaring an integer variable named like the actuator and containing the PIN number. We use the `append` keyword to add text to the generation buffer.

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/11_textgen_act.png" />
</p> 
 
A root concept will also define the generated filename and extension. When appending a model element, TextGen will recursively call the associated template. The system can automatically iterates on a collection of objects, using the `$list` keyword.

<p align="center">
  <img src="https://raw.githubusercontent.com/mosser/sec-labs/master/lab_1/figs/mps/12_textgen_app.png" />
</p>


## Documentation & Bibliography

  * (other) Existing DSL workbenches
    * XText
    * Spoofax
    * MetaEdit 
    * Gemoc Studio
    * ...
  * [MPS documentation](https://confluence.jetbrains.com/display/MPSD20172/MPS+User%27s+Guide) 
    * [Calculator tutorial](https://www.jetbrains.com/help/mps/mps-calculator-language-tutorial.html) 

