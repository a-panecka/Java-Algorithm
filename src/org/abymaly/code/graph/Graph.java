package org.abymaly.code.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

    public class Node {
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    int nodeCount;
    List<Node> nodes;
    boolean[][] neighbours;

    public Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        nodes = new ArrayList<>();
        for (int i = 0; i < nodeCount; ++i) {
            nodes.add(i, new Node(null));
        }

        neighbours = new boolean[nodeCount][nodeCount];

        eraseMatrix(nodeCount);
    }

    private void eraseMatrix(int nodeCount) {
        for (int i = 0; i < nodeCount; ++i) {
            for (int j = 0; j < nodeCount; ++j) {
                neighbours[i][j] = false;
            }
        }
    }

    public void setNeighbours(int idxBegin, int idxEnd) {
        neighbours[idxBegin][idxEnd] = true;
    }

    public void setValue(int idx) {
        Integer value = 1500 + idx;
        nodes.get(idx).setValue(value);
    }

    public Integer getValue(int idx) {
        return nodes.get(idx).getValue();
    }

    public String printNeighbours() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodeCount; ++i) {
            for (int j = 0; j < nodeCount; ++j) {
                sb
                        .append(neighbours[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public String printColours() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodeCount; ++i) {
            for (int j = 0; j < nodeCount; ++j) {
                sb
                        .append(neighbours[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean findPath(int idxBegin, int idxEnd) {

        Queue<Integer> idxQueue = new PriorityQueue<>();

        List<Colours> coloursList = new ArrayList<>();

        for (int i = 0; i < nodeCount; ++i) {
            coloursList.add(i, Colours.WHITE);
        }

        coloursList.set(idxBegin, Colours.GREY);

        idxQueue.add(idxBegin);

        while (idxQueue.size() != 0) {
            int currentNode = idxQueue.poll();

            for (int i = 0; i < nodeCount; ++i) {
                if ((neighbours[currentNode][i]) && coloursList.get(i) == Colours.WHITE) {
                    idxQueue.add(i);
                    coloursList.set(i, Colours.GREY);
                    if (i == idxEnd) {
                        return true;
                    }
                }
            }

            coloursList.set(currentNode, Colours.BLACK);
        }

        return false;
    }

}