__author__ = 'pascalpoizat'

from NamedElement import NamedElement


class App (NamedElement) :
    """
    Application built over bricks.

    """

    def __init__(self, name, states={}, bricks={}) :
        """
        Constructor.

        :param name: String, the name of the application
        :param states: Map[String,State], states of the application
        :param bricks: Map[String,Brick], bricks over which the application operates
        :return:
        """
        NamedElement.__init__(self, name)
        self.states = states
        self.bricks = bricks
