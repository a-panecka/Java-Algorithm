package test.org.abymaly.code;

import org.abymaly.code.SLL;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class SLLTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test01() {
        SLL<Integer> sll = new SLL<>();
        Assert.assertEquals(0, sll.nodeCount());
    }

    @Test
    public void test02() {
        SLL<Integer> sll = new SLL<>();
        sll.appendNode(3);
        Assert.assertEquals(1, sll.nodeCount());
    }

    @Test
    public void test03() {
        SLL<Integer> sll = new SLL<>();
        sll.appendNode(3);
        sll.appendNode(4);
        Assert.assertEquals(2, sll.nodeCount());
    }

    @Test
    public void test04() {
        SLL<Integer> sll = new SLL<>();
        sll.appendNode(4);
        Assert.assertNotNull(sll.search(4));
    }

    @Test
    public void test05() {
        SLL<Integer> sll = new SLL<>();
        sll.appendNode(1);
        sll.appendNode(4);
        Assert.assertNotNull(sll.search(4));
    }

    @Test
    public void test06() {
        SLL<Integer> sll = new SLL<>();
        sll.appendNode(1);
        sll.appendNode(4);
        Assert.assertNull(sll.search(5));
    }

    @Test
    public void test07() {
        SLL<String> sll = new SLL<>();
        sll.appendNode("00");
        sll.appendNode("01");
        Assert.assertEquals("01", sll.searchNth(1).getData());
    }

    @Test
    public void test08() {
        SLL<String> sll = new SLL<>();
        sll.appendNode("00");
        sll.appendNode("01");
        Assert.assertNull(sll.searchNth(3));
    }

    @Test
    public void test09() {
        SLL<String> sll = new SLL<>();
        sll.appendNode("00");
        sll.appendNode("01");
        sll.insert(null, "test");
        Assert.assertEquals("test", sll.searchNth(0).getData());
    }

    @Test
    public void test10() {
        SLL<String> sll = new SLL<>();
        sll.appendNode("00");
        sll.appendNode("01");
        sll.appendNode("02");
        sll.appendNode("03");
        sll.delete(sll.searchNth(1));
        Assert.assertEquals(3, sll.nodeCount());
    }

    public void test11() {
        SLL<String> sll = new SLL<>();
        sll.appendNode("00");
        sll.appendNode("01");
        sll.appendNode("02");
        sll.appendNode("03");
        sll.delete(sll.searchNth(1));
        Assert.assertEquals("03", sll.searchNth(2).getData());
    }
    @Test
    public void test12() {
        SLL<String> sll = new SLL<>();
        sll.appendNode("00");
        sll.appendNode("01");
        sll.appendNode("02");
        sll.appendNode("03");
        sll.delete(sll.searchNth(0));
        Assert.assertEquals(3, sll.nodeCount());
    }

    @Test
    public void headToTail() {
        SLL<String> sll = new SLL<>();
        sll.appendNode("A");
        sll.appendNode("B");
        sll.appendNode("C");
        sll.appendNode("D");
        sll.appendNode("E");
        sll.appendNode("F");
        sll.print();
        sll.headToTail(sll.searchNth(2));
        sll.print();
    }

}