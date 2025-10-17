/*

leet code problem 141
    - level : easy
    - Linked List Cycle
    - https://leetcode.com/problems/linked-list-cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by
continuously following the next pointer. Internally, pos is used to denote the index of the node that
tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

logic -

Initialize two pointers, slow and fast, both starting at the head of the linked list.
Move the slow pointer one node at a time, and the fast pointer two nodes at a time.
During traversal, if the slow and fast pointers meet, a cycle exists in the linked list.
If the fast pointer reaches the end of the list (null or fast.next == null), there is no cycle.
The method returns true if a cycle is detected; otherwise, it returns false.

 */
package com.dsa.lc;

public class CyclicLinkedList {
    public boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
