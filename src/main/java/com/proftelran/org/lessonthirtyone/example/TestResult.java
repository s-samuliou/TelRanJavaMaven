package com.proftelran.org.lessonthirtyone.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestResult {

    public static void main(String[] args) throws InterruptedException {
        List<Future<String>> resultList  = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 20; i++) {
            Future<String> submit = executorService.submit(new Result(i));
            resultList.add(submit);
        }

        Thread thread = new Thread(new ResultPrinter(resultList));
        thread.start();
        /*thread.join();*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input something: ");
        String s = scanner.nextLine();

        executorService.shutdown();

    }
}
