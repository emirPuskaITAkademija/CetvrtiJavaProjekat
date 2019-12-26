package advanced.four.pattern;

import java.util.ArrayList;
import java.util.List;

public class StatisticDisplay implements Observer, IDisplayElement {

    private final List<Float> temperatures = new ArrayList<>();
    private final List<Float> humidites = new ArrayList<>();
    private final List<Float> pressures = new ArrayList<>();

    public StatisticDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        temperatures.add(temperature);
        humidites.add(humidity);
        pressures.add(pressure);
        display();
    }

    @Override
    public void display() {
        System.out.printf("Average Temperature/Humidity/Pressure = %s/%s/%s%n", average(temperatures), average(humidites), average(pressures));
    }

    private float average(List<Float> elements) {
        float sum = 0f;
        for (float element : elements) {
            sum = sum + element;
        }
        return sum / elements.size();
    }

    private double averageStream(List<Float> elements) {
       // float sum = elements.stream().reduce(0f, (prethodna, buduca) -> prethodna + buduca);
      //  return sum / elements.size();
      return elements.stream().mapToDouble(element->element).average().orElse(0.0);
    }
}
