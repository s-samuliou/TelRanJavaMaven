package com.proftelran.org.lessontwentyfive;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class TestLocalDate {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        int year = date.getYear();
        Month month = date.getMonth();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeak = date.getDayOfWeek();
        System.out.println(" " + year + " " + month + " " + dayOfMonth + " " + dayOfWeak);

        LocalDate currentDate = LocalDate.of(2024, 1, 10);
        System.out.println(currentDate);
        System.out.println(currentDate.getMonth());

        currentDate = currentDate.plusYears(2);
        currentDate = currentDate.plusDays(10);
        currentDate = currentDate.plusMonths(1);
        System.out.println(currentDate);

        currentDate = currentDate.minusYears(5);
        currentDate = currentDate.minusDays(4);
        System.out.println(currentDate);
    }
}
