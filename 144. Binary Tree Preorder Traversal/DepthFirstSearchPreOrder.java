/*

leet code problem 144
    - Level - easy
    - Binary Tree Preorder Traversal
    - https://leetcode.com/problems/binary-tree-preorder-traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [1,2,4,5,6,7,3,8,9]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Logic -

Preorder Traversal means: Root → Left → Right

If the current node is null, return.
Add the current node’s value to the result list.
Recursively call the function on the left child.
Recursively call the function on the right child.
This ensures nodes are visited in Root → Left → Right order.

 */
package com.dsa.lc;

public class DepthFirstSearchPreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        list.add(node.val);
        if(node.left != null){
            preorder(node.left, list);
        }
        if(node.right != null){
            preorder(node.right, list);
        }
    }
}