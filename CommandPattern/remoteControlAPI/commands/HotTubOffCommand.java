package commands;

import receivers.HotTub;

public class HotTubOffCommand implements Command {
	HotTub hotTub;

	public HotTubOffCommand(HotTub hotTub) {
		this.hotTub = hotTub;
	}

	public void execute() {
        hotTub.jetsOff();
        hotTub.bubblesOff();
		hotTub.cool();
		hotTub.off();
	}

    public void undo() {
        hotTub.on();
        hotTub.heat();
        hotTub.bubblesOn();
        hotTub.jetsOn();
    }
}
