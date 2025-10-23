/*

leet code problem 154
    - level : hard
    - Find minimum in rotated sorted array II (may contain duplicate)
    - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
You must decrease the overall operation steps as much as possible.

Example 1:
Input: nums = [1,3,5]
Output: 1

Example 2:
Input: nums = [2,2,2,0,1]
Output: 0

logic -

Pivot point can be on the left side or the right side or at the mid.

Always compare mid with end.
    - If nums[mid] > nums[end] then pivot is in the right half, hence exclude mid.
    - else If nums[mid] < nums[end], then pivot can be in the left half or at the mid, hence include mid.
    - else nums[mid] == nums[end], which means we have found a duplicate, so we reduce the search space.

At the end, start and end both points to min element.

 */

package com.dsa.lc;

public class MinimumRotatedArrayII {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        if(nums[start] < nums[end]){   //Optional condition - if the array is not rotated or rotated to a full cycle.
            return nums[start];
        }

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[end]){   //Pivot is in the right half excluding mid
                 start = mid + 1;
            }else if(nums[mid] < nums[end]){   //Pivot can be on the left half or at the mid, hence include mid
                end = mid;
            }else{   //duplicate, nums[mid] == nums[end], reduce search space by 1 from end.
                end = end - 1;
            }
        }

        return nums[start];   //start == end, pointing to min element
    }
}


