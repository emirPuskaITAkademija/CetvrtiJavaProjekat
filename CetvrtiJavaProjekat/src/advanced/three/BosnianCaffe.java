package advanced.three;
//SOLID 
// S -> Single object responsibility
// O -> Open/close principle
// L -> Liskov substitution principle

public class BosnianCaffe extends Beverage {

    public BosnianCaffe() {
        super("Bosanska kafa");
        System.out.println("Pravi konobar bosansku kafu");
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
