package com.company;

/*
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class Lc121 implements Answer{

    @Override
    public int getIndex() {
        return 121;
    }

    // n:  prices.length
    // TC: O(n), steps: 3*n
    // SC: O(1)
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0 ; i<prices.length ; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }

            int profit = prices[i] - low;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
