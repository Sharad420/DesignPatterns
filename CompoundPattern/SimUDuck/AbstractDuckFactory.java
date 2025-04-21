public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}

// Using the abstract factory pattern to create different types of ducks.
// Each implementation of this abstract factory creates a different family of ducks.
// Much like the PizzaIngredientFactor in the pizza example.