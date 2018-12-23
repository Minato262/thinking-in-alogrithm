package org.kay.com.cocurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author kay
 * @version v1.0
 */
public class ThreadTest extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Object co = new Object();
        System.out.println(co);

        ThreadTest thread = new ThreadTest(co);
        ThreadTest thread1 = new ThreadTest(co);
        thread.start();
        thread1.start();

        thread.sleep(10);

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("-----Main Thread notify-----");
            synchronized (co) {
                co.notifyAll();
            }

            TimeUnit.SECONDS.sleep(2);
            System.out.println("Main Thread is end.");

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Object co;

    public ThreadTest(Object co) {
        this.co = co;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting.");
            synchronized (co) {
                co.wait();
            }
            System.out.println(Thread.currentThread().getName() + " has been notified.");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
