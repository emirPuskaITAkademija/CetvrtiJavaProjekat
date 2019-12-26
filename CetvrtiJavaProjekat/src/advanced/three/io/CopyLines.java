package advanced.three.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CopyLines {

    public static void main(String[] args) {
        String pathPrviFajl = "prvi.txt";
        String pathDrugiFajl = "drugi.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader("prvi.txt"));
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
