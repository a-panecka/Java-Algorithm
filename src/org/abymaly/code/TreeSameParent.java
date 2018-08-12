package org.abymaly.code;

public class TreeSameParent {

    public class Node {
        public int value;
        public Node nextLeft;
        public Node nextRight;

        public Node(int value) {
            this.value = value;
            this.nextLeft = null;
            this.nextRight = null;
        }

        public int getValue() {
            return value;
        }

        public Node which(int value) {
            if (value < this.value) {
                return nextLeft;
            } else {
                return nextRight;
            }
        }
    }

    public int nodeCount;

    Node root;

    public TreeSameParent() {
        this.root = null;
        nodeCount = 0;
    }

    public boolean hasLeft(Node node) {
        return node.nextLeft != null;
    }

    public boolean hasRight(Node node) {
        return node.nextRight != null;
    }

    public Node createNode(int newData) {
        return new Node(newData);
    }

    public void appendNode(int newData) {
        System.out.println("Append: " + newData);
        ++nodeCount;

        if (root == null) {
            root = createNode(newData);
            return;
        }

        Node actual = root;

        while (true) {

            if (newData < actual.getValue()) {
                if (hasLeft(actual)) {
                    actual = actual.nextLeft;
                } else {
                    actual.nextLeft = createNode(newData);
                    return;
                }
            } else {
                if (hasRight(actual)) {
                    actual = actual.nextRight;
                } else {
                    actual.nextRight = createNode(newData);
                    return;
                }
            }
        }
    }

    public boolean compareRelation(Node actual, int a, int b) {

        if ((a < actual.getValue()) && (b < actual.getValue())) {
            return true;
        }

        if ((a >= actual.getValue()) && (b >= actual.getValue())) {
            return true;
        }

        return false;
    }

    public int sameParent(int a, int b) {
        Node actual = root;

        while (compareRelation(actual, a, b)) {
            if (actual == null) {
                break;
            }
            actual = actual.which(a);
        }

        return actual.getValue();
    }
}