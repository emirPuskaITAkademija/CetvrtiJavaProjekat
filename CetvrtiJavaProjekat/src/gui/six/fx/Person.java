package gui.six.fx;
//masa * g = kgm/s2 = N

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * HALF LAZY -> kolko god mozes odgodi poziv operator new i kolko god mozes
 * odgodi kreiranje java fx property
 * <p>
 *
 * @author Grupa2
 */
public class Person {

    private double weight;
    private DoubleProperty weightProperty;

    public void setWeight(double weight) {
        if((weightProperty!=null) || (this.weight != weight)){
            weightProperty.set(weight);
        }
    }

    public double getWeight() {
        return weightProperty == null ? weight : weightProperty.get();
    }

    public DoubleProperty getWeightProperty() {
        if(weightProperty == null){
            weightProperty = new SimpleDoubleProperty(this, "WEIGHT", weight);
        }
        return weightProperty;
    }   
}
