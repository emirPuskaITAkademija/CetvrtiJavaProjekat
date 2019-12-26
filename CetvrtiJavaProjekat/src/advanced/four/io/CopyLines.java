package advanced.four.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        PrintWriter out = null;
        try {
            reader = new BufferedReader(new FileReader("prvi.txt"));
            out = new PrintWriter(new FileWriter("drugi.txt"));
            String line = reader.readLine();
            while(line !=null){
                System.out.println(line);
                out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
}
