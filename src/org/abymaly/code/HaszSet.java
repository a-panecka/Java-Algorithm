package org.abymaly.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HaszSet<T> {

    ArrayList<List<T>> verticalList;

    int size = 8;

    public HaszSet() {
        verticalList = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            LinkedList<T> horizontalList = new LinkedList<>();
            verticalList.add(i, horizontalList);
        }
    }

    public void add(T data) {
        int idx = data.hashCode() & size - 1;
        List<T> hList = verticalList.get(idx);
        if (!hList.contains(data)) {
            hList.add(data);
        }
    }

    public boolean find(T data) {
        int idx = data.hashCode() & size - 1;
        List<T> hList = verticalList.get(idx);
        return (hList.contains(data));
    }

    public void howMuch () {
        for (int i = 0; i < verticalList.size(); ++i) {
            System.out.println(i + " : " + verticalList.get(i).size());
        }
    }

}
