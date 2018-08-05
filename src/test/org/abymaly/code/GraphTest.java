package test.org.abymaly.code;

import org.abymaly.code.graph.Graph;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void testSetNeighbours() {
        Graph graph = new Graph(5);

        graph.setNeighbours(0, 1);
        graph.setNeighbours(0, 2);
        graph.setNeighbours(0, 3);
        graph.setNeighbours(2, 2);
        graph.setNeighbours(2, 4);

        Assert.assertEquals
                ("false true true true false \n" +
                        "false false false false false \n" +
                        "false false true false true \n" +
                        "false false false false false \n" +
                        "false false false false false \n", graph.printNeighbours());

        System.out.println(graph.printNeighbours());
    }

    @Test
    public void testSetValue() {
        Graph graph = new Graph(5);

        graph.setValue(0);
        graph.setValue(1);
        graph.setValue(2);
        graph.setValue(3);
        graph.setValue(4);
        graph.setValue(5);
        graph.setValue(6);
        graph.setValue(7);

        System.out.println(graph.getValue(4));

    }

    @Test
    public void fullGraph() {
        Graph graph = new Graph(8);

        graph.setValue(0);
        graph.setValue(1);
        graph.setValue(2);
        graph.setValue(3);
        graph.setValue(4);
        graph.setValue(5);
        graph.setValue(6);
        graph.setValue(7);

        graph.setNeighbours(0, 1);
        graph.setNeighbours(0, 2);
        graph.setNeighbours(0, 3);
        graph.setNeighbours(2, 2);
        graph.setNeighbours(2, 3);
        graph.setNeighbours(2, 4);
        graph.setNeighbours(3, 0);
        graph.setNeighbours(3, 4);
        graph.setNeighbours(5, 6);
        graph.setNeighbours(7, 5);

        System.out.println(graph.printNeighbours());

    }

    @Test
    public void findPath() {
        Graph graph = new Graph(8);

        graph.setValue(0);
        graph.setValue(1);
        graph.setValue(2);
        graph.setValue(3);
        graph.setValue(4);
        graph.setValue(5);
        graph.setValue(6);
        graph.setValue(7);

        graph.setNeighbours(0, 1);
        graph.setNeighbours(0, 2);
        graph.setNeighbours(0, 3);
        graph.setNeighbours(2, 2);
        graph.setNeighbours(2, 3);
        graph.setNeighbours(2, 4);
        graph.setNeighbours(3, 0);
        graph.setNeighbours(3, 4);
        graph.setNeighbours(5, 6);
        graph.setNeighbours(7, 5);

        Assert.assertTrue(graph.findPath(0, 4));
        Assert.assertFalse(graph.findPath(1, 5));

    }
}