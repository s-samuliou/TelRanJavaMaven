package com.proftelran.org.lessontwentyfive.homeworktwentyfive;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Startup {

    public static LocalDate BIRTHDAY_DATE = LocalDate.of(2002, 10, 10);

    public void start() {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
    }

    public void taskOne() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println(BIRTHDAY_DATE.format(dateTimeFormatter));
    }

    public void taskTwo() {
        System.out.println("It's friday? - " + (BIRTHDAY_DATE.getDayOfWeek()).equals(DayOfWeek.FRIDAY));
    }

    public void taskThree() {
        BIRTHDAY_DATE = BIRTHDAY_DATE.minusYears(10);
        System.out.println(BIRTHDAY_DATE);
    }

    public void taskFour() {
        Instant instant = Instant.parse("2022-12-19T06:55:30.00Z");
        System.out.println(instant);
    }

    public void taskFive() {
        ZoneId zoneId = ZoneId.of("Pacific/Midway");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println(zonedDateTime);
    }
}
