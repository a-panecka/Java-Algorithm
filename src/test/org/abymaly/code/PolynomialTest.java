package test.org.abymaly.code;

import org.abymaly.code.Polynomial;
import org.junit.Test;

public class PolynomialTest {

    @Test
    public void testMrHorner() throws Exception {
        Polynomial polynomial = new Polynomial();
        float[] val = {1, -2, 1, 3};
        System.out.println(polynomial.mrHorner(val, 3));
//        int min = 0xffffffff;
//        int max = 0x7fffffff;
//        System.out.println("min: " + min);
//        System.out.println("max: " + max);
        boolean a = true;
        boolean b = false;
        if (a ^ b) {
            System.out.println("XOR");
        }
    }

    @Test
    public void test01() {
        Polynomial polynomial = new Polynomial();
        polynomial.sumCombination(1, 5, 20);
    }
}