package gui.eight;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
//
public class JavFxStarter {

    public static void main(String[] args) {
        //Observable/UI controls/Property JavaFX
        //Observable objekat
        IntegerProperty counterProperty = new SimpleIntegerProperty(100);
        //Observer objekat - eager
        ChangeListener<Number> counterChangeListener = new CounterChangeListener();
        //Observer objekat - eager/lazy
        InvalidationListener counterInvalidationListener = new CounterInvalidationListener();
        counterProperty.addListener(counterChangeListener);
        counterProperty.addListener(counterInvalidationListener);
        counterProperty.setValue(111);
        counterProperty.setValue(120);
    }

    static class CounterChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            System.out.println("OLD value = " + oldValue + " +, NEW value = " + newValue);
        }
    }

    static class CounterInvalidationListener implements InvalidationListener {

        @Override
        public void invalidated(Observable observable) {
            System.out.println("Invalidation change listener je obaviješten");
        }

    }
}
