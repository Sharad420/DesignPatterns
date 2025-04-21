package Component;
public class HouseBlend extends Beverage {
    // To take care of the description, we set it in the constructor.
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        return .89;
    }
}