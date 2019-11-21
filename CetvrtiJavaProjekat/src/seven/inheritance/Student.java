package seven.inheritance;

public class Student extends Person {

    private int indexNumber;

    public Student(String name, String surname, int indexNumber) {
        super(name, surname);
        this.indexNumber = indexNumber;
        System.out.println("Kreiran student....");
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result + " " + indexNumber;
    }

}
