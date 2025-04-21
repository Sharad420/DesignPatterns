package PizzaIngredients;

import PizzaIngredients.PizzaIngredientFactory;
import PizzaIngredients.allIngredients.*;

// Implements the PizzaIngredientFactory interface to return the ingredients for NY style pizza.
// This is a concrete factory. It creates the ingredients for NY style pizza.
// The clams are fresh, because New York is on the coast. xD
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ThinCrustDough();
    }

    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }   

    public Clams createClam() {
        return new FreshClams();
    }   
    
}
