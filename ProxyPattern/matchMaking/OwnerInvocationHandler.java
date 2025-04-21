
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Implements the InvocationHandler interface.
public class OwnerInvocationHandler implements InvocationHandler {
    Person person;

    // Constructor takes in a reference to the Person object.
    public OwnerInvocationHandler(Person person) {
        this.person = person;
    }

    // Invocation Handler only has one method, invoke().
    // Gets called everytime a method in invoked on the dynamic proxy.
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            // If method is a getter, we invoke it on the real subject.
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            // owner can't set geek rating, so exception.
            } else if (method.getName().equals("setGeekRating")) {
                throw new IllegalAccessException(); 
            // Onwer can set.
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            // Will happen if the real subject throws an exception.
            e.printStackTrace();
        }
        // Return null otherwise.
        return null;
    }
}
