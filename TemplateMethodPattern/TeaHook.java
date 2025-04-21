

public class TeaHook extends CaffeineBeverageWithHook {
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    protected void addCondiments() {
        System.out.println("Adding honey and lemon");
    }

    // Notice we're not using the hook, but we could if we wanted to.
}