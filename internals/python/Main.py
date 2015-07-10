__author__ = 'pascalpoizat'

"""
no DSL version of the demo application
"""

from Sensor import Sensor
from Actuator import Actuator
from State import State
from Action import Action
from Transition import Transition
from App import App
import SIGNAL

BOUTON = Sensor("BOUTON", 9)
LED = Actuator("LED", 12)

SIG_ALLUMER = Action(SIGNAL.LOW, LED)
SIG_ETEINDRE = Action(SIGNAL.HIGH, LED)

ALLUME = State("ALLUME", None, [SIG_ETEINDRE])
ETEINT = State("ETEINT", None, [SIG_ALLUMER])

ALLUMER = Transition(BOUTON,SIGNAL.HIGH,ALLUME)
ETEINDRE = Transition(BOUTON,SIGNAL.LOW,ETEINT)

bricks = {BOUTON.name: BOUTON, LED.name: LED}
states = {ALLUME.name: ALLUME, ETEINT.name: ETEINT}

APP = App("MonApplication", states, bricks)

print APP
