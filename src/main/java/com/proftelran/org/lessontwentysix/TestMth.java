package com.proftelran.org.lessontwentysix;

public class TestMth {

    public static void main(String[] args) {
        System.out.println("Thread from main thread = " +Thread.currentThread().getName());

        CustomThread customThread = new CustomThread();
        customThread.start();

        CustomThread customThread2 = new CustomThread();
        customThread2.start();
    }
}
