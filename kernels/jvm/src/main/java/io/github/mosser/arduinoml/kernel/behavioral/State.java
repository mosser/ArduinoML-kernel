package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.NamedElement;
import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;

import java.util.ArrayList;
import java.util.List;

public class State implements NamedElement, Visitable {

	private String name;
	private Timer timer;
	private List<Action> actions = new ArrayList<Action>();
	private List<Transition> transitions = new ArrayList<Transition>();

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transition) {
		this.transitions = transition;
	}

	public void addTransition(Transition transition){
		this.transitions.add(transition);
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	@Override
	public String toString() {
		return "State{" +
				"name='" + name + '\'' +
				", timer=" + timer +
				", actions=" + actions +
				", transitions=" + transitions +
				'}';
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
