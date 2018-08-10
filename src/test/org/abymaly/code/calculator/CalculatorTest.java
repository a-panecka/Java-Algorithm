package test.org.abymaly.code.calculator;

import org.abymaly.code.calculator.Calculator;
import org.junit.Test;


public class CalculatorTest {

    @Test
    public void test01() {
        String input = "3 5 2 8 * + -";

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculator(input));
    }

} 
