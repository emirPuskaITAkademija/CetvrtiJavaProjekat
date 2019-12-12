package advanced.one.spliterator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PersonUser {

    public static void main(String[] args) {
        List<Person> persons = Person.socialNetwork();

        CheckPerson checker = (Person p) -> p.getAge() > 22;
        System.out.println("FUNCTIONAL interface");
        printPersons(persons, (p) -> p.getAge() > 22);
        System.out.println("");
        System.out.println("IDE mladji narastaj");
        System.out.println("FUNCTIONAL interface");
        printPersons(persons, p -> p.getAge() < 22);
        System.out.println("");
        System.out.println("Ide ZENSKI");
        printPersons(persons, p -> p.getGender().equals(Gender.FEMALE));
        System.out.println("");
        System.out.println("TRANS");
        printPersons(persons, p -> p.getBirthday().getYear() >= 1990 && p.getBirthday().getYear() <= 2000);
        System.out.println("IDU SORTIRANI");
        Collections.sort(persons, (p1, p2)-> p2.getBirthday().compareTo(p1.getBirthday()));
        persons.forEach(System.out::println);
    }

    static void printPersons(List<Person> persons, CheckPerson checkPerson) {
        for (Person p : persons) {
            if (checkPerson.check(p)) {
                System.out.println(p);
            }
        }
    }

}
