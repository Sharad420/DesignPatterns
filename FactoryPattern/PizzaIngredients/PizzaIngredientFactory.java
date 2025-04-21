package PizzaIngredients;
import PizzaIngredients.allIngredients.*;


public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}

// This is an interface for the factory that creates the ingredients for the pizzas.
// Each implementation of this interface will create the ingredients for a specific regional style of pizza.
