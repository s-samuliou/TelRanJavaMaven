package com.proftelran.org.lessontwentynine.storagesystem;

public class StorageSystemApp {

    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
