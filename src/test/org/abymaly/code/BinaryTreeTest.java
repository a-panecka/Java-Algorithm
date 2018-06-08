package test.org.abymaly.code;

import org.abymaly.code.BinaryTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testAppendNode01() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.appendNode(2);
        bt.appendNode(5);
        bt.appendNode(8);
        bt.appendNode(1);
        System.out.println("size: " + bt.nodeCount);
        bt.delete(1);
//        bt.searchValue(2);
//        bt.searchValue(5);
//        bt.searchValue(8);
        bt.searchValue(1);
        System.out.println("size: " + bt.nodeCount);

    }
} 
