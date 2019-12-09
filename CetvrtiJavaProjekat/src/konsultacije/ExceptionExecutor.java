package konsultacije;

import advanced.one.spliterator.Gender;
import advanced.one.spliterator.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * This class represents story about Exception handling
 * <p>
 * Three kinds of exception:
 * <li>Checked exception</li>
 * Provjeravani izuzeci su izuzeci od kojih se dobro napisana aplikacija moze
 * oporovati. Provjeravani izuzeci su kandidati za obradu unutar catch. Svi
 * izuzeci su provjeravani izuzeci osim onih koji nasljeđuju Error,
 * RuntimeException.
 * <li>Error</li> -> Unchecked exception Pretpostavimo da smo prilikom čitanja
 * fajla useru dali za pravo da unese puno ime fajla. User ili korisnik se
 * namučio i unio kako treba ime fajla i program počeo čitati taj fajl ali zbog
 * hardverske greške, malformed OS ili nekog razloga na koji naš prpogram ne
 * može uticati jednostavno ne možemo čitati fajl. Error izuzeci nisu uopće tema
 * catch bloka.
 * <li>RuntimeException</li> -> Unchecked exception Ovo je treća verzija
 * izuzetaka koje kompajler ne detektuje. Ovi izuzeci su rezultat programerskih
 * grešaka.
 *
 * @author Grupa2
 */
public class ExceptionExecutor {

    public static void main(String[] args) {
        String[] names = new String[5];
        names[4] = "Rijad Rogo";//Runtime exception
        names[0] = "Rijad Dautović";
        Person p1 = new Person("Rijad", "Rogo", Gender.MALE, LocalDate.MIN);
        System.out.println(p1.getAge());//NullPointerException4
        float number = 23f;
        float res = number / 0f;
        ExceptionExecutor exceptionExecutor = new ExceptionExecutor();
        Scanner scanner = null;
        try {
            exceptionExecutor.something(scanner);
        } catch (FileNotFoundException exc) {
            System.out.println("Rzalog nečitanja fajla: " + exc.getMessage());
        }finally{
            if(scanner != null){
                scanner.close();
            }
        }

    }

    public void something(Scanner scanner) throws FileNotFoundException {
        readFile(scanner);
    }

    //ovo je jednolinijski komentar
    /*
    
     */
    public void readFile(Scanner scanner) throws FileNotFoundException {
       scanner = new Scanner(new File("fajl.txt"));
    }
}
