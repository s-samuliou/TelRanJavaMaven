package com.proftelran.org.lessonthirty.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(20);

        String[] personName = {"Alex", "Roman", "Alena", "Anna",
                "Leo", "Bob", "Maxim", "Stepan"};

        for (String name : personName) {
            new Thread(new PersonInAirport(name, countDownLatch)).start();
            Thread.sleep(700);
        }
    }
}
