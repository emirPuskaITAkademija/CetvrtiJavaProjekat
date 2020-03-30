package gui.six.fx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * FULL LAZY - ovo kreiranj weightProperty cemo odgađati kolko god budemo mogli.
 * LAZY ćemo biti kada treba da dođe do kreiranja DoublePropertyž
 * <p>
 *
 * @author Grupa2
 */
public class Item {

    private double weight;
    private DoubleProperty weightProperty;

    public void setWeight(double weight) {
        if(weightProperty == null){
            this.weight = weight;
        }else{
            weightProperty.set(weight);
        }
    }

    public double getWeight() {
        return weightProperty == null ? weight : weightProperty.get();
    }

    public DoubleProperty getWeightProperty() {
        if (weightProperty == null) {
            weightProperty = new SimpleDoubleProperty(this, "WEIGHT", weight);
        }
        return weightProperty;
    }
}
