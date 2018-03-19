package states;

import context.Computer;

public class OnState implements IPowerState {

    private Computer computer;
    private int time = 0;

    public OnState(Computer computer) {
        this.computer = computer;

    }
    public void receivePowerSignal() {
        computer.setState(new HibernatingState(computer));
    }

    @Override
    public void plusTime(int time) {
        this.time += time;

        if(this.time >= 15) {
            computer.setState(new OffState(computer));
        } else if(this.time >= 5) {
            computer.setState(new HibernatingState(computer));
            computer.send5Seconds();
        }
    }

    @Override
    public String toString() {
        return "On";
    }

}

