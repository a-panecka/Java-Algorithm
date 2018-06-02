package org.abymaly.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ball {

    private class Field implements Comparable {
        int x;
        int y;
        int value;

        public Field(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return this.value - ((Field) o).value;
        }

        @Override
        public String toString() {
            return "Field{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    "}\n";
        }
    }

    public List<Field> getSortedBoard() {
        return sortedBoard;
    }

    List<Field> sortedBoard;

    Integer[][] board;
    Integer[][] result;

    public Ball(Integer[][] board) {
        this.board = board;
        this.result = new Integer[board.length][board[0].length];
    }

    public void sortedBoard() {

        sortedBoard = new ArrayList<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                Field field = new Field(i, j, board[i][j]);
                sortedBoard.add(field);
            }
            Collections.sort(sortedBoard);
        }
    }

    public void go () {
        for (Field item : sortedBoard) {

        }
    }
}