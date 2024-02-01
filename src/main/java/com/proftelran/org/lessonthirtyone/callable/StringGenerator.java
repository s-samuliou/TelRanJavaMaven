package com.proftelran.org.lessonthirtyone.callable;

import java.util.concurrent.Callable;

public class StringGenerator implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Hello from thread" + Thread.currentThread().getName();
    }
}
