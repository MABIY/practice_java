package chap12;

import java.time.*;
import java.util.TimeZone;

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
    }
}
