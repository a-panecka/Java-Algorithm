package org.abymaly.code;

public class SameSubstring {

    public String stringCompare(String a, String b) {
        String str = "";
        for (int i = 0; i < Math.min(a.length(), b.length()); ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                str = a.substring(0, i + 1);
            } else {
                break;
            }
        }
        return str;
    }

    public String maxSame(String[] allStrings) {
        String str = allStrings[0];
        for (int i = 0; i < allStrings.length; ++i) {
            str = stringCompare(str, allStrings[i]);
        }
        return str;
    }

    public String arrayToString(String[] allStrings) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < allStrings.length; ++i) {
            result
                    .append(allStrings[i])
                    .append("; ");
        }
        return result.toString();
    }
}