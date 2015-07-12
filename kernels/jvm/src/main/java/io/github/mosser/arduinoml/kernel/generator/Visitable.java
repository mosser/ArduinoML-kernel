package io.github.mosser.arduinoml.kernel.generator;

public interface Visitable {

	public void accept(Visitor visitor);

}
