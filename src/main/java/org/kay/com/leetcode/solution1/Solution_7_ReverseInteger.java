package org.kay.com.leetcode.solution1;

/**
 * 7.Reverse Integer
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 *  Input: 123
 *  Output: 321
 * <p>
 * Example 2:
 *  Input: -123
 *  Output: -321
 * <p>
 * Example 3:
 *  Input: 120
 *  Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 */
public class Solution_7_ReverseInteger {

    public static void main(String[] args) {
        int x = reverse(123);
        System.out.println(x);

        x = reverse(120);
        System.out.println(x);

        x = reverse(-1);
        System.out.println(x);

        x = reverse(-123);
        System.out.println(x);

        x = reverse(-120);
        System.out.println(x);
    }

    private static int reverse(int x) {
        final int low = -2147483648, high = 2147483647;
        long result = 0;
        boolean flag = x < 0;

        while (x != 0) {
            result = result * 10 + Math.abs(x % 10);
            x /= 10;
        }
        if ((-result) < low || result > high) {
            return 0;
        }
        else {
            return flag ? (int) (-result) : (int) result;
        }
    }
}
