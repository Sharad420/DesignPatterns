package Decorator;

import Component.Beverage;

public abstract class CondimentDecorator extends Beverage {
    // Need a reference to the component we are wrapping.
    protected  Beverage beverage;

    // All condiment decorators need to reimplement getDescription.
    public abstract String getDescription();
}