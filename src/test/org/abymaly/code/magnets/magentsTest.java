package test.org.abymaly.code.magnets;

import org.abymaly.code.magnets.Magnets;
import org.abymaly.code.magnets.Signs;
import org.junit.Test;

public class magentsTest {


    @Test
    public void test01() {
        Magnets magnets = new Magnets();
        Signs[][] board = magnets.emptyBoard();
        magnets.printBoard(board);
    }

    @Test
    public void test02() {
        Magnets magnets = new Magnets();

        Signs[][] board = {
                {Signs.EMPTY, Signs.EMPTY, Signs.X, Signs.EMPTY},
                {Signs.EMPTY, Signs.EMPTY, Signs.EMPTY, Signs.EMPTY},
                {Signs.X, Signs.EMPTY, Signs.EMPTY, Signs.X},
                {Signs.EMPTY, Signs.X, Signs.X, Signs.EMPTY},
        };

        magnets.printBoard(board);

        magnets.setStartPosition(board, 0, 0);
        magnets.setData(board, 1, 1, Signs.X);
        magnets.printBoard(board);
    }

    @Test
    public void test03() {
        Magnets magnets = new Magnets();

        int[] moves = {2, 3, 4, 1};

        Signs[][] board = {
                {Signs.EMPTY, Signs.O, Signs.EMPTY, Signs.X},
                {Signs.EMPTY, Signs.EMPTY, Signs.EMPTY, Signs.EMPTY},
                {Signs.X, Signs.EMPTY, Signs.EMPTY, Signs.X},
                {Signs.EMPTY, Signs.X, Signs.X, Signs.EMPTY},
        };

        magnets.printBoard(board);
        magnets.getStartPosition(board);

        magnets.go(board, moves);

        magnets.printBoard(board);
        System.out.println(magnets.possibleMoves);
    }

}