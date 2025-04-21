import interfaces.flyBehavior.FlyWithWings;
import interfaces.quackBehavior.Quack;

// This is the inherited class from Duck.java
// It inherits the instance variables flyBehavior and quackBehavior from the superclass Duck.
// When performFly() and performQuack() are called, the behavior is delegated to the object referenced by flyBehavior and quackBehavior.
public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
