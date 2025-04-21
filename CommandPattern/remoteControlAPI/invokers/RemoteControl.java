package invokers;

import commands.*;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl () {
        onCommands = new Command[9];
        offCommands = new Command[9];
        
        Command noCommand = new NoCommand();
        for (int i = 0; i < onCommands.length; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        undoCommand = new NoCommand();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        // Updating undo to be the last executed command's reverse.
        // The problem is the ceiling fan's state is not being taken into account, it's just switching off.
        // Realised I'm not using the undo() method of the command object at all.
        // undoCommand = offCommands[slot];
        // Every command has it's onw undo implementation.
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
        // undoCommand = onCommands[slot];
    }

    public void undoButtonWasPushed() {
        // undoCommand.execute();
        // undo method of any command stored here is invoked.s
        undoCommand.undo();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                                + " " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[slot Undo] " + undoCommand.getClass().getName() + "\n");
        return stringBuff.toString();
    }
 
}