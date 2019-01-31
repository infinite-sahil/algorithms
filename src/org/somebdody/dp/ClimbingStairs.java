package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 10:30 PM
 * ****************************************************************
 * Problem Statement:
 * * -------------------
 * you can climb 1 or 2 stairs with one step.
 * how many different ways can you climb n stairs ?
 *
 */

public class ClimbingStairs {

    public static void main(String[] args) {
        int numberOfStairs = 10;
        System.out.println(climbStairs(numberOfStairs));
    }

    private static long climbStairs(final int numberOfStairs) {
        long[] ways = new long[numberOfStairs + 1];
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

}
