
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu{
    List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<MenuItem>();

        addItem("K&B's Pancake Breakfast",
"Pancakes with scrambled eggs and toast",
true,
2.99);
        addItem("Regular Pancake Breakfast",
"Pancakes with fried eggs, sausage",
false,
2.99);
        addItem("Blueberry Pancakes",
"Pancakes made with fresh blueberries",
true,
3.49);
        addItem("Waffles", "Waffles with your choice of blueberries or strawberries",
true,
3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    // public List<MenuItem> getMenuItems() {
    //     return menuItems;
    // }

    // public Iterator createIterator() {
    //     return new PancakeMenuIterator(menuItems);
    // }
    // Java has it's own iterator interface, which has an iterator() method that returns an iterator of the collection, but it only 
    // supports ArrayLists, Vectors and Hashtables. For arrays, we need to implement out own iterator.

    public Iterator<MenuItem> createIterator() {
        // Return the iterator for the menu items. Like PancakeMenuIterator.
        // Use the inbuilt iterator() method of the ArrayList class.
        return menuItems.iterator();
    }

}
