package com.proftelran.org.lessontwentynine.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private List<String> storage;
    private AtomicInteger index;
    private int storageSize;

    public Storage(int storageLength) {
        this.storage = new ArrayList<>();
        this.index = new AtomicInteger(0);
        this.storageSize = storageLength;
    }

    public int getStorageSize() {
        return index.get();
    }

    public boolean putGood(String good) {
        if (this.index.get() == this.storageSize) {
            System.out.println("All cells are full!");
            return false;
        }

        this.storage.add(this.index.getAndIncrement(), good);

        return true;
    }

    public String getGood(int workerIndex) {
        if (this.index.get() == 0) {
            System.out.println("All cells are empty!");
            return null;
        }

        if (workerIndex >= this.storageSize) {
            return null;
        }

        String good = this.storage.get(workerIndex);
        this.index.getAndDecrement();
        this.storage.set(workerIndex, null);

        return good;
    }
}