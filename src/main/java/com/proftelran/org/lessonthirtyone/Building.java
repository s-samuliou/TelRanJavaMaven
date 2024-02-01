package com.proftelran.org.lessonthirtyone;

import java.util.concurrent.CountDownLatch;

public class Building implements Runnable {

    private String city;
    private CountDownLatch latch;
    private String[] stages;

    public Building(String city, CountDownLatch latch, String[] stages) {
        this.city = city;
        this.latch = latch;
        this.stages = stages;
    }

    @Override
    public void run() {
        for (int i = 0; i < stages.length; i++) {
            System.out.println("" + city + " : " + stages[i] + ", " +
                    Thread.currentThread().getName());

            latch.countDown();

            try {
                Thread.sleep((long) (Math.random() * 1500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
