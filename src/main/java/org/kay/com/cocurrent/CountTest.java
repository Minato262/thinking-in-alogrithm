package org.kay.com.cocurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author kay
 * @version v1.0
 */
public class CountTest {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static final int clientTotal = 50000;

    private static final int threadTotal = 200;

    private static int count = 0;

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.printf("count:%d, %d ms\n", count, System.currentTimeMillis() - start);
    }

    private static void add() {
        count++;
    }
}
