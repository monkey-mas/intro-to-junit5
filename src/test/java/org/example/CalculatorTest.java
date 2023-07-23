package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
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

    @Test
    public void Add_WhereSumOverflows_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.add(Integer.MAX_VALUE, 1));
    }
}
