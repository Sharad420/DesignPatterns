import java.util.HashMap;
import java.util.Iterator;


// we can just add this to the waitress since she only deals with menus and interfaces.
public class CafeMenu implements Menu {
    // We use a HashMap to store the menu items.
    // HashMap is a collection, so it supports java's iterator() method.
    private HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();

    public CafeMenu() {
        addItem("Veggie Burger and Air Fries",
        "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
        true, 3.99);
        addItem("Soup of the day",
        "A cup of the soup of the day, with a side salad",
        false, 3.69);
        addItem("Burrito",
        "A large burrito, with whole pinto beans, salsa, guacamole",
        true, 4.29);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(name, menuItem);
    }

    // Have to implement the createIterator() method specified in the menu interface.
    public Iterator<MenuItem> createIterator() {
        // Notice iterator is not for entire hash map, but for the values. Values are alsoe stores in a collections object.
        // This however, violates the principle of least knowledge. we are calling a method on an object returned by 
        // Calling another method. Can we fix this? 
        return menuItems.values().iterator();

    }


}


// HashMap is one of the few classes that indirectly supports the iterator() method.