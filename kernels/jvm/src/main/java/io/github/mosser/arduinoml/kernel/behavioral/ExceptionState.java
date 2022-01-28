package io.github.mosser.arduinoml.kernel.behavioral;


import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.Actuator;

public class ExceptionState extends State {
    private String name;
    private int nbBlinking;
    private Actuator actuator;


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Actuator getActuator() {
        return actuator;
    }

    public void setActuator(Actuator actuator) {
        this.actuator = actuator;
    }

    public void setNbBlinking(int nbBlinking) {
        this.nbBlinking = nbBlinking;
    }

    public int getNbBlinking() {
        return nbBlinking;
    }
}
