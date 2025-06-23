package hsdinflab.swe;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IWeatherSubject {

    private List<IWeatherObserver> observers = new ArrayList<>();
    private WeatherData weatherData = new WeatherData();

    @Override
    public void addObserver(IWeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IWeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IWeatherObserver observer : observers) {
            observer.updateWeather(weatherData);
        }
    }

    public void setWeatherData(float temperature, float humidity, float pressure) {
        weatherData.temperature = temperature;
        weatherData.humidity = humidity;
        weatherData.pressure = pressure;
        notifyObservers();
    }
}
