package test.org.abymaly.code;

import org.abymaly.code.LongestCommonSubstring;
import org.junit.Test;

public class LongestCommonSubstringTest {

    @Test
    public void test01() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "ala_ma_asa";
        String b = "ala_chce_kota";

        System.out.println(lcs.longestSubstring(a, b));
    }
}