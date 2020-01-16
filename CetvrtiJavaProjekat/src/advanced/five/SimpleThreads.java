package advanced.five;

//interrupt
//OUTER
//join - dopusta da jednom threadu da saceka drugog
//join- pauzira trenutni thread (main) kako bi drugi thread mozda brze zavrsio
public class SimpleThreads {

    public static void main(String[] args) throws InterruptedException {
        long strpljenje = 12 * 1000;//ms
        threadMessage("Main thread će startati MessageLoop thread");
        long startTime = System.currentTimeMillis();
        MessageLoop messageLoop = new MessageLoop();
        Thread thread1 = new Thread(messageLoop);
        thread1.start();
        threadMessage("Čekam da ovaj drugi izdegustira sve ove poruke: importantMessages");
        while (thread1.isAlive()) {
            threadMessage("Ja još čekammm....");
            long pragStrpljenja = System.currentTimeMillis() - startTime;
            if (pragStrpljenja > strpljenje && thread1.isAlive()) {
                threadMessage("Umorio sam se čekajuć te. Ipak sam ja glavni thread.");
                thread1.interrupt();
            }
            thread1.join(2000);
        }
        threadMessage("KOnačno. Nek si i ti završio....");
    }

    static void threadMessage(String message) {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        //print, println, format, printf
        System.out.format("%s: %s %n", threadName, message);
    }

    //Inner klasa
    private static class MessageLoop implements Runnable {

        @Override
        public void run() {
            try {
                String[] importantMessages = {"Fadil jede morske plodove",
                    "Rijad Dautovic i Rogo jedu pastrmku",
                    "Kolegice Ferida i Kanita vole kavijar",
                    "Kemal i Veselin vole od morskih plodova janje kad ga bacite u more",
                    "Malo dijete neku hapicu",
                    "Marko i Haris pozdravljaju Amara i ništa ne jedu jer nisu gladni"};
                for (int i = 0; i < importantMessages.length; i++) {
                    String importanMessage = importantMessages[i];
                    //pauza 
                    Thread.sleep(4000);
                    threadMessage(importanMessage);
                }
            } catch (InterruptedException e) {
                threadMessage("Nisam sve pojeo a ti si me prekinuo");
            }
        }
    }
}
