package chap12;

import java.time.*;
import java.time.chrono.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * @author : lh
 * @since : 2020/6/22, Mon
 **/
public class ZoneTest {
    public static void main(String[] args) {
//        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        Instant instant = Instant.now();
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone); // why add 2 hours

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        Instant instantFromDateTime = dateTime.atZone(romeZone).toInstant();

        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        LocalDateTime dateTime_ = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime dateTimeINNewYork = OffsetDateTime.of(dateTime_, newYorkOffset);
        System.out.println(dateTimeINNewYork);

        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        JapaneseDate japaneseDate = JapaneseDate.from(date);

        Chronology japaneseCHronology = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate now = japaneseCHronology.dateNow();

        HijrahDate ramadanDate = HijrahDate.now()
                .with(ChronoField.DAY_OF_MONTH, 1)
                .with(ChronoField.MONTH_OF_YEAR, 9);

        System.out.println("Ramadan starts on " +
                IsoChronology.INSTANCE.date(ramadanDate) +
                " and ends on " +
                IsoChronology.INSTANCE.date(
                        ramadanDate.with(
                                TemporalAdjusters.lastDayOfMonth()
                        )
                ));
    }
}
