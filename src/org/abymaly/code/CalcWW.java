package org.abymaly.code;

import java.util.*;
import java.util.regex.*;

public class CalcWW {

    public enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        POWER("^");

        String getSymbol() {
            return symbol;
        }

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

    }


    public static void calculate(Stack<Double> digits, Operator operator) {

        // Stack<Integer> digits = new Stack<>();
        // ArrayDeque<String> operators = new ArrayDeque<>();


        switch (operator) {
            case PLUS:
                digits.push(digits.pop() + digits.pop());
                break;
            case MINUS:
                digits.push(-digits.pop() + digits.pop());
                break;
            case MULTIPLY:
                digits.push(digits.pop() * digits.pop());
                break;
            case DIVIDE:
                digits.push(1 / digits.pop() * digits.pop());
                break;
            case POWER:
                digits.push(digits.pop() + digits.pop());
                break;
        }
    }

    public static void main(String args[]) {

        Stack<Double> digits = new Stack<>();
        ArrayDeque<Operator> operators = new ArrayDeque<>();

        // digits.push(1.);
        // digits.push(2.);

        String operationInput = "1 2 +";
        String[] operation = operationInput.split(" ");

        Operator[] allOperators = Operator.values();

        for (String op : operation) {

            if (op.matches("[0-9]")) {
                digits.push(Double.parseDouble(op));
//                System.out.println(digits.pop());
            } else {

                for (Operator o : allOperators) {

                    if (o == Operator.PLUS) {
                        calculate(digits, Operator.PLUS);
                        break;
                    }
                    if (o == Operator.MINUS) {
                        digits.push(-digits.pop() + digits.pop());
                        break;
                    }
                    if (o == Operator.PLUS) {
                        digits.push(digits.pop() + digits.pop());
                        break;
                    }
                    if (o == Operator.PLUS) {
                        digits.push(digits.pop() + digits.pop());
                        break;
                    }
                }
            }

        }



    }
}
