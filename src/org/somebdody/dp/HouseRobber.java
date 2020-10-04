package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 10:30 PM
 * ****************************************************************
 * -----------------------
 * Problem statement:
 * ----- ----- ----- -----
 * You are a professional robber, planning to rob houses along a street.
 *
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent housed have security system connected
 * and it will automatically contact the police if 2 adjacent houses were broken into
 * on the same night.
 *
 * ----------------------------------------------------------------------------------
 * Given a list of non-negative integers representing amount of money of each house,
 * determine the maximum amount of money you can rob without alerting the police.
 * ----------------------------------------------------------------------------------
 */
public class HouseRobber {

    public static void main(String[] args) {

        final int numberOfHouse = 7;
//        final long[] amountStashedInHouses = new long[] { 1, 2, 3, 4, 5 };
        final long[] amountStashedInHouses = new long[] { 4, 3, 2, 5, 2, 1, 5 };
        final long rob = robHouse(numberOfHouse, amountStashedInHouses);
        System.out.println("Max robbery can be done :" + rob);

    }

    private static long rob(final int numberOfHouse, final long[] nums) {

        final long[] robberyCanBeDone = new long[numberOfHouse + 1];
        robberyCanBeDone[0] = 0;
        // as you can either steal 1st or 2nd house
        robberyCanBeDone[1] = Long.max(nums[0], nums[1]);

        for (int i = 2; i < numberOfHouse; ++i) {
            /*
                setting value as previous value, this denotes that we
                didn't steal.
                = X i
             */
            robberyCanBeDone[i] = robberyCanBeDone[i - 1];
            for (int j = i - 2; j >= 0; --j) {
                robberyCanBeDone[i] = Long.max(robberyCanBeDone[i], robberyCanBeDone[j] + nums[i]);
            }
        }
        return robberyCanBeDone[numberOfHouse - 1];
    }

    /**
     * Recursive - Exponential solution
     */
    private static long robHouse(final int i, final long[] nums) {
        if (i == 1) {
            return nums[0];
        }

        long maxAmount = Long.MIN_VALUE;

        // when we don't steal the house i
        maxAmount = Long.max(maxAmount, robHouse(i - 1, nums));

        // when we steal the house i
        for (int j = i - 2; j >= 0; --j) {
            maxAmount = Long.max(maxAmount, robHouse(j, nums) + nums[i - 1]);
        }

        return maxAmount;
    }
}
