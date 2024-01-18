package com.proftelran.org.lessontwentysix;

import java.util.Scanner;

public class TestIO {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Input word: ");
            String next = scanner.next();
            System.out.println(next);
        }*/

        InputThread inputThread = new InputThread();
        OutputThread outputThread = new OutputThread();

        inputThread.start();
        outputThread.start();
    }
}
