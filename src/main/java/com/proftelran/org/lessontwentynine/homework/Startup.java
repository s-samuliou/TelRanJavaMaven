package com.proftelran.org.lessontwentynine.homework;

import java.util.Scanner;

public class Startup {

    public static int COUNT_OF_WORKERS;

    public void start() {
        System.out.print("Input num of storage length:");
        int storageLength = new Scanner(System.in).nextInt();

        System.out.print("Input count of workers:");
        COUNT_OF_WORKERS = new Scanner(System.in).nextInt();

        while (COUNT_OF_WORKERS > storageLength){
            System.out.print("Reenter the count of workers: ");
            COUNT_OF_WORKERS = new Scanner(System.in).nextInt();
        }

        Storage storage = new Storage(storageLength);

        Producer producer = new Producer(storage);
        producer.start();

        for (int i = 0; i < COUNT_OF_WORKERS; i++) {
            Consumer consumer = new Consumer(storage, i);
            Thread thread = new Thread(consumer);
            thread.setName("Worker" + (consumer.getWorkerIndex() + 1));
            thread.start();
        }
    }
}
