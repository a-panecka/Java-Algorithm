package test.org.abymaly.code; 

import org.abymaly.code.Recursion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class recursionTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 
@Test
public void testSumRecursion() {
    Recursion recursion = new Recursion();
    Assert.assertEquals(18, recursion.sumRecursion(3, 6));
}

@Test
public void testSubMapReduce() {
    Recursion recursion = new Recursion();
    Assert.assertEquals(25, recursion.sumRecursionMapReduce(3, 7));
    Assert.assertEquals(18, recursion.sumRecursionMapReduce(3, 6));
    Assert.assertEquals(3, recursion.sumRecursionMapReduce(3, 3));
}


} 
