package gui.seven;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regularni izrazi-  PERL programski
 * <p>
 * Regularni izrazi - su način da se opiše tekstualni set(set of strings) na osnovu 
 * zajedničkih karakteristika za svaki string unutar tog tekstualnog seta.
 * String text = "skmslfmskf dskd ";
 * String regex = " ";
 * <p>
 * <ol>
 * <li>Pattern -> regex(String)
 * <li> Matcher -> text po patternu koji smo ranije definirali testirati
 * 
 * <p>
 * Zasto mozemo koristiti regularne izraze:
 * <ol>
 * <li>Mogu biti iskorišteni za pretragu
 * <li>modifikaciju ili editovanje
 * <li>manipulacije sa tekstom na osnovu regex i kreiranog pattern
 * @author Grupa2
 */
public class RegexTester {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                System.out.println("Unesi regex ili pattern:");
                //regularni izraz
                String regex = scanner.nextLine();//selma, foo, cat[1-5]
                Pattern pattern = Pattern.compile(regex);//pattern -> selma, foo
                System.out.println("Unesi sada text");
                String text = scanner.nextLine();//foofoofoofoo Pozdrav raja, Mirzad, Kemal, RijadR, RijadD, KanitaM
                Matcher matcher = pattern.matcher(text);
                boolean found = false;
                while(matcher.find()){
                    String matcherGroup = matcher.group();
                    int startPosition = matcher.start();
                    int endPosition = matcher.end();
                    System.out.format("Pronašao sam tekst '%s' koji počinje na indeksu '%d' a završava na indeksu '%d'.%n", matcherGroup, startPosition, endPosition);
                    found = true;
                }
                if(!found){
                    System.out.format("Nema ništa u tekstu '%s' što odgovara regularnom izrazu '%s'.%n", text, regex);
                }
            }
            
        }catch(Exception e){
            System.err.println("No matching");
        }
    }
}
