/*

leet code problem 226
    - Level - easy
    - Invert Binary Tree
    - https://leetcode.com/problems/invert-binary-tree

Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

Logic -
Sure! Here’s a short, plain-text logic explanation (about 4–5 lines):

1. If the current node is `null`, just return — there’s nothing to invert.
2. Swap the left and right child of the current node.
3. Recursively call the same function on the left child.
4. Recursively call it again on the right child.
5. Return the current node (which now has its children inverted).


 */
package com.dsa.lc;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        //base case
        if(root == null){
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}