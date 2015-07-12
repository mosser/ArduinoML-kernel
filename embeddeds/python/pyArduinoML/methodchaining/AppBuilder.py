__author__ = 'pascalpoizat'

from pyArduinoML.model.App import App
from pyArduinoML.methodchaining.BrickBuilder import BrickBuilder
from pyArduinoML.methodchaining.StateBuilder import StateBuilder
from pyArduinoML.methodchaining.BrickBuilder import ACTUATOR, SENSOR


class AppBuilder:
    """
    Builder for the application.
    """

    def __init__(self, name):
        """
        Constructor.

        :param name: String, name of the app
        :return:
        """
        self.name = name
        self.bricks = []  # List[BrickBuider], builders for the bricks
        self.states = []  # List[StateBuilder], builders for the states

    def actuator(self, actuator):
        """
        Adds an actuator brick.

        :param actuator: String, name of the actuator
        :return: BrickBuilder, builder for bricks
        """
        builder = BrickBuilder(self, actuator, ACTUATOR)
        self.bricks.append(builder)
        return builder

    def sensor(self, sensor):
        """
        Adds a sensor brick.

        :param sensor: String, name of the sensor
        :return: BrickBuilder, builder for bricks
        """
        builder = BrickBuilder(self, sensor, SENSOR)
        self.bricks.append(builder)
        return builder

    def state(self, state):
        """
        Adds a state.

        :param state: String, name of the state
        :return: StateBuilder, builder for states
        """
        builder = StateBuilder(self, state)
        self.states.append(builder)
        return builder

    def get_contents(self):
        """
        Builds the app.

        :return: App, the app to be build
        """
        # build the bricks
        bricks = {}  # Map[String, Brick]
        for builder in self.bricks:
            brick = builder.get_contents()
            bricks[brick.name] = brick
        # build the states
        states = {} # Map[String, State]
        # we also use two lists since the ordering is important
        state_names = [] # List[String]
        state_values = [] # List[State]
        for builder in self.states:
            state = builder.get_contents(bricks)
            states[state.name] = state
            state_names += [state.name]
            state_values += [state]
        # build the transitions (2-step pass due to the meta-model)
        for builder in self.states:
            builder.get_contents2(bricks, states)
        # build the app
        return App(self.name, bricks.values(), state_values)
