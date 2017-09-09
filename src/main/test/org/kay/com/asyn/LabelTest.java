package org.kay.com.asyn;

import org.junit.Test;

import java.util.Random;

/**
 * @author kay
 * @version v0.0.1
 */
public class LabelTest {

    @Test
    public void test1() {
        outer:
        for (int i = 0; i < 10; i++) {
            System.out.println("\n" + "outer_loop:" + i);
            inner:
            for (int k = 0; i < 10; k++) {
                System.out.print(k + " ");
                int x = new Random().nextInt(10);
                if (x > 7) {
                    System.out.print(" >>x == " + x + "，结束inner循环，继续迭代执行outer循环了！");
                    continue outer;
                }
                if (x == 1) {
                    System.out.print(" >>x == 1，跳出并结束整个outer和inner循环！");
                    break outer;
                }
            }
        }
        System.out.println("------>>>所有循环执行完毕！");
    }
}
