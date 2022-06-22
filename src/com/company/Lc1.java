package com.company;

/*
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */

public class Lc1 implements Answer{

    @Override
    public int getIndex() {
        return 1;
    }

    // steps: n*(n-1)/2
    // n:     nums.length
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=1 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                if (nums[j] + nums[j-i] == target)
                    return new int[]{j-i, j};
            }
        }
        return null;
    }
}
