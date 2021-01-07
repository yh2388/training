package yc.lock;

import sun.misc.Unsafe;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();
    private int i = 0;
    synchronized void add() {
        System.out.println(i++);
    }

    void addWithLock() {

        lock.lock();
        System.out.println(lock.toString());
        System.out.println(i++);
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    test.addWithLock();
//                    test.add();
                }
            }.start();
        }
    }

}
