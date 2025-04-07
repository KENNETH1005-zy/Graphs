public class EduLinkedList<T> {

    // Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;
    }

    public Node headNode;
    public int size;

    public EduLinkedList() {
        this.headNode = null;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public int getSize() {
        return size;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode; // Linking newNode to head's nextNode
        this.headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        last.nextNode = newNode;
        size++;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List: ");

        while (temp != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }

    public void deleteAtHead() {
        if (isEmpty())
            return;

        headNode = headNode.nextNode;
        size--;
    }

    public void deleteAtTail() {
        if (isEmpty())
            return;

        if (headNode.nextNode == null) { // Only one element
            headNode = null;
        } else {
            Node secondLast = headNode;
            while (secondLast.nextNode.nextNode != null) {
                secondLast = secondLast.nextNode;
            }
            secondLast.nextNode = null;
        }
        size--;
    }

}