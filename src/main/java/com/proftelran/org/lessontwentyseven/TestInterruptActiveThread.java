package com.proftelran.org.lessontwentyseven;

public class TestInterruptActiveThread {

    public static void main(String[] args) throws InterruptedException {
        ActiveThread activeThread = new ActiveThread();
        activeThread.start();

        Thread.sleep(5000);
        activeThread.interrupt();
    }
}
