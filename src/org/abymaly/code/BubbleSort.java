package org.abymaly.code;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public int[] rand(int count) {

        int[] randomArray = new int[count];

        Random rand = new Random();

        for (int i = 0; i < count; ++i) {
            randomArray[i] = rand.nextInt(100);
        }

        return randomArray;
    }

    public void print(int[] arrayToSort) {
        System.out.println(Arrays.toString(arrayToSort));
    }

    public void sort(int[] arrayToSort) {

        int arrayLength = arrayToSort.length;
        int tmp = 0;

        for (int i = 0; i < arrayLength; ++i) {
            for (int j = 0; j < arrayLength - 1; ++j) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    tmp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = tmp;
                }
            }
        }
    }
}