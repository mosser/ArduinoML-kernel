<!--
            Author: Erick Gallesio [eg@unice.fr]
     Creation date: 28-Nov-2017 09:01
  Last file update: 30-Nov-2017 15:46 (eg)
-->

# ArduinoML implementation in C (using Bison/Flex)

This directory is a quick and dirty implementation of ArduinoML in C.
To parse the language, this implementation uses the Bison and Flex
tools (but classical Yacc an Lex should be fine too).


## Syntax 

The syntax used for this implementation is close to the G4 ANTLR one
used in the original ArduinoML implementation. The main differences with it
are: 

- usage of (old school) semicolon as bricks and actions
  terminators. This permits to have:

    - a better automatic indentation support in editors when they are told
      that their buffer is written in C.
    - a better error recovery (errors use the GNU format). 

- comments use the `//` C++ syntax (for a better fontification when
  buffer is in C mode) 

Here is a simple example: 

```c
application foo {
  // Declaring bricks
  sensor button : 9;
  actuator led  : 11;

  // Declaring states
  on {
    led <= HIGH;
    button is HIGH => off;
  }

  -> off {
    led <= LOW;
    button is HIGH => on;
  }
}
```


## Building the compiler

To build the compiler, just type `make` in the current directory. As
usual, you can clean the directory using the `clean` or `distclan` targets.

The compiler built is named `arduinoml`. It accepts a parameter which
is the `ArduinoML` program to compile (or the standard input). 


## Remark

The current code uses a lot of lists (list of actions, list of states, ...). 
Lists are implemented here in ad-hoc fashion. A generic
lists implementation would probably simplify the writing of
arduino.c, but at the cost of `list.{c,h}` files which would probably
add something like a hundred of lines to this implementation.

## Examples 

The examples are in the directory `Examples`:

  - files named `test*.aml` should produce an output
  - files named `fail*.aml` test variuous compilation errors
  

