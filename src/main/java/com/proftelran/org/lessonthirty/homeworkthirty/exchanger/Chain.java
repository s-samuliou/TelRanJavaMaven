package com.proftelran.org.lessonthirty.homeworkthirty.exchanger;

import java.util.concurrent.Exchanger;

public class Chain implements Runnable {

    private String id;
    private String chains[];
    private Exchanger<String> exchanger;

    public Chain(String name, String[] array, Exchanger<String> exchanger) {
        this.id = name;
        this.chains = array;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        System.out.println("Before exchange in chain " + id + ": " + chains[0] + " -> " + chains[1]);
        addInterval(5000);

        try {
            String exchange = exchanger.exchange(chains[0]);
            chains[0] = exchange;

            System.out.println("After exchange in chain " + id + ": " + chains[0] + " -> " + chains[1]);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addInterval(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
