package org.abymaly.code.calculator;

import java.util.*;

public class Calculator {

    public Operation checkOperator(String strOperator) {
        Operation currentOperator = null;
        for (Operation op : Operation.values()) {
            if (strOperator.equals(op.mark)) {
                currentOperator = op;
            }
        }
        return currentOperator;
    }

    public double calculator(String input) {

        String[] inputValue = input.split(" ");

        Stack<Double> stack = new Stack<>();

        for (String item : inputValue) {
            if (!item.matches("[^0-9]")) {
                stack.push(Double.parseDouble(item));
            } else {
                stack.push(checkOperator(item).calc(stack.pop(), stack.pop()));
            }
        }

        return stack.pop();
    }

}