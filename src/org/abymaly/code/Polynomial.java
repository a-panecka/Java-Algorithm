package org.abymaly.code;

public class Polynomial {

    public float mrHorner(float val[], float x) {
        float result = 0;
        float aX = 1;

        for (float i : val) {
            result += i * aX;
            aX *= x;
        }
        return result;
    }

    public void sumCombination(int a, int b, int c) {

        int[] data = {a, b, c};

        for (int counter = 0; counter < Math.pow(2, data.length); ++counter) {
            int tmp = counter;
            int[] intBinArr = new int[3];

            for (int idx = 0; idx < intBinArr.length; ++idx) {
                intBinArr[idx] = tmp % 2;
                tmp = tmp / 2;
            }

            int sum = 0;

            for (int idx = 0; idx < intBinArr.length; ++idx) {
                sum += intBinArr[idx] * data[idx];
            }
            System.out.println(sum);

        }
    }
}