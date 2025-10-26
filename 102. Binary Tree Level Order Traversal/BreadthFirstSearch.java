/*

leet code problem 102
    - Level - medium
    - Binary Tree Level Order Traversal
    - https://leetcode.com/problems/binary-tree-level-order-traversal

Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Logic -

The code goes through the binary tree one level at a time, starting from the root.
It uses a queue to remember which nodes need to be visited next.
For each level, it removes all nodes currently in the queue, records their values,
and adds their left and right children to the queue.
After finishing each level, it adds that level’s list to the final result.
In the end, it returns a list of all levels — each showing the nodes that appear on that level of the tree.

 */
package com.dsa.lc;

public class BreadthFirstSearch {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() != 0){

            List<Integer> list = new ArrayList<>();
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++){
                TreeNode currentNode = queue.remove();
                list.add(currentNode.val);

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            output.add(list);
        }
        return output;
    }
}