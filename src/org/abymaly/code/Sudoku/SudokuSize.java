package org.abymaly.code.sudoku;

import static java.lang.Math.sqrt;

public class SudokuSize {

    public int stepsCount = 0;

    public int size = 9;

    public int[] square;
    public int[] column;
    public int[] row;

    public int[] getSquare() {

        int[] square = new int[size * size];

        int i = 0;
        int value = 0;
        int sizeMulitplication = 0;
        int x = 1;

        while (i < size * size) {
            if (i == size * sqrt(size) * x) {
                value = (int) (value + sqrt(size));
                ++x;
            }
            for (i = size * sizeMulitplication; i < size * (sizeMulitplication + 1); i = (int) (i + (sqrt(size)))) {
                for (int j = 0; j < sqrt(size); ++j) {
                    square[i + j] = value;
                }
                ++value;
            }
            value = (int) (value - sqrt(size));
            ++sizeMulitplication;
        }

        return square;
    }

    public int[] getRow() {

        int[] row = new int[size * size];

        int value = 0;
        int i = 0;

        while (i < size * size) {
            for (i = size * value; i < size * (value + 1); ++i) {
                row[i] = value;
            }
            ++value;
        }

        return row;
    }


    public int[] getColumn() {

        int[] column = new int[size * size];

        int value = 0;
        int i = 0;

        while (i < size * size) {
            for (value = 0; value < size; ++value) {
                column[i] = value;
                ++i;
            }
        }

        return column;
    }

    public void printBoard(Integer[] board) {

        String newLine = "\n";
        StringBuffer sbLine = new StringBuffer();

        for (int i = 0; i < board.length; ++i) {
            if ((i) % size == 0) {
                sbLine.append(newLine);
            }
            if (board[i] == null) {
                sbLine.append(" _ ");
            } else {
                sbLine.append(" ");
                sbLine.append(board[i]);
                sbLine.append(" ");
            }
        }

        System.out.println(sbLine);
    }

    public boolean check(int idx, int value, Integer[] board) {

        square = getSquare();
        row = getRow();
        column = getColumn();

        if (board[idx] != null) {
            return false;
        }

        int mySquare = square[idx];

        for (int i = 0; i <= (size * size) - 1; ++i) {
            if (square[i] == mySquare) {
                if (board[i] == null) {
                    continue;
                }
                if (board[i].equals(value)) {
                    return false;
                }
            }
        }

        int myRow = row[idx];

        for (int i = 0; i <= (size * size) - 1; ++i) {
            if (row[i] == myRow) {
                if (board[i] == null) {
                    continue;
                }
                if (board[i].equals(value)) {
                    return false;
                }
            }
        }

        int myColumn = column[idx];

        for (int i = 0; i <= (size * size) - 1; ++i) {
            if (column[i] == myColumn) {
                if (board[i] == null) {
                    continue;
                }
                if (board[i].equals(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solveSudoku(Integer[] orgBoard) {
        Integer[] cloneBoard = orgBoard.clone();
        int firstEmpty = 0;

        for (firstEmpty = 0; firstEmpty < orgBoard.length + 1; ++firstEmpty) {
            if (firstEmpty < orgBoard.length && cloneBoard[firstEmpty] == null) {
                break;
            }
        }

        if (firstEmpty >= orgBoard.length) {
            printBoard(cloneBoard);
            return false;
        }

        for (int value = 1; value <= size; ++value) {
            if (check(firstEmpty, value, cloneBoard)) {
                ++stepsCount;
                cloneBoard[firstEmpty] = value;
                solveSudoku(cloneBoard);
                cloneBoard[firstEmpty] = null;
            }
        }

        return true;
    }
}
