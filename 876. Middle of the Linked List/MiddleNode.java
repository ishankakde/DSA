/*

leet code problem 876
    - level : easy
    - Middle of the Linked List
    - https://leetcode.com/problems/middle-of-the-linked-list

Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

logic -

Initialize two pointers, slow and fast, at the head of the linked list.
Move the slow pointer one node at a time and the fast pointer two nodes at a time.
Continue traversing the list until the fast pointer reaches the end (i.e., becomes null or its next is null).
At this point, the slow pointer will be positioned at the middle node of the list.
Return the slow pointer as the middle node.

 */
package com.dsa.lc;

public class MiddleNode {
    public Node middleNode(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
