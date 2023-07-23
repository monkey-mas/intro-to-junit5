package org.example;

public class Calculator {
    /**
     * Returns the sum of the input {@code a} and {@code b}.
     *
     * @param a left operand of the addition.
     * @param b right operand of the addition.
     * @return sum of the two input arguments.
     * @throws IllegalArgumentException if the sum overflows.
     */
    public int add(int a, int b) throws IllegalArgumentException {
        int sum = a + b;

        if (isOverflow(a, b, sum)) {
            throw new IllegalArgumentException("The sum overflows...");
        }

        return sum;
    }

    /**
     * Returns true if the {@code sum} of {@code a} and {@code b} overflows.
     * Otherwise, false is returned.
     *
     * e.g.,
     * a = 2^31 (== Integer.MAX_VALUE)
     * b = 1
     * sum = 2^31 + 1
     *     = Integer.MIN_VALUE due to overflow.
     *
     * @param a left operand of the sum operation.
     * @param b right oeprand of the sum operation.
     * @param sum sum of the a and b based on the operation `a + b`.
     * @return true if the {@code sum} overflows.
     */
    private boolean isOverflow(int a, int b, int sum) {
        if (a > 0 && b > 0 && sum < 0) {
            return true;
        }
        if (a < 0 && b < 0 && sum >= 0) {
            return true;
        }
        return false;
    }
}
