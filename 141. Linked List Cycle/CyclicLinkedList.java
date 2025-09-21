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

logic -
If a linkedList is not cyclic then fast pointer will reach to then end.
If linked list is cyclic then fast pointer will never be null and at some point fast
and slow pointer will meet & point to same node.

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
