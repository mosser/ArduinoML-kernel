__author__ = 'pascalpoizat'

from pyArduinoML.model.Action import Action
from pyArduinoML.methodchaining.UndefinedBrick import UndefinedBrick


class StateActionBuilder:
    """
    Builder for actions in states (MethodChaining)
    """

    def __init__(self, root, actuator):
        """
        Constructor.

        :param root: StateBuilder, root builder
        :param actuator: String, name of the actuator to operate on
        :return:
        """
        self.root = root
        self.actuator = actuator
        self.data = None  # SIGNAL, signal to send to the actuator

    def to(self, data):
        """
        Sets the signal to send.

        :param data: SIGNAL, signal to send
        :return: BehaviorBuilder, builder for the behavior
        """
        self.data = data
        return self.root

    def get_contents(self, bricks):
        """
        Builds the action.

        :param bricks: Map[String,Brick] the bricks of the application
        :return: Action, the action to build
        :raises: UndefinedBrick, if the action references an undefined brick
        """
        if self.actuator not in bricks.keys():
            raise UndefinedBrick()
        return Action(self.data, bricks[self.actuator])
