package gui.eight;

import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Exercise3 {

    static final double KOTIZACIJA = 200.0;

    public static void main(String[] args) {
        ObservableList<String> players = FXCollections.observableArrayList();
        ListChangeListener<String> fondPrinter = new FondPrinter();
        players.addListener(fondPrinter);
        try(Scanner scanner = new Scanner(System.in)){
            while(scanner.hasNextLine()){
                String playerName = scanner.nextLine();
                players.add(playerName);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

    }

    static class FondPrinter implements ListChangeListener<String> {

        @Override
        public void onChanged(Change<? extends String> c) {
            int numberOfPlayers = c.getList().size();
            double nagradniFond = KOTIZACIJA * numberOfPlayers;
            System.out.println("Novi nagradni fond : " + nagradniFond);
        }

    }
}
