package advanced.four.pattern;

import java.util.Observable;

public class FullConditionDisplay implements Observer, IDisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;

    public FullConditionDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current temperature: " + temperature + ", humidity: " + humidity + ", pressure: " + pressure);
    }

}
