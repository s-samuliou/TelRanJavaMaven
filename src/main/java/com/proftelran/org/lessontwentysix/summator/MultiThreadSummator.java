package com.proftelran.org.lessontwentysix.summator;

public class MultiThreadSummator implements Runnable {

    private int[] array;

    private int startIndex;

    private int endIndex;

    public MultiThreadSummator(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        sum();
    }

    public void sum() {
        int sum = 0;

        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Sum = " + sum);
    }
}
