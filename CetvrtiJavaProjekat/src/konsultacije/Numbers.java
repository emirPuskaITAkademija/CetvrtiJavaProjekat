package konsultacije;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private List<Integer> list;
    public static final int SIZE = 10;

    public Numbers() {
        list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeNumbers() {
        //IOException, FileNotFOundException
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File("output.txt"));
            for (int i = 0; i < list.size(); i++) {
                //IndexOutOfBoundsException
                out.println("Value at: " + i + " is = " + list.get(i));
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
