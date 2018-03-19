package states;

import context.Computer;

public class HibernatingState implements IPowerState {

    private Computer computer;
    private int time = 0;

    public HibernatingState(Computer computer) {
        this.computer = computer;
    }
    public void receivePowerSignal() {
        computer.setState(new OffState(computer));
    }

    @Override
    public void plusTime(int time) {
        this.time += time;
        if(this.time >= 15) {
            computer.setState(new OffState(computer));
        }
    }

    @Override
    public String toString() {
        return "Hibernating...";
    }

}

