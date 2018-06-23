package org.abymaly.code.magnets;

public class Magnets {

    public Signs[][] board;
    private final int size;
    public int movesCount;

    public int getSize() {
        return size;
    }

    public Magnets() {
        this.size = 4;
        this.board = new Signs[getSize()][getSize()];
    }

    public String boardToString(Signs[][] board) {
        String newLine = "\n";
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                result
                        .append(" ")
                        .append((board[i][j]).getMark())
                        .append(" ");
            }
            result.append(newLine);
        }
        return result.toString();
    }

    public void setCurrentPosition(Signs[][] board, int x, int y) {
        board[x][y] = Signs.O;
    }

    public void setData(Signs[][] board, int x, int y, Signs value) {
        board[x][y] = value;
    }

    public Signs[][] emptyBoard() {
        Signs[][] newBoard = new Signs[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                setData(newBoard, i, j, Signs.EMPTY);
            }
        }
        return newBoard;
    }

    public int actualX;
    public int actualY;

    public void refreshCurrentPosition(Signs[][] board) {
        setData(board, actualX, actualY, Signs.O);
    }

    public void emptyCurrentPosition(Signs[][] board) {
        setData(board, actualX, actualY, Signs.EMPTY);
    }

    public void getStartPosition(Signs[][] board) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j].equals(Signs.O)) {
                    actualX = i;
                    actualY = j;
                }
            }
        }
    }

    public boolean moveUp(Signs[][] board) {

        if (actualX == 0) {
            return false;
        }

        if (board[(actualX) - 1][actualY] == (Signs.X)) {
            return false;
        }

        emptyCurrentPosition(board);
        ++movesCount;
        --actualX;
        refreshCurrentPosition(board);

        return true;
    }

    public boolean moveRight(Signs[][] board) {

        if (actualY == (size - 1)) {
            return false;
        }

        if (board[actualX][(actualY) + 1] == (Signs.X)) {
            return false;
        }

        emptyCurrentPosition(board);
        ++movesCount;
        ++actualY;
        refreshCurrentPosition(board);

        return true;
    }

    public boolean moveDown(Signs[][] board) {

        if (actualX == size - 1) {
            return false;
        }

        if (board[actualX + 1][actualY] == (Signs.X)) {
            return false;
        }

        emptyCurrentPosition(board);
        ++movesCount;
        ++actualX;
        refreshCurrentPosition(board);

        return true;
    }

    public boolean moveLeft(Signs[][] board) {

        if (actualY == 0) {
            return false;
        }

        if (board[actualX][actualY - 1] == (Signs.X)) {
            return false;
        }

        emptyCurrentPosition(board);
        ++movesCount;
        --actualY;
        refreshCurrentPosition(board);

        return true;
    }

    public int go(Signs[][] board, Moves[] moves) {

        getStartPosition(board);

        movesCount = 0;

        for (int i = 0; i < moves.length; ++i) {
            switch (moves[i]) {
                case GO_UP:
                    while (moveUp(board)) {
                        moveUp(board);
                    }
                    break;
                case GO_RIGHT:
                    while (moveRight(board)) {
                        moveRight(board);
                    }
                    break;
                case GO_DOWN:
                    while (moveDown(board)) {
                        moveDown(board);
                    }
                    break;
                case GO_LEFT:
                    while (moveLeft(board)) {
                        moveLeft(board);
                    }
                    break;
            }
        }
        return movesCount;
    }
}