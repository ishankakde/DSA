/*

leet code problem 238
    - Product of Array Except Self
    - https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


logic -
Instead of creating three different arrays prefix, suffix and output use just one.
first calculate prefix and store in output,
then calculate suffix and multiply with prefix and store in output

    - Time complexity  - O(n)
    - Space complexity - O(1) - no additional arrays used

*/

package com.dsa.lc;

public class ProductOfArrayOptimal {

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] output = new int[length];

        // calculate prefix
        output[0] = 1;
        for (int i = 1; i < length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // calculate suffix
        int suffix = 1;
        for (int i = length - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1];
            output[i] = output[i] * suffix;
        }

        return output;
    }
}