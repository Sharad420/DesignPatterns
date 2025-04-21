public class Coffee extends CaffeineBeverage {
    // Needs to implement brew() and addocndiments(), the two abstract methods from CaffeineBeverage.
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    protected void addCondiments() {
        System.out.println("Mixing milk and sugar");
    }
}