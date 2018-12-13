package org.kay.com.algorithm;

/**
 * @author kay
 * @version v1.0
 */
public class IntegerDemo {

    /**
     * 题目1：实现一个rev操作，使得一个整数反转，如输入"123"，
     * 输出"321"，并去掉前导0，如输入“100”，输出"1"。然后输
     * 入两个数a,b，输出 rev(rev(a)+rev(b))的结果。
     */
    public void problem1() {
        long x = problem1(-1, 12);
        System.out.println(x);

        x = problem1(0, null);
        System.out.println(x);

        x = problem1(-2, 12);
        System.out.println(x);

        x = problem1(-1234567892, null);
        System.out.println(x);

        x = problem1(-120, null);
        System.out.println(x);

        x = problem1(-1200, null);
        System.out.println(x);
    }

    private static long problem1(int x, Integer y) {
        if (x != 0 && x % 10 == 0) {
            return guide(x);
        }
        else if (y != null) {
            return rev(rev(x) + rev(y.longValue()));
        }
        else {
            return rev(x);
        }
    }

    private static long rev(long x) {
        long y = 0;
        while (x != 0) {
            long z = x % 10;
            x = x / 10;
            y = (y == 0) ? z : (y * 10) + z;
        }
        return y;
    }

    private static long guide(int x) {
        while (x % 10 == 0) {
            x = x / 10;
        }
        return x;
    }

    /**
     * 题目2：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */
    public void problem2() {
        problem2(0);
        problem2(1);
        problem2(2);
        problem2(90);
        problem2(12450);
    }

    private static void problem2(int n) {
        System.out.print(n + "=");
        for (int i = 2; i <= n; i++) {
            while (n != i) {
                if (n % i != 0) { // 因数整除
                    break;
                }
                n = n / i;
                System.out.print(i + "*");
            }
        }
        System.out.println(n);
    }

    /**
     * 题目3：输入两个正整数m和n，求其最大公约数和最小公倍数
     */
    public void problem3() {
        problem3(1, 48);
        problem3(36, 48);
        problem3(2, 4);
    }

    private static void problem3(int m, int n) {
        int max = maxApproximate(m, n);
        int min = minMultiple(m, n);
        System.out.printf("max approximate:%d, min multiple:%d \n", max, min);
    }

    /**
     * m, n 为正整数，求 最大公约数
     * 若 n % m = 0, m 就是 约数.
     * 若 n % m = c, 则：n = k * m + c
     * 若 m % c = 0, 则：m = k * c,  n = (k * k1 + 1) + c
     * 说明：c 是 m 的约数，也是 n 的约数
     * <p>
     * 同理，如果 m 不能整除 c，则继续整除余数。直到能整除。
     * 最终结果是：m = kn * c, n = (K1K2K3K...Kn+1) * c
     *
     * @param m 正整数m（大于0）
     * @param n 正整数n（大于0）
     * @return 最大公约数
     */
    private static int maxApproximate(int m, int n) {
        for (int i; n != 0; ) { // 一直取余，缩小取余范围，直到能整除
            i = n;
            n = m % n;
            m = i;
        }
        return m;
    }

    private static int minMultiple(int m, int n) {
        return m * n / maxApproximate(m, n);
    }
}
