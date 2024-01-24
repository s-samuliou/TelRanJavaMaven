package com.proftelran.org.lessontwentynine.storagesystem;

public class Storage {

    private String[] cells;
    private int currentIndex;

    public Storage() {
        this.cells = new String[10];
        this.currentIndex = 0;
    }

    public boolean putGood(String good) {
        if (currentIndex == cells.length) {
            System.out.println("Storage is full!");
            currentIndex = 0;
            return false;
        }

        cells[currentIndex] = good;
        currentIndex++;

        return true;
    }

    public String getGood() {
        if (currentIndex == cells.length) {
            System.out.println("Storage is empty!");
            currentIndex = 0;
            return null;
        }

        String good = cells[currentIndex];
        cells[currentIndex] = null;
        currentIndex++;
        return good;
    }
}
