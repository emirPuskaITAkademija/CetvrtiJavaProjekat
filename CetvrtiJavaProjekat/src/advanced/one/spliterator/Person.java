package advanced.one.spliterator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Comparable<Person>{

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
        return name + ", " + surname + ", " + gender.getName() + ", " + birthday.toString();
    }

    // UPAMTITE KAO AKSIOM: hashCode & equals uvijek override zajedno
    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthday, gender);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person comparedObject = (Person) obj;
        return name.equals(comparedObject.getName())
                && surname.equals(comparedObject.getSurname())
                && birthday.equals(comparedObject.getBirthday())
                && gender.equals(comparedObject.getGender());
    }

    @Override
    public int compareTo(Person o) {
        int result = birthday.compareTo(o.getBirthday());
        if(result == 0){
            result = gender.compareTo(o.getGender());
        }
        if(result == 0){
            result = name.compareTo(o.getName());
        }
        return result;
    }

    public static List<Person> socialNetwork() {
        List<Person> socialNetworkList = new ArrayList<>();
        Person amarHodzic1 = new Person("Amar", "Hodzic", Gender.TRANS, LocalDate.of(1991, Month.DECEMBER, 19));
        Person amarHodzic = new Person("Amar", "Hodzic", Gender.MALE, LocalDate.of(1991, Month.DECEMBER, 19));
        socialNetworkList.add(amarHodzic);
        socialNetworkList.add(amarHodzic);
        socialNetworkList.add(amarHodzic1);
        socialNetworkList.add(new Person("Amar", "Hodzic", Gender.MALE, LocalDate.of(1991, Month.DECEMBER, 19)));
        socialNetworkList.add(new Person("Amar", "Topcic", Gender.MALE, LocalDate.of(2001, Month.JANUARY, 5)));
        socialNetworkList.add(new Person("Veselin", "Blagojevic", Gender.MALE, LocalDate.of(1997, Month.SEPTEMBER, 26)));
        socialNetworkList.add(new Person("Omar", "Ali", Gender.MALE, LocalDate.of(1999, Month.AUGUST, 9)));
        socialNetworkList.add(new Person("Demir", "Masic", Gender.MALE, LocalDate.of(2000, Month.MAY, 19)));
        socialNetworkList.add(new Person("Amar", "Prasovic", Gender.MALE, LocalDate.of(2000, Month.FEBRUARY, 8)));
        socialNetworkList.add(new Person("Harun", "Vejo", Gender.MALE, LocalDate.of(2000, Month.AUGUST, 3)));
        socialNetworkList.add(new Person("Mahir", "Babic", Gender.MALE, LocalDate.of(2000, Month.JUNE, 20)));
        socialNetworkList.add(new Person("Haris", "Rizvo", Gender.MALE, LocalDate.of(2000, Month.AUGUST, 11)));
        socialNetworkList.add(new Person("Rijad", "Rogo", Gender.MALE, LocalDate.of(1994, Month.MAY, 15)));
        socialNetworkList.add(new Person("Fadil", "Turalic", Gender.MALE, LocalDate.of(1981, Month.MAY, 2)));
        socialNetworkList.add(new Person("Emir", "Puška", Gender.TRANS, LocalDate.of(1988, Month.SEPTEMBER, 12)));
        socialNetworkList.add(new Person("Kanita", "Muzaferija", Gender.FEMALE, LocalDate.of(1996, Month.AUGUST, 6)));
        socialNetworkList.add(new Person("Ferida", "Bobar", Gender.FEMALE, LocalDate.of(1995, Month.AUGUST, 14)));
        socialNetworkList.add(new Person("Markulina", "Nikolic", Gender.MALE, LocalDate.of(1987, Month.JUNE, 10)));
        socialNetworkList.add(new Person("Marka", "Nikolic", Gender.MALE, LocalDate.of(1987, Month.JUNE, 10)));
        socialNetworkList.add(new Person("Marko", "Nikolic", Gender.FEMALE, LocalDate.of(1987, Month.JUNE, 10)));
        return socialNetworkList;
    }
}
