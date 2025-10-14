/*

leet code problem 53
    - level : medium
    - Maximum Subarray
    - https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the subarray (A subarray is a contiguous non-empty sequence
of elements within an array) with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

logic -
This is a brute force approach where code calculates sum of all the possible sub-arrays and then finds the max sum.
refer code to find all possible sub arrays - https://github.com/ishankakde/DSA/blob/develop/Find%20All%20Sub-Arrays/FindAllSubArrays.java

Time complexity  - O(n^2) - 2 for-loops

 */
package com.dsa.lc;

public class MaxSubArrayBruteForce {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int currentSum = 0;
            for(int j = i; j < nums.length; j++){
                currentSum = currentSum + nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
