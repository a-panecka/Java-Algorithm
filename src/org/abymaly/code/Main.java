package org.abymaly.code;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {

        System.out.println("test");

        int[] A = {1, 3, 2, 1, 1};
        int[] B = {5, 5, 5, 5};
        int n = A.length;
        int m = B.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                System.out.println(k);
        }
//        return -1;
    }
}

//public class Main {
//    public static void main(String[] args) {
//        {
//            int[] T = new int[]{-3, -14, -5, 7, 8, 42, 8, 3};
//
//            int result = 0;
//            int i = 0;
//            int maxAmp = Integer.MIN_VALUE;
//
//            for (i = 0; i < 4; ++i) {
//                int min = Integer.MAX_VALUE;
//                int max = Integer.MIN_VALUE;
//
//                for (int j = (T.length / 4) * i; j < T.length / 4 *(i+1); ++j) {
//
//                    if (T[j] < min) {
//                        min = T[j];
//                    }
//
//                    if (T[j] > max) {
//                        max = T[j];
//                    }
//
//                }
//
//                System.out.println("i: " + (i+1) + "   max: " + max + "   min: " + min);
////                System.out.println("max: " + Math.abs(max) + "   min: " + Math.abs(min));
//                System.out.println(max - min);
//
//                if (Math.abs(Math.abs(max)-Math.abs(min)) > maxAmp) {
//                    maxAmp = Math.abs(Math.abs(max)-Math.abs(min));
//                    result = i + 1;
//                }
//
//            }
//            System.out.println("result " + result);
//        }
//    }
//}
