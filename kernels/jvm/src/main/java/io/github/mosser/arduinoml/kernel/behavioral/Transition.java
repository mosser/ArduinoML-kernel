package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;

import java.util.List;

public class Transition implements Visitable {

	private State next;
	private List<Condition> conditions;

	public State getNext() {
		return next;
	}

	public void setNext(State next) {
		this.next = next;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> condition) {
		this.conditions = condition;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
