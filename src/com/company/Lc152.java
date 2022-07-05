package com.company;

/*
 * 152. Maximum Product Subarray
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 */

public class Lc152 implements Answer {

    @Override
    public int getIndex() {
        return 152;
    }

    // n:  nums.length
    // TC: O(n), steps: 6*n
    // SC: O(1)
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            if (product > max) max = product;
            if (product == 0) product = 1;
        }
        product = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            product *= nums[i];
            if (product > max) max = product;
            if (product == 0) product = 1;
        }
        return max;
    }

    // n:  nums.length
    // TC: O(n), steps: 6*n
    // SC: O(1)
    public int maxProduct_2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int p1 = 1, p2 = 1, n = nums.length;
        for (int i = 0; i < n; i++) {
            p1 *= nums[i];
            p2 *= nums[n - 1 - i];
            max = Math.max(max, Math.max(p1, p2));
            if (p1 == 0) p1 = 1;
            if (p2 == 0) p2 = 1;
        }
        return max;
    }


}
