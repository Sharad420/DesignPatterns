// Create the client that will invoke methods from the remote object.
public class GumballMonitor {
    // Can import this package if it is over a network.
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        // Relying on the interface rather than the implemntatioin.
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
            System.out.println("Current state: " + machine.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
