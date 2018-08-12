package test.org.abymaly.code;

import org.junit.Test;

import org.abymaly.code.graph.DijikstraGraph;

public class DijikstraTest {

    @Test
    public void test01() {
        DijikstraGraph dijikstraGraph = new DijikstraGraph(9);

        dijikstraGraph.setValue(0);
        dijikstraGraph.setValue(1);
        dijikstraGraph.setValue(2);
        dijikstraGraph.setValue(3);
        dijikstraGraph.setValue(4);
        dijikstraGraph.setValue(5);
        dijikstraGraph.setValue(6);
        dijikstraGraph.setValue(7);
        dijikstraGraph.setValue(8);

        dijikstraGraph.setNeighbours(0, 1, 2f);
        dijikstraGraph.setNeighbours(2, 1, 7f);
        dijikstraGraph.setNeighbours(0, 4, 20f);
        dijikstraGraph.setNeighbours(0, 3, 5f);
        dijikstraGraph.setNeighbours(3, 4, 10f);
        dijikstraGraph.setNeighbours(3, 7, 2f);
        dijikstraGraph.setNeighbours(7, 8, 2f);
        dijikstraGraph.setNeighbours(8, 5, 1f);
        dijikstraGraph.setNeighbours(4, 5, 1f);
        dijikstraGraph.setNeighbours(5, 6, 2f);
        dijikstraGraph.setNeighbours(3, 0, -15f);

//        System.out.println(dijikstraGraph.printNeighbours());

        System.out.println(dijikstraGraph.findPath(0, 6));
        System.out.println(dijikstraGraph.findPath(0, 1));
        System.out.println(dijikstraGraph.findPath(0, 5));
        System.out.println(dijikstraGraph.findPath(0, 4));
        System.out.println(dijikstraGraph.findPath(0, 2));


    }

}

