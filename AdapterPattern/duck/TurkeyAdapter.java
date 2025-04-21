// Implement the interface of they type you're adapting to.
// This is the adapter, implementing the target interface.
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    // Get the reference of the object that we are adapting, get that through the constructor.
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    // Obviously, implement all the methods in the interface by translating the adaptee, that you figure out.
    public void quack() {
        turkey.gobble();
    }

    // Coz turkeys fly a short distance, while ducks fly in long strokes!
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}