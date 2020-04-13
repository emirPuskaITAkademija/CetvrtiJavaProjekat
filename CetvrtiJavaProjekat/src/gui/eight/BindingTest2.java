package gui.eight;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
//invalidate()
//Invalidate a view -> to znači da bilo koji podatak koji je iscrtan nije više VALIDAN(nije frišak)
//invalidate()
public class BindingTest2 {

    public static void main(String[] args) {
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);
        SimpleIntegerProperty twoProperty = new SimpleIntegerProperty(2);
        //LAZY // eager
        NumberBinding sum = oneProperty.add(twoProperty);//x = y+z
        System.out.println("Suma = " + sum.getValue());
        ChangeListener<Number> changeListener = (observable, oldValue, newValue) -> System.out.println("Old = " + oldValue + ", New = " + newValue);
        InvalidationListener invalidationListener = (observable) -> System.out.println("Invalidation objekat obaviješten");
        sum.addListener(changeListener);
        System.out.println("Valid sum: " + sum.isValid());
        sum.addListener(invalidationListener);
        oneProperty.set(23);
        twoProperty.set(24);
        System.out.println("Valid sum: " + sum.isValid());
    }
}
