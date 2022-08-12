package com.company;

/*
 * 371. Sum of Two Integers
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */

public class Lc377 implements Answer {

    @Override
    public int getIndex() {
        return 377;
    }

    @Override
    public String getRoute() {
        return "combination-sum-iv";
    }

    // Time Limit Exceeded
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i] ) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        return res;
    }

    public int combinationSum4_2(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
}
