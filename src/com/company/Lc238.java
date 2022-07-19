package com.company;

/*
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */

public class Lc238 implements Answer {

    @Override
    public int getIndex() {
        return 238;
    }

    @Override
    public String getRoute() {
        return "product-of-array-except-self";
    }

    /*
     * Lets take S = [1,2,3,4] as an example. The expected answer is P = [24, 12, 8, 6].
     *
     * "DIAGRAM" :
     * "1"    <- 1 -> 2*3*4. product = 1 * 2 * 3 * 4
     *  1     <- 2 ->   3*4. product = 1 * 3 * 4
     *  1*2   <- 3 ->    *4. product = 1 * 2 * 4
     *  1*2*3 <- 4 ->    *1. product = 1 * 2 * 3 * 1
     *
     * Given an array S, and N_i is the ith element of S,
     * there P_i = L_i * R_i, where P_i is the product without N_i, L_i supplies
     * DIAGRAM's left element, and R_i supplies DIAGRAM's right element.
     */

    // n:  nums.length
    // TC: O(n), steps: 3*n
    // SC: O(n)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        // left
        product[0] = 1;
        for (int i = 1; i < n; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }
        // *right
        for (int i = n - 1, right = 1; i >= 0; i--) {
            product[i] *= right;
            right *= nums[i];
        }
        return product;
    }
}
