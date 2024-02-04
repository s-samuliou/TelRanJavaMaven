package com.proftelran.org.lessontwentyeight.homeworktwentyeight;

import com.proftelran.org.lessontwentyeight.homeworktwentyeight.enums.EventState;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EventCreator implements Runnable{

    AtomicInteger counter;
    private List<Event> eventList;
    private boolean isWorking;

    public EventCreator(List<Event> eventList) {
        this.eventList = eventList;
        this.isWorking = true;
        this.counter = new AtomicInteger(0);
    }

    @Override
    public void run() {
        while (isWorking) {
            addInterval(500);

            synchronized (eventList) {
                if (counter.get() % 3 == 0) {
                    eventList.add(new Event(counter.getAndIncrement(), "Name" + counter, "Ip:" + counter, LocalDate.now(), EventState.SUCCESS));
                } else if (counter.get() % 3 == 1) {
                    eventList.add(new Event(counter.getAndIncrement(), "Name" + counter, "Ip:" + counter, LocalDate.now(), EventState.REQUESTERROR));
                } else {
                    eventList.add(new Event(counter.getAndIncrement(), "Name" + counter, "Ip:" + counter, LocalDate.now(), EventState.ACCESSDENIED));
                }

                System.out.println(eventList.get(counter.get() - 1) + " - " + Thread.currentThread().getName());
            }
        }
    }

    public void stop() {
        isWorking = false;
    }

    private void addInterval(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
