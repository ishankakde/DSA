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

instead of using 3 for-loops as in brute force approach, here we use two for-loops.
using two for-loops we have two value of i and j, as we know the equation i + j + k = 0, we can find value of k, k = - i - j

now we can solve this problem using hashing as used in TwoSum problem.

 */
package com.dsa.lc;

import java.util.*;

public class ThreeSumBetter {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> tripletSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = i + 1; j < nums.length; j++){
                int k = - nums[i] - nums[j];

                if(map.containsKey(k)){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(triplet);
                    tripletSet.add(triplet);
                }else{
                    map.put(nums[j], j);
                }
            }
        }

        return tripletSet.stream().toList();
    }
}
