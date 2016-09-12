package org.kay.com.fundamentals;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * 调度算法
 *
 * @author kay
 * @since 1.0
 */
public class SchedulingAlgorithm {

    private static int score = 0;

    private static final int a = 1;  // 等待 a 分钟
    private static final int b = 2;  // 等待 a 分钟后 不满为b
    private static final int c = 3;  // 等待 c 分钟
    private static final int d = 4;  // 加 d 倍

    private static final int x = 100; // 人数
    private static final int y = 5;   // 楼层数
    private static final int g = 2;   // 每层所需时间
    private static final int h = 1;   // 每层停留时间
    private static final int z = 2;   // 电梯数
    private static final int k = 5;   // 每次启动时间

    private static class Transport implements Callable<Integer> {

        private final int PEOPLE_COUNT = z * k; // 每次启动时间

        public Integer call() throws Exception {
            int time = x / PEOPLE_COUNT;
            if ((x % PEOPLE_COUNT) > 0) {
                time += 1;      // 获取往返次数
            }

            Thread threads[] = new Thread[time];
            for (int i = 0; i < time; i++) {
                threads[i] = new Thread(new Runnable() {
                    public void run() {
                        try {
                            TimeUnit.MICROSECONDS.sleep(k * 1000); // 每次启动时间
                            TimeUnit.MICROSECONDS.sleep(y * z * g * h * 2 * 1000); // 电梯往返时间
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                try {
                    threads[i].start();
                    threads[i].join();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
    }

    private static class Satisfaction extends TimerTask {
        @Override
        public void run() {
            if (score == 0) {
                score = b;
            }
            else {
                score *= d;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future  = service.submit(new Transport()); //电梯运输人
        while (!future.isDone()) {
            Timer timer = new Timer();
            timer.schedule(new Satisfaction(), a * 1000, c * 1000); //计算满意度
        }
        System.out.println(score);
        service.shutdown();
    }
}
