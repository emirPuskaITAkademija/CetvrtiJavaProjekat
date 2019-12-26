package advanced.four.pattern;

public class CurrentConditionDisplay implements Observer, IDisplayElement {

    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current temperature: " + temperature + ", humidity: " + humidity);
    }

}
