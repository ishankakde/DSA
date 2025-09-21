/*

leet code problem 707
    - level : medium
    - Design Linked List
    - https://leetcode.com/problems/design-linked-list/

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
and next is a pointer/reference to the next node.

If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node
in the linked list. Assume all nodes in the linked list are 0-indexed.
 */

package com.dsa.lc;

class LinkedList {

    public class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    Node beforePointer; // is a dummy node that points to first node of the linked list.
    int length;

    public LinkedList() {
        length = 0;
        beforePointer = new Node(-1);
    }

    public int get(int index) {

        if(index < 0 || index >= length){
            return -1;
        }

        Node tempPointer = beforePointer;
        for(int i = 0; i <= index; i++){ // loop until that index/node
            tempPointer = tempPointer.next;
        }
        return tempPointer.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {

        if(index < 0 || index > length){
            return;
        }

        Node tempPointer = beforePointer;
        for(int i = 0; i < index; i++){ // loop until a node before
            tempPointer = tempPointer.next;
        }

        Node newNode = new Node(val);
        newNode.next = tempPointer.next;
        tempPointer.next = newNode;

        length++;
    }

    public void deleteAtIndex(int index) {

        if(index < 0 || index >= length){
            return;
        }

        Node tempPointer = beforePointer;
        for (int i = 0; i < index; i++){ // loop until node before
            tempPointer = tempPointer.next;
        }
        tempPointer.next = tempPointer.next.next;

        length --;
    }
}
