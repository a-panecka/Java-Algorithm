package org.abymaly.code.calculator;

public enum Operation {
    ADDITION("+") {
        double calc (double x, double y) {
            return x + y;
        }
    },
    SUBSTRACTION ("-"){
        double calc (double x, double y) {
            return x - y;
        }
    },
    MULTIPLICATION ("*"){
        double calc (double x, double y) {
            return x * y;
        }
    },
    DIVISION ("/"){
        double calc (double x, double y) {
            return x / y;
        }
    },
    EQUAL ("="){
        double calc (double x, double y) {
            return x;
        }
    };

    public final String mark;

    Operation(String mark) {
        this.mark = mark;
    }

    abstract double calc(double x, double y);

    public Operation checkOperator(String strOperator) {
        Operation currentOperator = null;
        for (Operation op : Operation.values()) {
            if (strOperator.equals(op.mark)) {
                currentOperator = op;
            }
        }
        return currentOperator;
    }
}
