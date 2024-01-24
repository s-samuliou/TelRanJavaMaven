package com.proftelran.org.lessontwentynine.storagesystem;

public class Consumer  extends Thread {

    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        // Take ever 5 seconds one good from storage
        // while storage is not empty

        synchronized (storage) {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                String good = storage.getGood();

                if (good != null) {
                    System.out.println("Get good with name " + good);
                } else {
                    storage.notify();

                    System.out.println("Storage is empty");
                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
