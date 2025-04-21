public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    // Implement the state interface methods.
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter!");
    }

    public void turnCrank() {
        System.out.println("You need to insert a quarter first!");
    }

    public void dispense() {
        System.out.println("You need to insert a quarter first!");
    }

    public void refill(int count) {
        System.out.println("Refilling gumball machine with " + count + " gumballs");
        gumballMachine.setCount(gumballMachine.getCount() + count);
    }
}