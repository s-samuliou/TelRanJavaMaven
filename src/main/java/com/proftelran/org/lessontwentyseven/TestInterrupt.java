package com.proftelran.org.lessontwentyseven;

public class TestInterrupt extends Thread {

    @Override
    public void run() {
        System.out.println("Hello! I am thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            System.out.println("Hello! I am " + Thread.currentThread().getName());
        }
    }
}
