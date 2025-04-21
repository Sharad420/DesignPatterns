package commands;

public interface Command {
    public void execute();
    // All we need is one method called execute.
    public void undo();
}