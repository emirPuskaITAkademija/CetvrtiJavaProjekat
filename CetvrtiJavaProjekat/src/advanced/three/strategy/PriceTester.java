/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.three.strategy;

import java.math.BigDecimal;

/**
 *
 * @author Grupa2
 */
public class PriceTester {

    public static void main(String[] args) {
        BigDecimal price = BigDecimal.valueOf(123.45);
        System.out.println("Cijena kada nisu snizenja = " + price.toPlainString());
        BigDecimal priceWithEasterDiscount = new EasterDiscounter().apply(price);
        System.out.println("Cijena sa usksrnim popustom = " + new EasterDiscounter().apply(price));
        BigDecimal newYearPrice = new NewYearDiscounter().apply(price);
        System.out.println("Cijena za novu godinu = " + newYearPrice.toPlainString());
        
    }

}
