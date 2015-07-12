__author__ = 'pascalpoizat'

from pyArduinoML.model.Actuator import Actuator
from pyArduinoML.model.Sensor import Sensor

ACTUATOR = 0
SENSOR = 1


class BrickBuilder:
    """
    Builder for bricks (MethodChaining)
    """

    def __init__(self, root, name, kind):
        """
        Constructor.

        :param root: AppBuilder, root builder
        :param name: Int, name of the brick
        :param kind: kind of brick to build
        :return:
        """
        self.root = root
        self.name = name
        self.kind = kind
        self.pin = None  # Int, pin of the brick

    def on_pin(self, pin):
        """
        Sets the pin of the brick

        :param pin: Int, pin of the brick
        :return: AppBuilder, builder of the whole application
        """
        self.pin = pin
        return self.root

    def get_contents(self):
        """
        Builds the brick.

        :return: Brick, the brick
        """
        if self.kind == ACTUATOR:
            return Actuator(self.name, self.pin)
        if self.kind == SENSOR:
            return Sensor(self.name, self.pin)
        return None
