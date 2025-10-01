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

logic -

Pivot point can be on the left side or the right side or at the mid.

Always compare mid with end.
    - If nums[mid] > nums[end] then pivot is in the right half, hence exclude mid.
    - else pivot can be in the left half or at the mid, hence include mid.

At the end, start and end both points to min element.

 */

package com.dsa.lc;

public class MinimumRotatedArray {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        // if the array is not rotated at all or rotated a full cycle (equal to its length)
        if(nums[start] < nums[end]){
            return nums[start];
        }

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[end]){ // Pivot is in the right half excluding mid
                 start = mid + 1;
            }else{
                end = mid;  // Pivot can be on the left half or at the mid, hence include mid
            }
        }

        //start == end, pointing to min element
        return nums[start];

    }
}


