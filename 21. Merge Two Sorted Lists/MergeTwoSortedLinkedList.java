/*

leet code problem 21
    - level : easy
    - Merge Two Sorted Lists
    - https://leetcode.com/problems/merge-two-sorted-lists/

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

 */
package com.dsa.lc;

public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode beforePointer = new ListNode(-1); // before first node
        ListNode tempPointer = beforePointer;


        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tempPointer.next = list1;
                list1 = list1.next;
            }else{
                tempPointer.next = list2;
                list2 = list2.next;
            }
            tempPointer = tempPointer.next;
        }

        //either l1 or l2 still have node(s) left.
        tempPointer.next = (list1 != null) ? list1 : list2;
        return beforePointer.next; // first node
    }
}
