/*

leet code problem 100
    - Level - easy
    - Same Tree
    - https://leetcode.com/problems/same-tree

Given the roots of two binary trees p and q,
write a function to check if they are the same or not.

Two binary trees are considered the same if they are
structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Logic -

Base case 1: If both nodes are null, they are the same.
Base case 2: If one node is null and the other isn’t, they’re not the same.
Base case 3: If values differ, trees are different.
Recursive case: Check both left and right subtrees recursively.

 */
package com.dsa.lc;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // base case 1
        if(p == null && q == null){
            return true;
        }

        //base case 2
        if(p == null || q == null){
            return false;
        }

        //base case 3
        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}