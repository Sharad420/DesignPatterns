package Pizzas;

import PizzaIngredients.allIngredients.*;

// This is the abstract class that all pizza types will inherit from.
public abstract class Pizza {
    // Each pizza has a name, a type of dough, a type of sauce, and a list of toppings.
    protected String name;
    // Reworking our pizza class to only use the ingredients provided by the ingredient factory.
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies veggies[];
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clams;

    // prepare is now going to become abstract, because the implementations of pizzas will have different ingredient combinations, and the ingredient factories will 
    // provide the regiional variants.
    public abstract void prepare();

    public void bake() {
        // Baking is the same for all pizzas, so it's implemented here.
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        // code to print pizza here...
        String pizza = "";
        return pizza;
    }
}
