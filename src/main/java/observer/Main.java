package observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        weatherStation.addObserver(currentDisplay);
        weatherStation.setMeasurements(80, 65, 30.4f);
        weatherStation.setMeasurements(76, 60, 29.8f);
    }
}
