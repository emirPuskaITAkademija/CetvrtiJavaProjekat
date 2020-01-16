package advanced.five.method.referencing;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum Gender {
        MALE, FEMALE;
    }

    private Gender gender;
    private String name;
    private LocalDate birthday;
    private String emailAddress;

    public Person(Gender gender, String name, LocalDate birthday, String emailAddress) {
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;
        this.emailAddress = emailAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = now.until(birthday);
        int age = period.getYears();
        return age;
    }

    public static List<Person> socialNetwork() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.FEMALE, "Kanita", LocalDate.of(1998, Month.MARCH, 1), "kanita@gmail.com"));
        persons.add(new Person(Gender.MALE, "Amar", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Haris", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.FEMALE, "Ferida", LocalDate.now(), "ferida@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        persons.add(new Person(Gender.MALE, "Kemal", LocalDate.now(), "kemao@gmail.com"));
        return persons;
    }
}
