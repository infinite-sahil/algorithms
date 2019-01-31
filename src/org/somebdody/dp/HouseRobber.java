package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 30, January, 2019 10:30 PM
 * ****************************************************************
 */
public class HouseRobber {

    public static void main(String[] args) {

        final int numberOfHouse = 5;
        final long[] amountStashedInHouses = new long[]{1, 2, 3, 4, 5};
        System.out.println("Max robbery can be done :" + robHouse(numberOfHouse,
                amountStashedInHouses));

    }

    private static long robHouse(final int numberOfHouse,
            final long[] amountPresentInHouses) {

        long[] robberyCanBeDone = new long[numberOfHouse + 1];
        robberyCanBeDone[0] = 0;

        for (int i = 1; i <= numberOfHouse; ++i) {

            long maxRobberyDone = Long.MIN_VALUE;
            for (int j = i; j <= i; j += 2) {
                long temp = amountPresentInHouses[j] + robberyCanBeDone[j - i];
                if (temp > maxRobberyDone) {
                    maxRobberyDone = temp;
                }
            }
            robberyCanBeDone[i] = maxRobberyDone;
        }
        return robberyCanBeDone[numberOfHouse];
    }


}
