public class CoffeeTestDrive {
    public static void main (String[] args) {
        TeaHook tea = new TeaHook();
        CoffeeHook coffee = new CoffeeHook();

        System.out.println("\nMaking tea . . .");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee . . .");
        coffee.prepareRecipe();
    }
}