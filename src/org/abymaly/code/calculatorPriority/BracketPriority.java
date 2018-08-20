package org.abymaly.code.calculatorPriority;

public enum BracketPriority {
    OPEN_BRACKET("(") {
        int calcBracketPriority() {
            return 1000;
        }
    },
    CLOSE_BRACKET(")") {
        int calcBracketPriority() {
            return -1000;
        }
    };

    public final String mark;

    BracketPriority(String mark) {
        this.mark = mark;
    }

    abstract int calcBracketPriority();

    public static BracketPriority checkOperator(String strOperator) {
        for (BracketPriority op : BracketPriority.values()) {
            if (op.mark.equals(strOperator)) {
                return op;
            }
        }
        return null;
    }

}
