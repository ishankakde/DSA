/*

leet code problem 300
    - level : medium
    - Longest Increasing Subsequence
    - https://leetcode.com/problems/longest-increasing-subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence
(A subsequence is an array that can be derived from another array by deleting some or no elements
without changing the order of the remaining elements)

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

 */
package com.dsa.lc;

import java.util.Arrays;

public class LongestIncreaseSubSeqMemoization {
    public int lengthOfLIS(int[] nums) {

        //initialize cache for memoization - it will store longest subsequence # unitl that element.
        int[] cache = new int[nums.length];

        //assume longest subsequence is the number itself for all elements.
        Arrays.fill(cache, 1);

        //find the subsequence
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (cache[i] < cache[j] + 1) { // or cache[i] = Math.max(cache[i], cache[j] + 1);
                        cache[i] = cache[j] + 1;
                    }
                }
            }
        }

        //fetch the longest sub sequence length from the cache
        int lengthOfSubSeq = 1;
        for (int k = 0; k < cache.length; k++) {
            if (cache[k] > lengthOfSubSeq) {
                lengthOfSubSeq = cache[k];
            }
        }
        return lengthOfSubSeq;
    }
}
