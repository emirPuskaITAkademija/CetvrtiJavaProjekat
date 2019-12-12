package advanced.two;

import advanced.one.spliterator.Person;
import advanced.one.spliterator.Gender;
import static java.lang.Math.E;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonExecutor {

    public static void main(String[] args) {
        PersonExecutor personExecutor = new PersonExecutor();
        List<String> names = new ArrayList<>();
        names.add("Mahir");
        names.add("Mahir");
        names.add("Veselin");
        names.add("Kanita");
        names.add("Ferida");
        names.add("Rijad");
        names.add("Mirzad");
        personExecutor.procesElements(names,
                ime -> ime.endsWith("a"),
                name -> System.out.println(name));

        List<Person> persons = Person.socialNetwork();

        System.out.println("Dame");
        //LAMBDA operator -> shortcut za ono new Person, new CheckPerson
        CheckPerson checkerDame = new CheckPerson() {
            @Override
            public boolean check(Person person) {
                return person.getGender().equals(Gender.FEMALE);
            }
        };
        CheckPerson checkerDame1 = p -> p.getGender().equals(Gender.FEMALE);
        Predicate<Person> tester = e -> e.getGender().equals(Gender.FEMALE);
        Consumer<Person> consumer = p -> System.out.println(p);
        personExecutor.procesElements(persons, tester, consumer);
        // personExecutor.printPersonsWithGender(persons, Gender.FEMALE);
        System.out.println("");
        System.out.println("Dame nisu same");
        personExecutor.procesElements(persons,
                p -> p.getGender().equals(Gender.MALE),
                p -> System.out.println(p));
        //personExecutor.printPersonsWithGender(persons, Gender.MALE);
        System.out.println("");
        System.out.println("IDU STARI");
        personExecutor.procesElements(persons,
                p -> p.getBirthday().isBefore(LocalDate.of(1991, Month.JANUARY, 1))
                        , consumer);
        //personExecutor.printPersonsOlderThan(persons, LocalDate.of(1991, Month.JANUARY, 1));
        System.out.println("");
        System.out.println("IDU ovi rodjeni poslije smaka svijeta");
        personExecutor.procesElements(persons,
                p -> p.getBirthday().isAfter(LocalDate.of(2000, Month.JANUARY, 1)),
                        consumer);
        //personExecutor.printPersonsYoungerThan(persons, LocalDate.of(2000, Month.JANUARY, 1));
        //HASH SET
        Set<Person> setOfPersons = new HashSet<>(persons);
        System.out.println("HASH SET print");
        setOfPersons.forEach(personu -> System.out.println(personu));
        //LINKED HASH SET
        System.out.println("");
        System.out.println("LINKED HASH SET print");
        setOfPersons = new LinkedHashSet<>(persons);
        setOfPersons.forEach(p -> System.out.println(p));
        //TREESET
        System.out.println("");
        System.out.println("TREE SET print");
        setOfPersons = new TreeSet<>(persons);
        setOfPersons.forEach(e -> System.out.println(e));
        System.out.println("");
        System.out.println("IDU OSOVE izmedju datum");
        //
        personExecutor.procesElements(persons,
                p -> p.getBirthday().isAfter(LocalDate.of(1990, Month.JANUARY, 1))
                && p.getBirthday().isBefore(LocalDate.of(2000, Month.JANUARY, 1)),
                consumer);
        personExecutor.procesElements(persons, p->p.getName().contains("A"), it->System.out.println(it+" G"));
        // personExecutor.printPersonsBetweenDates(persons, LocalDate.of(1990, Month.JANUARY, 1), LocalDate.of(2000, Month.DECEMBER, 1));
    }

    /*void printPersons(List<Person> persons, CheckPerson checkPerson) {
        persons.stream()//
                .filter(p -> checkPerson.check(p))//
                .forEach(it -> System.out.println(it));
    }*/
    public <E> void procesElements(List<E> elements, Predicate<E> tester, Consumer<E> consumer) {
        elements.stream().filter(tester).forEach(consumer);
    }

    /* public <E> void printElements(List<E> elements, Predicate<E> tester) {
        elements.stream().filter(tester).forEach(toStoTiVidis -> System.out.println(toStoTiVidis));
    }*/
    // C++
    /*   void printPersonsWithGender(List<Person> persons, Gender gender) {
        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);
            if (p.getGender().equals(gender)) {
                System.out.println(p);
            }
        }
    }*/
 /*
    //Java OLD enahnced 
    void printPersonsOlderThan(List<Person> persons, LocalDate date) {
        for (Person p : persons) {
            if (p.getBirthday().isBefore(date)) {
                System.out.println("Stari dobri: " + p);
            }
        }
    }*/
    //for each
    /*void printPersonsYoungerThan(List<Person> persons, LocalDate date) {
        //IBM Brian Goetz
        //1. Collection -> izvor stream ili toka podataka IZVOR
        //2. Intermediate operacije -> to su metode koje pozivamo nad streamom i one nam opet vracaju isti taj stream nakon sto ga malo izmijene
        //3. Terminirijaće operacije -> to je prva metoda koju pozoves a za uzvrat ne dobijes Stream
        persons.stream()//1. IZVOR Streama
                .filter(p -> p.getBirthday().isAfter(date))//2. MEĐUOPERACIJA među metoda
                .forEach(to -> System.out.println(to));//3. TERMINIRAJUĆA operacija
    }*/

 /*void printPersonsBetweenDates(List<Person> persons, LocalDate fromDate, LocalDate toDate) {
        persons.stream()//
                .filter(p -> p.getBirthday().isAfter(fromDate))//
                .filter(p -> p.getBirthday().isBefore(toDate))//
                .forEach(it -> System.out.println(it));
    }*/
}
