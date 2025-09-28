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

This algorithm is NOT Kadane's algorithm, but an adaptation of Kadane’s approach, where both the maximum and
minimum products ending at each index are tracked. This is crucial because multiplying by a negative number
can flip the sign, turning a minimum into a maximum. On each iteration, we update the max and min products by
either starting fresh with the current number or extending the previous product streak. The result keeps track
of the highest product seen so far and is returned at the end.

 */
package com.dsa.lc;

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {     // if num is negative then flip min/max.
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(num, max * num);
            min = Math.min(num, min * num);
            
            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }
}
