package advanced.three;

public class CocaCola extends Beverage {

    public CocaCola() {
        super("Coca cola");
    }

    @Override
    public double cost() {
        return 2.99;
    }
}
