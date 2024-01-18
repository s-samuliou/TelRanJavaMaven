package com.proftelran.org.lessontwentyseven;

public class TestLifeCycle {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(runnable);
        System.out.println("Thread created = " + thread.getState());

        thread.start();
        System.out.println("Thread started= " + thread.getState());

        Thread.sleep(1000);
        System.out.println("Thread sleep = " + thread.getState());

        Thread.sleep(7000);
        System.out.println("Thread end work = " + thread.getState());


    }
}
