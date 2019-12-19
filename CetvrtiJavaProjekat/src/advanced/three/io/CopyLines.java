package advanced.three.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CopyLines {

    public static void main(String[] args) {
        String pathPrviFajl = "C:\\Users\\Grupa2\\Documents\\NetBeansProjects\\javacoreprogrammingmahirpatkovic\\CetvrtiJavaProjekat\\src\\prvi.txt";
        String pathDrugiFajl = "C:\\Users\\Grupa2\\Documents\\NetBeansProjects\\javacoreprogrammingmahirpatkovic\\CetvrtiJavaProjekat\\src\\drugi.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(pathPrviFajl));
                PrintWriter writer = new PrintWriter(new FileWriter(pathDrugiFajl))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
