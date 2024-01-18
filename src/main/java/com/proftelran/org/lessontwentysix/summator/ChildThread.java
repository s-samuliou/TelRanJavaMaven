package com.proftelran.org.lessontwentysix.summator;

public class ChildThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Child thread start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Child thread stop");
    }
}
