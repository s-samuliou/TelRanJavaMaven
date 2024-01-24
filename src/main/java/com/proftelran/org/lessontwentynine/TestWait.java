package com.proftelran.org.lessontwentynine;

public class TestWait {

    public static void main(String[] args) {
        Crossbow crossbow = new Crossbow();

        new Thread(crossbow::fire).start();
        new Thread(crossbow::reload).start();
    }
}
