package advanced.five;

//1. DOhvaćanje vrijednosti
//2. Izmjena
//3. Vraćanje vrijednosti na memorijsku lokaciju
//Thread A
//Thread B
//1. Thread A dohvati 0
//1. Thread B dohvati 0
//2. Thread A izmjena 0 increment 0->1
//2. Thread B iumjena 0 decrement 0->-1
//3. Thread A vraća 1
//3. Thread B vraća -1  i kaže ovom drugom : Jarane đaba si se mučio da izmijeniš counter kad sam ja prepisao rezultata tvoje izmjene
//HAPPENS BEFORE RELACIJA 

//1. COmputational intensive operacije
//2. IO intensive
public class Counter {

    private String name;
    private int counter = 0;

    public Counter() {
        synchronized (this) {
            counter = counter + 1;
        }
        name = "Setup";
    }

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

}
