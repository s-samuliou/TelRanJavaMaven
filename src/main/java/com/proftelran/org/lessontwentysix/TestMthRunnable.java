package com.proftelran.org.lessontwentysix;

public class TestMthRunnable {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();

        Runnable runnable = () -> {
            System.out.println("Thread from runnable with lambda example " + Thread.currentThread().getName());
        };

        new Thread(runnable).start();
    }
}
