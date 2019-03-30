package org.kay.com.leetcode.solution01;

/**
 * 9.Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Coud you solve it without converting the integer to a string?
 */
public class Solution_9_PalindromeNumber {

    public static void main(String[] args) {
        boolean is = isPalindrome(121);
        System.out.println(is);

        is = isPalindrome(-121);
        System.out.println(is);

        is = isPalindrome(10);
        System.out.println(is);
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        final int r = x, high = 2147483647;
        long result = 0;
        while (x != 0) {
            result = result * 10 + Math.abs(x % 10);
            x /= 10;
        }
        if (result > high) {
            return false;
        }
        else {
            return r == result;
        }
    }
}
