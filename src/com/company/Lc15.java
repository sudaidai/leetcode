package com.company;

/*
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc15 implements Answer {

    @Override
    public int getIndex() {
        return 15;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i == 0 || nums[i] != nums[i-1]) {
                int p1 = i + 1, p2 = nums.length - 1;
                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == -nums[i]) {
                        List<Integer> triplet = List.of(nums[i], nums[p1], nums[p2]);
                        triplets.add(triplet);
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                        p1++;
                        p2--;
                    } else if (nums[p1] + nums[p2] < -nums[i]) p1++;
                    else p2--;
                }
            }
        }
        return triplets;
    }
}
