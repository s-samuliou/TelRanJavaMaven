package com.proftelran.org.lessontwentyseven.example;

public class ConsoleWriterThread implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello I am console writer thread " + Thread.currentThread().getName());

            if (Thread.currentThread().isInterrupted()) {
                //System.out.println("State " + Thread.currentThread().getState());
                System.out.println("Catch from active stage in thread " + Thread.currentThread().getName());
                break;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //System.out.println("State " + Thread.currentThread().getState());
                System.out.println("catch interrupted exception in thread " + Thread.currentThread().getName());
                break;
            }
        }
    }
}
