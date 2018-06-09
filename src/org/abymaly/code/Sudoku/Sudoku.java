package org.abymaly.code.Sudoku;

public class Sudoku {

    public int stepsCount = 0;

    static int[] square = {
            0, 0, 1, 1,
            0, 0, 1, 1,
            2, 2, 3, 3,
            2, 2, 3, 3};

    static int[] row = {
            0, 0, 0, 0,
            1, 1, 1, 1,
            2, 2, 2, 2,
            3, 3, 3, 3};

    static int[] column = {
            0, 1, 2, 3,
            0, 1, 2, 3,
            0, 1, 2, 3,
            0, 1, 2, 3};

    public void printBoard(Integer[] board) {

        String newLine = "\n";

        StringBuffer sbLine = new StringBuffer();

        for (int i = 0; i < board.length; ++i) {
            if ((i) % 4 == 0) {
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

        if (board[idx] != null) {
            return false;
        }

        int mySquare = square[idx];

        for (int i = 0; i <= 15; ++i) {
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

        for (int i = 0; i <= 15; ++i) {
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

        for (int i = 0; i <= 15; ++i) {
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

        for (int value = 1; value <= 4; ++value) {
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