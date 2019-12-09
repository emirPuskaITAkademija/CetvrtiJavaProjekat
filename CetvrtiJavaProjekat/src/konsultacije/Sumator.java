package konsultacije;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Sumator {

    public static void main(String[] args) {
        System.out.println("Unesite cijeli broj koji da dobijete sumu svih elemenata od 0 do tog broja:");
        try (Scanner scanner = new Scanner(System.in)) {
            int uneseniBroj = scanner.nextInt();
            int suma = sum(uneseniBroj);
            System.out.println("Suma svih brojeva od 0 do " + uneseniBroj + " je = " + suma);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static int sum(int n) {
  
        return n*(n+1)/2;
    }
}
