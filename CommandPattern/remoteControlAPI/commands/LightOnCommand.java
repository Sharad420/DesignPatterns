package commands;

import receivers.Light;

// This is a command, so we need to implement the command interface.
public class LightOnCommand implements Command {
    Light light;

    // The specific light that this command is going to control is passed. The command object consists of a set of actions on a Receiver, i.e the light. 
    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
