package org.abymaly.code.calculator;

public enum Operation {
    ADDITION("+") {
        double calc(double x, double y) {
            return y + x;
        }
    },
    SUBTRACTION("-") {
        double calc(double x, double y) {
            return y - x;
        }
    },
    MULTIPLICATION("*") {
        double calc(double x, double y) {
            return y * x;
        }
    },
    DIVISION("/") {
        double calc(double x, double y) {
            return y / x;
        }
    },
    POWER("^") {
        double calc(double x, double y) {
            return Math.pow(y, x);
        }
    },
    MODULO("%") {
        double calc(double x, double y) {
            return y % x;
        }
    };

    public final String mark;

    Operation(String mark) {
        this.mark = mark;
    }

    abstract double calc(double x, double y);

    public static Operation checkOperator(String strOperator) {
        for (Operation op : Operation.values()) {
            if (op.mark.equals(strOperator)) {
                return op;
            }
        }
        return null;
    }
}