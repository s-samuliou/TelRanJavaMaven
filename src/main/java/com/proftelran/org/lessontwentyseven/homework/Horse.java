package com.proftelran.org.lessontwentyseven.homework;

import java.time.LocalTime;

public class Horse implements Runnable{

    private String name;
    private int step;
    private int position;

    public Horse(String name, int step) {
        this.name = name;
        this.step = step == 0 ? 1 : step;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void nextStep() {
        position += step;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            nextStep();

            if (position > HippodromeApp.LOOP_LENGTH) {
                HippodromeApp.RESULT_FINISH.put(name, LocalTime.now());
                break;
            }
        }
    }
}
