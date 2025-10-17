/*

leet code problem 21
    - level : easy
    - Merge Two Sorted Lists
    - https://leetcode.com/problems/merge-two-sorted-lists/

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by
splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Logic -

Create a dummy node (beforeNode) to start a new merged list.
Compare the current nodes of both input lists, and attach the smaller one to the merged list.
Move the pointer forward in the list from which a node was taken.
Repeat the comparison until one of the lists is fully traversed.
Attach the remaining part of the non-empty list to the end of the merged list.
Return first node of the merged list.

 */
package com.dsa.lc;

public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode beforeNode = new ListNode(-1);
        ListNode tempNode = beforeNode;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tempNode.next = list1;
                list1 = list1.next;
            }else{
                tempNode.next = list2;
                list2 = list2.next;
            }
            tempNode = tempNode.next;
        }

        tempNode.next = (list1 != null) ? list1 : list2;
        return beforeNode.next;
    }
}
