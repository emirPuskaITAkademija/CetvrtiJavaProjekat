package eight.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionExecutor {
    public static void main(String[] args) {
        //fiksna duzina
        double[] numbers = new double[3];
        numbers[0] = 23.3;
        for(double number : numbers){
            System.out.println(number);
        }
        //
        ArrayList<Double> collectionOfNumbers = new ArrayList<>();
        collectionOfNumbers.add(2.3);
        collectionOfNumbers.add(3.4);
        collectionOfNumbers.add(23.34);
        collectionOfNumbers.add(23455.6);

        Iterator<Double> iterator = collectionOfNumbers.iterator();
        while (iterator.hasNext()) {
           Double element = iterator.next();
           if(element == 2.3){
               iterator.remove();
           }
        }
        for(Double element : collectionOfNumbers){
            System.out.println(element);
        }
    }
}
