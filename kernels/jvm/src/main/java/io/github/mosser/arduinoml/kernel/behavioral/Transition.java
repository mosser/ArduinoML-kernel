package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.*;

public abstract class Transition implements Visitable {

	protected State next;

	public State getNext() {
		return next;
	}

	public void setNext(State next) {
		this.next = next;
	}

	@Override
	public abstract void accept(Visitor visitor);
}
