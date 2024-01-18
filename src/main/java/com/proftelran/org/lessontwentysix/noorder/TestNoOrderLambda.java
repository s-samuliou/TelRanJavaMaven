package com.proftelran.org.lessontwentysix.noorder;

public class TestNoOrderLambda {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();

            for (int i = 0; i < 5; i++) {
                System.out.println("Thread name = " + name + " - " + i);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
