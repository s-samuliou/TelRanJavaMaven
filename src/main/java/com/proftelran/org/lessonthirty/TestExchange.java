package com.proftelran.org.lessonthirty;

import java.util.concurrent.Exchanger;

public class TestExchange {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        // A go to D
        String[] pOne = {"A->D", "A->C"};
        // B go to C
        String[] pTwo = {"B->C", "B->D"};

        new Thread(new Truck(1, pOne, exchanger)).start();

        Thread.sleep(200);

        new Thread(new Truck(2, pTwo, exchanger)).start();

    }
}
