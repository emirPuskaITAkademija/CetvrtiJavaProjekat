package two;

/**
 *
 * @author EmirPuska
 */
public class Person {

    private String name;
    private String surname;
    private int age;

    public Person(String ime, String prezime, int mladost) {
        this.name = ime;
        this.surname = prezime;
        this.age = mladost;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
