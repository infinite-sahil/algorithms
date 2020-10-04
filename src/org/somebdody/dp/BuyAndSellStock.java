package org.somebdody.dp;

/* ****************************************************************
 *  Author: Sahil Verma
 *  Created on: 04, October, 2020
 * ****************************************************************
 * -----------------------
 * Problem statement:
 * ----- ----- ----- -----
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * if you were only permitted to complete at most one transaction (i.e buy one and sell one share
 * of the stock), design an algorithm to find the maximum profit.
 * ----------------------------------------------------------------------------------
 * Examples:
 * input: [7, 1, 5, 3, 6, 4]
 * output: 5$
 *
 * Max profit: 6 - 1 = 5$

 * input: [7, 6, 4, 3, 1]
 * output: 0$
 *
 * in this case no transaction is done, i.w max profit = 0$.
 * ----------------------------------------------------------------------------------
 */
public class BuyAndSellStock {

    public static void main(String[] args) {
        final int numberOfStocks = 5;
        final int[] stocks = new int[] { 7, 3, 5, 13, 8 };
        final long profit = tradeDp(numberOfStocks, stocks);
        System.out.println("Max profit can be made: " + profit + "$");

    }

    /**
     * Order of n solution using dp
     */
    private static int tradeDp(final int numberOrStocks, final int[] stockPrices) {
        final int[] trade = new int[numberOrStocks];
        trade[0] = 0;
        int minValue = stockPrices[0];

        for (int i = 1; i < numberOrStocks; i++) {
            minValue = Integer.min(minValue, stockPrices[i]);
            trade[i] = Integer.max(trade[i - 1], stockPrices[i] - minValue);
        }
        return trade[numberOrStocks - 1];
    }


    /**
     * O(n2) solution
     */
    private static int trade(final int i, final int[] stocks) {
        if (i == 0) {
            return 0;
        }

        int maxProfit = trade(i - 1, stocks);
        for (int j = 1; j < i; ++j) {
            maxProfit = Integer.max(maxProfit, stocks[i - 1] - stocks[j - 1]);

        }
        return maxProfit;
    }
}
