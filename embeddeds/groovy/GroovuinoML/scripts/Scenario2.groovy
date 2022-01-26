sensor "button1" pin 9
sensor "button2" pin 10
actuator "buzzer" pin 11

state "both_off" means "buzzer" becomes "low"
state "both_on" means "buzzer" becomes "high"
state "one_btn_on" means "buzzer" becomes "low"

initial "both_off"

from "both_off" to "one_btn_on" when button1 becomes high and button2 becomes low
from "both_off" to "one_btn_on" when button1 becomes low and button2 becomes high
from "both_off" to "both_on" when button1 becomes high and button2 becomes high

from "one_btn_on" to "both_on" when button1 becomes high and button2 becomes high
from "one_btn_on" to "both_off" when button1 becomes low and button2 becomes low

from "both_on" to "one_btn_on" when button1 becomes low and button2 becomes high
from "both_on" to "one_btn_on" when button1 becomes high and button2 becomes low
from "both_on" to "both_off" when button1 becomes low and button2 becomes low

export "Scenario2!"