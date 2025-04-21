
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MatchMakingTestDrive {
    // Instance variables
    HashMap<String, Person> datingDB = new HashMap<String, Person>();

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    public void drive() {
        // Retrieve from database
        Person joe = getPersonFromDatabase("Joe Javabean"); 
        // Create an owner proxy.
        Person ownerProxy = getOwnerProxy(joe);
        // Set the name and interests.
        // Method called on proxy, which passes it over to the invocationHandler.
        ownerProxy.setInterests("Bowling, Go");
        System.out.println("Interests set from Owner Proxy");
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            System.out.println("Owner proxy can't set geek rating");
        }
        System.out.println("Geek rating is " + ownerProxy.getGeekRating());

        // Create a non-owner proxy.
        Person nonOwnerProxy = getNonOwnerProxy(joe);
        // Setting name and interests must not be allowed.allowed
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("Bowling, Go");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Non-onwer proxy cannot set interests");
        }
        // This shoudl be allowed.
        nonOwnerProxy.setGeekRating(3);
        System.out.println("Rating set from non-owner proxy");
        System.out.println("Geek rating is " + nonOwnerProxy.getGeekRating());
    }

    // Create the dynamic owner and non owner proxies, which java provides and creates at runtime.
    // It creates a proxy that implements the same interface as the subject and passes on method calls to the invocation handler.
    public Person getOwnerProxy(Person person) {
        // Creates the proxy.
        // Passes the Class Loader, the set of interfaces, and the invocationHandler, which 
        // are all required to create the proxy. Pass real subject into constructor of InvocationHandler.
        return (Person) Proxy.newProxyInstance(
            person.getClass().getClassLoader(), 
            person.getClass().getInterfaces(), 
            new OwnerInvocationHandler(person));
    }

    public Person getNonOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
            person.getClass().getClassLoader(), 
            person.getClass().getInterfaces(),
            new NonOwnerInvocationHandler(person));
    }


    // Create a new Person object and add it to the database.
    public void initializeDatabase() {
        Person joe = new PersonImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setGeekRating(7);
		datingDB.put(joe.getName(), joe);

		Person kelly = new PersonImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setGeekRating(6);
		datingDB.put(kelly.getName(), kelly);
    }

    public Person getPersonFromDatabase(String name) {
        // Hash returns an object, so typecast.
        return (Person)datingDB.get(name);
    }
}



// Are there any restrictions on
// the types of interfaces I can pass into
// newProxyInstance()?
// A: Yes, there are a few. First, it
// is worth pointing out that we always
// pass newProxyInstance() an array of
// interfaces—only interfaces are allowed, no
// classes. The major restrictions are that
// all non-public interfaces need to be from
// the same package. You also can’t have
// interfaces with clashing method names
// (that is, two interfaces with a method with
// the same signature). There are a few other
// minor nuances as well, so at some point
// you should take a look at the fine print on
// dynamic proxies in the javadoc.