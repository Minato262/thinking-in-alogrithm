package org.kay.com.cocurrent;

import org.junit.Test;
import org.kay.com.cocurrent.juc.ThreadPool;

import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link ThreadPool} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class ThreadPoolTest {

    @Test
    public void test() {
        ThreadPool pool = new ThreadPool(4);
        AtomicLong count = new AtomicLong();

        final long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            pool.execute(count::getAndIncrement);
        }
        System.out.println((System.currentTimeMillis() - begin));

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.get());
    }
}
