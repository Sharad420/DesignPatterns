
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// GumballMachine is going to subclass the UnicastRemoteObject; this gives it the ability to act as a remote service.
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    // UnicastRemoteObject implements Serializable, so we need the serialVersionUID field.
    private static final long serialVersionUID = 2L;
    // Other instance variables.
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state = soldOutState;
    int count = 0;
    String location;

    // Constructor 
    // The contructor throws a remote exception, because the superclass does.
    public GumballMachine(String location, int count) throws RemoteException {
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.count = count;
        this.location = location;

        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    // The state transisiton methods.
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
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

    // Implement the GumballMachineRemote methods.
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public State getState() {
        return state;
    }
}