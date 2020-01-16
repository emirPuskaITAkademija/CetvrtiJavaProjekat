/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.six;

import java.time.LocalDate;

public class AnimalTester {

    public static void main(String[] args) {
        //Martin Fowler
        Animal zeko = new Animal()
                .setId(0)
                .setAnimalType("sisar")
                .setName("Zex")
                .setOwner(new Person(Person.Gender.MALE, "Kanita", LocalDate.of(2000, 10, 10), "snesmk@gmail.com"));
    }
}
