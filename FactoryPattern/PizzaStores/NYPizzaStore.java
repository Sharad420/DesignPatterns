package PizzaStores;

import PizzaIngredients.NYPizzaIngredientFactory;
import PizzaIngredients.PizzaIngredientFactory;
import Pizzas.Pizza;
import Pizzas.pizzaVariants.CheesePizza;
import Pizzas.pizzaVariants.ClamPizza;
import Pizzas.pizzaVariants.PepperoniPizza;
import Pizzas.pizzaVariants.VeggiePizza;



public class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(String item) {
        // The NYPizzaStore creates NY-style pizzas.
        // The NYStylePizzaStore is a subclass of PizzaStore, so it has to implement the createPizza() method.
        // This method is a factory method that creates the pizza.
        // The NyStore is composed of an ingredient factory which will be used to create the pizzas.
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        // For each new pizza, we instantiate the pizza and give it the factory it needs for the ingredients.

        return pizza;
    }
    
}
