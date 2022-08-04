package com.company;

/*
 * 322. Coin Change
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */

import java.util.Arrays;

public class Lc322 implements Answer {

    @Override
    public int getIndex() {
        return 332;
    }

    @Override
    public String getRoute() {
        return "coin-change";
    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }

    /*
    For all coins, there exist cValue denotes coin's value and n > cValue belongs to N
    such that dp[n] = dp[n - cValue] + 1 ,dp[n] means the min number of coins we need
     */
}
