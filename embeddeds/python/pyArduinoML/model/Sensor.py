__author__ = 'pascalpoizat'

from pyArduinoML.model.Brick import Brick

class Sensor(Brick):
    """
    A sensor.

    """

    def __init__(self, name, pin):
        """
        Constructor.

        :param name: String, name of the sensor
        :param pin: Integer, pin where the sensor is connected
        :return:
        """
        Brick.__init__(self, name, pin)

    def setup(self):
        """
        Arduino code for the setup of the sensor

        :return: String
        """
        return "\tpinMode(%s, INPUT);" % self.name
