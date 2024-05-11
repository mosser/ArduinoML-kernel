//Alan wants to define a state machine where LED1 is switched on
//after a push on button B1 and switched off 800ms after, waiting again for a new push on B1.

sensor "B1" onPin 9
actuator "LED1" pin 12

state "on" means "LED1" becomes "high"
state "off" means LED1 becomes low

initial "off"

from off to on when B1 becomes high
//from on to off after 800.ms
from on to off after 800

export "Switch!"