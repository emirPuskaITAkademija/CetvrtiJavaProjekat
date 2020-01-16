package advanced.five;


public class FiveExecutor {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("Pozdrav iz : " + currentThread.getName());
        //1. način da kreiram kod koji će izvršavati paralelno sa MAIN thread
        HelloRunnable runnable = new HelloRunnable();//runnable
        Thread thread1 = new Thread(runnable);
        thread1.start();
        HelloThread thread2 = new HelloThread();
        thread2.test();
        thread2.start();
    }
}
