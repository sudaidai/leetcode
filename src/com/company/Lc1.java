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

import java.util.HashMap;
import java.util.Map;

public class Lc1 implements Answer{

    @Override
    public int getIndex() {
        return 1;
    }

    // n:  nums.length
    // TC: O(n^2), steps: n*(n-1)/2
    // SC: O(1)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=1 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                if (nums[j] + nums[j-i] == target)
                    return new int[]{j-i, j};
            }
        }
        return new int[]{0, 0};
    }

    // n:  nums.length
    // TC: O(n), steps: 2*n + n*log(n)
    // SC: O(n)
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
