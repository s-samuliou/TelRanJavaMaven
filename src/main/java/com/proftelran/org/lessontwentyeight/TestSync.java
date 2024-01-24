package com.proftelran.org.lessontwentyeight;

public class TestSync {

    public static void main(String[] args) throws InterruptedException {
        SyncImpl sync = new SyncImpl();

        Thread threadOne = new Thread(sync);
        Thread threadTwo = new Thread(sync);

        threadOne.start();
        Thread.sleep(2000);
        System.out.println("State for two thread " + threadOne.getState());

        threadTwo.start();
        Thread.sleep(2000);
        System.out.println("State for two thread " + threadTwo.getState());
    }
}
