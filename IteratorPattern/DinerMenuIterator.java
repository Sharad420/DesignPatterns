import java.util.Iterator;

// We use the iterator interface, but Array does not support the iterator() method. So we implement our own iterator.

public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    // Position maintains the current position of the iteration of the array.
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        // Takes in the menu of items to iterate through.
        this.items = items;
    }

    // Implements the next() and hasNext() methods.

    // MenuItem because we're implementing an Iterator<MenuItem> interface. 
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position += 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Don't try to remove an item from the menu!");
    }
}


// Because the diner chef went ahead and
// The hasNext() method checks to see
// if we’ve seen all the elements of the
// array and returns true if there are
// more to iterate through.

