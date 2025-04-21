// Interface for our ducks.
// Remember, interfaces cannot implement other interfaces, obviously.
public interface Quackable extends QuackObservable {
    void quack();
}
// Now each concrete implementation is an observable, but delegate 
// The registering and updation to another helper class.