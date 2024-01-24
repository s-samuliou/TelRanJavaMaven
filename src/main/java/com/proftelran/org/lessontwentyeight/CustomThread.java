package com.proftelran.org.lessontwentyeight;

import java.util.Objects;

public class CustomThread extends Thread{

    private Object monitor;

    public CustomThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println("I am " + Thread.currentThread().getName() + " captured monitor");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("I am " + Thread.currentThread().getName() + " released monitor");

        }
    }
}
