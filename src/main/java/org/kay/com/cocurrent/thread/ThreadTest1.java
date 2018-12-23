package org.kay.com.cocurrent.thread;

/**
 * @author kay
 * @version v1.0
 */
public class ThreadTest1 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        ThreadTest1 thread = new ThreadTest1(0);
        ThreadTest1 thread1 = new ThreadTest1(1);
        // thread.run();
        // thread1.run();

        Thread thread2 = new Thread(thread);
        Thread thread3 = new Thread(thread1);
        thread2.start();
        thread3.start();

        thread2.join();
        thread3.join();
    }

    private int i;

    public ThreadTest1(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + i);
    }
}
