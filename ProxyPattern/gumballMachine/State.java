
import java.io.Serializable;

// Just extend the Serializable class
public interface State extends Serializable {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
    public void refill(int gumballs);
}

// But there is a problem here. The implementations of State actually take in the gumball machine as an instance variable 
// and calls its methods to change the state of the gumball machine. We don't want the gumball machine to be 
// Serialized and sent as an object everytime, so we use the TRANSIENT keyword.
// The transient keyword tells the JVM not to serialize this field. 
// However, accessing this field after the container object has been sent over the network is dangerous, since it has not been
// serialized, therefore not sent over.