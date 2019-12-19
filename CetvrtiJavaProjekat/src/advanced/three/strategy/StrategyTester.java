/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.three.strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Grupa2
 */
public class StrategyTester {

    public static void main(String[] args) {
        BigDecimal price = BigDecimal.valueOf(150.0);
        System.out.println("Price = " + price);
        BigDecimal newYearPrice = new NewYearDiscounter().apply(price);
        System.out.println("New year price = " + newYearPrice.toPlainString());
        BigDecimal newYearPrice1 = Discounter.newYearDiscount().apply(price);
        System.out.println("New year price 1 = " + newYearPrice1);

        Discounter newYearDiscounter = Discounter.newYearDiscount();
        Discounter easterDiscounter = Discounter.easterDiscount();

        List<Discounter> discounters = Arrays.asList(
                it -> it.multiply(BigDecimal.valueOf(0.9)), 
                it-> it.multiply(BigDecimal.valueOf(0.8)), 
                newYearDiscounter, 
                easterDiscounter
                );
        BigDecimal priceWithDouble = newYearDiscounter.
                andThen(easterDiscounter).
                andThen(newYearDiscounter).
                andThen(easterDiscounter)
                .andThen(t -> t.multiply(BigDecimal.valueOf(0.1)))
                .apply(price);
        System.out.println(priceWithDouble.toPlainString());
    }
}
