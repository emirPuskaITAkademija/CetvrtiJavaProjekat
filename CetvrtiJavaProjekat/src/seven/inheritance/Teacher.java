package seven.inheritance;

public class Teacher extends Person {

    private double salary;

    public Teacher(String name, String surname, double salary) {
        super(name, surname);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

}
