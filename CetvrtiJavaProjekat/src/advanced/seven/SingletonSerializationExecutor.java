package advanced.seven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonSerializationExecutor {

    public static void main(String[] args) throws Exception {
        SingletonExecutor singletonExecutor = new SingletonExecutor();
        SingletonExecutor.ObjectPrinter printer = singletonExecutor.new ObjectPrinter();
        //singleton1 
        SingletonLazy nasFadil = SingletonLazy.getInstance();
        printer.print("nas fadil", nasFadil);
        //singleton2 
        SingletonLazy drugiFadilPokusaj = SingletonLazy.getInstance();
        printer.print("nas fadil", drugiFadilPokusaj);
        System.out.println(nasFadil == drugiFadilPokusaj);
        System.out.println(nasFadil.equals(drugiFadilPokusaj));
        //SERIJALISATIOn
        ObjectOutputStream outputObject = new ObjectOutputStream(new FileOutputStream("fadil.ser"));
        outputObject.writeObject(nasFadil);
        ObjectInputStream inputStreamObject = new ObjectInputStream(new FileInputStream("fadil.ser"));
        SingletonLazy deserializovanFadil = (SingletonLazy)inputStreamObject.readObject();
        printer.print("nas fadil", deserializovanFadil);
    }
}
