package org.abymaly.code;

import java.util.Arrays;

public class MyArray<T> {

    int size;
    private int reizeValue;
    private T[] data;

    public MyArray() {
        size = 0;
        reizeValue = 16;
        data = (T[]) new Object[reizeValue];
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    public void checkSize() {
        if (size == data.length) {
            resize(size + reizeValue);
        }
    }

    private void resize(int newLength) {
        T[] newData = (T[]) new Object[newLength];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public void append(T inData) {
        checkSize();
        data[size] = inData;
        ++size;
    }

    public void insert(int idx, T inData) {
        checkSize();

        System.arraycopy(data, idx, data, idx + 1, size - idx);
        data[idx] = inData;
        ++size;
    }

    public void delete(int idx) {
        System.arraycopy(data, idx + 1, data, idx, size - idx);
        --size;
    }

    public T getData(int idx) {
        return data[idx];
    }

    public void setData (int idx, T inData) {
        data[idx] = inData;
    }
}