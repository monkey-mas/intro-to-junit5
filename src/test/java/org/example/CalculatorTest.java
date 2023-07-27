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
            @Nested
            @DisplayName("given an identity element (0) as a param")
            class GivenIdentityElement {
                @RepeatedTest(20)
                void returnsSum() {
                    int expected = between(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    int actual = calculator.add(0, expected);
                    int actual2 = calculator.add(expected, 0);

                    assertEquals(expected, actual);
                    assertEquals(expected, actual2);
                }
            }

            @RepeatedTest(20)
            void returnsSum() {
                int a = between(Integer.MIN_VALUE, Integer.MAX_VALUE);
                int min = a < 0
                        ? Integer.MIN_VALUE - a
                        : Integer.MIN_VALUE;
                int max = a < 0
                        ? Integer.MAX_VALUE
                        : Integer.MAX_VALUE - a;
                int b = between(min, max);

                int actual = calculator.add(a, b);
                int actual2 = calculator.add(b, a);
                int expected = a + b;
                assertEquals(expected, actual);
                assertEquals(expected, actual2);
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

    /**
     * Returns an integer between {@code min} and {@code max}.
     *
     * @param min minimum value of the range.
     * @param max maximum value of the range.
     * @return
     */
    private static int between(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("");
        }
        return (int) ((Math.random() * ((long) max - (long) min)) + (long) min);
    }
}
