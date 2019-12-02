package eight.interfaces;

import eight.enumeration.Gender;
import eight.enumeration.Person;

public class BoxOtvarac {

    public static void main(String[] args) {
        Box<String> fadilovaKutija = new Box<>("Fadilov tekst koji opisuje kutiju");
        Box<Double> markovaKutija = new Box<>(23.0);
        Box<Person> amarovaKutija = new Box<>(new Person("Ferida", "Bobar", Gender.FEMALE));

        String fadilovProperty = fadilovaKutija.getProperties();
        Double markovaProperty = markovaKutija.getProperties();
    }
}
