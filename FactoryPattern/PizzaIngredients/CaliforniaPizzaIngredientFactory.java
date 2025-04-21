package PizzaIngredients;

import PizzaIngredients.PizzaIngredientFactory;
import PizzaIngredients.allIngredients.*;


public class CaliforniaPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ExtraThinCrustDough();
    }

    public Sauce createSauce() {
        return new CaliforniaSauce();
    }

    public Cheese createCheese() {
        return new CaliforniaCheese();
    }

    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Avocado(), new Spinach(), new Eggplant() };
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    public Clams createClam() {
        return new FreshClams();
    }
    
}
