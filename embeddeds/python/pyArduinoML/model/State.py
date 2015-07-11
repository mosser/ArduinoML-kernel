__author__ = 'pascalpoizat'

from pyArduinoML.model.NamedElement import NamedElement

class State(NamedElement):
    """
    A state in the application.

    """

    def __init__(self, name, actions=[], transition=None):
        """
        Constructor.

        :param name: String, name of the state
        :param actions: List[Action], sequence of actions to do when entering the state (size should be > 0)
        :param transition: Transition, unique outgoing transition
        :return:
        """
        NamedElement.__init__(self, name)
        self.transition = transition
        self.actions = actions

    def setTransition(self, transition):
        """
        Sets the transition of the state
        :param transition: Transition
        :return:
        """
        self.transition = transition
