package com.proftelran.org.lessonthirtyone.example;

import com.proftelran.org.lessonthirtyone.Building;

import java.util.concurrent.*;

public class TestThreadShuduledExecutor {

    public static void main(String[] args) throws InterruptedException {
        String[] stages = {"1. Project", "2. Start", "3. Finish", "4. Final"};

        CountDownLatch cd1 = new CountDownLatch(stages.length);
        CountDownLatch cd2 = new CountDownLatch(stages.length);
        CountDownLatch cd3 = new CountDownLatch(stages.length);
        CountDownLatch cd4 = new CountDownLatch(stages.length);

        System.out.println("Start threads");

        //ExecutorService executorService = Executors.newFixedThreadPool(2);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        Building dusseldorf = new Building("Dusseldorf", cd1, stages);

        executorService.schedule(dusseldorf, 3, TimeUnit.SECONDS);
        executorService.schedule(new Building("Cologne", cd2, stages), 7, TimeUnit.SECONDS);
        executorService.schedule(new Building("Dortmund", cd3, stages), 4, TimeUnit.SECONDS);
        executorService.schedule(new Building("Essen", cd4, stages), 2, TimeUnit.SECONDS);

        cd1.await();
        cd2.await();
        cd3.await();
        cd4.await();

        System.out.println("End threads");

        executorService.shutdown();
    }
}
