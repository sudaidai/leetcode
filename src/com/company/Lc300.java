package com.company;

/*
 * 300. Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */

import java.util.Arrays;

public class Lc300 implements Answer {

    @Override
    public int getIndex() {
        return 300;
    }

    @Override
    public String getRoute() {
        return "longest-increasing-subsequence";
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int n : nums) {
            int index = Arrays.binarySearch(dp, 0, len, n);
            if (index < 0) {
                index = -(index + 1);
                dp[index] = n;
            }
            if (index == len) len++;
        }
        return len;
    }


    /*
     * Case 1. If A[i] is smallest among all end
     * candidates of active lists, we will start
     * new active list of length 1.
     *
     * Case 2. If A[i] is largest among all end candidates of
     * active lists, we will clone the largest active
     * list, and extend it by A[i].
     *
     * Case 3. If A[i] is in between, we will find a list with
     * largest end element that is smaller than A[i].
     * Clone and extend this list by A[i]. We will discard all
     * other lists of same length as that of this modified list.
     */

    /*
     * It will be clear with an example, let us take example from {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}.
     * A[0] = 0. Case 1. There are no active lists, create one.
     * 0.
     * -----------------------------------------------------------------------------
     * A[1] = 8. Case 2. Clone and extend.
     * 0.
     * 0, 8.
     * -----------------------------------------------------------------------------
     * A[2] = 4. Case 3. Clone, extend and discard.
     * 0.
     * 0, 4.
     * 0, 8. Discarded
     * -----------------------------------------------------------------------------
     * A[3] = 12. Case 2. Clone and extend.
     * 0.
     * 0, 4.
     * 0, 4, 12.
     * -----------------------------------------------------------------------------
     * A[4] = 2. Case 3. Clone, extend and discard.
     * 0.
     * 0, 2.
     * 0, 4. Discarded.
     * 0, 4, 12.
     * -----------------------------------------------------------------------------
     * A[5] = 10. Case 3. Clone, extend and discard.
     * 0.
     * 0, 2.
     * 0, 2, 10.
     * 0, 4, 12. Discarded.
     * -----------------------------------------------------------------------------
     * A[6] = 6. Case 3. Clone, extend and discard.
     * 0.
     * 0, 2.
     * 0, 2, 6.
     * 0, 2, 10. Discarded.
     * -----------------------------------------------------------------------------
     * A[7] = 14. Case 2. Clone and extend.
     * 0.
     * 0, 2.
     * 0, 2, 6.
     * 0, 2, 6, 14.
     * -----------------------------------------------------------------------------
     * A[8] = 1. Case 3. Clone, extend and discard.
     * 0.
     * 0, 1.
     * 0, 2. Discarded.
     * 0, 2, 6.
     * 0, 2, 6, 14.
     * -----------------------------------------------------------------------------
     * A[9] = 9. Case 3. Clone, extend and discard.
     * 0.
     * 0, 1.
     * 0, 2, 6.
     * 0, 2, 6, 9.
     * 0, 2, 6, 14. Discarded.
     * -----------------------------------------------------------------------------
     * A[10] = 5. Case 3. Clone, extend and discard.
     * 0.
     * 0, 1.
     * 0, 1, 5.
     * 0, 2, 6. Discarded.
     * 0, 2, 6, 9.
     * -----------------------------------------------------------------------------
     * A[11] = 13. Case 2. Clone and extend.
     * 0.
     * 0, 1.
     * 0, 1, 5.
     * 0, 2, 6, 9.
     * 0, 2, 6, 9, 13.
     * -----------------------------------------------------------------------------
     * A[12] = 3. Case 3. Clone, extend and discard.
     * 0.
     * 0, 1.
     * 0, 1, 3.
     * 0, 1, 5. Discarded.
     * 0, 2, 6, 9.
     * 0, 2, 6, 9, 13.
     * -----------------------------------------------------------------------------
     * A[13] = 11. Case 3. Clone, extend and discard.
     * 0.
     * 0, 1.
     * 0, 1, 3.
     * 0, 2, 6, 9.
     * 0, 2, 6, 9, 11.
     * 0, 2, 6, 9, 13. Discarded.
     * -----------------------------------------------------------------------------
     * A[14] = 7. Case 3. Clone, extend and discard.
     * 0.
     * 0, 1.
     * 0, 1, 3.
     * 0, 1, 3, 7.
     * 0, 2, 6, 9. Discarded.
     * 0, 2, 6, 9, 11.
     * ----------------------------------------------------------------------------
     * A[15] = 15. Case 2. Clone and extend.
     * 0.
     * 0, 1.
     * 0, 1, 3.
     * 0, 1, 3, 7.
     * 0, 2, 6, 9, 11.
     * 0, 2, 6, 9, 11, 15. <-- LIS List
     * ----------------------------------------------------------------------------
     */
}
