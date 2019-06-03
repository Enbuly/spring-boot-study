package com.example.cas;

/**
 * cas example test
 *
 * @author lazy cat
 * @since 2019-05-29
 **/
public class LockExample implements Runnable {

    private static int sum;
    private SimpleLock lock;

    private LockExample(SimpleLock lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws Exception {
        SimpleLock lock = new SimpleLock();
        for (int i = 0; i < 100; i++) {
            LockExample test = new LockExample(lock);
            Thread t = new Thread(test);
            t.start();
        }
        Thread.sleep(1000);
        System.out.println("sum = " + sum);
    }

    @Override
    public void run() {
        this.lock.lock();
        sum++;
        this.lock.unlock();
    }
}
