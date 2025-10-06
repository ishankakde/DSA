/*

leet code problem 11
    - Level - medium
    - Container with most water
    - https://leetcode.com/problems/container-with-most-water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Logic -
Two pointer approach to reduce time complexity to O(n) when compared to brute force approach O(n^2).
Assign a start pointer and an end pointer.
Out of the two pointer move the the smaller height pointer to the next/previous height (start++ or end--).
repeat process to evaluate new start and end pointer until start < end.


Time complexity - O(n)

 */
package com.dsa.lc;

public class MaxAreaBest {
    public int maxArea(int[] height) {

        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while(start < end){

            int width = end - start;
            int minHeight = Math.min(height[start], height[end]);
            int currentArea = width * minHeight;

            maxArea = Math.max(maxArea, currentArea);

            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }
}
