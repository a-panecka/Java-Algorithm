package org.abymaly.code.calculatorPriority;

public enum OperationPriority {
    ADDITION("+") {
        int calcOperationPriority() {
            return 0;
        }
    },
    SUBTRACTION("-") {
        int calcOperationPriority() {
            return 0;
        }
    },
    MULTIPLICATION("*") {
        int calcOperationPriority() {
            return 1;
        }
    },
    DIVISION("/") {
        int calcOperationPriority() {
            return 1;
        }
    },
    EQUALS("=") {
        int calcOperationPriority() {
            return -10000;
        }
    };

    public final String mark;

    OperationPriority(String mark) {
        this.mark = mark;
    }

    public static OperationPriority checkOperator(String strOperator) {
        for (OperationPriority op : OperationPriority.values()) {
            if (op.mark.equals(strOperator)) {
                return op;
            }
        }
        return null;
    }

    abstract int calcOperationPriority();

}
