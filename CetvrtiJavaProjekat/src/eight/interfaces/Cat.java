package eight.interfaces;

public class Cat implements NoiseMaker, FoodEater{

    @Override
    public String makeNoise() {
        return "MJAU MJAU";
    }

    @Override
    public void eat() {
        System.out.println("Jedem hranu s blago ispruzenim jezikom zato sto sam ja mačka.");
    } 
}
