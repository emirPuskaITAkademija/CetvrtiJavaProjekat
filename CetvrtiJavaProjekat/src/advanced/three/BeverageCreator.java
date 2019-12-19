package advanced.three;
//Closed for modification
public class BeverageCreator {
    public static void main(String[] args) {
        BosnianCaffe bosnianCaffe = new BosnianCaffe();
        drinkBeverage(bosnianCaffe);
        Beverage espresso = new Espresso();
        drinkBeverage(espresso);
        Beverage cocaCola = new CocaCola();
        drinkBeverage(cocaCola);
        System.out.println("Kemal pije:");
        BosnianCaffe kemalovaKafa = new BosnianCaffe();
        Beverage bosnianCaffeWithMilk = new MilkDecorator(kemalovaKafa);
        drinkBeverage(bosnianCaffeWithMilk);
        Beverage espressoWithMilk = new MilkDecorator(new Espresso());
        drinkBeverage(espressoWithMilk);
        System.out.println("IRISH");
        Beverage beverage = new BeverageDecorator(new Espresso(), 0.4, " s rumom");
        drinkBeverage(beverage);
        
        //kafu sa šlagom
        Espresso espresso1 = new Espresso();
        Beverage caffeWithCream = new CreamDecorator(espresso1);
        drinkBeverage(caffeWithCream);
    }
    
    static void drinkBeverage(Beverage beverage){
        System.out.println("Pijem : " + beverage.getName()+" i to me košta : "+beverage.cost());
    }
}
