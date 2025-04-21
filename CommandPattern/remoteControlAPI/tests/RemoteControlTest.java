import commands.GarageDoorOpenCommand;
import commands.LightOnCommand;
import invokers.SimpleRemoteControl;
import receivers.GarageDoor;
import receivers.Light;


// This is now our client.
public class RemoteControlTest {
    public static void main(String[] args) {
        // Our invoker, which will be passed a concrete command object later to setCommand.
        SimpleRemoteControl remote = new SimpleRemoteControl();
        // Our receiver.
        // Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        // Create a command and pass the receiver in.
        // LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }
}
