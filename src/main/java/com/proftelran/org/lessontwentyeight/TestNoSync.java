package com.proftelran.org.lessontwentyeight;

public class TestNoSync {

    private static int counter = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                counter = 0;

                for (int i = 0; i < 5; i++) {
                    counter += 1;
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                }
            }
        };

        Thread threadOne = new Thread(runnable);
        Thread threadTwo = new Thread(runnable);

        threadOne.start();
        threadTwo.start();

    }
}
