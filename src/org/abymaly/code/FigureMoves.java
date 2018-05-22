package org.abymaly.code;

import java.util.ArrayList;

public class FigureMoves {

    public ArrayList<int[]> towerMoves(int[] position) {

        int size = 8;

        ArrayList<int[]> possibleMoves = new ArrayList<>();

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[] actPosition = position.clone();

        for (int[] items : direction) {
            actPosition = position.clone();
            for (int i = 0; ; ++i) {

                actPosition[0] = actPosition[0] + items[0];
                actPosition[1] = actPosition[1] + items[1];

                if (actPosition[0] >= size || actPosition[1] >= size || actPosition[0] < 0 || actPosition[1] < 0) {
                    break;
                }
                possibleMoves.add(actPosition.clone());
            }
        }

        return possibleMoves;

    }
}