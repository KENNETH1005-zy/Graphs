import java.util.*;
// Template for the linked list
class LinkedList<T> {
    public LinkedListNode<T> head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // The insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    public void insertAtEnd(T value) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(value);

        // New node will become the head node if there
        // are no elements in the linked list
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode<T> current = head;

            // Iterate over the linked list using current
            while (current.next != null) {
                current = current.next;
            }

            // Append a new node at the end of the linked list
            current.next = newNode;
        }
    }
    // The createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(T[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(lst[i]);
            insertNodeAtHead(newNode);
        }
    }
}