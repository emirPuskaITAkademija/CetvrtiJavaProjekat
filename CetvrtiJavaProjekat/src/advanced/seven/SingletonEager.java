package advanced.seven;

//Postoji potreba da postoji samo JEDAN objekat tipa neke klase
//CILJ: Osigurati postojanje jednog objekta ili jedne instance i omogućiti globalni pristup tom objektu
//IMPLEMENTACIJA
//1. Osigurati da postoji samo jedna instanca: PRIVATNI konstruktor
//2. Osigurati globalni pristup toj instanci: STATIČKA metoda
//VERZIJA 1
public class SingletonEager {
    //EAGER
    private static SingletonEager FADIL_TOSKIC = new SingletonEager();
    
    private SingletonEager(){
        if(FADIL_TOSKIC != null){
            throw new RuntimeException("JEDAN JE Fadil Toskic");
        }
        System.out.println("Kreiranje SINGLETON objekta...");
    }
    
    public static SingletonEager getInstance(){
        return FADIL_TOSKIC;
    }
}
