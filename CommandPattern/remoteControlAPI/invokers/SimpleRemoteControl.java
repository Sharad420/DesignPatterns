package invokers;

import commands.Command;

public class SimpleRemoteControl {
    // This is the invoker which stores the command object and executes it as required.
    // Currently only one slot to hold our command.
    Command slot;
    public SimpleRemoteControl() {

    }

    // Method to set the command, we can change it multiple times.
    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
