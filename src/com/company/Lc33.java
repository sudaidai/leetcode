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

import java.util.Arrays;

public class Lc33 implements Answer {

    @Override
    public int getIndex() {
        return 33;
    }

    @Override
    public String getRoute() {
        return "search-in-rotated-sorted-array";
    }

    public int search(int[] nums, int target) {
        return binarySearch_2(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (right < left) return -1;
        int mid = (right + left) >>> 1;
        if (arr[mid] == target) return mid;
        if (arr[left] <= target && target < arr[mid]) return binarySearch(arr, left, mid - 1, target);
        else if (arr[mid] < target && target <= arr[right]) return binarySearch(arr, mid + 1, right, target);
        else if (arr[mid] > arr[right]) return binarySearch(arr, mid + 1, right, target);
        else return binarySearch(arr, left, mid - 1, target);
    }

    public int binarySearch_2(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (target == arr[mid]) return mid;
            if (arr[left] <= arr[right]) {
                if (target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < arr[right] && arr[mid] < arr[left]) {
                    if (arr[mid] < target && target <= arr[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (arr[mid] > target && target >= arr[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public int search_2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) return mid;
            if (nums[left] <= nums[mid]) {
                if (target < nums[left] || target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (target > nums[right] || target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public int search_3(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int l = nums.length;
        int left = (target <= nums[l - 1]) ? minIdx : 0;
        int right = (target > nums[l - 1]) ? minIdx : l;
        int result = Arrays.binarySearch(nums, left, right, target);
        if (result < 0) return -1;
        else return result;
    }

    public int findMinIdx(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
