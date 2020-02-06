package advanced.seven;
//Teško je kreirati Singleton ???????
//1. Refleksija

import java.lang.reflect.Constructor;

//2. Serijalizacija/deserijalizacija
//3. clone
//4. višenitno programiranje 

public class SingletonExecutor {

    public static void main(String[] args) throws Exception{
        SingletonExecutor singletonExecutor = new SingletonExecutor();
        ObjectPrinter printer = singletonExecutor.new ObjectPrinter();
        //SINGLETON EAGER
        SingletonEager singleton1 = SingletonEager.getInstance();
        printer.print("singleton1", singleton1);
        SingletonEager singleton2 = SingletonEager.getInstance();
        printer.print("singleton2", singleton2);
        //SINGLETON LAZY
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        printer.print("singleton lazy1", singletonLazy1);
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        printer.print("singleton lazy2", singletonLazy2);
 
    }

    class ObjectPrinter {

        public void print(String message, Object singleton) {
            System.out.println(String.format("Ime objekta: %s, HashCode: %d", message, singleton.hashCode()));
        }
    }
}
