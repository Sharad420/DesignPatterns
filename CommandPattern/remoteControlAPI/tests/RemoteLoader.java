import commands.*;
import receivers.*;
import invokers.RemoteControl;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();


        // Create all the devices in their proper locations.
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("Garage");
        Stereo stereo = new Stereo("Living Room");
        HotTub hotTub = new HotTub("Living Room");
        TV tv = new TV("Living Room");


        // the client creates all the command objects.
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        
        GarageDoorOpenCommand garageDoorUp = new GarageDoorOpenCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
        
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        HotTubOnCommand hotTubOn = new HotTubOnCommand(hotTub);
        HotTubOffCommand hotTubOff = new HotTubOffCommand(hotTub);

        TVOnCommand tvOn = new TVOnCommand(tv);
        TVOffCommand tvOff = new TVOffCommand(tv);

        Command[] partyOn = {livingRoomLightOff, stereoOnWithCD, hotTubOn, tvOn};
        Command[] partyOff = {livingRoomLightOn, stereoOff, hotTubOff, tvOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        // Loading commands into the invoker.
        // Can use lambda expressions if the class we're using has only one abstract method.
        // () means the function object takes no arguments. 
        // remember button.addActionListener(event -> System.out.println("Do it!"))?
        // Now that undo method was added to command, you can no longer exploit lambda.
        // remoteControl.setCommand(0, () -> livingRoomLight.on(), () -> livingRoomLight.off());
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
        remoteControl.setCommand(3, ceilingFanLowCommand, ceilingFanOffCommand);
        remoteControl.setCommand(4, ceilingFanMediumCommand, ceilingFanOffCommand);
        remoteControl.setCommand(5, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControl.setCommand(6, hotTubOn, hotTubOff);
        remoteControl.setCommand(7, tvOn, tvOff);
        // Remember it has to be the MacroCommand, which is the concrete implementation of command.
        remoteControl.setCommand(8, partyOnMacro, partyOffMacro);


        // Overriden toString() method.
        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        // Testing undo
        remoteControl.undoButtonWasPushed();
        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();
        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.undoButtonWasPushed();
        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(5);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(8);
        remoteControl.undoButtonWasPushed();

        
        // Note the buttons not set are dealt with the null object instead of coding for null.

    }
}
