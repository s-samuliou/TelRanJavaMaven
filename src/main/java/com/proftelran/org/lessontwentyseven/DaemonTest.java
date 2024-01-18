package com.proftelran.org.lessontwentyseven;

public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.setDaemon(true);
        test.start();
        
        Thread.sleep(5000);

        System.out.println("End of main thread");
    }
}
