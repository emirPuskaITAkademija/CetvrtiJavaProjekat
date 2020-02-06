package advanced.six;

//1. Lambda -> FunctionalInterface
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//2. Method referenciranje -> nekada lamda ne radi ništa drugo osim što poziva neku metodu
//-> referenciramo se na metodu ::
//Comparable<T> compareTo(T element)
//Comparator<T> compare(T t1, T t2)
public class PersonExecutor {

    public static void main(String[] args) {
        //Java 8 uvodi to da mozemo kreirati klasu unutar metode
        class PersonPrinter {

            void print(Person p) {
                System.out.println(p.getName() + " -> " + p.getBirthday());
            }
        }
        PersonPrinter personPrinter = new PersonPrinter();
        List<Person> personList = Person.socialNetwork();
        List<String> names = new ArrayList<>();
        //izvor stream stream source -> Stream<Person> object
        //METHOD REFERENCIRANJE
        //1. Lambda poziva objektnu fuknciju od objekta personPrinter imeObjekta::imeMetode
        personList
                .stream()
                .filter(p -> p.getGender().equals(Person.Gender.FEMALE))
                .forEach(personPrinter::print);
        //2. Lambda poziva klasnu odnosno statičku funkciju klase ImeKklase::imeMetode
        personList
                .stream()
                .filter(p -> p.getGender().equals(Person.Gender.MALE))
                .forEach(PersonExecutor::printStatic);
        class ComparisonProvider {

            public int compareByName(Person p1, Person p2) {
                int result = p1.getName().compareTo(p2.getName());
                return result;
            }

            public int compareByBirthday(Person p1, Person p2) {
                int result = p1.getBirthday().compareTo(p2.getBirthday());
                return result;
            }
        }
        ComparisonProvider comparisonProvider = new ComparisonProvider();
        Collections.sort(personList, comparisonProvider::compareByBirthday);
        Collections.sort(personList, comparisonProvider::compareByName);
        //3. reference to an instance method of particular type of an arbitrary object
        //referenciramo se na objektnu metodu kroz naziv klase od tipa tog objekta
        String[] personNames = (String[]) personList
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList()).toArray();
        //4. lambda poziva samo kontstruktor klase HashSet ->p
        Supplier<HashSet<Person>> hashSetSupplier = () -> new HashSet<>();
        Supplier<HashSet<Person>> hashSetSupplier1 = HashSet::new;
        Set<Person> personSet = transferElements(personList, HashSet::new);
        
        
        //
        String[] namesArray = {"Marko", "Kanita", "Ferida", "Fadil", "Mirzad", "Amar"};
        Arrays.sort(namesArray, (n1, n2)->n1.compareToIgnoreCase(n2));
    }

    //uvodim generičke tipove na nivou funkcije
    //1. generičke tipove na nivou funkcije
    //1.1 E -> element je unbounded generic type
    //1.2 SC extends Collection<E> -> bounded generic type
    //1.3 DC extends Collection<E> -> bounded generic type
    static <E, SC extends Collection<E>, DC extends Collection<E>> DC transferElements(SC sourceCollection, Supplier<DC> collectionSupplier) {
        DC destinationCollection = collectionSupplier.get();
        for (E mutant : sourceCollection) {
            destinationCollection.add(mutant);
        }
        return destinationCollection;
    }

    public static void printStatic(Person p) {
        System.out.println("Muskarcine: " + p.getName());
    }

}
