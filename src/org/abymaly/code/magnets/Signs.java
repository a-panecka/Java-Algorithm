package org.abymaly.code.magnets;

public enum Signs {
    X ("X"),
    O ("O"),
    EMPTY ("_");

    private String mark;

    Signs(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
