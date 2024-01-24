package com.proftelran.org.lessontwentynine;

public class Crossbow {

    private int arrows = 10;

    public synchronized void fire() {
        while (arrows >= 0) {
            if (arrows == 0) {
                System.out.println("The arrows is over");
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("We have " + (arrows));
            arrows--;
        }
    }

    public synchronized void reload() {
        while (true) {
            System.out.println("Reload/ new arrows on the way");
            arrows = 10;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Count arrows: " + arrows);
            notify();

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
