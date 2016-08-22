package org.kay.com.fundamentals;

/**
 * 写着玩
 *
 * @author kay
 * @version 1.0
 */
public class BeerTest {

    /**
     * 啤酒兑换计算工具 -- 精简代码 装13用
     *
     * @param a 初始购买瓶数
     * @param b 啤酒:啤酒瓶兑换比例
     * @param c 啤酒:啤酒盖对话比例
     *          a > b > c
     * @return
     */
    public static int queryWineNumFinal(int a, int b, int c) {
        int wineNum = a, wineNumOffset, bottle = a, cap = a;
        do {
            wineNumOffset = bottle / b + cap / c;
            bottle = bottle % b + wineNumOffset;
            cap = cap % c + wineNumOffset;
            wineNum += wineNumOffset;
        } while (wineNumOffset != 0);
        return wineNum;
    }

    public static void main(String args[]) {
        System.out.println(queryWineNumFinal(5, 4, 2));
    }
}
