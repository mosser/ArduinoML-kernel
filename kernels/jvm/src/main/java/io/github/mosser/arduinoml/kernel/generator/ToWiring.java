package io.github.mosser.arduinoml.kernel.generator;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.structural.*;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {
	enum PASS {ONE, TWO}


	public ToWiring() {
		this.result = new StringBuffer();
	}

	private void w(String s) {
		result.append(String.format("%s",s));
	}

	@Override
	public void visit(App app) {
		//first pass, create global vars
		context.put("pass", PASS.ONE);
		w("// Wiring code generated from an ArduinoML model\n");
		w(String.format("// Application name: %s\n", app.getName())+"\n");

		w("long debounce = 200;\n");
		w("\nenum STATE {");
		String sep ="";
		for(State state: app.getStates()){
			w(sep);
			state.accept(this);
			sep=", ";
		}
		w("};\n");
		for (State state: app.getStates()){
			System.out.println(state);
			if (state.getTimer() != null){
				w(String.format("boolean %sStateTimer=%b;\n", state.getName(), state.getTimer().isActive()));
			}
		}
		if (app.getInitial() != null) {
			w("STATE currentState = " + app.getInitial().getName()+";\n");
		}

//		for(Brick brick: app.getBricks()){
		if(app.getBricks().size()>0)
			app.getBricks().get(0).accept(this);
//		}
		//second pass, setup and loop
		context.put("pass",PASS.TWO);
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
		w("\t}\n" +
			"}");
	}

	@Override
	public void visit(Actuator actuator) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("  pinMode(%d, OUTPUT); // %s [Actuator]\n", actuator.getPin(), actuator.getName()));
			return;
		}
	}


	@Override
	public void visit(Sensor sensor) {
		if(context.get("pass") == PASS.ONE) {
			w("boolean bounceGuard = false;\n");
			w("long lastDebounceTime = 0;\n");
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("  pinMode(%d, INPUT);  // %s [Sensor]\n", sensor.getPin(), sensor.getName()));
			return;
		}
	}

	@Override
	public void visit(State state) {
		if(context.get("pass") == PASS.ONE){
			w(state.getName());
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w("\t\tcase " + state.getName() + ":\n");
			for (Action action : state.getActions()) {
				action.accept(this);
			}
			if(state.getTimer() != null){
				w(String.format("\t\t\tif(%sStateTimer){\n", state.getName()));
				w(String.format("\t\t\t\tdelay(%d);\n", state.getTimer().getTime()));
				w("\t\t\t\tcurrentState = " + state.getTransitions().get(0).getNext().getName() + ";\n");
				w("\t\t\t\tbreak;\n");
				w("\t\t\t}\n");
			}
			w("\t\t\tbounceGuard = millis() - lastDebounceTime > debounce;\n");
			for (Transition transition : state.getTransitions()) {
				transition.accept(this);
			}
			w("\t\tbreak;\n");
			return;
		}

	}

	@Override
	public void visit(Transition transition) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {

			w(String.format("\t\t\tif ( bounceGuard "));
			for (Condition condition :transition.getConditions()) {
				w("&& ");
				condition.accept(this);
			}
			w(") {\n");
			w("\t\t\t\tlastDebounceTime = millis();\n");
			w("\t\t\t\tcurrentState = " + transition.getNext().getName() + ";\n");
			w("\t\t\t\tbreak;\n");
			w("\t\t\t}\n");
			return;
		}
	}

	@Override
	public void visit(ExceptionTransition exceptionTransition) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("\t\t\tif ("));
			for (int i = 0; i<exceptionTransition.getCondition().size(); i++) {
				exceptionTransition.getCondition().get(i).accept(this);
				if(i != exceptionTransition.getCondition().size() - 1){
					w(" && ");
				}
			}
			w(") {\n");
			w("\t\t\t\tcurrentState = " + exceptionTransition.getNext().getName() + ";\n");
			w("\t\t\t\tbreak;\n");
			w("\t\t\t}\n");
			return;
		}
	}


	@Override
	public void visit(Condition condition) {
		w(String.format("(digitalRead(%s) == %s) ", condition.getSensor().getPin(), condition.getValue()));
	}

	@Override
	public void visit(ExceptionState state){
		if(context.get("pass") == PASS.ONE) {
			w(state.getName());
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			int pin = state.getActuator().getPin();
			w("\t\tcase " + state.getName() + ":\n");
			w("\t\t\tint counter = 0;\n");
			w("\t\t\tint blinkSpeed = 100;\n");
			w("\t\t\twhile (counter < " + state.getNbBlinking() + ") {\n");
			w("\t\t\t\tdigitalWrite(" + pin + ", HIGH);\n");
			w("\t\t\t\tdelay(blinkSpeed);\n");
			w("\t\t\t\tdigitalWrite(" + pin + ", LOW);\n");
			w("\t\t\t\tdelay(blinkSpeed);\n");
			w("\t\t\t\tcounter++;\n");
			w("\t\t\t}\n");
			w("\t\t\tdelay(1000);\n");
			w("\t\tbreak;\n");
		}
	}


//	@Override
//	public void visit(ExceptionState state) {
//		if(context.get("pass") == PASS.ONE){
//			w(state.getName());
//			return;
//		}
//		if(context.get("pass") == PASS.TWO) {
//			w("\t\tcase " + state.getName() + ":\n");
//			for (Action action : state.getActions()) {
//				action.accept(this);
//			}
//			for (Transition transition : state.getTransitions()) {
//				w("\t\t\tbounceGuard = millis() - lastDebounceTime > debounce;\n");
//				w(String.format("\t\t\tif ( bounceGuard "));
//				for (Item item :transition.getItem()) {
//					item.accept(this);
//				}
//				w(") {\n");
//				w("\t\t\t\tlastDebounceTime = millis();\n");
//				w("\t\t\t\tcurrentState = " + transition.getNext().getName() + ";\n");
//				w("\t\t\t\t//error state \n");
//				w("\t\t\t\tfor (int i = 0; i < "+state.getNbBlinking()+"; ++i) {\n");
//
//				w("\t\t\t\t\tdigitalWrite("+state.getActuator().getPin()+", HIGH);\n");
//				w("\t\t\t\t\tdelay(100);\n");
//				w("\t\t\t\t\tdigitalWrite("+state.getActuator().getPin()+", LOW);\n");
//				w("\t\t\t\t\tdelay(100);\n");
//
//				w("\t\t\t\t}\n");
//				w("\t\t\t\tbreak;\n");
//				w("\t\t\t}\n");
//				return;
//			}
//			w("\t\tbreak;\n");
//			return;
//		}
//	}

	@Override
	public void visit(Action action) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("\t\t\tdigitalWrite(%d,%s);\n",action.getActuator().getPin(),action.getValue()));
			return;
		}
	}

}
