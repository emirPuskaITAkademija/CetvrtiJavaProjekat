package advanced.three;
// 1. 2. 
public class BeverageDecorator extends Beverage{
    
    private final double cost;
    private final Beverage beverage;

    public BeverageDecorator(Beverage beverage,double cost, String name) {
        super(name);
        this.beverage = beverage;
        this.cost = cost;
    }

    @Override
    public double cost() {
        return beverage.cost() + cost;
    }
    
    
}
