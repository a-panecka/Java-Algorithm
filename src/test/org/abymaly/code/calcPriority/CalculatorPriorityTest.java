package test.org.abymaly.code.calcPriority;

import org.abymaly.code.calcPriority.CalculatorPriority;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.abymaly.code.calcPriority.CalculatorPriority;
import org.junit.Test;

public class CalculatorPriorityTest {

    @Test
    public void test01() {
        CalculatorPriority calculator = new CalculatorPriority();
        System.out.println(calculator.calculator("2 * ( 7 + 3 ) / ( 9 - 7 ) ="));
    }
}
