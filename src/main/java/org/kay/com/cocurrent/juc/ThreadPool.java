/*
 * Copyright 2017-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
