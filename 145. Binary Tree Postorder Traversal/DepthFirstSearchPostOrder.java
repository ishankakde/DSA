/*

leet code problem 145
    - Level - easy
    - Binary Tree Postorder Traversal
    - https://leetcode.com/problems/binary-tree-postorder-traversal/

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,6,7,5,2,9,8,3,1]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Logic -

PostOrder Traversal means: Left → Right → Root

If the current node is null, return.
Recursively call the function on the left child.
Recursively call the function on the right child.
Add the current node’s value to the result list.
This ensures nodes are visited in Left → Right → Root

 */

package com.dsa.lc;

public class DepthFirstSearchPostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        if(node.left != null){
            postOrder(node.left, list);
        }
        if(node.right != null){
            postOrder(node.right, list);
        }

        list.add(node.val);
    }
}