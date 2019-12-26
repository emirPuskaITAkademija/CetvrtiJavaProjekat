package advanced.four.pattern;
//1. akter -> Observable
public interface Subject {
    public void registerObserver(Observer o);
    
    public void removeObserver(Observer o);
    
    public void notifyObservers();
}
