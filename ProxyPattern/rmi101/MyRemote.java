
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    // All interface methods throw exception by default, acknowleding the risk.
    // All args and return types are primitives/serializable.
    public String SayHello() throws RemoteException;
}