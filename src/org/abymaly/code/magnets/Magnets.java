package org.abymaly.code.magnets;

public class Magnets {

    public Signs[][] board;
    private final int size;
    public int possibleMoves = 0;

    public Magnets(int size) {
        this.size = size;
        this.board = new Signs[size][size];
    }

    public Magnets() {
        this.size = 4;
    }

    class StartPosition {
        int x;
        int y;

        public StartPosition() {
        }
    }

    StartPosition startPosition = new StartPosition();

    public void printBoard(Signs[][] board) {
        String newLine = "\n";
        StringBuffer sbLine = new StringBuffer();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j].equals(Signs.EMPTY)) {
                    sbLine.append(" _ ");
                } else {
                    sbLine.append(" ");
                    sbLine.append(board[i][j]);
                    sbLine.append(" ");
                }
            }
            sbLine.append(newLine);
        }
        System.out.println(sbLine);
    }

    public void setStartPosition(Signs[][] board, int x, int y) {
        board[x][y] = Signs.O;
    }

    public void setData(Signs[][] board, int x, int y, Signs value) {
        board[x][y] = value;
    }

    public Signs[][] emptyBoard () {
        Signs [][] newBoard = new Signs[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                setData(newBoard, i, j, Signs.EMPTY);
            }
        }
        return newBoard;
    }

    public void refreshStartPosition(Signs[][] board) {
        setStartPosition(board, startPosition.x, startPosition.y);
    }

    public void emptyStartPosition (Signs[][] board) {
        setData(board, startPosition.x, startPosition.y, Signs.EMPTY);
    }

    public void getStartPosition(Signs[][] board) {

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j].equals(Signs.O)) {
                    startPosition.x = i;
                    startPosition.y = j;
                }
            }
        }
    }

    public boolean moveTop(Signs[][] board) {
        if (startPosition.x == 0 || board[(startPosition.x) - 1][startPosition.y].equals(Signs.X)) {
            return false;
        } else {
            emptyStartPosition(board);
            ++possibleMoves;
            --startPosition.x;
            refreshStartPosition(board);
        }
        return true;
    }

    public boolean moveRight(Signs[][] board) {
        if ((startPosition.y == (size - 1)) || board[startPosition.x][(startPosition.y) + 1].equals(Signs.X)) {
            return false;
        } else {
            emptyStartPosition(board);
            ++possibleMoves;
            ++startPosition.y;
            refreshStartPosition(board);
        }
        return true;
    }

    public boolean moveBottom(Signs[][] board) {
        if ((startPosition.x == size - 1) || board[startPosition.x + 1][startPosition.y].equals(Signs.X)) {
            return false;
        } else {
            emptyStartPosition(board);
            ++possibleMoves;
            ++startPosition.x;
            refreshStartPosition(board);
        }
        return true;
    }

    public boolean moveLeft(Signs[][] board) {
        if ((startPosition.y == 0) || board[startPosition.x][startPosition.y - 1].equals(Signs.X)) {
            return false;
        } else {
            emptyStartPosition(board);
            ++possibleMoves;
            --startPosition.y;
            refreshStartPosition(board);
        }
        return true;
    }

    public void go(Signs[][] board, int[] moves) {
        for (int i = 0; i < moves.length; ++i) {
            switch (moves[i]) {
                case 1:
                    while (moveTop(board)) {
                        moveTop(board);
                    }
                    break;
                case 2:
                    while (moveRight(board)) {
                        moveRight(board);
                    }
                    break;
                case 3:
                    while (moveBottom(board)) {
                        moveBottom(board);
                    }
                    break;
                case 4:
                    while (moveLeft(board)) {
                        moveLeft(board);
                    }
                    break;
            }
        }
    }
}