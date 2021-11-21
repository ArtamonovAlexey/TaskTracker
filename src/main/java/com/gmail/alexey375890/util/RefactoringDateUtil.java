package com.gmail.alexey375890.util;

import java.util.*;

public class RefactoringDateUtil {

    private static Calendar stringToCalendar(String string) {
        string = string.split(" ")[1];

        List<String> dateString = Arrays.asList(string.split("\\."));

        List<Integer> date = new ArrayList<>();

        dateString.forEach(d-> date.add(Integer.valueOf(d)));

        Calendar calendar = new GregorianCalendar(date.get(2), date.get(1) - 1, date.get(0));

        return calendar;
    }

    private static String calendarToString(Calendar calendar) {
        String hour = String.valueOf(calendar.get(Calendar.HOUR));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH));
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        return hour + ":" + minute + " " + day + "." + month + "." + year;
    }

    private static Calendar getNowDateAsCalendar() {
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        return calendar;
    }

    public static String getNowDateAsString() {
        Calendar calendar = getNowDateAsCalendar();

        return calendarToString(calendar);
    }

    public static boolean before(String string1, String string2) {
        Calendar calendar1 = stringToCalendar(string1);
        Calendar calendar2 = stringToCalendar(string2);

        return calendar1.before(calendar2);
    }

}
