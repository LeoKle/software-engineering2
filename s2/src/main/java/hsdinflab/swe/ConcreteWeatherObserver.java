package hsdinflab.swe;

public class ConcreteWeatherObserver implements IWeatherObserver {

    private WeatherStation weatherStation;

    public ConcreteWeatherObserver(WeatherStation station) {
        this.weatherStation = station;
        station.addObserver(this);
    }

    @Override
    public void updateWeather(WeatherData data) {
        System.out.println("Updated weather: Temp=" + data.temperature +
                ", Humidity=" + data.humidity +
                ", Pressure=" + data.pressure);
    }
}
