package com.proftelran.org.lessontwentysix.summator;

public class SingleThreadSummator {
    private int[] array;

    public SingleThreadSummator(int[] array) {
        this.array = array;
    }

    public void sum() {
        int sum = 0;
        long start = System.currentTimeMillis();


        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Sum = " + sum);
        System.out.println("Time is = " + (System.currentTimeMillis()-start));
    }
}
