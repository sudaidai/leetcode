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

    // Sliding Window
    // n:  nums.length
    // TC: O(n), steps: 2*n
    // SC: O(1)
    public int maxSubArray_2(int[] nums) {
        int a = nums[0], b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = Math.max(a + nums[i], nums[i]);
            b = Math.max(a, b);
        }
        return b;
    }
}
