package advanced.two;

import advanced.one.spliterator.Person;

@FunctionalInterface
public interface CheckPerson {
 // -> LAMBDA 
    public boolean check(Person person);
}
