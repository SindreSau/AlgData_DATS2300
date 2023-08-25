package UnitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SimpleCalculatorTest {

    @Test
    void twoPlusTwoEqualsFour() {
        var calc = new SimpleCalculator();
        //! Denne ville også vært sann om det var snakk om ganging. Derfor vil man ha flere tester
        assertEquals(4, calc.addNums(2, 2));
    }

    @Test
    void fivePlusTwoEqualsSeven() {
        var calc = new SimpleCalculator();
        assertEquals(7, calc.addNums(5, 2));
    }
}