__author__ = 'pascalpoizat'

"""
no DSL version of the demo application
"""

from Sensor import Sensor
from Actuator import Actuator
from Action import Action
from SIGNAL import *
from State import State
from Transition import Transition
from App import App

button = Sensor("button", 9)
led = Actuator("led", 12)

on = State("on", [Action(HIGH, led)])
off = State("off", [Action(LOW, led)])

switchOn = Transition(button, HIGH, on)
switchOff = Transition(button, LOW, off)

on.setTransition(switchOff)
off.setTransition(switchOn)

app = App("MonApplication", [off, on], [button, led])

print app
