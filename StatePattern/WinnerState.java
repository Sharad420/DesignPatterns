public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You already inserted a quarter champ! You're getting an extra gumball!");
    }

    public void ejectQuarter() {
        System.out.println("You have already turned the crank, cannot eject quarter!");
    }

    public void turnCrank() {
        System.out.println("You're already getting an extra gumball!");
    } 

    public void dispense() {
        gumballMachine.releaseBall();
        // Technically don't need these many checks since it is already checked in HasQuarterState.
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            if (gumballMachine.getCount() > 0) {
                gumballMachine.releaseBall();
                System.out.println("CONGRATULATIONS FOR BEING A WINNER!! You're getting an extra gumball!");
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                gumballMachine.setState(gumballMachine.getSoldOutState());
                System.out.println("Out of gumballs, please refill!");
            }
        }

    }

    public void refill(int count) {
        System.out.println("Dispensing gumball, cannot refill the gumball machine!");
    }
}