package test.org.abymaly.code;

import org.abymaly.code.FigureMoves;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class FigureMovesTest {

    @Test
    public void test01() {

        int[] position = {0, 0};
        FigureMoves figureMoves = new FigureMoves();

        ArrayList<int[]> result = figureMoves.towerMoves(position);

        for (int[] finallItems : result) {
            System.out.println(Arrays.toString(finallItems));
        }
    }

    @Test
    public void test02() {

        int[] position = {7, 7};
        FigureMoves figureMoves = new FigureMoves();

        ArrayList<int[]> result = figureMoves.towerMoves(position);

        for (int[] finallItems : result) {
            System.out.println(Arrays.toString(finallItems));
        }
    }
}