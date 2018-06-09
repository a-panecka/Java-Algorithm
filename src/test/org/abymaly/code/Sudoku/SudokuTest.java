package test.org.abymaly.code.Sudoku;

import org.abymaly.code.Sudoku.Sudoku;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class SudokuTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void board01() {
        Sudoku sudoku = new Sudoku();

        Integer[] board = {
                null, null, 1, null,
                4, null, null, null,
                null, null, null, 2,
                null, 3, null, null
        };

        sudoku.printBoard(board);
        sudoku.solveSudoku(board);
        System.out.println("steps count: " + sudoku.stepsCount);
    }
} 
