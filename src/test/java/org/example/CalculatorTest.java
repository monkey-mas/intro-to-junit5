package org.example;

import org.junit.jupiter.api.*;

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

    @Nested
    @DisplayName("#add")
    class Add {
        @Nested
        @DisplayName("where the sum doesn't overflow")
        class WhereSumDoesNotOverflow {
            @Test
            void returnsSum() {
                int actual = calculator.add(1, 1);
                int expected = 1 + 1;
                assertEquals(expected, actual);
            }
        }

        @Nested
        @DisplayName("where the sum overflows")
        class WhereSumOverflows {
            @Test
            void throwsIllegalArgumentException() {
                assertThrows(IllegalArgumentException.class,
                        () -> calculator.add(Integer.MAX_VALUE, 1));
            }
        }
    }
}
