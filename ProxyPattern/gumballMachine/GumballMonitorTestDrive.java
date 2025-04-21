
import java.rmi.Naming;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        // All the locations we're going ot monitor.
        String[] locations = {
            "rmi://127.0.0.1/santafe/gumballmachine",
            "rmi://127.0.0.1/boulder/gumballmachine",
            "rmi://127.0.0.1/seattle/gumballmachine"
        };
        

        // Create an array of gumballmonitors.
        GumballMonitor[] monitors = new GumballMonitor[locations.length];

        for (int i = 0; i < locations.length; i++) {
            try {
                // Typecast the returned remote object to a GumballMachineRemote.
                // Use the lookup table to get the remote object.
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(locations[i]);
                monitors[i] = new GumballMonitor(machine);
                System.out.println(monitors[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
        }
    }
}
