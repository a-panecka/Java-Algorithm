package org.abymaly.code.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijikstraGraph {

    public enum DijikstraColours {
        WHITE, BLACK;
    }

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
    Float[][] neighbours;

    public DijikstraGraph(int nodeCount) {
        this.nodeCount = nodeCount;
        nodes = new ArrayList<>();
        for (int i = 0; i < nodeCount; ++i) {
            nodes.add(i, new Node(null));
        }

        neighbours = new Float[nodeCount][nodeCount];

        eraseMatrix(nodeCount);
    }

    private void eraseMatrix(int nodeCount) {
        for (int i = 0; i < nodeCount; ++i) {
            for (int j = 0; j < nodeCount; ++j) {
                neighbours[i][j] = null;
            }
        }
    }

    public void setNeighbours(int idxBegin, int idxEnd, Float price) {
        neighbours[idxBegin][idxEnd] = price;
    }

    public void setValue(int idx) {
        Integer value = 1500 + idx;
        nodes.get(idx).setValue(value);
    }

    public Integer getValue(int idx) {
        return nodes.get(idx).getValue();
    }

    public class PairIdxPrice implements Comparable<PairIdxPrice> {

        private Integer idx;
        private Float price;

        public PairIdxPrice(Integer idx, Float price) {
            this.idx = idx;
            this.price = price;
        }

        public Float getPrice() {
            return price;
        }

        @Override
        public int compareTo(PairIdxPrice other) {
            return this.getPrice().compareTo(other.getPrice());
        }
    }

    public Float findPath(int idxBegin, int idxEnd) {

        Float minPrice = 0F;

        List<DijikstraColours> coloursList = new ArrayList<>();
        for (int i = 0; i < nodeCount; ++i) {
            coloursList.add(i, DijikstraColours.WHITE);
        }

        List<Float> roadPrice = new ArrayList<>();
        for (int i = 0; i < nodeCount; ++i) {
            roadPrice.add(i, 1000f);
        }

        Queue<PairIdxPrice> idxQueue = new PriorityQueue<>();

        idxQueue.add(new PairIdxPrice(idxBegin, 0.f));
        coloursList.set(idxBegin, DijikstraColours.BLACK);

        Float currentPrice = 0f;

        while (idxQueue.size() != 0) {
            PairIdxPrice currentPair = idxQueue.poll();

            for (int i = 0; i < nodeCount; ++i) {
                if ((neighbours[currentPair.idx][i] != null) && coloursList.get(i) == DijikstraColours.WHITE) {
                    currentPrice = neighbours[currentPair.idx][i] + currentPair.price;
                    if (currentPrice < roadPrice.get(i)) {
                        idxQueue.add(new PairIdxPrice(i, currentPrice));
                    }
                }
            }

            if (currentPair.idx == idxEnd) {
                minPrice = currentPair.price;
                return minPrice;
            }
            coloursList.set(currentPair.idx, DijikstraColours.BLACK);
        }

        return null;
    }

    public String printNeighbours() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        for (int i = 0; i < nodeCount; ++i) {

            for (int j = 0; j < nodeCount; ++j) {
                sb
                        .append(neighbours[i][j] == null ? "___" : neighbours[i][j])
                        .append("  ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}