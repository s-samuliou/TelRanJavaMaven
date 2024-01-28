package com.proftelran.org.lessontwentynine.homework;

public class Producer extends Thread{

    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        synchronized (storage) {
            int count = 0;

            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                String good = "A" + ++count;
                boolean result = storage.putGood(good);

                if (!result) {
                    storage.notifyAll();

                    if (storage.getStorageSize() > 0) {
                        try {
                            storage.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    System.out.println("Put into storage: " + good);
                }
            }
        }
    }
}