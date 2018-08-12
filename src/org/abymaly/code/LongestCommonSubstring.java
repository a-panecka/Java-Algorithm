package org.abymaly.code;

public class LongestCommonSubstring {

    public char myCharAt(String str, int idx) {
        return str.charAt(idx - 1);
    }

    public void matrixToString(int[][] lists) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lists.length; ++i) {
            for (int j = 0; j < lists[i].length; ++j) {
                sb
                        .append(lists[i][j])
                        .append("; ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public int longestSubstring(String a, String b) {

        int maxCount = 0;

        int[][] lists = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i < lists.length; ++i) {
            for (int j = 1; j < lists[i].length; ++j) {
                if (myCharAt(a, i) == myCharAt(b, j)) {
                    lists[i][j] = lists[i - 1][j - 1] + 1;
                    if (lists[i][j] > maxCount) {
                        maxCount = lists[i][j];
                    }
                } else {
                    lists[i][j] = 0;
                }
            }
        }

        matrixToString(lists);

        return maxCount;
    }
}