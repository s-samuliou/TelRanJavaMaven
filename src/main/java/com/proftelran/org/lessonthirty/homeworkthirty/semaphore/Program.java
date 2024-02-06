package com.proftelran.org.lessonthirty.homeworkthirty.semaphore;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    private static final int COUNT_OF_PETROL_STATIONS = 4;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(COUNT_OF_PETROL_STATIONS, true);
        boolean[] freePetrolStations = new boolean[COUNT_OF_PETROL_STATIONS];
        AtomicBoolean isWorking = new AtomicBoolean(true);
        AtomicInteger counter = new AtomicInteger(0);

        // Set time limits
        LocalDateTime startTime = LocalDateTime.now();
        int minutesToWork = 1;
        LocalDateTime endTime = startTime.plus(minutesToWork, ChronoUnit.MINUTES);

        // Start timer
        timeSignalStop(isWorking, endTime);

        while (isWorking.get()) {
            GasStation gasStation = new GasStation("Car" + counter.getAndIncrement(), semaphore, freePetrolStations);

            new Thread(gasStation).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void timeSignalStop(AtomicBoolean isWorking, LocalDateTime endTime) {
        Runnable runnable = () -> {
            try {
                while (LocalDateTime.now().isBefore(endTime)) {
                    Thread.sleep(1000);
                }

                System.out.println("End time: " + endTime);
                isWorking.set(false);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(runnable).start();
    }
}
