package test.org.abymaly.code;

import org.abymaly.code.Ball;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallTest {

    @Test
    public void testSortedBoard() {
        Integer board[][] = {{6, 2, 1}, {5, 1, 3}, {4, 2, 0}};
        Ball ball = new Ball(board);
        ball.sortedBoard();

        System.out.println(ball.getSortedBoard());
    }

}
