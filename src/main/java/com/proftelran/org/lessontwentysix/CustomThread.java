package com.proftelran.org.lessontwentysix;

public class CustomThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread from custom thread = " + Thread.currentThread().getName());
    }
}
