
package advanced.seven;
//Singleton - 
//Effective Java SFP

import java.time.LocalDate;
import java.time.Month;

public class SevenExecutor {
    public static void main(String[] args) {
        Book book1 = Book.of(0, "Fadil", "Stomatološka praksa");
        Book book2 = Book.withoutIsbn("Effective Java", "Josh Bloch", LocalDate.of(2010, Month.MARCH, 1));
        
    }
}
