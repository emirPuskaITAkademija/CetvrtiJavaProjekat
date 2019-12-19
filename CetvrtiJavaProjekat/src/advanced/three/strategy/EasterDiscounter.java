package advanced.three.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EasterDiscounter implements Discounter {

    @Override
    public BigDecimal apply(BigDecimal amount) {
        BigDecimal percentage = new BigDecimal(0.5);
        BigDecimal result = amount.multiply(percentage);
        result = result.setScale(2, RoundingMode.HALF_UP);
        return result;
    }
}
