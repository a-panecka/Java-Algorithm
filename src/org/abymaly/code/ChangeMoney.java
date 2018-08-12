package org.abymaly.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChangeMoney {

    public void removeAdd(Integer coin, ArrayList<Integer> allCoins, ArrayList<Integer> checkedCoins) {
        allCoins.remove(coin);
        checkedCoins.add(coin);
    }

    public void changeHelper(int sum, List<Integer> allCoins_, List<Integer> checkedCoins_, ArrayList<List<Integer>> resultList) {

        int previousCoin = 0;

        for (Integer coin : allCoins_) {

            ArrayList<Integer> allCoins = new ArrayList<>(allCoins_);
            ArrayList<Integer> checkedCoins = new ArrayList<>(checkedCoins_);

            if (previousCoin == coin) {
                continue;
            } else {
                previousCoin = coin;
            }

            if (sum - coin == 0) {
                removeAdd(coin, allCoins, checkedCoins);
                resultList.add(checkedCoins);
                continue;
            }

            if (sum - coin > 0) {
                removeAdd(coin, allCoins, checkedCoins);
                changeHelper(sum - coin, allCoins, checkedCoins, resultList);
                continue;
            }

            if (sum - coin < 0) {
                continue;
            }
        }

        return;
    }

    public ArrayList<List<Integer>> change(Integer sum, ArrayList<Integer> allCoins) {

        ArrayList<List<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> currentCoins = new ArrayList<>();

        Collections.sort(allCoins, Collections.reverseOrder());

        changeHelper(sum, allCoins, currentCoins, resultList);

        return resultList;
    }

    public String allCoinsToString(ArrayList<Integer> allCoins) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < allCoins.size(); ++i) {
            result
                    .append(allCoins.get(i))
                    .append("; ");
        }
        return result.toString();
    }

    public String resultToString(ArrayList<List<Integer>> resultList) {
        StringBuilder newResult = new StringBuilder();

        for (List<Integer> lists : resultList) {
            newResult.append("[");
            for (Integer item : lists) {
                newResult
                        .append(item)
                        .append("; ");
            }
            newResult
                    .delete(newResult.length() - 2, newResult.length())
                    .append("]\n");
        }

        return newResult.toString();

    }
}