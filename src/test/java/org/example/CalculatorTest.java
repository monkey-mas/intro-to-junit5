package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        // Set up before running each @Test method,
        // e.g., create mock instance.
        calculator = new Calculator();
    }

    @Test
    public void Add_ReturnsSum() {
        int actual = calculator.add(1, 1);
        int expected = 1 + 1;
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Add_WhereSumOverflows_ThrowsIllegalArgumentException() {
        calculator.add(Integer.MAX_VALUE, 1);
    }
}
