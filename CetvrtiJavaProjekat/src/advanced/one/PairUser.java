package advanced.one;

import java.util.ArrayList;
import java.util.List;

public class PairUser {

    public static void main(String[] args) {
        Pair<Integer, String> kanita = new OrderedPair<>(1, "Kanita");
        System.out.println(kanita.getKey() + kanita.getValue());
        
        List<String> prvaKlupa = new ArrayList<>();
        prvaKlupa.add("Mahir");
        prvaKlupa.add("Ferida");
        prvaKlupa.add("Kanita");
        Pair<Integer, List<String>> ferida = new OrderedPair<>(1, prvaKlupa);
        
        Pair<Integer, String> pair3 = new OrderedPair<>(1, "Ferida");
        //1.7  S- Integer, U - String
        boolean result = Util.<Integer, String>comparePair(kanita, pair3);
        boolean result3 = Util.comparePair(kanita, pair3);
        System.out.println(result);
        //TYPE INFERENCE -> Kompajler određuje tip na osnovu parametara funkcije(objekti pair1 i pair3)
    }
}
