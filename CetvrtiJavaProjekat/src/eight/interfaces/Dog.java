package eight.interfaces;

public class Dog implements FoodEater, NoiseMaker {

    @Override
    public void eat() {
        System.out.println("Jedem hranu masuc repom i sa baska ispruzenim jezikom jer ja sam PAS");
    }

    @Override
    public String makeNoise() {
        return "WOW WOW";
    }
}
