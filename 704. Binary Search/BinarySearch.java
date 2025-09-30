/*

leet code problem 704
    - level : easy
    - Binary Search
    - https://leetcode.com/problems/binary-search

Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

logic -

Binary search works by repeatedly dividing a sorted array in half to find a target value.
It compares the target to the middle element:
    - If equal, it returns the index.
    - If the target is smaller, it searches the left half; if larger, the right half.
This continues until the target is found or the search space is empty.

How to find mid -
    1. int mid = (start + end) / 2;
        may result in integer overflow if both start and end are large values
        and adding together exceeds integers maximum value (Integer.MAX_VALUE = 2,147,483,647).

    2. int mid = start + (end - start) / 2;
        This avoids directly adding two potentially large numbers.
        (end - start) will not cause integer overflow if start <= end.

 Time  Complexity - O(log n)
 Space Complexity - O(1)

 */

package com.dsa.lc;

public class BinarySearch {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target > nums[mid]){
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else {
                return mid;  // target found
            }
        }
        return -1;  // target not found
    }
}
