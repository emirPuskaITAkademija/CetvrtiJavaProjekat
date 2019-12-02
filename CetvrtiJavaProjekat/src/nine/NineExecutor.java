package nine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NineExecutor {

    public static void main(String[] args) {
        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Ferida");
        listOfNames.add("Ferida");
        listOfNames.add("Kanita");
        listOfNames.add("Kanita");
        listOfNames.add("Kanita");
        listOfNames.add("Fadila");
        listOfNames.add("Markulina");
        listOfNames.add("Veselina");
        System.out.println(listOfNames.get(5));
        printCollection(listOfNames);
        System.out.println("LINKED LIST");
        List<String> listOfNames1 = new LinkedList<>();
        listOfNames1.add("Ferida");
        listOfNames1.add("Ferida");
        listOfNames1.add("Kanita");
        listOfNames1.add("Kanita");
        listOfNames1.add("Kanita");
        listOfNames1.add("Fadila");
        listOfNames1.add("Markulina");
        listOfNames1.add("Veselina");
        System.out.println("NULTI element = " + listOfNames1.get(0));
        printCollection(listOfNames1);
        System.out.println("IDE HASHSET");
        Set<String> listOfNames2 = new HashSet<>();
        listOfNames2.add("Ferida");
        listOfNames2.add("Ferida");
        listOfNames2.add("Kanita");
        listOfNames2.add("Kanita");
        listOfNames2.add("Kanita");
        listOfNames2.add("Fadila");
        listOfNames2.add("Markulina");
        listOfNames2.add("Veselina");
        printCollection(listOfNames2);
        System.out.println("");
        System.out.println("LINKED HASH SET");
        Set<String> listOfNames3 = new LinkedHashSet<>();
        listOfNames3.add("Ferida");
        listOfNames3.add("Ferida");
        listOfNames3.add("Kanita");
        listOfNames3.add("Kanita");
        listOfNames3.add("Kanita");
        listOfNames3.add("Fadila");
        listOfNames3.add("Markulina");
        listOfNames3.add("Veselina");
        printCollection(listOfNames3);
        System.out.println("TREE SET");
        Set<String> listOfNames4 = new TreeSet<>();
        listOfNames4.add("Ferida");
        listOfNames4.add("Ferida");
        listOfNames4.add("Kanita");
        listOfNames4.add("Kanita");
        listOfNames4.add("Kanita");
        listOfNames4.add("Fadila");
        listOfNames4.add("Markulina");
        listOfNames4.add("Veselina");
        printCollection(listOfNames4);
    }

    static void printCollection(Collection<String> names) {
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            String next = namesIterator.next();
            System.out.println(next);
        }
    }
}
