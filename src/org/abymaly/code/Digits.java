package org.abymaly.code;

public class Digits {

    public static int DigitDivide(int n) {
        int digit = 1;
        while (n >= 10) {
            n = n / 10;
            ++digit;
        }
        return digit;
    }

    public static int DigitLog10(int n) {
        int digit = 1 + (int) Math.log10(n);
        return digit;
    }

    public static int DigitMultiplication(int n) {
        int a = 1;
        int digit = 0;
        while (a <= n) {
            a = a * 10;
            ++digit;
        }
        return digit;
    }


    public static int DigitArrayCompare(int n) {
        int digit = 0;
        int[] array = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        for (int i : array) {
            ++digit;
            if (n < i) {
                break;
            }
        }
        return digit;
    }
}
