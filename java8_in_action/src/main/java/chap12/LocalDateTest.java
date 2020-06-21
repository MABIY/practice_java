package chap12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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
    }
}
