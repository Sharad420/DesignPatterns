public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    // Implement the state interface methods.
    public void insertQuarter() {
        System.out.println("You inserted a quarter, but the machine is sold out!");
    }

    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter!");
    }

    public void turnCrank() {
        System.out.println("You need to insert a quarter first! Also, the machine is sold out!");
    }

    public void dispense() {
        System.out.println("No gumball dispensed, the machine is sold out!");
    }

    public void refill(int count) {
        System.out.println("Refilling gumball machine with " + count + " gumballs");
        gumballMachine.setCount(gumballMachine.getCount() + count);
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("The machine is still sold out!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

}