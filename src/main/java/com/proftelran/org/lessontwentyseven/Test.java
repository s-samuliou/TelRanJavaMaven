package com.proftelran.org.lessontwentyseven;

public class Test extends Thread{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        boolean isDaemon = Thread.currentThread().isDaemon();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isDaemon) {
                System.out.println("I am daemon thread " + name);
            } else {
                System.out.println("I am work thread " + name);
            }
        }
    }
}
