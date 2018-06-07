package org.abymaly.code;

public class BinaryTree<T> {

    public class Node<T> {
        public Integer data;
        public Node nextLeft;
        public Node nextRight;

        public Node(Integer data) {
            this.data = data;
            }

        public Integer getData() {
            return data;
        }

        public Node getNextLeft() {
            return nextLeft;
        }

        public Node getNextRight() {
            return nextRight;
        }

        Node<T> root;
        Node<T> actual;

        public void appendNode(Integer newData) {
            Node ref = root;
            Node<T> newNode = new Node<>(newData);

            if (root == null) {
                root = newNode;
                return;
            }
            actual = root;

            while (actual != null) {

                if (newData.compareTo(root.getData()) < 0) {
                    if (actual.nextLeft == null) {
                        nextLeft = newNode;
                    } else {
                        nextLeft = actual;
                    }
                } else if (newData.compareTo(root.getData()) > 0)
                    if (actual.nextRight == null) {
                        nextRight = newNode;
                    } else {
                        nextRight = actual;
                    }
            }
            return;
        }
    }
}