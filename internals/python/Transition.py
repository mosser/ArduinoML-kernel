__author__ = 'pascalpoizat'

class Transition :
    """
    A transition between two states.
    """

    def __init__(self, sensor, value, nextstate):
        """
        Constructor.

        :param sensor: Sensor, sensor which value is checked to trigger the transition
        :param value: SIGNAL, value that the sensor must have to trigger the transition
        :param nextstate: State, state to change to when the transition is triggered
        :return:
        """
        self.sensor = sensor
        self.value = value
        self.nextstate = nextstate
