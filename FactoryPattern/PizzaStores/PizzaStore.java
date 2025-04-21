package PizzaStores;

import Pizzas.Pizza;

public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // The createPizza() method is now abstract, so it's up to the subclasses to handle the creation of the pizza.
    // This method acts as a factory method, which is a method that creates objects but defers the exact creation to subclasses.
    protected abstract Pizza createPizza(String type);
    // The subclasses HAVE to implement this method.
}

// v0: The PizzaStore simply instantiated a Pizza object and then called the prepare(), bake(), cut(), and box() methods on it.
// v1: New types of Pizza were needed, so Pizza became an interface, and depending on the type of pizza, a different class was instantiated.
// v2: The createPizza() method was encapsulated into a PizzaFactory class, which was then used by the PizzaStore to create the pizza.
// The PizzaStore was constructed with a reference to the type of factory, and the factory was used to create the pizza.
// But the problem is that the PizzaStore is still tightly coupled to the SimplePizzaFactory. Which was inflexible.
// How was it inflexible? We did not have enough control over what happens once the factory creates the pizza.
// The owners were doing their own thing.
// v3: The PizzaStore was now made abstract, and the createPizza was made abstract as well.
// This way, the subclasses of PizzaStore had to implement the createPizza() method, which gave us more control over the creation of the pizza.
// If a franchise wanted to serve NY-style pizzas, they could use the NYStylePizzaStore subclass which implements its own createPizza() method.
// v4: We're worried about the quality of ingredients being used, so we want to provide these ingredients ourselves. This calls for an ingredient factory.