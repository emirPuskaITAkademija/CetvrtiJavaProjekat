package gui.two;

public class Person {

    private final int id;
    private final String lastName;
    private final String firstName;
    private final int age;

    public Person(int id, String lastName, String firstName, int age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return lastName+", " + firstName;
    }

    
}
