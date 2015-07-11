__author__ = 'pascalpoizat'

class Action :
    """
    An action over a brick, sending a signal to it

    """

    def __init__(self, value, brick) :
        """
        Constructor.

        :param value: SIGNAL, the signal to send
        :param actuator: Brick, the brick concerned by the action
        :return:
        """
        self.value = value
        self.brick = brick