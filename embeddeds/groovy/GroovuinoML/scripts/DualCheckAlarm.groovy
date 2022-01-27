sensor "button1" pin 9
sensor "button2" pin 10
actuator "buzzer" pin 11

state "off" means "buzzer" becomes "low"
state "on" means "buzzer" becomes "high"
state "one_btn_on" means "buzzer" becomes "low"

initial "off"

from "on" to "one_btn_on" when button1 becomes low and button2 becomes high
from "on" to "one_btn_on" when button1 becomes high and button2 becomes low
from "on" to "off" when button1 becomes low and button2 becomes low

from "off" to "one_btn_on" when button1 becomes high and button2 becomes low
from "off" to "one_btn_on" when button1 becomes low and button2 becomes high
from "off" to "on" when button1 becomes high and button2 becomes high

from "one_btn_on" to "on" when button1 becomes high and button2 becomes high
from "one_btn_on" to "off" when button1 becomes low and button2 becomes low

export "DualCheckAlarm!"