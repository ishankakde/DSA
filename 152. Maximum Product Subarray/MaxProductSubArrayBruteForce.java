/*

leet code problem 152
    - level : medium
    - Maximum Product SubArray
    - https://leetcode.com/problems/maximum-product-subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

logic -
This is a brute force approach where code calculates product of all the possible sub-arrays and then finds the max product.
refer code to find all possible sub arrays - https://github.com/ishankakde/DSA/blob/develop/Find%20All%20Sub-Arrays/FindAllSubArrays.java

Time complexity  - O(n^2) - 2 for-loops

 */
package com.dsa.lc;

public class MaxProductSubArrayBruteForce {

    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        for(int i = 0; i < nums.length; i++){
            int currentProduct = 1;
            for(int j = i; j< nums.length; j++){
                currentProduct = currentProduct * nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        return maxProduct;
    }
}
