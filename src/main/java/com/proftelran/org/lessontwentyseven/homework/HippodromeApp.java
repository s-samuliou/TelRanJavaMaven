package com.proftelran.org.lessontwentyseven.homework;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;;

public class HippodromeApp {

    public static final int LOOP_LENGTH = 1000;
    public static Map<String, LocalTime> RESULT_FINISH = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Random random = new Random();
        List<Horse> horses = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            horses.add(new Horse("a" + i, random.nextInt(5)));
        }

        horses.stream().map(Thread::new)
                .toList()
                .forEach(Thread::start);

        Runnable resultPrinter = () -> {
            while (true) {
                if (RESULT_FINISH.entrySet().size() == horses.size()) {
                    RESULT_FINISH.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue())
                            .map(entry -> "Horse - " + entry.getKey() + " Position - " + entry.getValue())
                            .toList()
                            .forEach(System.out::println);

                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread daemonThread = new Thread(resultPrinter);
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            daemonThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
