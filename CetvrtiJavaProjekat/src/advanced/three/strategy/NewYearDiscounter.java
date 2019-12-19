/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.three.strategy;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class NewYearDiscounter implements Discounter {

    @Override
    public BigDecimal apply(BigDecimal amount) {
        // 100 = 30 + 70 
        // amount = 50 KM
        // (30/100)*amount =  0.3 *50  (30 % od 50)
        // amountNakonSnizenja = amount - (30/100)*amount
        // amountNakonSNizenja = amount*(70/100)
        BigDecimal percentage = new BigDecimal(0.7);
        BigDecimal result = percentage.multiply(amount, new MathContext(2, RoundingMode.HALF_UP));
        return result;
    }

}
