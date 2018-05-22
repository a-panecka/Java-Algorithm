package test.org.abymaly.code;

import org.abymaly.code.MyArray;
import org.junit.Test;

public class MyArrayTest {

    @Test
    public void test01() {
        MyArray<Integer> myArray = new MyArray<>();
        myArray.append(4);
        myArray.append(2);
        myArray.append(3);
        myArray.append(4);
        myArray.print();
        myArray.insert(2, 19);
        myArray.print();
        myArray.insert(0, 100);
        myArray.print();
        myArray.delete(3);
        myArray.print();
        System.out.println(myArray.getData(0).toString());
        myArray.setData(0, 200);
        System.out.println(myArray.getData(0).toString());
    }

    @Test
    public void test02() {
        MyArray<Integer> myArray = new MyArray<>();
        for (int i = 0; i < 1000000; ++i) {
            myArray.append(1);
            if (i%10000 == 0) {
                System.out.println(i);
            }

        }
    }
}