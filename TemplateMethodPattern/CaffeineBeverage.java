public abstract class CaffeineBeverage {
    // Final because no other subclass should change this tmeplate.
    public final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // All these are protected because apart from the subclasses, no one really needs to access these methods.
    // These steps in the algorithm are left for the sublclasses to implement.
    protected abstract void brew();
    protected abstract void addCondiments();

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
}