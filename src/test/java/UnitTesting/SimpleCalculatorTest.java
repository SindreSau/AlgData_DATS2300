package UnitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

    @Test
    void twoPlusTwoEqualsFour() {
        var calc = new SimpleCalculator();
        assertEquals(4, calc.addNums(2, 2));

    }
}

