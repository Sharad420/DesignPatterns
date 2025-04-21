import java.util.Random;

public class HasQuarterState implements State {
    // Add a random number generator to determine if the cusromer is a winner.
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

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
        int winner = randomWinner.nextInt(10);
        // If the customer is a winner, and we have enough gumballs, set the state to WinnerState.
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
        
    }

    public void dispense() {
        System.out.println("Please wait, we're already giving you a gumball!");
    }

    public void refill(int count) {
        System.out.println("You have inserted a quarter, cannot refill the gumball machine!");
    }
}