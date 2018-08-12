package test.org.abymaly.code;

import org.abymaly.code.SameSubstring;
import org.junit.Test;

public class SameSubstringTest {


    @Test
    public void test01() {
        SameSubstring sameSubstring = new SameSubstring();
        System.out.println(sameSubstring.stringCompare("testami", "tes"));
    }

    @Test
    public void test02() {
        SameSubstring sameSubstring = new SameSubstring();
        String[] allStrings = {"ala_ma_kota", "ala_ma_asa",  "ala_makaka_ma"};
        System.out.println(sameSubstring.arrayToString(allStrings));
        System.out.println(sameSubstring.maxSame(allStrings));
    }

    @Test
    public void test03() {
        SameSubstring sameSubstring = new SameSubstring();
        String[] allStrings = {"ala_ma_kota", "ala_ma_asa",  "ola_makaka_ma"};
        System.out.println(sameSubstring.arrayToString(allStrings));
        System.out.println(sameSubstring.maxSame(allStrings));
    }
}
