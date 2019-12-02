package nine.reference;

public class StringExecutor {

    public static void main(String[] args) {
        String name = new String("Amar");
        String name1 = new String("Marko");
        String name2 = "Marko";
        System.out.println(name1.equals(name2));
        String names = "Ferida "
                + "Kanita "
                + "Rijad "
                + "Fadila";
        //split(String regex)ž
        System.lineSeparator();
        String[] niz = names.split("\n");
        System.out.println(niz.length);
        for(int i = 0; i<niz.length; i++){
            String vrijednost = niz[i];
            System.out.print(vrijednost +", ");
        }
    }
}
