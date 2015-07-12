__author__ = 'pascalpoizat'

from pyArduinoML.model.Brick import Brick

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

    def setup(self):
        """
        Arduino code for the setup of the actuator

        :return: String
        """
        return "\tpinMode(%s, OUTPUT);" % self.name
