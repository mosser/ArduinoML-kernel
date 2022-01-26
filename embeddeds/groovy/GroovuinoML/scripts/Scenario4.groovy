sensor "button" pin 9
actuator "buzzer" pin 11
actuator "led" pin 12

state "button_push_once" means led becomes high and buzzer becomes low
state "button_push_twice" means led becomes low and buzzer becomes high
state "button_off" means led becomes low and buzzer becomes low

initial button_off

from button_off to button_push_once when button becomes high
from button_push_once to button_push_twice when button becomes high
from button_push_twice to button_off when button becomes high

export "Scenario4!"