
import java.util.ArrayList;
import java.util.List;

// Note that implementatons of this interface can have their own methods. Obviously, only the methods in the interface
// will be available to the client.
// The own methods are usually private.
// public interface Menu {
//     public Iterator<MenuItem> createIterator();
// }

// We are not following the iterator pattern anymore. Since Menu is part of a composition, it extends MenuComponent.
public class Menu extends MenuComponent {
    List<MenuComponent> menuComponents;
    String name;
    String description;

    public Menu(String name, String description) {
        this.menuComponents = new ArrayList<MenuComponent>();
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("--------------");

        // To print each component in the menu, i.e have consistent behaviour across all the subclasses of the component
        // We recurse for the composite.
        // Using java's enhanced for loop
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
            // If it is another component, it recursively prints it.
        }
    }

}