package org.abymaly.code.graph;

public enum Colours {
    WHITE ('W'),
    GREY ('G'),
    BLACK ('B');

    private char colour;

    Colours(char colour) {
        this.colour = colour;
    }

    public char getColour() {
        return colour;
    }
}
