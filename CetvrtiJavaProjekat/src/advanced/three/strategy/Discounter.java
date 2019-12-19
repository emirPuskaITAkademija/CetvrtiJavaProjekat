package advanced.three.strategy;

import java.math.BigDecimal;
import java.util.function.Function;

@FunctionalInterface
public interface Discounter extends Function<BigDecimal, BigDecimal>{

  //BigDecimal apply(BigDecimal amount);

    static Discounter newYearDiscount() {
        //objekat koji predstavlja novogodisnji popust 30 %
        Discounter discounter = price -> price.multiply(BigDecimal.valueOf(0.7));
        return discounter;
    }

    static Discounter easterDiscount() {
        //objekat koji predstavlja novogodisnji popust 30 %
        Discounter discounter = price -> price.multiply(BigDecimal.valueOf(0.5));
        return discounter;
    }
}
