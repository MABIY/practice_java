package practice.chap12;

import chap12.LocalDateTest;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author lh
 */
public class DateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate now = LocalDate.now();

        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime.of(13, 35);
        LocalTime time = LocalTime.of(13, 35, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDate dateParseValue = LocalDate.parse("2014-03-18");
        LocalTime timeParseValue = LocalTime.parse("13:45:20");

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();

        Instant.ofEpochMilli(3);
        Instant instant1 = Instant.ofEpochSecond(3, 0);
        Instant instant2 = Instant.ofEpochSecond(3, 1_000_000_000);
        Instant instant3 = Instant.ofEpochSecond(4, -1000_000_000);
        // Instant.now().get(ChronoField.DAY_OF_MONTH); unsupport
        // Duration d1 = Duration.between(date, LocalDate.of(2017, 11, 11)); unsupport
        Duration d2 = Duration.between(time, time1);
        Duration d3 = Duration.between(dt1, dt2);
        Duration d4 = Duration.between(instant1, instant2);

        Period tenDay = Period.between(date, date1);

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        LocalDate date_1 = LocalDate.of(2014, 3, 18);
        LocalDate date_2 = date_1.withYear(2011);
        LocalDate data_3 = date_2.withDayOfMonth(25);
        LocalDate data_4 = data_3.with(ChronoField.MONTH_OF_YEAR, 9);

        LocalDate date_1_1 = LocalDate.of(2014, 3, 18);
        LocalDate date_2_2 = date_1_1.plusWeeks(1);
        LocalDate date_3_3 = date_2_2.minusYears(3);
        LocalDate date_4_4 = date_3_3.plus(6, ChronoUnit.MONTHS);
        data_3.minus(6, ChronoUnit.MONTHS);

        LocalDate date_11 = LocalDate.of(2014,3, 18);
        date_11 = date_11.with(ChronoField.MONTH_OF_YEAR, 9);
        date_11 = date_11.plusYears(2).minusDays(10);
        date_11.withYear(2011);

        LocalDate date1_ = LocalDate.of(2014, 3, 18);
        LocalDate date2_ = date1_.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        System.out.println();
    }
}
