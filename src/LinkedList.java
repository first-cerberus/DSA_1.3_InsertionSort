public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertionSort() {
        Node sortedNode = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sortedNode = sortedInsert(sortedNode, current);
            current = next;
        }
        head = sortedNode;
    }

    public Node sortedInsert(Node sortedNode, Node newNode) {
        if (sortedNode == null || sortedNode.data >= newNode.data) {
            newNode.next = sortedNode;
        } else {
            Node current = sortedNode;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return sortedNode;
    }
}

