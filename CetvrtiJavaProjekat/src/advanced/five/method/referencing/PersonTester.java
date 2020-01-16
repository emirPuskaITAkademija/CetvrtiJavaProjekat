package advanced.five.method.referencing;
// -> 
// Lambda definira blok koda koje metode iz funkcionalnog interfejsa

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//kreirajuc potpuno definiran objekat
//Nekada LAMBDA tom prilikom ne radi ništa drugo nego samo pozove drugu metodu
//Kada LAMBDA ne radi ništa drugo do poziva neke metode mi treba samo da se REFERENCIRAMO NA TU METODU
// ::

//Postoje 4 vrste METHOD referenciranja
// 1. Referenciranje na Statičku metodu definiranu unutar neke klase
// ImeKlase::imeMetode
//2. Referenciranje na objektnu metodu
// imeObjekta::imeMetode
//3. Referenciranje na objektnu metodu proizvoljnog objekta određenog tipa
//4. Referenciranje na konstruktor
//ImeKLase::new
public class PersonTester {
    public static void main(String[] args) {
        List<Person> persons = Person.socialNetwork();
        Person[] personArray = (Person[])persons.toArray();
        print(personArray);
        PersonComparator pc = new PersonComparator();
        Arrays.sort(personArray, pc::compare);
        
    }
    
    private static void print(Person[] persons){
        Arrays.stream(persons).map(it->it.getBirthday()).forEach(b->System.out.println(b.toString()));
    }
    
   static class PersonComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getBirthday().compareTo(o2.getBirthday());
        }
        
    }
}
