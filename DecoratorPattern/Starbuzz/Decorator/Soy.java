package Decorator;

import Component.Beverage;
import Decorator.CondimentDecorator;

// Soy is a decorator, so we extend CondimentDecorator.
// Remember that CondimentDecorator extends Beverage.
public class Soy extends CondimentDecorator {
    // We need to keep a reference to the beverage we are wrapping.
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    // Now you see why we need to reimplement getDescription.
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return beverage.cost() + 0.15;
    }
}