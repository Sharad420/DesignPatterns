public class ChocolateBoilerTest {
    public static void main(String[] args) {
        // Get the only instance of ChocolateBoiler
        // ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
        // ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
        ChocolateBoiler boiler1 = ChocolateBoiler.UNIQUEBOILER;
        ChocolateBoiler boiler2 = ChocolateBoiler.UNIQUEBOILER;

        // Check if both references point to the same instance
        System.out.println("boiler1 and boiler2 are the same instance: " + (boiler1 == boiler2));

        // Initial state check
        System.out.println("Is Empty: " + boiler1.isEmpty()); // true
        System.out.println("Is Boiled: " + boiler1.isBoiled()); // true

        // Fill the boiler
        boiler1.fill();
        System.out.println("Filled the boiler.");

        // Check state after filling
        System.out.println("Is Empty: " + boiler1.isEmpty()); // false
        System.out.println("Is Boiled: " + boiler1.isBoiled()); // false

        // Boil the chocolate
        boiler1.boil();
        System.out.println("Boiled the chocolate.");

        // Check state after boiling
        System.out.println("Is Empty: " + boiler1.isEmpty()); // false
        System.out.println("Is Boiled: " + boiler1.isBoiled()); // true

        // Drain the boiler
        boiler1.drain();
        System.out.println("Drained the boiler.");

        // Final state check
        System.out.println("Is Empty: " + boiler1.isEmpty()); // true
    }
}
