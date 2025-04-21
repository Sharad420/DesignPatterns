package commands;

import receivers.GarageDoor;

public class GarageDoorDownCommand implements Command{
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.down();
        garageDoor.lightOff();
    }

    public void undo() {
        garageDoor.up();
        garageDoor.lightOn();
    }
}
