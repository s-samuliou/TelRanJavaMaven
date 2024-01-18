package com.proftelran.org.lessontwentyseven;

public class TestInterruptApp {

    public static void main(String[] args) throws InterruptedException {
        TestInterrupt testInterrupt = new TestInterrupt();
        testInterrupt.start();

        Thread.sleep(7000);

        // interrupt - вызывает у потока InterruptedException, который находится в состоянии
        // сна или ожидания
        testInterrupt.interrupt();
        System.out.println("End of main thread");
    }
}
