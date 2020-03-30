
package gui.six.fx.game;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GameScoreWriter implements ChangeListener<Number>{
    private final StringBuilder scoreBuilder = new StringBuilder();
    private final File file;

    public GameScoreWriter(File file) {
        this.file = file;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        IntegerProperty playerPropery = (IntegerProperty) observable;
        scoreBuilder.append(playerPropery.getName())
                .append(": Old score = ")
                .append(oldValue)
                .append(", new score = ")
                .append(newValue)
                .append(System.lineSeparator());
        writeScore1(scoreBuilder.toString());
    }

    private void writeScore1(String scoreValue){
        try(PrintWriter pw = new PrintWriter(new PrintStream(file))){
            pw.println(scoreValue);
        }catch(IOException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
    
}
