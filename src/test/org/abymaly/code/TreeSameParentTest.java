package test.org.abymaly.code;

import org.abymaly.code.TreeSameParent;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TreeSameParentTest {

    @Test
    public void test01() {
        TreeSameParent binaryTree = new TreeSameParent();
        binaryTree.appendNode(5);
        binaryTree.appendNode(7);
        binaryTree.appendNode(8);
        binaryTree.appendNode(6);
        binaryTree.appendNode(1);
        binaryTree.appendNode(0);
        binaryTree.appendNode(2);
        binaryTree.appendNode(4);
    }
    @Test
    public void test02() {
        TreeSameParent binaryTree = new TreeSameParent();
        binaryTree.appendNode(5);
        binaryTree.appendNode(7);
        binaryTree.appendNode(8);
        binaryTree.appendNode(6);
        binaryTree.appendNode(1);
        binaryTree.appendNode(0);
        binaryTree.appendNode(3);
        binaryTree.appendNode(2);
        binaryTree.appendNode(4);

        System.out.println(binaryTree.sameParent(0, 4));
        System.out.println(binaryTree.sameParent(2, 4));
    }

} 
