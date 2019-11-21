package seven;

import seven.inheritance.Person;
import seven.inheritance.Student;
import seven.inheritance.Teacher;

public class SevenExecutor {

    public static void main(String[] args) {
        Person p = new Student("Fadil", "Turalić", 30);
        String result = checkPerson(p);
        System.out.println(result);
        Person p1 = new Teacher("Emir", "Puska", 300);
        result = checkPerson(p1);
        System.out.println(p.toString());
        System.out.println(p1.toString());
    }
    
    private static String checkPerson(Person p){
        if(p instanceof Student){
            return "Student";
        }else if(p instanceof Teacher){
            return "Teacher";
        }else{
            return "Person";
        }
    }
}
