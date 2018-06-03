package org.kay.com.cocurrent.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author kay
 * @version v1.0
 */
public class Consumer implements Runnable {

    private final Queue<Bread> queue;

    public Consumer(ArrayBlockingQueue<Bread> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            Bread bread = queue.poll();
            if (bread == null) {
                break;
            }
            System.out.println("consumer:" + bread);

            System.out.println("==>山治开始做 " + bread);
            System.out.println("==>山治做好了 " + bread);
        }
    }
}
