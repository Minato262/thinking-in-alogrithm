package org.kay.com.leetcode.solution06;

public class Solution_58_LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        return (array.length == 0) ? 0 : array[array.length - 1].length();
    }

    public static void main(String[] args) {
        int len = lengthOfLastWord("Hello World");
        System.out.println(len);

        len = lengthOfLastWord("   ");
        System.out.println(len);
    }
}
