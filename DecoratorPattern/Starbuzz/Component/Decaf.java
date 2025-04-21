package Component;

import Component.Beverage;
// Extends the Beverage class and provides the implementation for the cost() method.
public class Decaf extends Beverage {
    // To take care of the description, we set it in the constructor.
    public Decaf() {
        description = "Decaf";
    }

    public double cost() {
        return 1.05;
    }
}