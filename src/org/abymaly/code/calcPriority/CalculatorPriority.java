package org.abymaly.code.calcPriority;

import java.util.Stack;

public class CalculatorPriority {

    Stack<PriorityPair> operators;
    Stack<Double> values;

    public CalculatorPriority() {
        this.operators = new Stack<>();
        operators.add(new PriorityPair(0, 0, ""));
        this.values = new Stack<>();
    }

    public class PriorityPair {
        private int operationPriority;
        private int bracketPriority;
        private String sign;

        public String getSign() {
            return sign;
        }

        public int getBracketPriority() {
            return bracketPriority;
        }

        public PriorityPair(int operationPriority, int bracketPriority, String sign) {
            this.operationPriority = operationPriority;
            this.bracketPriority = bracketPriority;
            this.sign = sign;
        }

        public int getSumPriority() {
            return operationPriority + bracketPriority;
        }
    }

    public boolean nextPrioritySumBigger(PriorityPair currentValue) {
        return operators.peek().getSumPriority() <= currentValue.getSumPriority();
    }

    public PriorityPair createNextPair(String input) {
        if (OperationPriority.checkOperator(input) != null) {
            return new PriorityPair(OperationPriority.checkOperator(input).calcOperationPriority(), operators.peek().getBracketPriority(), input);
        } else {
            return new PriorityPair(0, BracketPriority.checkOperator(input).calcBracketPriority() + operators.peek().getBracketPriority(), input);
        }
    }

    public double calculator(String input) {

        String[] inputValues = input.split(" ");

        for (String item : inputValues) {
            if (OperationPriority.checkOperator(item) != null || BracketPriority.checkOperator(item) != null) {

                if (nextPrioritySumBigger(createNextPair(item))) {
                    operators.push(createNextPair(item));

                } else {
                    while (operators.size() > 1) {
                        if (OperationPriority.checkOperator(operators.peek().getSign()) != null) {
                            values.push(Operation.checkOperator(operators.pop().getSign()).calc(values.pop(), values.pop()));
                        } else {
                            operators.pop();
                        }
                    }

                    if (OperationPriority.checkOperator(item) != null) {
                        operators.push(createNextPair(item));
                    }

                }
            } else {
                values.push(Double.parseDouble(item));
            }
        }

        return values.pop();
    }
}