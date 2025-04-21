package receivers;

public class HotTub {
    String location;
	boolean on;
	int temperature;

	public HotTub(String location) {
        this.location = location;
	}

	public void on() {
		on = true;
        System.out.println("Hottub is on");
	}

	public void off() {
		on = false;
        System.out.println("Hottub is off");
	}

	public void bubblesOn() {
		if (on) {
			System.out.println("Hottub is bubbling!");
		} else {
            System.out.println("Switch on the hottub first!");
        }
	}

	public void bubblesOff() {
		if (on) {
			System.out.println("Hottub is not bubbling");
		}
	}

	public void jetsOn() {
		if (on) {
			System.out.println("Hottub jets are on");
		} else {
            System.out.println("Switch on the hottub first!");
        }
	}

	public void jetsOff() {
		if (on) {
			System.out.println("Hottub jets are off");
		}
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void heat() {
        if (on) {
         	temperature = 105;
		    System.out.println("Hottub is heating to a steaming 105 degrees");   
        } else {
            System.out.println("Switch on the hottub first!");
        }

	}

	public void cool() {
        if (on) {
            temperature = 98;
		    System.out.println("Hottub is cooling to 98 degrees");
        } else {
            System.out.println("Switch on the hottub first!");
        }

	}

}
