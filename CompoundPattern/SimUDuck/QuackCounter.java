// We want to count the number of quacks across all ducks.
// So we extend a ducks behaviour by wrapping it in a decorator.
// Has to implement the same interface it is wrapping.
public class QuackCounter implements Quackable {
    Observable observable;
    // Contains a reference to the duck object
    Quackable duck;
    // Counting all quacks, so using a static variable to keep track across all classes.
    static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
        observable = new Observable(this);
    }

    public void quack() {
        duck.quack();
        // this is the added behaviour.
        notifyObservers();
        numberOfQuacks++;
    }

    // Why does this method have to be static? Because it is accesssing and returning a static variable.
    public static int getQuacks() {
        return numberOfQuacks;
    }

    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }

    public String toString() {
        return duck.toString();
    }
    
}