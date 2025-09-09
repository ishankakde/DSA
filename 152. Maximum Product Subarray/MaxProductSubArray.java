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

 */
package com.dsa.lc;

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            // after multiplying with -ve number, max becomes min and min becomes max, therefore flip min/max.
            if (val < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(val, max * val);
            min = Math.min(val, min * val);

            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }
}
