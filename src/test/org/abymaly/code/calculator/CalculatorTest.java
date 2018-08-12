package test.org.abymaly.code.calculator;

import org.abymaly.code.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void test01() {

        Calculator calculator = new Calculator();

        String inputPlus = "3 -2.4 +";
        String inputMinus = "9 10 -";
        String inputMulti = "12 2.5 *";
        String inputDiv = "100 3 /";
        String inputPower = "2 4 ^";
        String inputModulo = "8 3 %";

        String inputAll = "4 2 * 68 10 % 2 / + 3 2 ^ -";

        Assert.assertEquals(0.6, calculator.calculator(inputPlus), 0.001);
        Assert.assertEquals(-1.0, calculator.calculator(inputMinus), 0.001);
        Assert.assertEquals(30.0, calculator.calculator(inputMulti), 0.001);
        Assert.assertEquals(33.333, calculator.calculator(inputDiv), 0.001);
        Assert.assertEquals(16.0, calculator.calculator(inputPower), 0.001);
        Assert.assertEquals(2.0, calculator.calculator(inputModulo), 0.001);

        Assert.assertEquals(3.0, calculator.calculator(inputAll), 0.001);

    }


} 
