package Decorator;

import Component.Beverage;
import Decorator.CondimentDecorator;

// Whip is a decorator, so we extend CondimentDecorator.
// Remember that CondimentDecorator extends Beverage.
public class Whip extends CondimentDecorator {
    // We need to keep a reference to the beverage we are wrapping.
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    // Now you see why we need to reimplement getDescription.
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        return beverage.cost() + 0.10;
    }
}