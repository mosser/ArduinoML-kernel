ArduinoML implementation using Shell
====================================

This project is a quick implementation of the ArduinoML language as a
DSL embedded in the Shell.

## Uh, why Shell?

Shell is pretty cool for prototyping DSL, because it gives almost for
free a nice syntax.  For instance:

    app 'Switch!'
    
      sensor BUTTON
        pin 9
    
      actuator LED
        pin 12
    
      state off
        change LED to LOW
        when BUTTON has_value HIGH go_to_state on
    
      state on
        change LED to HIGH
        when BUTTON has_value HIGH go_to_state off
    
	  initial_state off

However, it can very easely lead to mistakes, because there is no good
way to recognise them, and because it is very hard to report them
nicely.  The DSL is also very hard to maintain.


## But... the definition of a DSL in shell must be awful?!

Do you think so?  Here is the definition of a DSL covering the on/off
button example of this repository:

    app           () { elem app                        "$@"; }

    sensor        () { elem app/sensor                 "$@"; }
    actuator      () { elem app/actuator               "$@"; }
    state         () { elem app/state                  "$@"; }
    initial_state () { elem app/initial_state          "$@"; }

    pin           () { elem app/sensor/pin             "$@" 2>/dev/null\
                    || elem app/actuator/pin           "$@"; }
    change        () { elem app/state/change           "$@"; }
    when          () { elem app/state/when             "$@"; }

    to            () { elem app/state/change/to        "$@"; }
    has_value     () { elem app/state/when/has_value   "$@"; }
    go_to_state   () { elem app/state/when/go_to_state "$@"; }

Each element has a "type" that explains where it can be used.  For
instance, the `change` element has type `app/state/change` saying that
it can only be used under a `app/state` context.  If it is not the
case, the definition will raise an error.  A more subtle element is
`pin` that can be used either under the context `app/sensor` or under
the context `app/actuator`.  This can be handled by catching the error
for the first one and trying the other one.

- FIXME: explain how the AST can be handled afterwards

## Requirements

A Shell compatible with the "almost-POSIX"-[shell][debian-policy-10.4]
defined in the Debian policy.  Almost every modern shell that one can
find in Unix distributions should be compatible.


[debian-policy-10.4]: https://www.debian.org/doc/debian-policy/ch-files.html#s-scripts
