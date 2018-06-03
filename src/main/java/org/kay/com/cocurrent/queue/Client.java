package org.kay.com.cocurrent.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author kay
 * @version v1.0
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        Queue<Bread> queue = new ArrayBlockingQueue<>(10);

        new Thread(new Producer(queue)).start();
        Thread.sleep(1000);
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
