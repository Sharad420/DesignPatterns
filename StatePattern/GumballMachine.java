public class GumballMachine {
    // Our states.
    // Now after creating state interfaces, we need to refactor our code to use them and make our code more flexible.

    // final static int NO_QUARTER = 0;
    // final static int QUARTER = 1;
    // final static int SOLD = 2;
    // final static int SOLD_OUT = 3;

    // All the states.
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State soldOutState;
    State winnerState;


    // the instance variables.
    State state;
    int count = 0;

    // Initialize the machine with a count and no quarter.
    // Now, we need to create all the states and set the intiial state of the gumball machine as well.
    public GumballMachine(int count) {

        // Note that the NoQuarterState class takes a GumballMachine. It's kinda recursive.
        // Java allows passing this from inside the constructor
        // — it's not unsafe as long as you're careful not to use the object before it's fully initialized. 
        // This is a common pattern in Java, and it's used here to allow the state classes to interact with the GumballMachine instance.
        // This is a safe practice if:
            // You don’t use the this reference to call methods or access uninitialized fields before the constructor finishes.
            // You’re just passing it to another object to store for later use — as is the case here.
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.winnerState = new WinnerState(this);
        this.count = count;

        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    // The state transitions aka the methods forming the gumball machine interface.
    public void insertQuarter() {
        // Navigate the state transitions with if else, or switch statements.
        // if (state == NO_QUARTER) {
        //     state = QUARTER;
        //     System.out.println("You have inserted a quarter");
        // } else if (state == QUARTER) {
        //     System.out.println("Can't insert another quarter!");
        // } else if (state == SOLD) {
        //     System.out.println("Please wait, we're already giving you a gumball");
        // } else if (state == SOLD_OUT) {
        //     System.out.println("Can't insert quarter, there are no gumballs!");
        // }
        // Remove these badly designed if else statements and use state patterns instead.
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    // We don't need an action method for dispense because it's an internal action, the user can't call dispanse.
    public void turnCrank() {
        // Determines if the state becomes winner or sold.
        state.turnCrank();
        state.dispense();
    }

    // Add toString method.
    @Override
    public String toString() {
        return """
               Mighty Gumball, Inc.
               Java-enabled Standing Gumball Model #2025
               Inventory:  """ + count + " gumballs\n" +
               "Machine is waiting for quarter";
    }
    
    public void refill(int gumballs) {
        state.refill(gumballs);
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void releaseBall() {
        if (count > 0) {
            System.out.println("A gumball comes rolling out of the slot . . .");
            count--;
        } else {
            System.out.println("No gumball dispensed, the machine is sold out!");
        }
    }

    // Getters and setters for the states.
    public void setState(State state) {
        this.state = state;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }
}