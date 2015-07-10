__author__ = 'pascalpoizat'

from Brick import Brick


class Actuator(Brick):
    """
    An actuator.

    """

    def __init__(self, name, pin):
        """
        Constructor.

        :param name: String, name of the actuator
        :param pin: Integer, pin where the actuator is connected
        :return:
        """

        Brick.__init__(self, name, pin)
