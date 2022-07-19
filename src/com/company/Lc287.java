package com.company;

/*
 * 287. Find the Duplicate Number
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */

public class Lc287 implements Answer{

    @Override
    public int getIndex() {
        return 287;
    }

    @Override
    public String getRoute() {
        return "find-the-duplicate-number";
    }

    public int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for(int i : nums) {
            if(arr[i]) {
                return i;
            } else {
                arr[i] = true;
            }
        }
        return -1;
    }
}
