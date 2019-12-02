package nine.reference;
//1. prosljeđivanje po vrijednosti
//2. concept objektne reference

public class PersonExecutor {

    public static void main(String[] args) {
        //PROSTI TIPOVI PODATAKA: prosljeđivanje funkciji vrijednosti a ne informaciju o memorijskoj lokacijia
        int y1 = 23;
        int y2 = 34;
        System.out.println("Prije poziva funkcije x1 = " + y1 + ", x2 = " + y2);
        swap(y1, y2);
        System.out.println("Poslije poziva funkcije x1 = " + y1 + ", x2 = " + y2);
        //person -> objektna referenca
        int i = 5;
        Person person = new Person();
        person.setName("Kanita");
        System.out.println(person.getName() + " , " + i);
        setPersonName(i, person);
        System.out.println(person.getName() + " , " + i);

        int[] numbers = new int[2];
        numbers[0] = 34;
        int j = 5;
        System.out.println(numbers[0] + " , " + j);//34, 5
        receiveArray(numbers, j);
        System.out.println(numbers[0] + " , " + j);//23, 5
        
        Person p1 = new Person();
        p1.setName("Rijad");
        System.out.println(p1.getName());//Rijad    Rijad
        getAnotherPerson(p1);
        System.out.println(p1.getName());//Fadil    Rijad
    }
    //Sta se desilo sa Fadilom ? 
    static void getAnotherPerson(Person person){
        person = new Person();
        person.setName("Fadil");
    }
    

    static void receiveArray(int[] brojevi, int j) {
        j = 34;
        brojevi[0] = 23;
    }

    static void setPersonName(int i, Person p) {
        i = 99;
        p.setName("Ferida");
    }

    static void swap(int x1, int x2) {
        int temp = x1;
        x1 = x2;
        x2 = temp;
        System.out.println("U funkciji x1 = " + x1 + ", x2 = " + x2);
    }
}
