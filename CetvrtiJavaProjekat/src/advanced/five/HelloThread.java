
package advanced.five;

import advanced.one.spliterator.Gender;
import advanced.one.spliterator.Person;
import java.time.LocalDate;
import java.time.Month;

public class HelloThread extends Thread{

    public void test(){
            System.out.println("Vozdra Amare, pitanje je odlicno : " + Thread.currentThread().getName());
    }
    
    @Override
    public void run() {
        System.out.println("test iz drugog threada");
        test();
        Person p = new Person("Amar", "Topčić", Gender.MALE, LocalDate.of(2001, Month.JANUARY, 5));
        System.out.println(p.getBirthday().toString()+ Thread.currentThread().getName());
        System.out.println("Pozdrav iz: "+Thread.currentThread().getName());
    }
}
