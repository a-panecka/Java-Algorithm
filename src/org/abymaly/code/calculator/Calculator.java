package org.abymaly.code.calculator;

import java.util.*;

public class Calculator {

    public double calculator(String input) throws Exception {

        String[] inputValues = input.split(" ");

        Stack<Double> values = new Stack<>();

        for (String item : inputValues) {
            if (Operation.checkOperator((item)) == null) {
                try {
                    values.push(Double.parseDouble(item));
                }
                catch (RuntimeException e) {
                    System.out.println("Error: invalid datatype");
                }
            } else {
                values.push(Operation.checkOperator(item).calc(values.pop(), values.pop()));
            }
        }

        return values.pop();
    }

}