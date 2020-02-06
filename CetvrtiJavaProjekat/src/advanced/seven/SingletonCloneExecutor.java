package advanced.seven;

public class SingletonCloneExecutor {

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
        //CLONE
        SingletonLazy kloniranFadil = (SingletonLazy)nasFadil.clone();
        printer.print("nas fadil", kloniranFadil);
    }
}
