package com.proftelran.org.lessonthirty.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {

        String[] personName = {"Alex", "Roman", "Alena", "Anna",
                "Leo", "Bob", "Maxim", "Stepan"};

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Funicular());

        for (String name : personName) {
            new Thread(new PeopleInFunicular(name, cyclicBarrier)).start();
            Thread.sleep(400);
        }


    }
}
