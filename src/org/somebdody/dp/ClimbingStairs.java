package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 10:30 PM
 * ****************************************************************
 *   Problem Statement:
 * * --------------------------------------------------------------
 * you can climb 1 or 2 stairs with one step or two step, how many different ways can you climb n stairs ?
 *
 */

public class ClimbingStairs {


    public static void main(String[] args) {
        int numberOfStairs = 30;
        long start = System.nanoTime();
        // recursive solution : this takes a lot of time for larger input
        long ways = recursiveClimbStairs(numberOfStairs);
        long end = System.nanoTime();
        System.out
                .println("*** Number of ways to climb " + numberOfStairs
                        + " stairs - (recursive) ==> "
                        + ways + ", Time taken: " + (end - start));
        // using dp
        start = System.nanoTime();
        ways = climbStairs(numberOfStairs);
        end = System.nanoTime();
        System.out.println(
                "*** Number of ways to climb " + numberOfStairs
                        + " stairs - (dynamic programming) ==> " + ways + ", Time taken: " + (end
                        - start));
    }

    /**
     * This solution uses existing array and work far far better than recursive one
     * @param numberOfStairs stairs to climb
     * @return number ot way to climb N stairs
     */
    private static long climbStairs(final int numberOfStairs) {
        final long[] ways = new long[numberOfStairs + 1];
        // to climb 1 stair: it gonna take 1 step
        ways[1] = 1;
        // to climb 2 stair: it can be done (1-climb ,1-climb OR direct 2 climb), so 2 ways
        ways[2] = 2;
        for (int i = 3; i <= numberOfStairs; i++) {
            // here we are getting values from the already derived values (i.e that are present in the ways array)
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[numberOfStairs];
    }

    /**
     * This solution takes exponential time
     * @param numberOfStairs stairs to climb
     * @return number ot way to climb N stairs
     */
    private static long recursiveClimbStairs(final int numberOfStairs) {
        if (numberOfStairs == 1)
            return 1;
        else if (numberOfStairs == 2)
            return 2;

        return recursiveClimbStairs(numberOfStairs - 1) + recursiveClimbStairs(numberOfStairs - 2);
    }

}
