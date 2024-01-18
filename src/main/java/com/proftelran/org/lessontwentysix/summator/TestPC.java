package com.proftelran.org.lessontwentysix.summator;

public class TestPC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread start");
        new Thread(new ChildThread()).start();
        Thread.sleep(1000);
        System.out.println("Main thread stop");
    }
}
