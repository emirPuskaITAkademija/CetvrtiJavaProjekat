package advanced.three.io;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyCharacters {

    public static void main(String[] args) {
        //Java platforma čuva karaktere po Unicode konvenciji
        //Unicode  16 bit  2na 16 = 65xxx
        String pathPrviFajl = "C:\\Users\\Grupa2\\Documents\\NetBeansProjects\\javacoreprogrammingmahirpatkovic\\CetvrtiJavaProjekat\\src\\prvi.txt";
        String pathDrugiFajl = "C:\\Users\\Grupa2\\Documents\\NetBeansProjects\\javacoreprogrammingmahirpatkovic\\CetvrtiJavaProjekat\\src\\drugi.txt";
        try (FileReader reader = new FileReader(pathDrugiFajl); FileWriter writer = new FileWriter(pathPrviFajl)) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
