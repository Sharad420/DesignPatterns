package Component;
public class Espresso extends Beverage {
    // To take care of the description, we set it in the constructor.
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}