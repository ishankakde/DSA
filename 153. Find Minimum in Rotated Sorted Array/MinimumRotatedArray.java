/*

leet code problem 153
    - level : medium
    - Find minimum in rotated sorted array
    - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

******
LOGIC -
******
 1. min and max are next to each other in a rotated sorted array
 2. Using binary search algorithm, rotated array gets divided into either
        1. sorted array (which can be ignored) & rotated array (which contains min & max)
        2. two sorted arrays (when mid points to max) ex. 4,5,6,7,0,1,2 or 4,3,5,1,2
 3. after some iterations mid will point to either
        1. max element
        2. min element
    and using mid pointer min/max condition we can find min element.

    mid pointing to min condition should be after mid pointing to max condition because
    when there are just 2 elements left during binary search (i.e. start and end are next
    to each other) then mid points to min will result in index out of bound.
    mid = start + end / 2 -> 0 + 1 / 2 -> 0.5 -> 0 and
    nums[mid -1] = nums[0 - 1] = nums[-1] = resulting array index out of bound exception.
 */

package com.dsa.lc;

public class MinimumRotatedArray {

    public int findMin(int[] nums) {

        //if array has just one element
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        //if array is sorted but not rotated
        if (nums[start] < nums[end]) {
            return nums[start];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // mid pointing to max element
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            //mid pointing to min element
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[start] < nums[mid]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid - 1;
            }
        }
        return -1; //this will never get returned.
    }
}


