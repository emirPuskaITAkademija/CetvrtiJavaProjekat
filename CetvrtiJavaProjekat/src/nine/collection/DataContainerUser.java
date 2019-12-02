package nine.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class DataContainerUser {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        Iterator<String> listaIterator = lista.iterator();
        while(listaIterator.hasNext()){
            String element = listaIterator.next();
            if(element.equals("Marko")){
                listaIterator.remove();
            }
            System.out.println(element);
        }
        IntegerContainer dataContainer = new IntegerContainer();
        Iterator<Integer> dataContainerIterator = dataContainer.iterator();
        while(dataContainerIterator.hasNext()){
            Integer element = dataContainerIterator.next();
            System.out.println(element);
        }
    }
}
