package org.kay.com.cocurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author kay
 * @version v1.0
 */
public class Consumer implements Runnable {

    private final ArrayBlockingQueue<Bread> queue;

    public Consumer(ArrayBlockingQueue<Bread> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ;i++) {
            try {
                Bread bread = queue.take();
                System.out.println("consumer:" + bread);

                System.out.println("==>山治开始做 " + bread);
                System.out.println("==>山治做好了 " + bread);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
