package com.company;

/*
 * 300. Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */

import java.util.Arrays;

public class Lc300 implements Answer {

    @Override
    public int getIndex() {
        return 300;
    }

    @Override
    public String getRoute() {
        return "longest-increasing-subsequence";
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int n : nums) {
            int index = Arrays.binarySearch(dp, 0, len, n);
            if (index < 0) {
                index = -(index + 1);
                dp[index] = n;
            }
            if (index == len) len++;
        }
        return len;
    }
}
