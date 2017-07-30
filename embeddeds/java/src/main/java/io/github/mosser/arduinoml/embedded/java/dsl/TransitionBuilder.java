package io.github.mosser.arduinoml.embedded.java.dsl;


import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;

public class TransitionBuilder {


    private TransitionTableBuilder parent;

    private Transition local;

    TransitionBuilder(TransitionTableBuilder parent, String source) {
        this.parent = parent;
        this.local = new Transition();
        parent.findState(source).setTransition(local);
    }


    public TransitionBuilder when(String sensor) {
        local.setSensor(parent.findSensor(sensor));
        return this;
    }

    public TransitionBuilder isHigh() {
        local.setValue(SIGNAL.HIGH);
        return this;
    }

    public TransitionBuilder isLow() {
        local.setValue(SIGNAL.LOW);
        return this;
    }

    public TransitionTableBuilder goTo(String state) {
        local.setNext(parent.findState(state));
        return parent;
    }


}
