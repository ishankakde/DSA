/*

leet code problem 94
    - Level - easy
    - Binary Tree Inorder Traversal
    - https://leetcode.com/problems/binary-tree-inorder-traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Logic -

InOrder Traversal means: Left → Root → Right

In inorder traversal, we visit nodes in the order Left → Root → Right.
Start from the root and keep traversing the left subtree until you reach a leaf.
Once you reach null, add the current node’s value to the result.
Then move to its right subtree and repeat the process.
Continue until all nodes are visited and added to the result list.

 */

package com.dsa.lc;

public class DepthFirstSearchInOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode node, List list){
        if(node == null){
            return;
        }

        if(node.left != null){
            inOrder(node.left, list);
        }
        list.add(node.val);
        if(node.right != null){
            inOrder(node.right, list);
        }
    }
}