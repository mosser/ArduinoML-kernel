sensor "button_1" pin 8
sensor "button_2" pin 9
actuator "led" pin 10

state "on_light" means "led" becomes high
state "off_light" means "led" becomes low

initial off_light

from "off_light" to on_light when button_1 becomes high
from "off_light" to on_light when button_2 becomes high

from "on_light" to off_light when button_1 becomes low
from "on_light" to off_light when button_2 becomes low

error 3 on led when button_1 becomes high and button_2 becomes high

export "ExceptionThrowing Scenario!"