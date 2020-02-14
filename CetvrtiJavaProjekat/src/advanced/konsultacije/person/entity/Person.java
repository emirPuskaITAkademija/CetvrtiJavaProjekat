package advanced.konsultacije.person.entity;

import java.sql.Date;

public class Person {

    private int id;
    private String name;
    private String surname;
    private Date birthday;

    public Person(int id, String name, String surname, Date birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

}
