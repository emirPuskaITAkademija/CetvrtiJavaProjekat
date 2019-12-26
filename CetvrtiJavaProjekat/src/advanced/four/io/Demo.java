package advanced.four.io;

public class Demo implements AutoCloseable{
    
    
    public void something(){
        System.out.println("Vozdra Adnane. Nadamo se da će sada biti jasnije");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing DEMOOOO");
    }

    
    
}
