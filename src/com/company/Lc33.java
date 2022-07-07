package com.company;

/*
 * 33. Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class Lc33 implements Answer {

    @Override
    public int getIndex() {
        return 33;
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (right < left) return -1;
        int mid = (right + left) >>> 1;
        if (arr[mid] == target) return mid;
        if (arr[left] <= target && target < arr[mid]) return binarySearch(arr, left, mid - 1, target);
        else if (arr[mid] < target && target <= arr[right]) return binarySearch(arr, mid + 1, right, target);
        else if (arr[mid] > arr[right]) return binarySearch(arr, mid + 1, right, target);
        else return binarySearch(arr, left, mid - 1, target);
    }
}
