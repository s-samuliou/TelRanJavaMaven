package com.proftelran.org.lessontwentysix;

public class OutputThread extends Thread{

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input word: ");
        }
    }
}
