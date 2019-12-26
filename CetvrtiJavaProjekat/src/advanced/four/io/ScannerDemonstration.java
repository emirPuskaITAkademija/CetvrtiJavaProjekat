package advanced.four.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ScannerDemonstration {

    public static void main(String[] args) {
        //try-with-resource 1.7 
        double sum = 0.0;
        try (Scanner nasScanner = new Scanner(new BufferedReader(new FileReader("brojevi.txt")))) {
            nasScanner.useLocale(Locale.US);
            while (nasScanner.hasNext()) {
                if(nasScanner.hasNextDouble()){
                    sum = sum+nasScanner.nextDouble();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("SUMA  = " + sum);
        writeToFile("brojevi1.txt", sum+"");
    }
    
    private static void writeToFile(String fileName, String content){
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            writer.println(content);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
