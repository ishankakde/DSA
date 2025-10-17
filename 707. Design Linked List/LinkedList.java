/*

leet code problem 707
    - level : medium
    - Design Linked List
    - https://leetcode.com/problems/design-linked-list/

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the
current node, and next is a pointer/reference to the next node.

If you want to use the doubly linked list, you will need one more attribute prev to indicate the
previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class -

MyLinkedList() Initializes the MyLinkedList object.

int get(int index)
Get the value of the indexth node in the linked list.
If the index is invalid, return -1.

void addAtHead(int val)
Add a node of value val before the first element of the linked list.
After the insertion, the new node will be the first node of the linked list.

void addAtTail(int val)
Append a node of value val as the last element of the linked list.

void addAtIndex(int index, int val)
Add a node of value val before the indexth node in the linked list.
    If index equals the length of the linked list, the node will be appended to the end of the linked list.
    If index is greater than the length, the node will not be inserted.

void deleteAtIndex(int index)
Delete the indexth node in the linked list, if the index is valid.

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

    Node beforeNode;
    int length;

    public LinkedList() {
        length = 0;
        beforeNode = new Node(-1);
    }

    public int get(int index) {

        if(index < 0 || index >= length){
            return -1;
        }

        Node tempNode = beforeNode;
        for(int i = 0; i <= index; i++){ // loop until that index/node
            tempNode = tempNode.next;
        }
        return tempNode.val;
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

        Node tempNode = beforeNode;
        for(int i = 0; i < index; i++){ // loop until a node before
            tempNode = tempNode.next;
        }

        Node newNode = new Node(val);
        newNode.next = tempNode.next;
        tempNode.next = newNode;

        length++;
    }

    public void deleteAtIndex(int index) {

        if(index < 0 || index >= length){
            return;
        }

        Node tempNode = beforeNode;
        for (int i = 0; i < index; i++){ // loop until node before
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        length --;
    }
}
