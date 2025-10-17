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

Logic -

A dummy node (beforeNode) is initialized with a value of -1 and points to the head of the list (or null initially).
A length variable tracks the current number of elements in the list.

get(int index)
    Returns the value at the specified index.
    If the index is invalid (negative or ≥ length), returns -1.
    Traverses from the dummy node to the desired index and returns the node's value.

addAtHead(int val)
    Inserts a new node at the beginning of the list.
    Internally calls addAtIndex(0, val) to handle insertion logic.

addAtTail(int val)
    Appends a new node at the end of the list.
    Internally calls addAtIndex(length, val) to insert after the current last node.

addAtIndex(int index, int val)
    Inserts a new node with the given value at the specified index.
    If index is invalid (less than 0 or greater than current length), the operation is ignored.
    Traverses to the node before the specified index, inserts the new node, and updates links accordingly.
    Increments the list length.

deleteAtIndex(int index)
    Removes the node at the specified index.
    If the index is invalid (less than 0 or ≥ length), the operation is ignored.
    Traverses to the node before the target node, bypasses the target by updating the next pointer.
    Decrements the list length.

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
