import Component.*;
import Decorator.*;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        // Espresso, no condiments.
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // Make a DarkRoast object.
        Beverage beverage2 = new DarkRoast();
        // Wrap it with a Mocha.
        // Assigned new behavior to beverage2 at runtime.
        // Using the decorator pattern, we can mix and match decorators to create new combinations.
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        // Make a HouseBlend object.
        Beverage beverage3 = new HouseBlend();
        // Wrap it with a Soy.
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
