package advanced.seven;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonLazy implements Serializable, Cloneable{

    private static SingletonLazy FADIL;
    
    private SingletonLazy() {
        System.out.println("Kreiram našeg Fadila i jedan je Fadil...");
    }
    
    public static SingletonLazy getInstance(){
        if(FADIL == null){
            FADIL = new SingletonLazy();
        }
        return FADIL;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        if(FADIL!=null){
            throw new CloneNotSupportedException("JEdan je nas FADIL");
        }
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    //serialization fixirat
    private Object readResolve() throws ObjectStreamException{
        return FADIL;
    }
}
