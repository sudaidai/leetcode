package com.company;

/**
 * 268. Missing Number
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */

public class Lc268 implements Answer {

    @Override
    public int getIndex() {
        return 268;
    }

    @Override
    public String getRoute() {
        return "missing-number";
    }

    // a^b^b = a
    public int missingNumber(int[] nums) {
        int xor = 0, i;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
