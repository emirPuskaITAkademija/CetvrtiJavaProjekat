package advanced.four.pattern;
//1. Strategy 
//2. Decorator
//3. Iterator
//4. Observer pattern -> šabloni
//OBSERVER -> dva aktera
//Observable(Subject) --> Observer
//Relacija one-to-many

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(5f, 80f, 1f);
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);
        weatherData.setMeasurement(5f, 80f, 1f);
        System.out.println("Novo mjerenje");

        FullConditionDisplay fullConditionDisplay = new FullConditionDisplay(weatherData);
        weatherData.setMeasurement(10f, 100f, 1.2f);
        weatherData.setMeasurement(2f, 70f, 0.8f);
        weatherData.removeObserver(statisticDisplay);
        System.out.println("ZADNJE Mjerenje");
        weatherData.setMeasurement(2f, 70f, 0.8f);
    }
}
