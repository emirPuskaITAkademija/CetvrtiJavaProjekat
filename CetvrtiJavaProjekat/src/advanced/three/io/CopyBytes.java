package advanced.three.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

    public static void main(String[] args) {
        String pathPrviFajl = "C:\\Users\\Grupa2\\Documents\\NetBeansProjects\\javacoreprogrammingmahirpatkovic\\CetvrtiJavaProjekat\\src\\prvi.txt";
        String pathDrugiFajl = "C:\\Users\\Grupa2\\Documents\\NetBeansProjects\\javacoreprogrammingmahirpatkovic\\CetvrtiJavaProjekat\\src\\drugi.txt";
        try (FileInputStream in = new FileInputStream(new File(pathPrviFajl));
                FileOutputStream out = new FileOutputStream(new File(pathDrugiFajl))) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
