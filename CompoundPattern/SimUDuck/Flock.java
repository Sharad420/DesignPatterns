
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// The composite needs to implement the same interface as our leaf elements.
public class Flock implements Quackable {
    // Doesn't really need this but we are keeping it for consistency.
    Observable observable;
    // Using arrayList inside each flock to hold the Quackables.
    List<Quackable> quackers = new ArrayList<Quackable>();


    public Flock() {
        observable = new Observable(this);
    }

    // Adds a Quackable to the flock.
    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    public void quack() {
        // Iterator pattern, uses Java's Collections interface to create an iterator.
        Iterator<Quackable> iterator = quackers.iterator();
        // Loop through the iterator and call quack on each Quackable.
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            // This quacks if it is a leaf element, or just recurses if it is a composite.
            // This is the key to the composite pattern, it allows us to treat
            // composites and leaf elements the same.
            quacker.quack();


             /* Notify the observers of the flock.
            // notifyObservers();
            */
            // Flock does not need to notify observers again, because the leaf elements do so.
            // Honestly, flock doesn't need an Observable nor does it need to implement notifyObservers.
                    
        }
    }

    // Register the observer with each Quackable in the flock.
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.registerObserver(observer);
        }
    }

    // Just for implementation, we are keeping this method.
    public void notifyObservers() {
        // We don't need to notify observers here, because the flock itself is not a leaf element.
        // The leaf elements will notify their observers.
        observable.notifyObservers();
    }
}


// You might remember that in the Composite Pattern chapter the composites (the Menus) and the
// leaves (the MenuItems) had the same exact set of methods, including the add() method. Because
// they had the same set of methods, we could call methods on MenuItems that didn’t really make
// sense (like trying to add something to a MenuItem by calling add()). The benefit of this was that the
// distinction between leaves and composites was transparent: the client didn’t have to know whether
// it was dealing with a leaf or a composite; it just called the same methods on both.
// Here, we’ve decided to keep the composite’s child maintenance methods separate from the leaf
// nodes: that is, only Flocks have the add() method. We know it doesn’t make sense to try to add
// something to a Duck, and in this implementation, you can’t. You can only add() to a Flock. So
// this design is safer—you can’t call methods that don’t make sense on components—but it’s less
// transparent. Now the client has to know that a Quackable is a Flock in order to add Quackables to it.
// As always, there are tradeoffs when you do OO design and you need to consider them as you create
// your own composites.