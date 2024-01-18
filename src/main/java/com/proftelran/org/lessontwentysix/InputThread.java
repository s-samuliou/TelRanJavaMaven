package com.proftelran.org.lessontwentysix;

import java.util.Scanner;

public class InputThread extends Thread{

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String next = scanner.next();
            System.out.println(next);
        }
    }
}
