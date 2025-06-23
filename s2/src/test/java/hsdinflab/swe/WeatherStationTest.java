package hsdinflab.swe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class WeatherStationTest {

    private WeatherStation station;
    private TestObserver observer;
    private TestObserver observer1;
    private TestObserver observer2;

    @BeforeEach
    public void setup() {
        station = new WeatherStation();
        observer = new TestObserver();
        observer1 = new TestObserver();
        observer2 = new TestObserver();
    }

    private static class TestObserver implements IWeatherObserver {
        private boolean updated = false;

        @Override
        public void updateWeather(WeatherData data) {
            this.updated = true;
        }

        public boolean wasUpdated() {
            return updated;
        }
    }

    @Test
    public void testObserverNotifiedOnDataChange() {
        station.addObserver(observer);
        station.setWeatherData(21.0f, 55.0f, 1015.0f);
        assertTrue(observer.wasUpdated());
    }

    @Test
    public void testObserversNotifiedOnDataChange() {
        station.addObserver(observer);
        station.addObserver(observer1);
        station.addObserver(observer2);
        station.setWeatherData(21.0f, 55.0f, 1015.0f);
        assertTrue(observer.wasUpdated());
        assertTrue(observer1.wasUpdated());
        assertTrue(observer2.wasUpdated());
    }

    @Test
    public void testObserverRemoved() {
        station.addObserver(observer);
        station.removeObserver(observer);
        station.setWeatherData(21.0f, 55.0f, 1015.0f);
        assertFalse(observer.wasUpdated());
    }

}
