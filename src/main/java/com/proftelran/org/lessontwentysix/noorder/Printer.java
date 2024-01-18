package com.proftelran.org.lessontwentysix.noorder;

public class Printer implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name = " + name + " - " + i);
        }
    }
}
