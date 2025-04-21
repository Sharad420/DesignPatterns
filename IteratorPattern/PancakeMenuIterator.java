
import java.util.List;

// Essentially do not need this since arrayLists have their own iterator() method that returns an iterator, which java provides.
public class PancakeMenuIterator implements Iterator {
    List<MenuItem> items;
    int position = 0;

    public PancakeMenuIterator(List<MenuItem> items) {
        this.items = items;
    }

    public MenuItem next() {
        MenuItem menuItem = items.get(position);
        position += 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.size() || items.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }
}