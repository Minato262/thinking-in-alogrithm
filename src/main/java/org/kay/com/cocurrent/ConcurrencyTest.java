package org.kay.com.cocurrent;

/**
 * @author kay
 * @version v1.0
 */
public class ConcurrencyTest {

    public static void main(String[] args) throws InterruptedException {
        concurrency(10000);
        serial(10000);

        concurrency(100000);
        serial(100000);

        concurrency(1000000);
        serial(1000000);

        concurrency(100000000);
        serial(100000000);
    }

    private static void concurrency(final long count) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency:" + time + "ms, b=" + b);
    }

    private static void serial(long count) {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms, b=" + b + ", a=" + a);
    }
}
