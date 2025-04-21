package Decorator;

import Component.Beverage;
import Decorator.CondimentDecorator;

// SteamedMilk is a decorator, so we extend CondimentDecorator.
// Remember that CondimentDecorator extends Beverage.
public class SteamedMilk extends CondimentDecorator {
    // We need to keep a reference to the beverage we are wrapping.
    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    // Now you see why we need to reimplement getDescription.
    public String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
    }

    public double cost() {
        return beverage.cost() + 0.10;
    }
}