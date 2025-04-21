package Component;

import Component.Beverage;
// Extends the Beverage class and provides the implementation for the cost() method.
public class DarkRoast extends Beverage {
    // To take care of the description, we set it in the constructor.
    public DarkRoast() {
        description = "Dark Roast";
    }

    public double cost() {
        return .99;
    }
}