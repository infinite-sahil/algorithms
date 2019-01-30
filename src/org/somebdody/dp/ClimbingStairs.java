package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 10:30 PM
 * ****************************************************************
 */

/**
 * Problem Statement:
 *
 * you can climb 1 or 2 stairs with one step. how many different ways can you climb n stairs ?
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int numberOfStairs = 10;
        System.out.println(climbStairs(numberOfStairs));
    }

    public static long climbStairs(final int numberOfStairs) {
        long[] ways = new long[numberOfStairs + 1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= numberOfStairs; i++)
            ways[i] = ways[i - 1] + ways[i - 2];

        return ways[numberOfStairs];
    }

}
