public class MenuItem extends MenuComponent {
    // This inherits MenuComponent, since we need it to be part of a heirarchy.
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    // We have to implement out print method.
    public void print() {
        System.out.print(getName());
        if (isVegetarian()) {
            System.out.println("(v), ");
        }
        System.out.print(getPrice() + " -- ");
        System.out.println(getDescription());
    }
}

// v0: was a standalone entitity which all the chefs used in their menu.
// v1: is now inheriting from MenuComponent, so printing is not the job of the waitress, we override.