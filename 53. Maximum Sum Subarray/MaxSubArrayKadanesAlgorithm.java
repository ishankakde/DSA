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

The algorithm employs a linear-time strategy (Kadane’s Algorithm) by maintaining a variable currentSum to track
the sum of the current contiguous subarray. If currentSum becomes negative, it is reset to zero since a negative sum
would reduce the potential maximum. The algorithm keeps updating maxSum to store the highest sum seen so far,
ensuring the maximum subarray is found efficiently.

Kadane's Algorithm is a form of dynamic programming.

 */

package com.dsa.lc;

public class MaxSubArrayKadanesAlgorithm {

    public int maxSubArray(int[] nums) {

        int currentSum = 0;
        int maxSum = nums[0];

        for(int i = 0; i < nums.length; i++){
            currentSum = currentSum + nums[i];
            maxSum = Math.max(maxSum, currentSum);
            
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
