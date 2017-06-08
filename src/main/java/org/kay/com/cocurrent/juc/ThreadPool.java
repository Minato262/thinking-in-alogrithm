package org.kay.com.cocurrent.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Thread Pool.
 *
 * @author kay
 * @version v0.0.1
 */
public class ThreadPool {
    private final int size;
    private List<Work> works = Collections.synchronizedList(new ArrayList<Work>());
    private final List<Runnable> jobs = new LinkedList<>();

    public ThreadPool(int size) {
        this.size = size;
        initWorkThread();
    }

    public void initWorkThread() {
        for (int i = 0; i < this.size; i++) {
            Work work = new Work();
            works.add(work);
            new Thread(work, "workThread-" + i).start();
        }
    }

    public void execute(final Runnable job) {
        synchronized (jobs) {
            jobs.add(job);
            jobs.notify();
        }
    }

    private class Work implements Runnable {

        private volatile boolean isRun = true;

        @Override
        public void run() {
            while (isRun) {
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
