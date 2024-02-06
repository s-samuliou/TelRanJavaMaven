package com.proftelran.org.lessonthirty.homeworkthirty.semaphore;

import java.util.concurrent.Semaphore;

public class GasStation implements Runnable {

    private String carName;
    private Semaphore semaphore;
    private boolean[] patrolStations;

    public GasStation(String name, Semaphore semaphore, boolean[] petrolStations) {
        this.carName = name;
        this.semaphore = semaphore;
        this.patrolStations = petrolStations;
    }


    @Override
    public void run() {
        System.out.println("[->] Car: " + carName + " arrived to Gas Station");

        try {
            semaphore.acquire();

            int reservedPetrolStation = -1;

            synchronized (patrolStations) {
                for (int i = 0; i < patrolStations.length; i++) {
                    if (!patrolStations[i]) {
                        patrolStations[i] = true;
                        reservedPetrolStation = i;
                        System.out.println("[~] The car: " + carName + " started to refuel at the pump numbered: " + i);
                        break;
                    }
                }
            }

            Thread.sleep(5000);

            synchronized (patrolStations) {
                patrolStations[reservedPetrolStation] = false;
            }

            semaphore.release();

            synchronized (patrolStations) {
                System.out.println("[!] The car: " + carName + " refueled and left. The pump num: " + reservedPetrolStation + " is free");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
