__author__ = 'pascalpoizat'

class AppStringBuilder:
    """
    Builder for applications from String.
    Enables to get a better formatting at the cost of no auto-completion.
    """

    def __init__(self, value):
        """
        Constructor.

        :param value: String, a string corresponding to a python program for the application
        :return:
        """
        self.value = str.strip(value)

    def __repr__(self):
        """
        External representation: Arduino program

        :return: String
        """
        # add a line continuation after each line but the last
        from pyArduinoML.methodchaining.AppBuilder import AppBuilder
        from pyArduinoML.model.SIGNAL import HIGH, LOW
        program = " \\\n".join(self.value.split('\n'))
        program += " \\\n" + ".get_contents()"
        app = eval(program)
        return app.__repr__()
