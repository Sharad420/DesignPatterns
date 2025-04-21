public class MallardDuck implements Quackable {
    Observable observable;

    public MallardDuck() {
        // Pass the observable a reference to the duck object.
        observable = new Observable(this);
    }
    
    // The method which needs to be updated to the observers.
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    // The methods delegated to the helper object.
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }

    public String toString() {
        return "Mallard Duck";
    }
}