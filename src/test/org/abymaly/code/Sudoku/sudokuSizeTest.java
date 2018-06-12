package test.org.abymaly.code.Sudoku;

import org.abymaly.code.Sudoku.SudokuSize;
import org.junit.Test;

public class sudokuSizeTest {


    @Test
    public void board01() {
        SudokuSize sudoku = new SudokuSize();

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


    @Test
    public void board02() {
        SudokuSize sudokuSize = new SudokuSize();

        Integer[] board = {
                5, 3, null, null, 7, null, null, null, null,
                6, null, null, 1, 9, 5, null, null, null,
                null, 9, 8, null, null, null, null, 6, null,
                8, null, null, null, 6, null, null, null, 3,
                4, null, null, 8, null, 3, null, null, 1,
                7, null, null, null, 2, null, null, null, 6,
                null, 6, null, null, null, null, 2, 8, null,
                null, null, null, 4, 1, 9, null, null, 5,
                null, null, null, null, 8, null, null, 7, 9
        };

        sudokuSize.printBoard(board);
        sudokuSize.solveSudoku(board);
        System.out.println("steps count: " + sudokuSize.stepsCount);
    }

}
