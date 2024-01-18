package com.proftelran.org.lessontwentyfive;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        GregorianCalendar gregorianCalendar = new GregorianCalendar(2024, Calendar.JANUARY, 10);
        System.out.println(gregorianCalendar);

        int month = calendar.get(Calendar.MONTH);
        System.out.println("Month is " + month);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String format = simpleDateFormat.format(new Date());
        System.out.println("Formatted date is " + format);

        calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(calendar.getTime());
        System.out.println("Formatted date from calendar is " + formattedDate);
    }
}
