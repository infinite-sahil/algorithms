package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 10:30 PM
 * ****************************************************************
 * Problem Statement:
 * -------------------
 * Given a rod of length N and prices P[i] = 1, . . . . ., n
 * where p[i] is the price of a rod of length i.
 * Find the maximum total revenue you can make by cutting
 * and selling  the rod (assume no cost for cutting the rod)
 */
public class CuttingRods {

    // this is a maximization problem
    public static void main(String[] args) {

        int rodLength = 8;
        final long[] prices = {1, 5, 3, 9, 10, 11, 15, 18};

        System.out.println("Max revenue found: " + findMaxRevenueRecursive(rodLength, prices));
        System.out.println("Max revenue found: " + findMaxRevenue(rodLength, prices));

    }

    /**
     * Solution using dynamic programming O(n2) - complexity
     * @param rodLength length of the rod
     * @param prices price of the rod with count
     */
    private static long findMaxRevenue(final int rodLength, final long[] prices) {
        final long[] revenues = new long[rodLength + 1];
        revenues[0] = 0;
        for (int i = 1; i <= rodLength; ++i) {
            long maxRevenue = Long.MIN_VALUE;

            for (int j = 1; j <= i; ++j) {
                long tempRevenue = prices[j - 1] + revenues[i - j];
                if (tempRevenue > maxRevenue)
                    maxRevenue = tempRevenue;
            }
            revenues[i] = maxRevenue;
        }

        return revenues[rodLength];
    }

    /**
     * This is not the right way to do things - expensive one recursive solution: large length -
     * exponential solution
     */
    private static long findMaxRevenueRecursive(final int rodLength, final long[] prices) {
        long maxRevenue = -1;
        // as rod of length zero will have no revenue
        if (rodLength == 0)
            return 0;

        for (int i = 0; i < rodLength; ++i) {
            // revenue = price of rod cut uptil + max revenue can be gained out of the rest of the rod length
            long tempRevenue = prices[rodLength - i - 1] + findMaxRevenueRecursive(i, prices);
            if (tempRevenue > maxRevenue)
                maxRevenue = tempRevenue;
        }

        return maxRevenue;
    }

}
