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
