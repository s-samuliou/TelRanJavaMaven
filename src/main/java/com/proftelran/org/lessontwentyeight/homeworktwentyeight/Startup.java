package com.proftelran.org.lessontwentyeight.homeworktwentyeight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Startup {

    private int COUNT_OF_USERS = 10;
    private int COUNT_OF_FEL = 4;
    private long EVENT_CREATOR_WORKING_TIME = 500;

    public void start() {
        List<Event> eventList = new ArrayList<>();
        List<String> logList = new ArrayList<>();

        EventCreator eventCreator = new EventCreator(eventList);

        createUserEvents(eventCreator, EVENT_CREATOR_WORKING_TIME);
        createUserLogs(eventList, logList);

        Runnable showLogs = () -> logList.forEach(System.out::println);
        new Thread(showLogs).start();
    }

    private void createUserLogs(List<Event> eventList, List<String> logList) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_OF_FEL);

        for (int i = 0; i < COUNT_OF_FEL; i++) {
            executorService.execute(new FirewallEventListener(eventList, logList));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void createUserEvents(EventCreator eventCreator, long timeSignalToStop) {
        ExecutorService userExecutor = Executors.newFixedThreadPool(COUNT_OF_USERS);

        for (int i = 0; i < COUNT_OF_USERS; i++) {
            userExecutor.execute(new Thread(eventCreator));
        }

        try {
            Thread.sleep(timeSignalToStop);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        eventCreator.stop(); //Signal to stop

        userExecutor.shutdown();

        try {
            userExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
