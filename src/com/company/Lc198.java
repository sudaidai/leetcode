package com.company;

/*
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

import java.util.Arrays;

public class Lc198 implements Answer {

    @Override
    public int getIndex() {
        return 198;
    }

    @Override
    public String getRoute() {
        return "house-robber";
    }

    public int rob(int[] nums) {
        int v1 = 0;
        int v2 = 0;
        for (int num : nums) {
            int tmp = v1;
            v1 = Math.max(v2 + num , v1);
            v2 = tmp;
        }
        return v1;
    }

//    public int rob(int[] nums) {
//        return rob(nums, nums.length - 1);
//    }
//    private int rob(int[] nums, int i) {
//        if (i < 0) {
//            return 0;
//        }
//        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//    }
}
