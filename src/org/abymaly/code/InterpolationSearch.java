package org.abymaly.code;

import java.util.*;

public class InterpolationSearch {

    List<Integer> data;

    public InterpolationSearch() {
        this.data = data;
        data = new ArrayList<>();
    }

    public void fillList() {
        for (int i = 0; i < 15; ++i) {
            data.add((int) Math.random() * 10);
        }

        Collections.sort(data);
    }

    public void fillDefault() {
        data.add(0);
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(100);
        data.add(200);
        data.add(300);
        data.add(400);
        data.add(500);
    }

    public void printList() {
        System.out.println(data.toString());
    }

    public int findValue(Integer x) {

        int begin = 0;
        int end = data.size()-1;
        int movement;

        if (x < data.get(0) || x > data.get(data.size() - 1)) {
            return -1;
        }

        if ((int) x == data.get(0)) {
            return data.get(0);
        }

        if ((int) x == data.get(data.size() - 1)) {
            return data.size() - 1;
        }

        while (true) {

            float a = x - data.get(begin);
            float b = (float)(data.get(end) - data.get(begin));
            float c = (end - begin);

            movement = (int) Math.floor(a / b * c);

            if (x.equals(data.get(movement + begin))) {
                return movement;
            }

            if (movement == 0) {
                while (begin < end) {
                    begin++;
                    if (x.equals(data.get(begin))) {
                        return begin;
                    }
                }
                return -1;
            }

            if (movement == end - begin) {
                while (end > begin) {
                    end--;
                    if (x.equals(data.get(end))) {
                        return end;
                    }
                }
                return -1;
            }

            if (x > data.get(movement)) {
                begin += movement;
            } else {
                end -= movement;
            }

        }
    }
}