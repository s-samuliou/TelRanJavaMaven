package com.proftelran.org.lessontwentyeight;

public class SyncImpl implements Runnable{

    @Override
    public void run() {
        synchronized (this) {
            try {
                System.out.println("I am: " + Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
