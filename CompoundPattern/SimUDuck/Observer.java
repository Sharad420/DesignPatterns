// The observer interface has one method which takes in a QuackObservable.
// The observable calls the update method, and passes on the QuackObservable associated with the Observable object so 
// The Observer knwos which duck has quacked.
public interface Observer {
    public void update(QuackObservable duck);
}