
import java.util.Enumeration;
import java.util.Iterator;

// Since we're adapting enumeration to iterator, adapter implements the iterator interface.

public class enumerationIterator implements Iterator<Object> {
    Enumeration<?> enumeration;

    // Using object adapter, so instance variable is stored in the implementation.
    public enumerationIterator(Enumeration<?> enumeration) {
        this.enumeration = enumeration;
    }

    // hasNext() is one to one with hasMoreelements()
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    public Object next() {
        return enumeration.nextElement();
    }

    // enumerator does not have remove, so just throw exception. Not a perfect adapter, but it's the 
    // best we have.
    public void remove() {
        throw new UnsupportedOperationException("Adaptee does not support remove()!");
    }
}