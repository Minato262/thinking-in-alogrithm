package org.kay.com.cocurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author kay
 * @version v1.0
 */
public class Producer implements Runnable {

    private final ArrayBlockingQueue<Bread> queue;

    public Producer(ArrayBlockingQueue<Bread> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ;i++) {
            try {
                Bread bread = new Bread();
                queue.put(bread);
                System.out.println("Producer:" + bread);

                System.out.println("-->路飞拿到 " + bread);
                System.out.println("-->路飞吃完 " + bread);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
