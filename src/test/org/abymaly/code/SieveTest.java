package test.org.abymaly.code;

import org.abymaly.code.Sieve;
import org.junit.Assert;
import org.junit.Test;

public class SieveTest {

    @Test
    public void testSieveToString() {
        Sieve sieve = new Sieve();
        System.out.println(sieve.sieveToString(sieve.createSieve(1000)));
    }

    @Test
    public void testIsPrimary() {
        Sieve sieve = new Sieve();
        Assert.assertTrue(sieve.isPrimary(1));
        Assert.assertTrue(sieve.isPrimary(2));
        Assert.assertFalse(sieve.isPrimary(4));
        Assert.assertTrue(sieve.isPrimary(7));
        Assert.assertFalse(sieve.isPrimary(100));
    }
} 
