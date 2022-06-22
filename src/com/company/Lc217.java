package com.company;

/*
 * 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lc217 implements Answer{

    @Override
    public int getIndex() {
        return 217;
    }

    // n:  nums.length
    // TC: O(n^2) ~ Θ(n*log(n)), steps: n*log(n)+n | n^2 + n
    // SC: O(1) ~ O(log(n))
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0 ; i<nums.length-1 ; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    // n:  nums.length
    // TC: O(n), steps: n
    // SC: O(n)
    public boolean containsDuplicate_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0 ; i<nums.length ; i++) {
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

}
