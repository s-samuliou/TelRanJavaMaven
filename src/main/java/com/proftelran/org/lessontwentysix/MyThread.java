package com.proftelran.org.lessontwentysix;

public class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread from runnable example " + Thread.currentThread().getName());
    }
}
