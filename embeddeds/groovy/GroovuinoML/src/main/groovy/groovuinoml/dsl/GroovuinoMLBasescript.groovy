package main.groovy.groovuinoml.dsl

import io.github.mosser.arduinoml.kernel.behavioral.Action
import io.github.mosser.arduinoml.kernel.behavioral.State;
import io.github.mosser.arduinoml.kernel.structural.Sensor

abstract class GroovuinoMLBasescript extends Script {
	// sensor "name" pin n
	def sensor(String name) {
		[pin: { n -> ((GroovuinoMLBinding)this.getBinding()).getGroovuinoMLModel().createSensor(name, n) }]
	}
	
	// actuator "name" pin n
	def actuator(String name) {
		[pin: { n -> ((GroovuinoMLBinding)this.getBinding()).getGroovuinoMLModel().createActuator(name, n) }]
	}
	
	// state "name" is actuator is signal
	def state(String name) {
		[means: { actuator -> 
			[becomes: { signal ->
				Action action = new Action()
				action.setActuator(actuator)
				action.setValue(signal)
				((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createState(name, Arrays.asList(action))
			}]
		}]
	}
	
	// state state is initial
	def initial(State state) {
		((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().setInitialState(state)
	}
	
	// from state1 to state2 when sensor becomes signal
	def from(State state1) {
		[to: { state2 -> 
			[when: { sensor ->
				[becomes: { signal -> 
					((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().createTransition(state1, state2, sensor, signal)
				}]
			}]
		}]
	}
	
	// export name
	def export(String name) {
		println(((GroovuinoMLBinding) this.getBinding()).getGroovuinoMLModel().generateCode(name).toString())
	}
}
