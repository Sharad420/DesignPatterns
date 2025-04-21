public class SoldState implements State {
    private static final long serialVersionUID = 2L;
    transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You already inserted a quarter, cannot insert another one!");
    }

    public void ejectQuarter() {
        System.out.println("You have already turned the crank, cannot eject quarter!");
    }

    public void turnCrank() {
        System.out.println("You cannot turn the crank again to get another gumball!");
    }

    public void dispense() {
        // We ask the gumball machine to release a gumball.
        gumballMachine.releaseBall();
        // System.out.println("Dispensing a gumball. . . ");
        // Then we ask the machine what the gumball count is, and either transition to NoQuarterState or SOldOutState.
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
            System.out.println("Out of gumballs, please refill!");
        }
    }

    public void refill(int count) {
        System.out.println("Dispensing gumball, cannot refill the gumball machine!");
    }
}