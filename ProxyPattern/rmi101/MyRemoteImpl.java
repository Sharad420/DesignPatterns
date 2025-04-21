
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Extend UnicastRemoteObject
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    //nicastRemoteObject implements Serializable, so we need the serialVersionUID field.
    private static final long serialVersionUID = 1L;

    // Create a no args constructor that throws an exception
    public MyRemoteImpl() throws RemoteException{}

    public String SayHello() {
        return "Server says hello.";
    }

    // Register with RMI registry.
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            // Bind the service to the registry
            Naming.bind("RemoteHello", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

