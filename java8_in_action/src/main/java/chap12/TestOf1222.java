package chap12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * @author : lh
 * @since : 2020/6/22, Mon
 **/
public class TestOf1222 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1_1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1_1.format(formatter);
        LocalDate date2_2 = LocalDate.parse(formattedDate, formatter);

        DateTimeFormatter itallanFormatter = DateTimeFormatter.ofPattern("d. MMM yyyy", Locale.ITALIAN);
        LocalDate date1_1_1 = LocalDate.of(2014, 3, 18);
        String formattedDate_1_1_1 = date1_1_1.format(itallanFormatter);
        LocalDate date2_2_2 = LocalDate.parse(formattedDate_1_1_1, itallanFormatter);

        DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
    }
}
