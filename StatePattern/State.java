// Creating the State interface. Using the State pattern to encapsulate state-specific behaviour.
// By using the Stte pattern, we've made it much easier to ad new states to the gumball machine.
// Essential;y, we've closed the gumball machine to modification, but open to extension.
public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
    public void refill(int count);
}
