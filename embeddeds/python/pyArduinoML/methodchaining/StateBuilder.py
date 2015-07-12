__author__ = 'pascalpoizat'

from pyArduinoML.model.State import State
from pyArduinoML.model.Transition import Transition
from pyArduinoML.methodchaining.TransitionBuilder import TransitionBuilder
from pyArduinoML.methodchaining.StateActionBuilder import StateActionBuilder
from pyArduinoML.methodchaining.UndefinedBrick import UndefinedBrick
from pyArduinoML.methodchaining.UndefinedState import UndefinedState

class StateBuilder:
    """
    Builder for states.
    """

    def __init__(self, root, state):
        """
        Constructor.

        :param root: BehaviorBuilder, root builder
        :param state: String, state name
        :return:
        """
        self.root = root
        self.state = state
        self.actions = []  # List[StateActionBuilder], builders for the state actions
        self.transition = None  # TransitionBuilder, builder for the state transition (unique in the current meta-model)

    def set(self, actuator):
        """
        Adds an action to the state.

        :param actuator: String, brink the action operates on
        :return: StateActionBuilder, the builder for the action
        """
        action = StateActionBuilder(self, actuator)
        self.actions = self.actions + [action]
        return action

    def when(self, sensor):
        """
        Sets the transition of the state (unique in the current meta-model)

        :param sensor: String, brick to operate on
        :return: TransitionBuilder, the builder for the transition
        """
        transition = TransitionBuilder(self, sensor)
        self.transition = transition
        return transition

    def get_contents(self, bricks):
        """
        Builds the state (step 1)

        :param bricks: Map[String, Brick], the bricks of the application
        :return: State, the state to build

        This method does not builds the transition attribute.
        A 2-step build is required (due to the meta-model) to get references right while avoiding bad typing tricks
        such as passing a TransitionBuilder instead of a Transition.
        """
        return State(self.state, map(lambda builder: builder.get_contents(bricks), self.actions), None)

    def get_contents2(self, bricks, states):
        """
         Builds the state (step 2)

        :param bricks: Map[String,Brick], the bricks of the application
        :param states: Map[String, State], the states of the application
        :return:
        :raises: UndefinedBrick, if the brick the transition operates on is not defined
        :raises: UndefinedState, if the target state is not defined

        This method builds the transition attribute.
        A 2-step build is required (due to the meta-model) to get references right while avoiding bad typing tricks
        such as passing a TransitionBuilder instead of a Transition.
        """
        if self.transition.sensor not in bricks.keys():
            raise UndefinedBrick()
        if self.state not in states.keys():
            raise UndefinedState()
        if self.transition.next_state not in states.keys():
            raise UndefinedState()
        transition = Transition(bricks[self.transition.sensor],
                                self.transition.value,
                                states[self.transition.next_state])
        states[self.state].transition = transition

