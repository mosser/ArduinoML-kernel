__author__ = 'pascalpoizat'


class Action :
    """
    An action over a brick, sending a signal to it

    """

    def __init__(self, value, actuator) :
        """
        Constructor.

        :param value: SIGNAL, the signal to send
        :param actuator: Actuator, the actuator to send the signal to
        :return:
        """

        self.value = value
        self.actuator = actuator