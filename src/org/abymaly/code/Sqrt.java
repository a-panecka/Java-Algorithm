package org.abymaly.code;

public class Sqrt {


    public static int cubic(int val) {
        System.out.println(val);
        return val * val * val;
    }

    public static int sqrt3(int n) {
        int sqrt = 0;
        int begin = 0;
        int end = 1;

        while (n > cubic(end)) {
            begin = end;
            end = end * 2;
        }

        if (n == cubic(end)) {
            return end;
        }

        int mid = (end + begin) / 2;

        while (n != cubic(mid)) {
            if (n > cubic(mid)) {
                begin = mid;
                mid = (end + begin) / 2;
            } else {
                end = mid;
                mid = (end + begin) / 2;
            }
            if (end - begin == 1) {
                return -1;
            }

        }
        sqrt = mid;

        System.out.println("begin: " + begin);
        System.out.println("end: " + end);
        return sqrt;
    }
}
