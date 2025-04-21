package observers;

public interface Observer {
    // public void update(float temp, float humidity, float pressure);
    // change the update method to have no arguments.
    public void update();
}

// Also, all the displays have been changed to reflect the pulling of needed data from the WeatherData object.
// Instead of the WeatherData object pushing the data to the displays, regardless of whether the displays need it or not.
// "Pull" is more flexible than "push" because the Observer can get the exact data it needs, and only the data it needs.