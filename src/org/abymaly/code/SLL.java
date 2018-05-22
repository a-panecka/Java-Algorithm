package org.abymaly.code;

public class SLL<T> {

    public class Node<T> {
        T data;
        Node next;

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;

    public SLL() {
        this.head = null;
    }

    public int nodeCount() {
        int nodeCount = 0;
        Node ref = head;
        while (ref != null) {
            nodeCount++;
            ref = ref.next;
        }
        return nodeCount;
    }

    public void print() {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.getData() + "; ");
            ref = ref.next;
        }
        System.out.print("\n");
    }

    public void appendNode(T newData) {
        Node ref = head;
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
        } else {
            while (ref.next != null) {
                ref = ref.next;
            }
            ref.next = newNode;
        }
    }

    public Node search(T data) {
        Node ref = head;

        while (ref != null) {
            if (ref.data.equals(data)) {
                return ref;
            }
            ref = ref.next;
        }
        return null;
    }

    public Node searchNth(int nth) {
        Node ref = head;
        int nodeCount = 0;

        while (ref != null) {
            if (nodeCount == nth) {
                return ref;
            }
            nodeCount++;
            ref = ref.next;
        }
        return null;
    }

    public void insert(Node item, T newData) {
        Node ref = head;

        Node<T> newNode = new Node<>(newData);

        if (item == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        newNode.next = item.next;
        item.next = newNode;
    }

    public void delete(Node item) {

        if (head == null) {
            return;
        }

        if (item.next == null) {
            return;
        }

        if (item == null) {
            head = head.next;
            return;
        }

        item.next = item.next.next;

    }

    public void headToTail(Node newHead) {
        
        Node ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }

        ref.next = head;
        head = newHead.next;

        ref = head;

        while (ref.next != newHead.next) {
            ref = ref.next;
        }

        ref.next = null;
    }
}
