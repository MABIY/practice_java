package practice.chap12;

import org.omg.PortableInterceptor.INACTIVE;

import javax.management.InstanceNotFoundException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;

/**
 * @author lh
 */
public class NextWorkingDay implements TemporalAdjuster {
    public static NextWorkingDay test = new NextWorkingDay();

    public static void main(String[] args) {
        {
            LocalDate date = LocalDate.of(2014, 3, 18);
            String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
            String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
            System.out.println(s1);
            System.out.println(s2);

            LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
            LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
            System.out.println();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date11 = LocalDate.of(2014, 3, 18);
            String formattedDate = date11.format(formatter);
            LocalDate date22 = LocalDate.parse(formattedDate, formatter);
            System.out.println();

            DateTimeFormatter italianFomatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
            formattedDate = date.format(italianFomatter);
            System.out.println(formattedDate);
        }

        {
            ZoneId romeZone = ZoneId.of("Europe/Rome");
            LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
            ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

            LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
            ZonedDateTime zdt2 = dateTime.atZone(romeZone);

            Instant instant = Instant.now();
            ZonedDateTime zdt3 = instant.atZone(romeZone);
            System.out.println();
        }

        {
            ZoneId romeZone = ZoneId.of("Europe/Rome");
            LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
            Instant instantFromDateTime = dateTime.atZone(romeZone).toInstant();

            Instant instant = Instant.now();
            LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);
        }

        {
            ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
            LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
            OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime, newYorkOffset);
        }
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        }
        if (dow == DayOfWeek.SATURDAY) {
            dayToAdd = 2;
        }
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }
}
