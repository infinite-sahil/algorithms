package org.somebdody.recursion;

import java.util.stream.IntStream;

/**
 * Most basic example of recursion usage
 */
public class NumberSum {

    public static final String SUM_OF_NUMBERS = "Sum of numbers: ";

    public static void main(String[] args) {
        int uptil = 1000;
        System.out.println(SUM_OF_NUMBERS + sumOfNumbers(uptil));
        System.out.println(SUM_OF_NUMBERS + sumOfNumbersIterative(uptil));
        System.out.println(SUM_OF_NUMBERS + sumOfNumbersJava8Way(uptil));
    }

    /**
     * Recursion way
     */
    private static int sumOfNumbers(final int until) {
        if (until == 1)
            return 1;
        return until + sumOfNumbers(until - 1);
    }

    /**
     * Iterative way
     */
    private static int sumOfNumbersIterative(final int until) {
        int sum = 0;
        for (int i = 1; i <= until; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Using java8 IntStream
     */
    private static int sumOfNumbersJava8Way(final int until) {
        return IntStream.rangeClosed(1, until).sum();
    }
}
