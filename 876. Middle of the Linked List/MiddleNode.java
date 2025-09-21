/*

leet code problem 876
    - level : easy
    - Middle of the Linked List
    - https://leetcode.com/problems/middle-of-the-linked-list

Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

logic -
when fast pointer reaches the end the slow pointer reaches the middle of the linked list.

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
