
import java.util.Enumeration;
import java.util.Iterator;

public class iterationEnumerator implements Enumeration<Object> {
    Iterator<Object> iterator;

    public iterationEnumerator(Iterator<Object> iterator) {
        this.iterator = iterator;
    }

    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    public Object nextElement() {
        return iterator.next();
    }

    // enumerator does not have remove, so no need to implement that.
}