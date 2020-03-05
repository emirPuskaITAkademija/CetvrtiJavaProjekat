package gui.four;


public class Person implements Observer{

    public Person(Observable observable) {
        observable.registerObserver(this);       
    }

    @Override
    public void update() {
        System.out.println("Persona je dobila novo izdanje novina..");
    }
}
