package hsdinflab.swe;

public interface IWeatherSubject {
    void addObserver(IWeatherObserver observer);

    void removeObserver(IWeatherObserver observer);

    void notifyObservers();
}
