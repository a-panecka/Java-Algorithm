package org.abymaly.code.calcPriority;

public enum OperationPriority {
    ADDITION("+") {
        int calcOperationPriority() {
            return 1;
        }
    },
    SUBTRACTION("-") {
        int calcOperationPriority() {
            return 1;
        }
    },
    MULTIPLICATION("*") {
        int calcOperationPriority() {
            return 2;
        }
    },
    DIVISION("/") {
        int calcOperationPriority() {
            return 2;
        }
    },
//    TODO:
//    POWER ("^") {
//        int calcOperationPriority() { return 3; }
//    },
    MODULO("%") {
        int calcOperationPriority() {
            return 3;
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
