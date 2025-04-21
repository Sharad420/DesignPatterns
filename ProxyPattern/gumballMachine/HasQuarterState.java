
public class HasQuarterState implements State {
    // In each implementation of State, we add the serialVersionUID foeld.
    private static final long serialVersionUID = 2L;
    transient GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    // Implement the state interface methods.
    public void insertQuarter() {
        System.out.println("You  already inserted a quarter, can't insert another one!");
    }

    public void ejectQuarter() {
        System.out.println("Ejecting quarter. . . ");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank() {
        System.out.println("Turning crank. . .");
        // The sold state handles the dispense() method, which handles what happens when we run out of gumballs.
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("Please wait, we're already giving you a gumball!");
    }

    public void refill(int count) {
        System.out.println("You have inserted a quarter, cannot refill the gumball machine!");
    }
}