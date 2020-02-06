package advanced.seven;
//SingletonMultiThreadingBreak.class
//SingletonMultiThreadingBreak$1.InnerClassRunnable

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//SingletonMultiThreadingBreak$2
//SingletonMultiThreadingBreak$3 -> NE POSTOJI
public class SingletonMultiThreadingBreak {

    public static void main(String[] args) {
        //main
        iskoristiSingleton();
        //nekog drugo thread
        //new Thread(new InnerClassRunnable()).start();
        //treci thread-anonimni inner tip
        //javap 
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                iskoristiSingleton();
            }
        };
        // new Thread(runnable).start();
        //Lambda 
        Runnable runnable1 = () -> iskoristiSingleton();
        //new Thread(runnable1).start();
        //Method referenciranje
        Runnable runnable2 = SingletonMultiThreadingBreak::iskoristiSingleton;
        // new Thread(runnable2).start();

        //DRUGI način da pokrenete kod koji se izvrsava u nekom drugom threadu
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(() -> iskoristiSingleton());
        executorService.submit(SingletonMultiThreadingBreak::iskoristiSingleton);
        executorService.submit(SingletonMultiThreadingBreak::iskoristiSingleton);
        executorService.submit(SingletonMultiThreadingBreak::iskoristiSingleton);

        executorService.submit(SingletonMultiThreadingBreak::iskoristiSingleton);
        executorService.submit(SingletonMultiThreadingBreak::iskoristiSingleton);
        executorService.submit(SingletonMultiThreadingBreak::iskoristiSingleton);
    }

    static void iskoristiSingleton() {
        System.out.println(Thread.currentThread().getName());
        SingletonExecutor singletonExecutor = new SingletonExecutor();
        SingletonExecutor.ObjectPrinter printer = singletonExecutor.new ObjectPrinter();
        //singleton1 
        SingletonLazy nasFadil = SingletonLazy.getInstance();
        printer.print("nas fadil", nasFadil);
    }

    //inner klasu koja implementira runnable
    static class InnerClassRunnable implements Runnable {

        @Override
        public void run() {
            iskoristiSingleton();
        }

    }
}
