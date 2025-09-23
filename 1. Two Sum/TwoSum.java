/*

leet code problem 1
    - Two Sum
    - https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Logic -

Two Sum leverages a hash map (or hash table/dictionary).
This approach achieves an O(n) time complexity by iterating through the array once.
For each number, it calculates the "complement" (target - current number)
and checks if this complement already exists in the hash map.
If it does, the indices of the current number and its complement are returned.
If not, the current number and its index are added to the hash map for future lookups.

Time complexity is O(n) where
    - n is number of elements in nums.
    - arrays nums[] is traversed once
    - each map operation is O(1)

 */
package com.dsa.lc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        for(int i = 0; i < nums.length; i++ ){
            diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i); //store as <value, index>
        }
        return new int[]{};
    }
}
