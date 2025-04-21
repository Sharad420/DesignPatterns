package commands;

import receivers.HotTub;

public class HotTubOnCommand implements Command {
	HotTub hotTub;

	public HotTubOnCommand(HotTub hotTub) {
		this.hotTub = hotTub;
	}

	public void execute() {
        hotTub.on();
        hotTub.heat();
        hotTub.bubblesOn();
        hotTub.jetsOn();  
	}

    public void undo() {
      
        hotTub.jetsOff();
        hotTub.bubblesOff();
		hotTub.cool();
		hotTub.off();
    }
}
