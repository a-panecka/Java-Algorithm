package test.org.abymaly.code;

import org.abymaly.code.BubbleSort;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void test01() {
        BubbleSort bubbleSort = new BubbleSort();
        int [] newBubbleSort = bubbleSort.rand(20);
        bubbleSort.print(newBubbleSort);

    }
    @Test
    public void test02() {
        BubbleSort bubbleSort = new BubbleSort();
        int [] newBubbleSort = bubbleSort.rand(10);

        bubbleSort.print(newBubbleSort);
        bubbleSort.sort(newBubbleSort);
        bubbleSort.print(newBubbleSort);
    }

}