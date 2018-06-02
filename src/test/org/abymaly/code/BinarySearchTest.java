package test.org.abymaly.code; 

import org.abymaly.code.BinarySearch;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class BinarySearchTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void testFill() throws Exception {
    BinarySearch binarySearch = new BinarySearch();
    binarySearch.fill();
    binarySearch.print();
} 

@Test
public void testFind9() throws Exception {
    BinarySearch binarySearch = new BinarySearch();
    binarySearch.fillDefault();
    binarySearch.print();
    binarySearch.find(9);
}

    @Test
    public void testFind11() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.fillDefault();
        binarySearch.print();
        binarySearch.find(11);
    }

    @Test
    public void testFind_10() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.fillDefault();
        binarySearch.print();
        binarySearch.find(-10);
    }

    @Test
    public void testFind100() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.fillDefault();
        binarySearch.print();
        binarySearch.find(100);
    }

    @Test
    public void testFind1() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.fillDefault();
        binarySearch.print();
        binarySearch.find(1);
    }

    @Test
    public void testFind12() throws Exception {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.fillDefault();
        binarySearch.print();
        binarySearch.find(12);
    }

} 
