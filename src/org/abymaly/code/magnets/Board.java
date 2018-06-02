package org.abymaly.code.magnets;

public class Board {
    int size = 3;

    enum Val {O, X, EMPTY}

    ;

    Val[][] board = {{Val.EMPTY, Val.X, Val.EMPTY}, {Val.X, Val.EMPTY, Val.EMPTY}, {Val.EMPTY, Val.X, Val.O}};

    public Val getData(int x, int y) {
        return board[x][y];
    }

    public boolean isEmpty(int x, int y) {
        return (board[x][y]).equals(Val.EMPTY);
    }

    public void printBoard() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(board[j][i].toString());
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
        System.out.println("--------------------------------");
    }

        enum MagnetsVal {M1, M2, M3, M4}
        ;

        public void M1Move ( int x, int y){

        }


    }
