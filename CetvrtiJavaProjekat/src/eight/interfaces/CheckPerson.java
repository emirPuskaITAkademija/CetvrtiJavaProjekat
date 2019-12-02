package eight.interfaces;

import eight.enumeration.Person;

@FunctionalInterface
public interface CheckPerson {

    boolean check(Person person);
}
