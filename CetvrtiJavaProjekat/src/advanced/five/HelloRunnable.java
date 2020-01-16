package advanced.five;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("Hello from :  " + Thread.currentThread().getName());
    }
}
