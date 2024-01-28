package com.proftelran.org.lessonthirty.cyclicbarrier;

public class Funicular implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Фуникулёр взял несколько человек и поднимает их на гору");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
