package com.proftelran.org.lessonthirtyone.example;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ResultPrinter implements Runnable{

    private List<Future<String>> resultList;

    public ResultPrinter(List<Future<String>> resultList) {
        this.resultList = resultList;
    }

    @Override
    public void run() {
        boolean allDone = false;

        while (!allDone) {
            allDone = true;

            for (Future<String> result : resultList) {
                if (!result.isDone()) {
                    allDone = false;
                }
            }
        }

        resultList.forEach(result -> {
            try {
                System.out.println("Result is: " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
