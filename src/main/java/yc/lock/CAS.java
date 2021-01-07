package yc.lock;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * CAS: Compare and swap
 */
public class CAS {



    public static synchronized void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println("atomicInteger:" + atomicInteger.getAndIncrement());;
                }
            }.start();
        }

        System.out.println("---------------------------------------");

//        final Integer[] integer = {0};
//        for (int i = 0; i < 10; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    System.out.println("integer:" + integer[0]++);;
//                }
//            }.start();
//        }
    }
}
