package com.proftelran.org.lessontwentyeight;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                   synchronized (this) {
                       counter.getAndIncrement();
                   }
                }
            }
        };

        Thread threadOne = new Thread(runnable);
        Thread threadTwo = new Thread(runnable);
        Thread threadThree = new Thread(runnable);

        long startTime = System.currentTimeMillis();
        threadOne.start();
        threadTwo.start();
        threadThree.start();


        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter " + counter);
        System.out.println("Execute time = " + (System.currentTimeMillis() - startTime));

    }
}
