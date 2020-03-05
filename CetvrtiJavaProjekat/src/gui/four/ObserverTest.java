package gui.four;


public class ObserverTest {
    public static void main(String[] args) {
        //ONE->TO->MANY
        //ONE
        Newspaper newspaperObservable = new Newspaper();
        //MANY
        Observer personObserver = new Person(newspaperObservable);
        Observer companyObserver = new Company(newspaperObservable);
        
        newspaperObservable.notifyObserver();
        newspaperObservable.removeObserver(personObserver);
        newspaperObservable.notifyObserver();
        
    }
}
