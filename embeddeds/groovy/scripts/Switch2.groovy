sensor "button" pin 9
actuator "led1" pin 12
actuator "led2" pin 13
actuator "led3" pin 14

state "on" means led1 becomes high
state "off" means led1 becomes low and led2 becomes low and led3 becomes low

initial off

from on to off when button becomes high
from off to on when button becomes high

export "Switch!"