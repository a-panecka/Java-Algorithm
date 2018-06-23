package test.org.abymaly.code.magnets;

import org.abymaly.code.magnets.Magnets;
import org.abymaly.code.magnets.Signs;
import org.abymaly.code.magnets.Moves;
import org.junit.Test;

public class magentsTest {

    @Test
    public void test01() {
        Magnets magnets = new Magnets();
        Signs[][] board = magnets.emptyBoard();
        System.out.println(magnets.boardToString(board));
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

        System.out.println(magnets.boardToString(board));

        magnets.setCurrentPosition(board, 0, 0);
        magnets.setData(board, 1, 1, Signs.X);
        System.out.println(magnets.boardToString(board));
    }

    @Test
    public void test03() {
        Magnets magnets = new Magnets();

        Moves[] moves = {Moves.GO_RIGHT, Moves.GO_DOWN, Moves.GO_LEFT, Moves.GO_UP};

        Signs[][] board = {
                {Signs.EMPTY, Signs.O, Signs.EMPTY, Signs.X},
                {Signs.EMPTY, Signs.EMPTY, Signs.EMPTY, Signs.EMPTY},
                {Signs.X, Signs.EMPTY, Signs.EMPTY, Signs.X},
                {Signs.EMPTY, Signs.X, Signs.X, Signs.EMPTY},
        };

        System.out.println(magnets.boardToString(board));

        magnets.go(board, moves);

        System.out.println(magnets.boardToString(board));
        System.out.println(magnets.movesCount);
    }

}