package org.abymaly.code;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.Arrays;

public class BinaryTree<T> {
    public int nodeCount;

    public class Node<T> {
        public Integer data;
        public Node<T> nextLeft;
        public Node<T> nextRight;


        public Node(Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }
    }

    Node<T> root;

    public BinaryTree() {
        this.root = null;
        nodeCount = 0;
    }

    public boolean isNextLeft(Node node) {
        return node.nextLeft != null;
    }

    public boolean isNextRight(Node node) {
        return node.nextRight != null;
    }

    public void appendNode(Integer newData) {
        Node<T> newNode = new Node<>(newData);

        ++nodeCount;

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> actual = root;

        while (true) {

            if (newData < actual.getData()) {
                if (isNextLeft(actual)) {
                    actual = actual.nextLeft;
                } else {
                    actual.nextLeft = newNode;
                    return;
                }
            }

            if (newData > actual.getData()) {
                if (isNextRight(actual)) {
                    actual = actual.nextRight;
                } else {
                    actual.nextRight = newNode;
                    return;
                }
            }

            if (newData == actual.getData()) {
                return;
            }
        }
    }

    public void searchValue(Integer findValue) {
        int stepsCount = 1;

        if (findValue == root.getData()) {
            System.out.println(stepsCount);
            return;
        }

        Node<T> actual = root;

        while (findValue != actual.getData()) {

            if (findValue < actual.getData()) {
                if (isNextLeft(actual)) {
                    ++stepsCount;
                    actual = actual.nextLeft;
                } else {
                    System.out.println("There is no");
                    return;
                }
            }

            if (findValue > actual.getData()) {
                if (isNextRight(actual)) {
                    ++stepsCount;
                    actual = actual.nextRight;
                } else {
                    System.out.println("There is no");
                    return;
                }
            }
        }
        System.out.println(stepsCount);
    }

    public void delete(Integer deleteValue) {

//        TODO: nie działa kasowanie przez dodawanie referencji do null. Wyszukuje dobrze, sprawdza dobrze, kasuje źle, do ogarniecia

        Node<T> actual = root;

        if (root.getData() == deleteValue) {
            actual = root;
        } else {

        while (deleteValue != actual.getData()) {

            if (deleteValue < actual.getData()) {
                if (isNextLeft(actual)) {
                    actual = actual.nextLeft;
                } else {
                    System.out.println("There is no");
                    return;
                }
            }

            if (deleteValue > actual.getData()) {
                if (isNextRight(actual)) {
                    actual = actual.nextRight;
                } else {
                    System.out.println("There is no");
                    return;
                }
            }
        }
        }

        if ((actual.nextLeft == null) && (actual.nextRight == null)) {
            System.out.println("OK");
            actual = null;
            --nodeCount;
        } else if (actual.nextRight == null) {
            actual = actual.nextLeft;
            --nodeCount;
        } else {
            actual = actual.nextRight;
            --nodeCount;
        }

    }

}
