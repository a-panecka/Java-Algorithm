package test.org.abymaly.code;

import org.abymaly.code.InterpolationSearch;
import org.junit.Assert;
import org.junit.Test;

public class InterpolationSearchTest {

    @Test
    public void test01() {
        InterpolationSearch search = new InterpolationSearch();
        search.fillDefault();
        search.findValue(6);
//        Assert.assertEquals(-1, search.findValue(-1));
//        Assert.assertEquals(0, search.findValue(0));
//        Assert.assertEquals(2, search.findValue(2));
//        Assert.assertEquals(4, search.findValue(499));
//        Assert.assertEquals(-1, search.findValue(500));
//        Assert.assertEquals(6, search.findValue(998));
//        Assert.assertEquals(7, search.findValue(999));
//        Assert.assertEquals(-1, search.findValue(1000));
    }

}