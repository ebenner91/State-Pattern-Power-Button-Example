package states;

import context.Computer;

public class InitializingState implements IPowerState {

    private Computer computer;
    private int time = 0;

    public InitializingState(Computer computer) {
        this.computer = computer;
    }

    public void receivePowerSignal() {
        computer.setState(new OffState(computer));
    }

    @Override
    public void plusTime(int time) {
        this.time += time;
        if(this.time >= 15) {
            computer.setState(new OnState(computer));
        }
    }

    @Override
    public String toString() {
        return "Initializing...";
    }

}

