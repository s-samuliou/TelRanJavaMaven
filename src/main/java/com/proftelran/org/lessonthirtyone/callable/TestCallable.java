package com.proftelran.org.lessonthirtyone.callable;

import java.util.concurrent.*;

public class TestCallable {

    public static void main(String[] args) {
        StringGenerator stringGenerator = new StringGenerator();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Start threads");
        Future<String> result = executorService.submit(stringGenerator);

        System.out.println("Submit thread");

        /*int count = 0;

        while (!result.isDone()) {
            System.out.println("Attempt " + count++);
            Thread.sleep(1000);
        }*/

        String s = null;
        try {
            s = result.get(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(s);

        System.out.println("End thread");

        executorService.shutdown();
    }
}
