package com.proftelran.org.lessontwentyfive;

import java.util.GregorianCalendar;

public class TestSelfWork {

    public static void main(String[] args) {
        boolean b = checkYear(2024);
        System.out.println("This year is leap: " + b);
    }

    private static boolean checkYear(int year) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        return gregorianCalendar.isLeapYear(year);
    }
}
