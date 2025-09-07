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

*/

package com.dsa.lc;

/*  - Time complexity  - O(n) + O(n) + O(n) -> O(3n) -> O(n) - used 3 for loops
    - Space complexity - O(n) - used two additional arrays - prefix & suffix.   */

public class ProductOfArrayOptimized {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] prefix = new int[length];
        int[] suffix = new int[length];
        int[] answer = new int[length];

        prefix[0] = 1;
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        suffix[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = suffix[i] * prefix[i];
        }

        return answer;
    }
}