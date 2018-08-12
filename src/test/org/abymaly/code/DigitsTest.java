package test.org.abymaly.code;

import org.abymaly.code.Digits;
import org.junit.Assert;
import org.junit.Test;

public class DigitsTest {

    @Test
    public void testDivision() {
        Assert.assertEquals(1, Digits.DigitDivide(1));
        Assert.assertEquals(1, Digits.DigitDivide(5));
        Assert.assertEquals(1, Digits.DigitDivide(9));
        Assert.assertEquals(2, Digits.DigitDivide(11));
        Assert.assertEquals(3, Digits.DigitDivide(999));
        Assert.assertEquals(4, Digits.DigitDivide(1000));
    }

    @Test
    public void testLog10() {
        Assert.assertEquals(1, Digits.DigitLog10(1));
        Assert.assertEquals(1, Digits.DigitLog10(5));
        Assert.assertEquals(1, Digits.DigitLog10(9));
        Assert.assertEquals(2, Digits.DigitLog10(11));
        Assert.assertEquals(3, Digits.DigitLog10(999));
        Assert.assertEquals(4, Digits.DigitLog10(1000));
    }
    @Test
    public void testMultiplication() {
        Assert.assertEquals(1, Digits.DigitMultiplication(1));
        Assert.assertEquals(1, Digits.DigitMultiplication(5));
        Assert.assertEquals(1, Digits.DigitMultiplication(9));
        Assert.assertEquals(2, Digits.DigitMultiplication(11));
        Assert.assertEquals(3, Digits.DigitMultiplication(999));
        Assert.assertEquals(4, Digits.DigitMultiplication(1000));
    }
    @Test
    public void testArrayCompare() {
        Assert.assertEquals(1, Digits.DigitArrayCompare(9));
        Assert.assertEquals(1, Digits.DigitArrayCompare(1));
        Assert.assertEquals(1, Digits.DigitArrayCompare(5));
        Assert.assertEquals(2, Digits.DigitArrayCompare(11));
        Assert.assertEquals(3, Digits.DigitArrayCompare(999));
        Assert.assertEquals(4, Digits.DigitArrayCompare(1000));
    }
    @Test
    public void testTimeDivision() {

        int count = 100;
        int loopsCount = 10;
        int val = 100;

        long endTime;
        long averageDuration;

        for (int j = 0; j < loopsCount; ++j) {
            Digits.DigitDivide(val);
            long startTime = System.nanoTime();

            for (int i = 0; i < count; ++i) {
                Digits.DigitDivide(val);
            }
            endTime = System.nanoTime();
            averageDuration = (endTime - startTime) / count;

            System.out.println(averageDuration);
        }
    }
    @Test
    public void testTimeLog10() {

        int count = 100;
        int loopsCount = 10;
        int val = 100;

        long endTime;
        long averageDuration;

        for (int j = 0; j < loopsCount; ++j) {
            Digits.DigitDivide(val);
            long startTime = System.nanoTime();

            for (int i = 0; i < count; ++i) {
                Digits.DigitDivide(val);
            }
            endTime = System.nanoTime();
            averageDuration = (endTime - startTime) / count;

            System.out.println(averageDuration);
        }
    }

    @Test
    public void testTimeMulitplication() {

        int count = 100;
        int loopsCount = 10;
        int val = 100;

        long endTime;
        long averageDuration;

        for (int j = 0; j < loopsCount; ++j) {
            Digits.DigitMultiplication(val);
            long startTime = System.nanoTime();

            for (int i = 0; i < count; ++i) {
                Digits.DigitMultiplication(val);
            }
            endTime = System.nanoTime();
            averageDuration = (endTime - startTime) / count;

            System.out.println(averageDuration);
        }
    }

    @Test
    public void testTimeArrayCompare() {

        int count = 100;
        int loopsCount = 10;
        int val = 10000;

        long endTime;
        long averageDuration;

        for (int j = 0; j < loopsCount; ++j) {
            Digits.DigitArrayCompare(val);
            long startTime = System.nanoTime();

            for (int i = 0; i < count; ++i) {
                Digits.DigitArrayCompare(val);
            }
            endTime = System.nanoTime();
            averageDuration = (endTime - startTime) / count;

            System.out.println(averageDuration);
        }
    }
} 
