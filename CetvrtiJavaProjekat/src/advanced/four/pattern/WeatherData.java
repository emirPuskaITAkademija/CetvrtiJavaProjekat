package advanced.four.pattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private float temperature;
    private float humidity;
    private float pressure;
    private final List<Observer> observers = new ArrayList<>();

    public WeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public void setMeasurement(float temp, float hum, float pre) {
        this.temperature = temp;
        this.humidity = hum;
        this.pressure = pre;
        measurementChanged();
    }

    private void measurementChanged() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

}
