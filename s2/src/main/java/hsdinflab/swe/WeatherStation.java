package hsdinflab.swe;

import java.util.ArrayList;
import java.util.List;

import hsdinflab.swe.IWeatherObserver;

public class WeatherStation {
    public WeatherStation() {
    }

    private List<IWeatherObserver> observers = new ArrayList<>();
    private WeatherData weatherData = new WeatherData();

    public void subscribe(IWeatherObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(IWeatherObserver observer) {
        observers.remove(observer);
    }

    private void onNewData() {
        for (IWeatherObserver observer : observers) {
            observer.updateWeather(weatherData);
        }
    }

    public void setWeatherData(float temperature, float humidity, float pressure) {
        weatherData.temperature = temperature;
        weatherData.humidity = humidity;
        weatherData.pressure = pressure;
        onNewData();
    }
}
