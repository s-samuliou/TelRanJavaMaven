package com.proftelran.org.lessonthirty.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class PersonInAirport implements  Runnable{

    private String name;
    private CountDownLatch countDownLatch;

    public PersonInAirport(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("-> " + name + " приехал в аэропорт");
        System.out.println("[!] " + name + " зарегистрировался");
        System.out.println("[!] " + name + " перекусил");

        countDownLatch.countDown();

        try {
            countDownLatch.await(10, TimeUnit.SECONDS);

            System.out.println("-> " + name + " вылетел на отдых");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
