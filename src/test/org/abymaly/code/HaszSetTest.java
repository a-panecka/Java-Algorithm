package test.org.abymaly.code;

import org.abymaly.code.HaszSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class HaszSetTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFind() {
        HaszSet haszSet = new HaszSet();
        haszSet.add(10);
        Assert.assertTrue(haszSet.find(10));
    }


    @Test
    public void testAdd() {
        HaszSet haszSet = new HaszSet();
        for (int i = 0; i < 1024 * 1024; ++i) {
            haszSet.add((int) (Math.random() * 1024 * 1024));
        }
        haszSet.howMuch();
    }
} 
