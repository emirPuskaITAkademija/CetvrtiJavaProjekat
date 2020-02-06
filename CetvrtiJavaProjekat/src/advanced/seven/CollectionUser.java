/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.seven;

import advanced.six.Person;
import java.util.Collection;

/**
 *
 * @author Grupa2
 */
public class CollectionUser {

    //DEPENDENT INJECTION
    private final Collection<Person> collection;

    public CollectionUser(Collection<Person> collection) {
        this.collection = collection;
    }

    public void procesCollection() {
        for (Person p : collection) {
            System.out.println(p);
        }
    }
}
