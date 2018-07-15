package org.abymaly.code;

public class RotLeft {

    public int[] rotLeft(int[] a, int d) {

        int size = a.length;
        int tmp;

        for (int count = 0; count < d; ++count) {
            tmp = a[0];

            for (int i = 0; i < size - 1; ++i) {
                a[i] = a[i+1];
            }

            a[size - 1] = tmp;
        }

        return a;
    }

    public String toString(int[] a) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length; ++i) {
            result
                    .append(a[i])
                    .append(" ");
        }
        return result.toString();
    }
}
