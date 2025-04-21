
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.performFly();
        // This changes the behavior of the model duck dynamically at runtime.
        // Composition allows us to change the behavior of the duck at runtime.
        // It will not be locked with the behavior it was instantiated with.
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}