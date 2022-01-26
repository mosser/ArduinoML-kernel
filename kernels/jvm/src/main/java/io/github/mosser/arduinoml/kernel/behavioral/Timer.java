package io.github.mosser.arduinoml.kernel.behavioral;

public class Timer {
    private boolean isActive = false;
    private int time;

    public Timer(boolean isActive, int time) {
        this.isActive = isActive;
        this.time = time;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "isActive=" + isActive +
                ", time=" + time +
                '}';
    }
}
