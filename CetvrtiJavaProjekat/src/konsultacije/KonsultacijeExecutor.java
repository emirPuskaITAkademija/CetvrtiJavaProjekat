package konsultacije;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
//Exception - exceptional event ili izuzetan događaj koji može prekinuti normalan slijed izvršavanja programa
//try - catch -finnaly 
//try blok - izvrsava se u normalnom toku izvrsavanja programa
//catch blok - izvrsava se u u slučaju da try blok koda "baci" exceptional event odnosno ukoliko neka linija izazove izuzetan događaj
//finally - izvršava se uvijek i njega boli briga i za try i za catch blok
public class KonsultacijeExecutor {

    public static void main(String[] args) {
        String imeFajla = JOptionPane.showInputDialog("Ziv bio, daj mi ime fajla kojeg zelis citati");
        // try block -> try - kljucna rezervisana riječ u Javi
        Scanner nasScanner = null;
        try {
            nasScanner = new Scanner(new File(imeFajla));
            String line = nasScanner.nextLine();
            System.out.println(line);
        } catch (FileNotFoundException exception) {
            System.err.println("Pogresno ime fajla : " + imeFajla);
        } finally {
            if (nasScanner != null) {
                nasScanner.close();
            }
        }
        int number = 23;
        float floatingNumber = 23f;
        System.out.println("Vozdra raja, dobro mi došli na konsultacije");
    }
}
