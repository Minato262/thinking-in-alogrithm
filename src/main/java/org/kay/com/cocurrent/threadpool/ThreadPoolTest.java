package org.kay.com.cocurrent.threadpool;

import java.util.concurrent.*;

/**
 * @author kay
 * @version v1.0
 */
public class ThreadPoolTest implements Runnable {

    private int i;

    public ThreadPoolTest(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println(i);
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.MICROSECONDS, queue);
        for (int i = 0; i < 10; i++) {
            executor.execute(new ThreadPoolTest(i));
            System.out.println("线程队列大小为-->" + queue.size());
        }
        executor.shutdown();
    }
}
