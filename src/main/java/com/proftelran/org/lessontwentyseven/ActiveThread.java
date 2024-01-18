package com.proftelran.org.lessontwentyseven;

public class ActiveThread extends Thread{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            System.out.println("Is interrupt = " + Thread.currentThread().isInterrupted());

            int sum = 0;
            for (int i = 0; i < 1000000000l; i++) {
                sum += i;
            }
        }
    }
}
