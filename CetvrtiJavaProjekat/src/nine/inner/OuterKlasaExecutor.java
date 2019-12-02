package nine.inner;

import java.util.ArrayList;
import java.util.Iterator;


public class OuterKlasaExecutor {
    public static void main(String[] args) {
        OuterKlasa.StaticNestedKlasa objekatStatičkeKlase = new OuterKlasa.StaticNestedKlasa();
        OuterKlasa outerKlasaObjekat = new OuterKlasa();
        OuterKlasa.InnerKlasa innerClassObjekat = outerKlasaObjekat.new InnerKlasa();
        ArrayList<String> list = new ArrayList<>();
        Iterator<String> itrObject = list.iterator();
    }
}
