import PizzaStores.*;
import Pizzas.*;

public class PizzaTestDrive {
    public static void main(String[] args) {
        // Create a new NY-style pizza store.
        PizzaStore nyStore = new NYPizzaStore();
        // Create a new Chicago-style pizza store.
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        // Create a new California-style pizza store.
        PizzaStore californiaStore = new CaliforniaPizzaStore();

        // Order a cheese pizza from the NY-style pizza store.
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        // Order a cheese pizza from the Chicago-style pizza store.
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        // Order a cheese pizza from the California-style pizza store.
        pizza = californiaStore.orderPizza("cheese");
        System.out.println("John ordered a " + pizza.getName() + "\n");
    }
}
