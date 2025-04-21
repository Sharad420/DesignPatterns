
import java.rmi.Naming;



public class MyRemoteClient {
    public static void main(String[] args) {
        // There's no constructor here?
        new MyRemoteClient().go();
    }

    public void go() {
        // Get the service object from a remote implementation, using lookup. Note that RMI builds the stub and skeleton.
        try {
            MyRemote service = (MyRemote)Naming.lookup("rmi://127.0.0.1/RemoteHello");
            // Now you can call a method on the remote service.
            String s = service.SayHello();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}