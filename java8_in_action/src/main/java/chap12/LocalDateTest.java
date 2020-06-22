package chap12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author : lh
 * @since : 2020/6/21, Sun
 **/
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate today = LocalDate.now();
        int yearByEnum = date.get(ChronoField.YEAR);
        int monthByEnum = date.get(ChronoField.MONTH_OF_YEAR);
        int dayByEnum = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        LocalDate dateByParse = LocalDate.parse("2014-03-18");
        LocalTime timeByParse = LocalTime.parse("13:45:20");

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();

        Instant instant = Instant.ofEpochSecond(3);
        Instant instant1 = Instant.ofEpochSecond(3, 0);
        Instant instant2 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant3 = Instant.ofEpochSecond(4, 1_000_000_000);
        Instant instant4 = Instant.ofEpochMilli(3000);


        Duration d1 = Duration.between(time, time1);
        Duration d2 = Duration.between(dt1, dt2);
        Duration d3 = Duration.between(instant1, instant2);

        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));

        Duration threeMinutes = Duration.ofMinutes(3);
        threeMinutes = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        LocalDate date1_t = LocalDate.of(2014, 3, 18);
        LocalDate date2_t = date1_t.withYear(2011);
        LocalDate date3_t = date2_t.withDayOfMonth(25);
        LocalDate date4_t = date3_t.with(ChronoField.MONTH_OF_YEAR, 9);

        LocalDate date1_1 = LocalDate.of(2014, 3, 18);
        LocalDate date2_2 = date1_1.plusWeeks(1);
        LocalDate date3_3 = date2_2.minusYears(3);
        LocalDate date4_4 = date3_3.plus(6, ChronoUnit.MONTHS);

        LocalDate date_test = LocalDate.of(2014, 3, 18);
        date_test = date_test.with(ChronoField.MONTH_OF_YEAR, 9);
        date_test = date_test.plusYears(2).minusDays(10);
        date_test = date_test.withYear(2011);

        LocalDate date1_Ad = LocalDate.of(2014, 3, 18);
        LocalDate date2_Ad = date1_Ad.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3_Ad = date2_Ad.with(TemporalAdjusters.lastDayOfMonth());
    }
}
