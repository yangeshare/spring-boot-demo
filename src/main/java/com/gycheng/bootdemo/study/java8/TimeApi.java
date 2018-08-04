package com.gycheng.bootdemo.study.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Locale;
import java.util.Set;

public class TimeApi {

    public static void main(String[] args) {

        //TimeZones
//        testTimeZone();

        //LocalTime
        testLocalTime();

        //LocalDate
        testLocalDate();
    }

    private static void testLocalDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesteday = tomorrow.minusDays(2);
        System.out.println(yesteday);

        LocalDate independenceDay = LocalDate.of(2018, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

    }

    private static void testLocalTime() {
        ZoneId zoneId = ZoneId.of("Europe/Minsk");
        LocalTime time1 = LocalTime.now(zoneId);
        LocalTime time2 = LocalTime.now();
        long hours = ChronoUnit.HOURS.between(time1, time2);
        System.out.println(hours);

        LocalTime late = LocalTime.of(12, 16, 32);
        System.out.println(late);

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:22", dateTimeFormatter);
        System.out.println(leetTime);

    }

    private static void testTimeZone() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        ZoneId zoneId = ZoneId.of("Europe/Minsk");
        System.out.println(zoneId.getRules());
    }
}
