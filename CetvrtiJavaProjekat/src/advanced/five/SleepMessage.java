package advanced.five;
//Thread sleep

public class SleepMessage {

    public static void main(String[] args) throws InterruptedException {
        String[] importantMessages = {"Fadil jede morske plodove",
            "Rijad Dautovic i Rogo jedu pastrmku",
            "Kolegice Ferida i Kanita vole kavijar",
            "Kemal i Veselin vole od morskih plodova janje kad ga bacite u more",
            "Malo dijete neku hapicu",
            "Marko i Haris pozdravljaju Amara i ništa ne jedu jer nisu gladni"};
        for (int i = 0; i < importantMessages.length; i++) {
            //pauzu od 4 sekunde
            String poruka = importantMessages[i];
            System.out.println(poruka);
            if (i == 0) {
                Thread.sleep(4000);
            }
        }

    }
}
