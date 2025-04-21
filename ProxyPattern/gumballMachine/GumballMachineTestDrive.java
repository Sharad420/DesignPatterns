
import java.rmi.Naming;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = null;
        int count;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }
        
        // Add the gumball machine service to the RMI registry. 
        // Use try catch to acknowledge the inherent riskiness of network operations.
        try {
            // number of args starts after the class name.
            count = Integer.parseInt(args[1]);
            
            gumballMachine = new GumballMachine(args[0], count);
            // For now, just adding the local host url. 
            Naming.rebind("//127.0.0.1/" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
