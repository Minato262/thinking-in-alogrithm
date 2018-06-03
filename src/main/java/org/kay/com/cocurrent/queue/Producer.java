package org.kay.com.cocurrent.queue;

import java.util.Queue;

/**
 * @author kay
 * @version v1.0
 */
public class Producer implements Runnable {

    private final Queue<Bread> queue;

    public Producer(Queue<Bread> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Bread bread = new Bread();
            queue.add(bread);
            System.out.println("Producer:" + bread);

            System.out.println("-->路飞拿到 " + bread);
            System.out.println("-->路飞吃完 " + bread);
        }
    }
}
