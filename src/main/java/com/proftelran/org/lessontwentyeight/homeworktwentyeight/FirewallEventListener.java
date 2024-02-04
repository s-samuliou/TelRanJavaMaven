package com.proftelran.org.lessontwentyeight.homeworktwentyeight;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FirewallEventListener implements Runnable{

    private List<Event> eventList;
    private List<String> logList;
    private static AtomicInteger currentEventIndex = new AtomicInteger(0);

    public FirewallEventListener(List<Event> eventList, List<String> logList) {
        this.eventList = eventList;
        this.logList = logList;
    }

    @Override
    public void run() {
        while (true) {
            Event event;

            synchronized (eventList) {
                if (currentEventIndex.get() >= eventList.size()) {
                    break;
                }

                event = eventList.get(currentEventIndex.getAndIncrement());
            }

            synchronized (logList) {
                addLog(event);
            }
        }
    }

    private void addLog(Event event) {
        logList.add("\nОбработчик " + Thread.currentThread().getName() + " - " + event.getEventId() + " - " + event.getUserName());
        addInterval(1);

        logList.add("Обработчик " + Thread.currentThread().getName() + " - " + event.getEventId() + " - " + event.getUserIp());
        addInterval(1);

        logList.add("Обработчик " + Thread.currentThread().getName() + " - " + event.getEventId() + " - " + event.getEventDate());
        addInterval(1);

        logList.add("Обработчик " + Thread.currentThread().getName() + " - " + event.getEventId() + " - " + event.getEventState());
        addInterval(1);
    }

    private void addInterval(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
