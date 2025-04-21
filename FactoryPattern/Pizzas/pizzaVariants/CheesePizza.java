package Pizzas.pizzaVariants;

import Pizzas.Pizza;
import PizzaIngredients.*;
import PizzaIngredients.allIngredients.*;

public class CheesePizza extends Pizza {
    // To make a pizza now, we need a factory to provide the ingredients. So each pizza class gets a factory passed into its constructor.
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        // Each time it needs an ingredient, it asks the factory to produce it.
    }
}
