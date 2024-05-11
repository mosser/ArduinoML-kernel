package io.github.mosser.arduinoml.kernel.behavioral;

public enum TimeUnit {
    ms(1), s(1000);

    TimeUnit(int inMillis) {
        this.inMillis = inMillis;
    }

    public final int inMillis;
}
