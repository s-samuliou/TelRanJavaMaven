package com.proftelran.org.lessontwentyseven.example;

import java.util.Random;

public class ConsoleWriterApp {

    public static void main(String[] args) throws InterruptedException {
        ConsoleWriterThread consoleWriterThread = new ConsoleWriterThread();
        Thread thread = new Thread(consoleWriterThread);
        thread.start();

        Random random = new Random();
        Thread.sleep(random.nextInt(5) * 1000);
        System.out.println("State " + thread.getState());
        thread.interrupt();
    }
}
