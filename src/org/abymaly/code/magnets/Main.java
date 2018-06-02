package org.abymaly.code.magnets;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        int movesCount = 0;
        int iniX = 0;
        int iniY = 0;

        board.printBoard();

        System.out.print(board.getData(2, 0));
        System.out.print(board.getData(0, 2));

//        while (iniY < 3 || board.isEmpty(iniX, iniY)) {
//            iniY++;
//            movesCount++;
//        }
//        System.out.println(movesCount);

    }
}
