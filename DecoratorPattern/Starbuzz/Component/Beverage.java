package Component;

public abstract class Beverage {
    // Need to keep it protected so that the concrete classes can access it.
    public String description = "Unknown beverage";

    // No constructor in the abstract class.

    public String getDescription() {
        return description;
    }

    // This is the only method that must be implemented by the subclasses.
    public abstract double cost();
}
