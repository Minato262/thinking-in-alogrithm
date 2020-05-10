package org.kay.com.leetcode.solution02;

public class Solution_13_RomanToInt {

    enum RomanNumber {
        CM("CM", 900),
        CD("CD", 400),
        XC("XC", 90),
        XL("XL", 40),
        IX("IX", 9),
        IV("IV", 4),

        M("M", 1000),
        D("D", 500),
        C("C", 100),
        L("L", 50),
        X("X", 10),
        V("V", 5),
        I("I", 1);

        private final String code;
        private final int    value;

        RomanNumber(String code, int value) {
            this.code = code;
            this.value = value;
        }

        public static RomanNumber getValue(String str) {
            for (RomanNumber roman : values()) {
                if (str.contains(roman.code)) {
                    return roman;
                }
            }
            return null;
        }
    }

    public int romanToInt(String s) {
        int i = 0;

        RomanNumber roman = RomanNumber.getValue(s);
        while (roman != null) {
            s = s.replaceFirst(roman.code, "");
            i += roman.value;

            roman = RomanNumber.getValue(s);
        }
        return i;
    }
}
