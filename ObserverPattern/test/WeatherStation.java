import subject.WeatherData;
import display.*;
import observers.*;

public class WeatherStation {
    public static void main(String[] args) {
        // Create a WeatherData object
        WeatherData weatherData = new WeatherData();

        // Create the display objects, which use the implementation of the Observer interface.
        // The display objects are registered as observers of the WeatherData object.
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        // Simulate new weather measurements
        // The WeatherData object will notify the display objects when the measurements change.
        // The display objects will then update their displays.
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);


    }
}