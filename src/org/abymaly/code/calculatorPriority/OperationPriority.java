package org.abymaly.code.calculatorPriority;

public enum OperationPriority {
    ADDITION("+") {
        int calcPriority() {
            return 0;
        }
    },
    SUBTRACTION("-") {
        int calcPriority() {
            return 0;
        }
    },
    MULTIPLICATION("*"){
        int calcPriority () {
            return 1;
        }
    },
    DIVISION("/"){
        int calcPriority () {
            return 1;
        }
    },
    OPEN_BRACKET("(") {
        int calcPriority() {
            return 1;
        }
    },
    CLOSE_BRACKET(")") {
        int calcPriority() {
            return -1;
        }
    };

    public final String mark;

    OperationPriority(String mark) {
        this.mark = mark;
    }

    abstract int calcPriority();

}
