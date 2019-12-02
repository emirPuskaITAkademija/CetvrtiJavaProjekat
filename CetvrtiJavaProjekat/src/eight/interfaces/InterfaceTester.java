package eight.interfaces;

import eight.enumeration.Gender;
import eight.enumeration.Person;

public class InterfaceTester {
    public static void main(String[] args) {
        NoiseMaker noiseMaker = new NoiseMaker() {
            @Override
            public String makeNoise() {
                return "Dynamic noise maker...";
            }
        };
        //Java SE 1.8
        NoiseMaker noiseMaker1 = ()->"Make noise";
        CheckPerson femaleCheckPerson = new CheckPerson() {
            @Override
            public boolean check(Person person) {
                return person.getGender().equals(Gender.FEMALE);
            }
        };
        boolean result = femaleCheckPerson.check(new Person("Ferida", "Bobar", Gender.FEMALE));
        System.out.println(result);
        CheckPerson maleChecker = (Person p) ->  p.getGender().equals(Gender.MALE);
        String noise = noiseMaker.makeNoise();
        System.out.println(noise);
    }
}
