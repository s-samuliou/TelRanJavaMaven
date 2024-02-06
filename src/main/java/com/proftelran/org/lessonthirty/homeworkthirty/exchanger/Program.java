package com.proftelran.org.lessonthirty.homeworkthirty.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        String[][] chains = {
                {"A1", "A2"},
                {"B1", "B2"},
                {"C1", "C2"},
                {"D1", "D2"},
                {"E1", "E2"},
                {"F1", "F2"},
                {"G1", "G2"},
                {"H1", "H2"},
                {"I1", "I2"},
                {"J1", "J2"},
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < chains.length; i++) {
            Thread chainOne = new Thread(new Chain("" + i, chains[i], exchanger));
            addInterval(1000);

            executorService.submit(chainOne);
        }

        executorService.shutdown();
    }

    public static void addInterval(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
