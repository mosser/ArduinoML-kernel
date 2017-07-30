package io.github.mosser.arduinoml.embedded.java.dsl;


import io.github.mosser.arduinoml.kernel.behavioral.State;

public class StateBuilder {

    AppBuilder parent;
    State local = new State();

    StateBuilder(AppBuilder parent, String name) {
        this.parent = parent;
        local.setName(name);
    }

    public InstructionBuilder setting(String sensorName) {
        return new InstructionBuilder(this, sensorName);
    }

    public StateBuilder initial() { parent.theApp.setInitial(this.local); return this; }

    public AppBuilder endState() { parent.theApp.getStates().add(this.local); return parent; }

}