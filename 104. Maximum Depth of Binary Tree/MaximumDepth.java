/*

leet code problem 104
    - Level - easy
    - Maximum Depth of Binary Tree
    - https://leetcode.com/problems/maximum-depth-of-binary-tree

A binary tree's maximum depth is the number of nodes along the
longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Logic -
If the current node is null, return 0.
Otherwise, calculate the depths of the left and right subtrees, take the greater one, and add 1 to it.

 */
package com.dsa.lc;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        //end condition
        if(root == null){
            return 0;
        }

        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);

        return Math.max(depthLeft, depthRight) + 1;
    }
}