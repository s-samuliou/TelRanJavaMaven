package com.proftelran.org.lessontwentynine.storagesystem;

public class Producer extends Thread {

    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        // put 1 good into storage per 1 second
        // while storage is not full
        int count = 0;

        synchronized (storage) {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                String good = "A" + ++count;
                boolean result = storage.putGood(good);

                if (!result) {
                    storage.notify();

                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Put good " + good + " into storage");
                }
            }
        }
    }
}
