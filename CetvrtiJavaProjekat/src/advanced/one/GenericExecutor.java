package advanced.one;
//1. tipovi podataka
// proste i slozene(objektne) i parametrizirane objektne tipove

import java.util.ArrayList;
import java.util.List;

// operatore, kontrola toka, petlje
//OOP - enkapsulacija, nasljeđivanje, polimorfizam i apstrakcije
// instanceOf 

// COMPILE ERROR - lakši za detekciju; IDE 
// RUNTIME BUGS - oni ne isplivaju n površinu odmah
// GENERIČKI TIPOVI ? ?? dodaju stabilnost nasem kodu čineći bugove DETEKTABILNIM u COMPILE TIME
// mozemo definirati zajedno sa: klasom, interfejsom, metode
// 1. STROŽIJU PROVJERU tipa odmah u compile
// 2. ELIMINACIJU KONVERZIJE(CAST)
public class GenericExecutor {
    public static void main(String[] args) {
        List lista = new ArrayList();
        lista.add("Amar");
        String prviElement =(String) lista.get(0); // 
        
        List<String> lista1 = new ArrayList<String>();
        lista.add("Amar");
        String prviElement1 = lista1.get(0);
        
        //Backward compatibility 1998 RAW type 1.4
        Box kanitinaKutija = new Box();
        kanitinaKutija.setObject("Kanita");
        String vrijednostUPoljuKanitineKutije =(String) kanitinaKutija.getObject();
        
        Box feridinaKutija = new Box();
        feridinaKutija.setObject(new Integer(23));
        Integer vrijednostUPoljuFeridineKutije = (Integer)feridinaKutija.getObject();
        //<1.7 (1.5, 1.6)
        Box<String> fadilovaKutija = new Box<String>();
        fadilovaKutija.setObject("Fadil");
        String vrijednostPoljaUFadilKutiji = fadilovaKutija.getObject();
        //1.5, 1.6, 1.7
        Box<Double> mahirovaKutija = new Box<>();//diamond
        mahirovaKutija.setObject(0.4);
        Double sadrzaj = mahirovaKutija.getObject();
        //T, S, E U , V -> objektni tipovima
        // E -> Element
        // K -> key
        // V -> value
    }
}
