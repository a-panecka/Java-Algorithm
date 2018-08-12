package test.org.abymaly.code;

import org.abymaly.code.Sqrt;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class SqrtTest {

    @Test
    public void testSqrt3() {
        Assert.assertEquals(3, Sqrt.sqrt3(27));
        Assert.assertEquals(4, Sqrt.sqrt3(64));
        Assert.assertEquals(-1, Sqrt.sqrt3(7777));
    }

    @Test
    public void test01() {
    Sqrt.sqrt3(64);
    }


} 
