package gui.four;

import java.util.ArrayList;
import java.util.List;

public class Newspaper implements Observable{

    private List<Observer> observers = new ArrayList<>();
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }
    
}
