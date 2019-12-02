package eight;

import eight.enumeration.Day;
import eight.enumeration.Gender;
import eight.enumeration.Person;
import eight.enumeration.Season;



public class EightExecutor {
    public static void main(String[] args) {
        Day day = new Day(Season.FALL);
        Day day1 = new Day(Season.SPRING);
        //Day day = new Day(Season.SPRING);
        System.out.println(day.getSeason().getName());//Fall
        System.out.println(day1.getSeason().getName());//Spring
        printGender(Gender.TRANS);
        printGender(Gender.MALE);
        printGender(Gender.FEMALE);
    }
    
    static void printGender(Gender gender){
        switch(gender){
            case MALE:
                System.out.println("Ja sam muškarčina");
                break;
            case FEMALE:
                System.out.println("I am a lady");
                break;
            case TRANS:
                System.out.println("Ne znam šta sam");
                break;
            default:
                System.out.println("Unknown gender");
        }
    }
}
