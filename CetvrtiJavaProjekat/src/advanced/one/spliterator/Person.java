package advanced.one.spliterator;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private final String surname;
    private final Gender gender;
    private final LocalDate birthday;

    public Person(String name, String surname, Gender gender, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        int years = birthday.until(currentDate).getYears();
        return years;
    }

    @Override
    public String toString() {
        return name +", " + surname +", " + gender.getName() + ", " + birthday.toString();
    }
    
    

    public static List<Person> socialNetwork() {
        List<Person> socialNetworkList = new ArrayList<>();
        socialNetworkList.add(new Person("Amar", "Hodzic", Gender.MALE, LocalDate.of(1991, Month.DECEMBER, 19)));
        socialNetworkList.add(new Person("Harun", "Vejo", Gender.MALE, LocalDate.of(2000, Month.AUGUST, 3)));
        socialNetworkList.add(new Person("Mahir", "Babic", Gender.MALE, LocalDate.of(2000, Month.JUNE, 20)));
        socialNetworkList.add(new Person("Haris", "Rizvo", Gender.MALE, LocalDate.of(2000, Month.AUGUST, 11)));
        socialNetworkList.add(new Person("Rijad", "Rogo", Gender.MALE, LocalDate.of(1994, Month.MAY, 15)));
        socialNetworkList.add(new Person("Fadil", "Turalic", Gender.MALE, LocalDate.of(1981, Month.MAY, 2)));
        socialNetworkList.add(new Person("Emir", "Puška", Gender.TRANS, LocalDate.of(1988, Month.SEPTEMBER, 12)));
        socialNetworkList.add(new Person("Kanita", "Muzaferija", Gender.FEMALE, LocalDate.of(1996, Month.AUGUST, 6)));
        socialNetworkList.add(new Person("Ferida", "Bobar", Gender.FEMALE, LocalDate.of(1995, Month.AUGUST, 14)));
        return socialNetworkList;
    }
}
