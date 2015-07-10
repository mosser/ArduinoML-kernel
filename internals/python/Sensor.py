__author__ = 'pascalpoizat'

from Brick import Brick


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
