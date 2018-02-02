module ArduinoML

import public ArduinoML.Model
import public ArduinoML.Wire
import public Data.Union

%access export

syntax when [s] is [sig] goto [t] = MkTransition s sig t
syntax set [a] to [v] = MkAction a v
syntax state [x] startsWith [as] and [t] = MkState x t as
syntax app [x] withStates [ss] andBricks [bs] startsAs [s] = MkApp x s ss bs
