package com.proftelran.org.lessontwentysix.summator;

public class TestSummarize {

    public static void main(String[] args) throws InterruptedException {
        int[] elements = {1,1,1,1,2,2,2,2,3,3,3,3}; //4, 8, 12 = 24

        SingleThreadSummator singleThread = new SingleThreadSummator(elements);
        singleThread.sum();

        MultiThreadSummator one = new MultiThreadSummator(elements, 0, 4);
        MultiThreadSummator two = new MultiThreadSummator(elements, 4, 8);
        MultiThreadSummator three = new MultiThreadSummator(elements, 8, 12);

        Thread thread1 = new Thread(one);
        Thread thread2 = new Thread(two);
        Thread thread3 = new Thread(three);

        long start = System.currentTimeMillis(); //Поток main
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Time is = " + (System.currentTimeMillis() - start)); //Поток main
    }
}
