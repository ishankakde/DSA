/*

leet code problem 206
    - level : easy
    - Reverse Linked List
    - https://leetcode.com/problems/reverse-linked-list

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

logic -

Traverse the list while reversing the direction of each node's pointer to point to its before node.
At the end, the last node becomes the new head of the reversed list.

Use three pointers:
    current (to track the node being processed),
    before (to build the reversed list), and
    after (to not lose the remaining list).

Repeat the process until all nodes are reversed and the new head is returned.
 */
package com.dsa.lc;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode before  = null;
        ListNode after   = null;

        while(current != null){
            //reverse the pointers
            after = current.next;
            current.next = before;
            //shift the pointers
            before = current;
            current = after;
        }
        return before;
    }
}