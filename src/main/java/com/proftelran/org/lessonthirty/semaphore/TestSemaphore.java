package com.proftelran.org.lessonthirty.semaphore;

import com.proftelran.org.lessonthirty.semaphore.Person;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, true);

        //true - занято, false - свободно(столики)
        boolean[] freeTables = new boolean[5];

        String[] personName = {"Alex", "Roman", "Alena", "Anna", "Leo", "Bob", "Maxim"};

        Arrays.stream(personName).map(name -> new Person(name, semaphore, freeTables))
                .map(Thread::new)
                .forEach(thread -> {
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    thread.start();
                });
    }
}
