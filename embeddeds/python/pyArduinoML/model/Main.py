__author__ = 'pascalpoizat'

"""
no DSL version of the demo application
"""


def demo():
    from pyArduinoML.model.App import App
    from pyArduinoML.model.Action import Action
    from pyArduinoML.model.Actuator import Actuator
    from pyArduinoML.model.Sensor import Sensor
    from pyArduinoML.model.State import State
    from pyArduinoML.model.Transition import Transition
    from pyArduinoML.model.SIGNAL import HIGH, LOW

    button = Sensor("BUTTON", 9)
    led = Actuator("LED", 12)

    on = State("on", [Action(HIGH, led)])
    off = State("off", [Action(LOW, led)])

    switchon = Transition(button, HIGH, on)
    switchoff = Transition(button, HIGH, off)

    on.settransition(switchoff)
    off.settransition(switchon)

    app = App("Switch!", [button, led], [off, on])

    print app


if __name__ == '__main__':
    demo()
