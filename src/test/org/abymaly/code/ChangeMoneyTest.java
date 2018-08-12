package test.org.abymaly.code;

import org.abymaly.code.ChangeMoney;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeMoneyTest {

    @Test
    public void test01() {
        ChangeMoney changeMoney = new ChangeMoney();
        ArrayList<Integer> allCoins = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 5, 5, 5));
        System.out.println("All coins: " + changeMoney.allCoinsToString(allCoins));
    }

    @Test
    public void test02() {
        ChangeMoney changeMoney = new ChangeMoney();
        int sum = 6;
        ArrayList<Integer> allCoins = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 5, 5));
        System.out.println(changeMoney.resultToString(changeMoney.change(sum, allCoins)));
    }

} 
