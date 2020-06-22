package chap12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

/**
 * @author : lh
 * @since : 2020/6/22, Mon
 **/
public class NextWorkingDay implements TemporalAdjuster {

    public static TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
            temporal -> {
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
    );

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        } else if (dow == DayOfWeek.SUNDAY) {
            dayToAdd = 2;
        }

        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }

    public static Temporal staticAdjustInto(Temporal temporal) {
        return new NextWorkingDay().adjustInto(temporal);
    }

    public static void main(String[] args) {
        Temporal date = LocalDate.of(2014, 3, 14);
        date = date.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            } else if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });

    }

    public void test() {
        Temporal date = LocalDate.of(2014, 3, 14);
        date.with(NextWorkingDay::staticAdjustInto);
    }
}
