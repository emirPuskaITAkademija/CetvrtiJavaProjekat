package nine.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CollectionExecutor {

    public static void main(String[] args) {
        String names = "Amar Hodzic;Rijad Dautovic;Rijad Rogo";
        String[] arrayOfNames = names.split(";");
        for (String name : arrayOfNames) {
            System.out.println(name);
        }
        //arrayOfNames[4] = "Marko Nikolić";
        ArrayList<String> iterableObject = new ArrayList<>();
        for (String name : arrayOfNames) {
            iterableObject.add(name);
        }
        System.out.println("Printam iterable object");
        Iterator<String> iterator = iterableObject.iterator();
        List<Integer> listOfNumbes = new ArrayList<>();
        printCollection(iterableObject);
        HashSet<String> setOfStrings = new HashSet<>();
        printCollection(setOfStrings);
        
    }
    
    static void printCollection(Collection<String> collectionOfStrings){
        for(String stringElement: collectionOfStrings){
            System.out.println(stringElement);
        }
    }
}
