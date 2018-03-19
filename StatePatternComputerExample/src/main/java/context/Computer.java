package context;

import states.*;

public class Computer {


    private IPowerState currentState;

    public Computer() {
        currentState = new OffState(this);
    }

    public void setState(IPowerState newState) {
        currentState = newState;
    }

    public String getStateText() {
        return currentState.toString();
    }

    public void sendPowerSignal() {
        currentState.receivePowerSignal();
    }

    public void send15Seconds() {
        currentState.plusTime(15);
    }

    public void send5Seconds() {
        currentState.plusTime(5);
    }
}
