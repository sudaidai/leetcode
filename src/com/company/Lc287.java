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

import java.util.Arrays;

public class Lc287 implements Answer{

    @Override
    public int getIndex() {
        return 287;
    }

    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 0);
        for(int i : nums) {
            if(arr[i] == 0) {
                arr[i] = 1;
            } else {
                return i;
            }
        }
        return -1;
    }
}
