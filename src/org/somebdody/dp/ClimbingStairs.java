package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 10:30 PM
 * ****************************************************************
 *   Problem Statement:
 * * --------------------------------------------------------------
 *  You can climb 1 or 2 stairs with one step, how many different ways can you climb n stairs ?
 *
 */

public class ClimbingStairs {

    public static final String MESSAGE =
            "*** Number of ways to climb %s stairs - (%s) ==> %s ways, Time taken: %s nanoseconds";

    public static void main(String[] args) {
        int numberOfStairs = 45;
        // recursive solution : this takes a lot of time for larger input
        long start = System.nanoTime();
        long ways = recursiveClimbStairs(numberOfStairs);
        long end = System.nanoTime();


        System.out.printf((MESSAGE) + "%n", numberOfStairs, "recursive", ways, (end - start));

        // using dp
        start = System.nanoTime();
        ways = climbStairs(numberOfStairs);
        end = System.nanoTime();
        System.out.printf((MESSAGE) + "%n", numberOfStairs, "dynamic programming", ways, (end - start));
    }

    /**
     * This solution uses existing array and work far far better than recursive one
     *
     * @param numberOfStairs stairs to climb
     * @return number ot way to climb N stairs
     */
    private static long climbStairs(final int numberOfStairs) {
        final long[] ways = new long[numberOfStairs + 1];
        // to climb 1 stair: it gonna take 1 step
        ways[1] = 1;
        /*
            To climb 2 stairs, it can achieved by 2 ways:
                1 way - 1 step climb then again 1 step climb
                2 way - direct 2 step climb
         */
        ways[2] = 2;

        for (int i = 3; i <= numberOfStairs; i++) {
            // here we are getting values from the already derived values (i.e that are present in the ways array)
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[numberOfStairs];
    }

    /**
     * This solution takes exponential time
     *
     * @param stairsToClimb stairs to climb
     * @return number of ways to climb N stairs
     */
    private static long recursiveClimbStairs(final int stairsToClimb) {
        if (stairsToClimb == 1) {
            return 1;
        } else if (stairsToClimb == 2) {
            return 2;
        }

        return recursiveClimbStairs(stairsToClimb - 1) + recursiveClimbStairs(stairsToClimb - 2);
    }

}
