package org.abymaly.code;

public class Recursion {

    public int sumRecursion(int a, int b) {

//        return a == b ? b : sumRecursion(a+1, b) + a;

        if (a == b) {
            return b;
        } else {
            return sumRecursion(a + 1, b) + a;
        }
    }

    public int sumRecursionMapReduce(int a, int b) {

        if (a >= b) {
            return b;
        } else {
            return (sumRecursionMapReduce(a, (a + b) / 2) + sumRecursionMapReduce((a + b) / 2 + 1, b));
        }
    }
}
