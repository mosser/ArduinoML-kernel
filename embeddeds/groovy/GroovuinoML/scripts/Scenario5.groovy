sensor "button" pin 9
actuator "led" pin 10

state "on" means led becomes high
state "off" means led becomes low

initial off

waitFor 1000 when "on"
from on to off when button becomes low
from off to on when button becomes high

export "Scenario5!"