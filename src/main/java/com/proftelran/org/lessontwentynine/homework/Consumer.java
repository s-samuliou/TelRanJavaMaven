package com.proftelran.org.lessontwentynine.homework;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer extends Thread {

    private Storage storage;
    private AtomicInteger workerIndex;

    public Consumer(Storage storage, int workerIndex) {
        this.storage = storage;
        this.workerIndex = new AtomicInteger(workerIndex);
    }

    public int getWorkerIndex() {
        return workerIndex.get();
    }

    @Override
    public void run() {
        synchronized (storage) {

            int defaultIndex = workerIndex.get();

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                String good = storage.getGood(workerIndex.get());

                if (good == null) {
                    workerIndex.set(defaultIndex);

                    if (storage.getStorageSize() == 0) {
                        storage.notifyAll();
                    }

                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    workerIndex.set(workerIndex.get() + Startup.COUNT_OF_WORKERS);
                    System.out.println("Take good: " + good + " " + Thread.currentThread().getName());
                }
            }
        }
    }
}