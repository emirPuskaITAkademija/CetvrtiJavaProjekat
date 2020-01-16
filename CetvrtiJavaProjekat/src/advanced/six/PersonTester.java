package advanced.six;

import advanced.one.spliterator.Gender;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
// 4 najvaznija funkcionalna interfejsa
//1. Consumer<T>  -> pohlepan  void accept(T element);
//2. Supplier<T> -> darezljiv  T get();
//3. Predicate<T> -> tester  boolean test(T element);
//4. Function<T, R> -> R apply(T element);

public class PersonTester {
    
    public static void main(String[] args) {
        List<Person> personList = Person.socialNetwork();

        //1. izvor stream -> Collection
        //2. međuoperacije 
        //3. terminirajuću operaciju
        Consumer<Person> personConsumer = new Consumer<Person>() {
            @Override
            public void accept(Person t) {
                System.out.println("Ja sam konzumer i konzumiram objekat person koji se zove : " + t.getName());
            }
        };

        //type inference
        Consumer<Person> personConsumer1 = p -> {
            System.out.println("Vozdra raja iz lambda kreiranog objekta : " + p.getName());
        };
        personConsumer.accept(personList.get(0));
        personConsumer1.accept(personList.iterator().next());
        Supplier<Person> personSupplier;
        Predicate<Person> personTester;
        Function<Person, String> transformFromPersonToString;
        //1. C++
        System.out.println("C++ style");
        PersonTester tester = new PersonTester();
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            tester.printPerson(p);
        }
        //2. FOR in /enhanced for
        System.out.println("Java <8 style");
        for (Person p : personList) {
            if (p.getName().equals("Kemal")) {
                tester.printPerson(p);
            }
        }
        //3. Java 8 forEach
        System.out.println("Java 8 style : functional");
        //3.1 izvor stream-> objekat tipa collection
        //3.2 međueoperacije 
        Predicate<Person> testerKemala = it ->it.getName().equals("Kemal");
        Function<Person, String> transformer = p-> p.getName();
        personList
                .stream()//izvor stream
                .filter(it->it.getName().equals("Kemal"))
                .map(transformer)
                .forEach(it-> System.out.println(it));//terminirajuca operacija
        
        List<LocalDate> birthdays = personList
                .stream()
                .map(p->p.getBirthday())
                .collect(Collectors.toList());//terminirajuća operacija
        
        //Kada lambda ne radi ništa drugo do poziva neke funkcije mi se samo trebamo referencirati na tu funkciju
        //1. referenciranje na funkciju od objekta
        personList.stream()
                .filter(it->it.getGender().equals(Person.Gender.FEMALE))
                .forEach(tester::printPerson);
    }
    
    private void printPerson(Person person) {
        System.out.println(person.getName() + " -> gender : " + person.getGender() + " -> email: " + person.getEmailAddress());
    }
}
