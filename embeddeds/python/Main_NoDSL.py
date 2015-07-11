__author__ = 'pascalpoizat'

"""
no DSL version of the demo application
"""

from Sensor import Sensor
from Actuator import Actuator
from Action import Action
import SIGNAL
from State import State
from Transition import Transition
from App import App

button = Sensor("button", 9)
led = Actuator("led", 12)

on = State("on", [Action(SIGNAL.HIGH, led)])
off = State("off", [Action(SIGNAL.LOW, led)])

switchOn = Transition(button, SIGNAL.HIGH, on)
switchOff = Transition(button, SIGNAL.LOW, off)

on.setTransition(switchOff)
off.setTransition(switchOn)

app = App("MonApplication", [off, on], [button, led])

print app
