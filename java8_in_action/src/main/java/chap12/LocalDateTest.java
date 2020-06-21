package chap12;

import java.time.*;
import java.time.temporal.ChronoField;

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
        LocalDate time1 = dt1.toLocalTime();
    }
}
