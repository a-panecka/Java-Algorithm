package org.abymaly.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    List<Integer> data;

    public BinarySearch() {
        this.data = data;
        data = new ArrayList<>();
    }

    public void fill() {
        for (int i = 0; i < 10; ++i) {
            data.add((int) (Math.random() * 10));
        }
        data.add(4);
        Collections.sort(data);
    }

    public void fillDefault() {
        data.add(1);
        data.add(3);
        data.add(9);
        data.add(12);
    }

    public void print() {
        System.out.println(data.toString());
    }

    public int find(Integer x) {
        int begin = 0;
        int end = data.size();

//        if (x > data.get(data.size() - 1)) {
//            System.out.println("There is no.");
//            return -1;
//        }
//
//        if (x < data.get(0)) {
//            System.out.println("There is no.");
//            return -1;
//        }

        while (true) {
            int mid = begin + ((end - begin) / 2);

            System.out.println("begin: " + begin + "; end: " + end + "; mid: " + data.get(mid));

            if (x.equals(data.get(mid))) {
                System.out.println(mid);
                return mid;

            } else if (x < data.get(mid)) {
                end = mid;

            } else if (x > data.get(mid)) {
                begin = mid;
            }

            if ((end - begin) / 2 == 0){
                System.out.println("There is no.");
                return -1;
            }
        }
    }
}