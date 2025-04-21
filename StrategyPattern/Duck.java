// This is the superclass of all the duck classes. It contains the behavior that all ducks have in common.

import interfaces.flyBehavior.FlyBehavior;
import interfaces.quackBehavior.QuackBehavior;

public abstract class Duck {
    // Each concrete duck object will assign to these variables a specific behavior at runtime.
    // These are interfaces, so the concrete duck object will implement the concrete behavior.
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void performFly() {
        flyBehavior.fly();
    }

    // Rather than handling the quack behavior itself, the Duck object delegates that behavior to the object referenced by quackBehavior.
    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    // now to set the behavior of the duck dynamically.
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

}