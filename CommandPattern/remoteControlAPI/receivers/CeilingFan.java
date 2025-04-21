package receivers;

public class CeilingFan {
	String location = "";
	int level;
	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	public static final int OFF = 0;

 
	public CeilingFan(String location) {
		this.location = location;
	}
  
	public void high() {
		// turns the ceiling fan on to high
		level = HIGH;
		System.out.println(location + " ceiling fan is on high");
 
	} 

	public void medium() {
		// turns the ceiling fan on to medium
		level = MEDIUM;
		System.out.println(location + " ceiling fan is on medium");
	}

	public void low() {
		// turns the ceiling fan on to low
		level = LOW;
		System.out.println(location + " ceiling fan is on low");
	}
 
	public void off() {
		// turns the ceiling fan off
		level = OFF;
		System.out.println(location + " ceiling fan is off");
	}
 
	public int getSpeed() {
		return level;
	}

	// DRY principle applied here, the undo here was stateful, so it was repeated everytime ceiling fan had a diff speed.
	public void undoExecute(int prevSpeed) {
		switch (prevSpeed) {
			case HIGH:
				this.high();
				break;
		
			case MEDIUM:
				this.medium();
				break;

			case LOW:
				this.low();
				break;

			case OFF:
				this.off();
				break;
			default:
				break;
		}
	}
}
