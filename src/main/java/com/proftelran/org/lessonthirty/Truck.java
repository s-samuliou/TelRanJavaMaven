package com.proftelran.org.lessonthirty;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Truck implements Runnable {

    private int number;
    private String[] parcels;
    private Exchanger<String> exchanger;

    public Truck(int number, String[] parcels, Exchanger<String> exchanger) {
        this.number = number;
        this.parcels = parcels;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        Random random = new Random();

        System.out.println("Truck num:" + number + " parcels is: " + parcels[0] + "-" + parcels[1]);
        try {
            String exchange = exchanger.exchange(parcels[1]);
            parcels[1] = exchange;
            System.out.println("Truck num:" + number + " parcels is: " + parcels[0] + "-" + parcels[1]);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
