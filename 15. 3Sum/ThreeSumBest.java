/*
leet code problem 15
    - level : medium
    - 3 Sum
    - https://leetcode.com/problems/3sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Logic -

This is the optimal solution using two pointer approach.
Sort the array to make it easier to find and skip duplicates.
Loop through for each nums[i] then use two pointers start, end to find sum of nums[i], nums[start], nums[end] = 0
If found store the triplet, skip the duplicates and repeat by adjusting pointers.

If sum < 0 which means start should be incremented to next bigger value to have bigger sum.
If sum > 0 which means end should be decremented to a smaller value to have smaller sum.
If sum == 0 then store the triplet and skip any duplicates and then increment start and decrement end.

*/

package com.dsa.lc;

import java.util.*;

public class ThreeSumBest {
    public List<List<Integer>> threeSum(int[] nums) { 

        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //check for duplicate for i, if present then skip it using continue and for-loops i++ takes it to next element.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[start], nums[end]);
                    output.add(triplet);

                    //check duplicates for start and end pointers
                    while (start < end && nums[start] == nums[start + 1]) { start++; }
                    while (start < end && nums[end] == nums[end - 1]) { end--; }

                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return output;
    }
}
