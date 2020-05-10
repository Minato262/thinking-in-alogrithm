package org.kay.com.algorithm;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * 石头剪刀布 游戏
 *
 * @author kay
 * @version v1.0
 */
public class FingerGuessingGame {

    private static final String[] FINGER_GUESS = new String[]{"石头", "剪刀", "布"};
    private static final String[] FINGER_ENDING = new String[]{"平局！", "电脑胜利！", "你赢了！"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        do {
            out.println("猜拳游戏开始！0是石头，1是剪刀，2是布，请输入:");
            int u = scan.nextInt();
            fingerGuess(u);

            out.println("是否继续？0:继续,1:退出.");
            i = scan.nextInt();
        }
        while (i != 1);
    }

    private static void fingerGuess(int u) {
        int c = new Random().nextInt(3);
        int x = (u - c + 3) % 3;
        out.printf("你出的是：%s, 电脑出的是：%s,\n猜拳游戏结束！\n%s\n", FINGER_GUESS[u],
                                                                   FINGER_GUESS[c],
                                                                   FINGER_ENDING[x]);
    }
}
