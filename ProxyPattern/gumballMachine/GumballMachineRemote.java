
import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating a remote interface for the gumball machine. 
public interface GumballMachineRemote extends Remote {
    // Ensuring all args and return types are primitives/Serializable
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    // Note that this is neither, so we convert this into a serializable.
    public State getState() throws RemoteException;
}