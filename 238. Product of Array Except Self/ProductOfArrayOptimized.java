/*

leet code problem 238
    - Product of Array Except Self
    - https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that answer[i] is equal
to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


logic -

create three arrays prefix, suffix and output.

Prefix -
prefix stores product of all the elements on the left of the current element/index.
assign first element prefix to 1 because there is nothing on the left.
for prefix run loop from left to right starting from index 1 to last index.

Suffix -
suffix stores product of all the elements on the right of the current element/index.
assign last element suffix to 1 because there is nothing on the right.
for suffix run loop from right to left starting from index (length - 2) to first index.

Ouput -
After calculating the prefix and suffix arrays, multiply them to get the output array,
where each position holds the product of all elements except the one at that index.

- Time complexity  - O(n) + O(n) + O(n) -> O(3n) -> O(n) - used 3 for loops
- Space complexity - O(n) - used two additional arrays - prefix & suffix.

*/


package com.dsa.lc;

public class ProductOfArrayOptimized {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] prefix = new int[length];
        int[] suffix = new int[length];
        int[] output = new int[length];

        prefix[0] = 1;
        for (int i = 1; i < length; i++) { // till last index
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) { // till 0th index
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            output[i] = suffix[i] * prefix[i];
        }

        return output;
    }
}