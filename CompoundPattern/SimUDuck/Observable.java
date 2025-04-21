
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Implements all the functionality that a quackable needs to become an observable.
public class Observable implements QuackObservable {
    // The list of observers each duck will have.
    List<Observer> observers = new ArrayList<Observer>();
    QuackObservable duck;

    // Teh QuackObservable object that is using this object to manage it's observable behaviour is passed.
    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }


    // Notice the updation, we are passing the duck object to the observer, so that the observer knows which duck has quacked.
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update(duck);
        }
    }
}