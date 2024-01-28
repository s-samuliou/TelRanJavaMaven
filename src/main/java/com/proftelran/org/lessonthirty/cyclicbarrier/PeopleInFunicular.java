package com.proftelran.org.lessonthirty.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PeopleInFunicular implements Runnable {

    private String name;
    private CyclicBarrier cyclicBarrier;

    public PeopleInFunicular(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("-> " + name + " ожидает на платформе");
            cyclicBarrier.await();
            System.out.println("<- " + name + " уже на вершине");

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
