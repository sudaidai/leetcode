package com.company;

/*
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */

public class Lc53 implements Answer {

    @Override
    public int getIndex() {
        return 53;
    }

    @Override
    public String getRoute() {
        return "maximum-subarray";
    }

    // https://leetcode.com/problems/maximum-subarray/discuss/405559/Easy-Understand-Java-Solutions-with-Explanations-(B-F-Divide-And-Conquer-DP)

    // n:  nums.length
    // TC: O(n), steps: 3*n
    // SC: O(1)
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int buffer = 0;
        for (int i = 0; i < nums.length; i++) {
            buffer += nums[i];
            if (buffer > max) max = buffer;
            if (buffer < 0) buffer = 0;
        }
        return max;
    }

    // n:  nums.length
    // TC: O(n), steps: 2*n
    // SC: O(1)
    public int maxSubArray_2(int[] nums) {
        int n = nums.length;
        int SUM = nums[0];
        int OPT = nums[0];
        for (int i = 1; i < n; ++i) {
            SUM = Math.max(SUM + nums[i], nums[i]);
            OPT = Math.max(OPT, SUM);
        }
        return OPT;
    }
}
