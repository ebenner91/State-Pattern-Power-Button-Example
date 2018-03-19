package states;

import context.Computer;

public class OffState implements IPowerState {

    private Computer computer;
    private int time = 0;

    public OffState(Computer computer) {
        this.computer = computer;
    }
    public void receivePowerSignal() {
        computer.setState(new InitializingState(computer));
    }

    @Override
    public void plusTime(int time) {
        this.time += time;

        //Time doesn't do anything in off state
    }

    @Override
    public String toString() {
        return "Off";
    }
}
