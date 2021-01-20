package io.github.mosser.arduinoml.kernel.generator;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.structural.*;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {

	public ToWiring() {
		this.result = new StringBuffer();
	}

	private void w(String s) {
		result.append(String.format("%s",s));
	}

	@Override
	public void visit(App app) {
		w("// Wiring code generated from an ArduinoML model\n");
		w(String.format("// Application name: %s\n", app.getName())+"\n");

		w("long debounce = 200;\n");
		w("\nenum STATE {");
		String sep ="";
		for(State state: app.getStates()){
			w(sep+state.getName());
			sep=", ";
		}
		w("};\n");
		if (app.getInitial() != null) {
			w("STATE currentState = " + app.getInitial().getName()+";\n");
		}

		for(Brick brick: app.getBricks()){
			if (brick instanceof Sensor){ //it may be a button so we may debounce
				w(String.format("\nboolean %sBounceGuard = false;\n", brick.getName()));
				w(String.format("long %sLastDebounceTime = 0;\n", brick.getName()));
			}
		}
		w("\nvoid setup(){\n");
		for(Brick brick: app.getBricks()){
			brick.accept(this);
		}
		w("}\n");

		w("\nvoid loop() {\n" +
			"\tswitch(currentState){\n");
		for(State state: app.getStates()){
			state.accept(this);
		}
		w("\t}\n\t  delay(debounce); //enable the FSM periodically to avoid bouncing effects\n" +
			"}");
	}

	@Override
	public void visit(Actuator actuator) {
	 	w(String.format("  pinMode(%d, OUTPUT); // %s [Actuator]\n", actuator.getPin(), actuator.getName()));
	}


	@Override
	public void visit(Sensor sensor) {
		w(String.format("  pinMode(%d, INPUT);  // %s [Sensor]\n", sensor.getPin(), sensor.getName()));
	}

	@Override
	public void visit(State state) {
		w("\t\tcase "+state.getName()+":\n");
		for(Action action: state.getActions()) {
			action.accept(this);
		}

		if (state.getTransition() != null) {
			state.getTransition().accept(this);
			w("\t\tbreak;\n");
		}

	}

	@Override
	public void visit(Transition transition) {
		String sensorName = transition.getSensor().getName();
		w(String.format("\t\t\t%sBounceGuard = millis() - %sLastDebounceTime > debounce;\n",
				sensorName, sensorName));
		w(String.format("\t\t\tif( digitalRead(%d) == %s) {\n",
				transition.getSensor().getPin(),transition.getValue()));
		w(String.format("\t\t\t\t%sLastDebounceTime = millis();\n", sensorName));
		w("\t\t\t\tcurrentState = "+transition.getNext().getName()+";\n");
		w("\t\t\t}\n");
	}

	@Override
	public void visit(Action action) {
		w(String.format("\t\t\tdigitalWrite(%d,%s);\n",action.getActuator().getPin(),action.getValue()));
	}

}
