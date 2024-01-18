package com.proftelran.org.lessontwentysix.noorder;

public class TestNoOrder {

    public static void main(String[] args) {
        Printer one = new Printer();
        Printer two = new Printer();
        Printer three = new Printer();

        new Thread(one).start();
        new Thread(two).start();
        new Thread(three).start();
    }
}
