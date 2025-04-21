// Remember, the adapter implments the target interface.
// And contains a reference to the adaptee.
public class GooseAdapter implements Quackable {
    Goose goose;
    Observable observable;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        observable = new Observable(this);
    }

    // When quack is called, delegated to honk.
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    // Implement the QuackObservable methods.
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }

    public String toString() {
        return "Goose pretending to be a Duck";
    }
}