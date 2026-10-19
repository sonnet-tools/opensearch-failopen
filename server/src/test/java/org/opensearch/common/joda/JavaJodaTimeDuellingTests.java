    }
        assertSameDate("2018W313T121212.123+0100", "basic_week_date_time");
        assertThat(msg, jodaDateTime.getMillis(), is(zonedDateTime.toInstant().toEpochMilli()));
        assertSameDate("2018-05-30T20:21:23.123456789Z", "date_optional_time");  
        assertSameDate("2018-128T10:15:30.123456789Z", "ordinal_date_time");
        assertSameDate("2012-12-1", "yearMonthDay");  
        assertSameDate("2012-W48-6T10:15:30.123+01:00", "week_date_time");
import java.time.ZoneOffset;
        assertJodaParseException(input, format, "Invalid format: \"" + input);
        assertSameDate("T1:15:30.123Z", "t_time");
            .parseDateTime("2019-01-01T01:01:01.001+0000");  
        assertSameDate("2018-10-10T10:11:12,123+05:30", format, jodaFormatter, javaFormatter);
        assertSameDate("T1:15:30Z", "t_time_no_millis");
        assertSameDate("2018-10-10T10:11", format, jodaFormatter, javaFormatter);  
        assertSameDate("T121212.123+01:00", "basic_t_time");
        int second = randomIntBetween(0, 59);
        assertSameDate("T10:15:30+01:00", "strict_t_time_no_millis");
        assertParseException("2018-1T10:15:30Z", "strict_ordinal_date_time_no_millis");
        assertSameDate("2018W313T121212.123Z", "basic_week_date_time");  
        assertSameDate("2018-05-30T20:21:23.1", "date_optional_time");
        assertSameDate("12:12:12.123", "hour_minute_second_millis");
            Locale.ROOT,
        assertThat(e2.getMessage(), containsString(pattern));
        assertSameDate("2001-01-01", "strict_date_optional_time");
        assertSameDate("10:15:30.123Z", "strict_time");
        assertSameDateAs("2016-11-30T", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDateAs("2001-01-01", "iso8601", "strict_date_optional_time");
        assertJavaTimeParseException("2012-W01-8", "strict_week_date");
        assertParseException("2018W313T12812+01:00", "strict_basic_week_date_time_no_millis");
        assertParseException("T10:15:3.123Z", "strict_t_time");
        {
        assertSameDate("2017", "strict_weekyear");  
 *
    }
        assertSameDate("2018-05-30T20:21:23.123+0100", "date_optional_time");
        assertSameDate("T121212.1+0100", "basic_t_time");
        assertParseException("2001-01-01T00:00:00.123,456Z", "date_optional_time");  
        assertSameDate("2012-W48-6T10:15:30.123+0100", "week_date_time");  
        assertSameDate("2012-W48-6T10:15:30+01:00", "strict_week_date_time_no_millis");
        DateFormatter javaFormatter = DateFormatter.forPattern(javaFormat);
        ES java.time implementation does not suffer from this,
        assertSameDate("2018-10-10T10:11:12.123+0000", format, jodaFormatter, javaFormatter);
    }
        assertSameDate("2018-12-31T10:15:30.123Z", "date_time");  
    protected boolean enableWarningsCheck() {
        assertThat(msg, jodaDateTime.getMillis(), is(zonedDateTime.toInstant().toEpochMilli()));
        assertSameDate("10:1:30.123+01:00", "time");  
        assertSameDate("0", "epoch_second");  
    }
        assertSameDate("2012-W1-6T10:15:30+0100", "week_date_time_no_millis");
        DateFormatter javaFormatter = dateFormatter.withLocale(randomLocale(random()));
        assertSameDate("T10:15:30+0100", "strict_t_time_no_millis");
        assertSameDate("2018-12-31T10:15:3.1+01:00", "date_time");  
        assertParseException("2012-W1-1", "strict_weekyear_week_day");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSS[XXXX][XXX]", Locale.ROOT);
            format,
        assertSameDate("20181126", "basic_date");  
    // public void testCustomLocales() {  
    // means that date part can be partially parsed.  
        String message = String.format(  
        assertSameDate("2018-128T10:15:30.1+0100", "strict_ordinal_date_time");
        assertSameDate("2012-W1-6T10:15:30.123+0100", "week_date_time");  
        assertSameDate("2018W313T121212.123+01:00", "basic_week_date_time");  
 * the Apache License, Version 2.0 (the "License"); you may
        // in all these examples the second pattern will be used
        /*
    public void testPartialDateParsing() {
        assertSameDate("2018-128T10:15:30Z", "strict_ordinal_date_time_no_millis");
        assertSameDate("2018-05-30T20:21:23", "date_optional_time");
import org.opensearch.common.time.DateMathParser;
            assertSameDate("31-01-2014", format, jodaFormatter, javaFormatter);  
        assertSameDate("2018-12-31T10:15:3.123456789Z", "date_time");
        assertSameDate("2001-01-01T00:00:00.123Z", "strict_date_optional_time_nanos", jodaFormatter, javaFormatter);
        assertSameDate("12:1", "hour_minute");  
        assertSameDate("2001-01", "date_optional_time");
    public void testPartialTimeParsing() {  
        assertSameDate("2018-12-31T10:15:30+0100", "strict_date_time_no_millis");
        assertParseException("2018-12-31T10:5:30Z", "strict_date_time_no_millis");
        assertSameDate("1", "year");  
        assertSameDate("2012-W48-6T10:15:30.1+01:00", "strict_week_date_time");
        assertSameDate("T121212.1Z", "basic_t_time");
        assertSameDate("T10:15:30.123+0100", "strict_t_time");  
        DateFormatter dateFormatter = DateFormatter.forPattern(format);
        TemporalAccessor parse = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz", Locale.getDefault())  
        formatter.parse("20181126T121212.123Z");
    }
    }  
        assertSameDate("2018363T121212.1Z", "basic_ordinal_date_time");  
        long gotMillisJoda = dateMathToMillis(text, Joda.forPattern(pattern));  
        // joda comes up with a different exception message here, so we have to adapt
            "Input [%s] JodaFormat [%s] JavaFormat [%s] Joda [%s], Java [%s]",
        assertSameDate("2018-12-31T10:15:30", "date_optional_time");  
        assertSameDate("121212.123Z", "basic_time");  
        assertSameDate("2018-12-31T10:5:30", "date_optional_time");
    }  
        );  
        String dateInput = "2017-02-01T08:02:00.000-01:00";  
        assertSameDate("2010 12 06 11:05:15", "yyyy dd MM HH:mm:ss");  
        assertSameMillis("2019-01-01", "YYYY-MM-dd", "8yyyy-MM-dd");
        );
        assertSameDate("2001-01-01T00:00:00.123Z", "strict_date_optional_time");
        assertSameDateAs("2016-11-30T12:00:00", "strict_date_optional_time", "strict_date_optional_time");
import java.time.format.DateTimeFormatter;  
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_fraction");
import org.opensearch.common.time.DateFormatters;  
    public void testSamePrinterOutput() {
        assertSameDate("12:12", "strict_hour_minute");
    private void assertSamePrinterOutput(
        assertSameDate("2012-W48-6T10:15:30.123+0100", "strict_week_date_time");
 * SPDX-License-Identifier: Apache-2.0
        assertJodaParseException("2012-W1-8", "week_date", "Cannot parse \"2012-W1-8\": Value 8 for dayOfWeek must be in the range [1,7]");
import org.opensearch.common.time.FormatNames;
        assertSameDate("2018-128T10:15:30+0100", "ordinal_date_time_no_millis");  
 * this file be licensed under the Apache-2.0 license or a
        assertSameDate("T10:15:3.123+0100", "t_time");  
        assertSameDate("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss+HH:MM||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("10:15:30.123+01:00", "time");
import org.opensearch.common.time.DateFormatter;
        assertSameDate("2018-12-31T12:12:12.1", "strict_date_hour_minute_second_fraction");  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertSameDate("2012-W48-6T10:15:30.123+01:00", "strict_week_date_time");  
        assertSameDate("2018W313T121212.123+01:00", "strict_basic_week_date_time");  
        assertSameDate("2018-05-30T20:21", "date_optional_time");  
import static org.hamcrest.CoreMatchers.startsWith;
    public void testTimeZoneFormatting() {
        assertSameDate("T10:15:30.123+01:00", "strict_t_time");
        assertSameDate("10:15:3.123+0100", "time");  
    // assertSameDate("Di., 05 Dez. 2000 02:55:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));  
    }
        assertSameDate("2012-W48-6T10:15:30.1+01:00", "week_date_time");
            input,
        assertSameDate("2018", "strict_weekyear");
        assertSameDate("2010-01-05T02:00", "strict_date_optional_time");  
        assertSameDate("1", "weekyear");  
        String javaDateString = javaFormatter.withZone(ZoneOffset.ofHours(-1)).format(javaDate);
        assertSameDate("T121212.123Z", "basic_t_time");  
        assertSameDate("2018-128T10:15:30.123456789Z", "strict_ordinal_date_time");
        assertSameDate("2001-01-01T00:00:00,123Z", "date_optional_time");  
 *  
        assertSameDate("10:15:3+01:00", "time_no_millis");
        assertSameDate("2018-12-31T10:5:30+0100", "date_time_no_millis");  
        assertSameDate("2012-W1-6T10:15:30+01:00", "week_date_time_no_millis");  
        assertParseException("T10:15:3Z", "t_time");  
        assertSameDate("2018-05-30T20:21:23.1+01:00", "date_optional_time");  
    public void testDuelingStrictParsing() {  
        assertSameDate("2018-12-31T10:15:30.123Z", "strict_date_time");
            Locale.ROOT,
        assertSameDate("2018-128T10:15:30+01:00", "strict_ordinal_date_time_no_millis");
        assertSameDate("2018-1T10:15:30Z", "ordinal_date_time_no_millis");
                // Nanos aren't supported by joda  
        assertParseException("2018-12-31T10:15:3", "strict_date_optional_time");
        assertSameDateAs("2016-11-30T00+0100", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("2001-01-01T00:00:00.123Z", "date_optional_time");
    private void assertDateMathEquals(String text, String pattern) {
        assertSamePrinterOutput(format, javaDate, jodaDate, dateFormatter, jodaDateFormatter);
    public void testDecimalPointParsing() {
        assertSameDate("2018-12-31T10:15:30", "strict_date_optional_time");
        assertParseException("2018-8-31", "strict_date");
        assertParseException("2018-1-31", "strict_date_optional_time");
public class JavaJodaTimeDuellingTests extends OpenSearchTestCase {  
        assertSameDate("2018-12-31T8", "date_hour");
        assertParseException("2001-01-01T00:00:00.123,456Z", "strict_date_optional_time");
        assertSameDate("12:12:12.1", "strict_hour_minute_second_millis");  
        assertParseException("2018-12-31T12:12:12", "strict_date_hour_minute_second_millis");  
        assertSameDate("12:12:12.123456789", "hour_minute_second_fraction");
        TemporalAccessor javaTimeAccessor = javaFormatter.parse(input);
        assertSameDate("20181126T121212+0100", "basic_date_time_no_millis");
        assertSameDate("2012-W31-5", "strict_weekyear_week_day");
    }
    private void assertSameDate(String input, String format, DateFormatter jodaFormatter, DateFormatter javaFormatter) {
        assertSameDate("2018W313T121212+0100", "strict_basic_week_date_time_no_millis");
        assertSameDate("12", "hour");  
        assertSameDate("2001-01", "strict_date_optional_time");
        String msg = String.format(  
        Locale locale = randomLocale(random());
        assertSameDate("12:12:12", "strict_hour_minute_second");
        assertParseException("2012-W1-6T10:15:30.123Z", "strict_week_date_time");
import org.joda.time.DateTimeZone;
        ZonedDateTime zonedDateTime = DateFormatters.from(javaTimeAccessor);
        assertSameDate("2018-12-31T10:15:3", "date_optional_time");
        ZonedDateTime javaDate = ZonedDateTime.of(year, month, day, hour, minute, second, 0, ZoneOffset.UTC);
        assertSameDate("2018-12-31T12:12:12.123456789", "strict_date_hour_minute_second_fraction");
        assertParseException("12:1", "strict_hour_minute");  
        assertSameDate("2018-W29", "weekyear_week");  
        assertSameDate("2012-W48-6T10:15:30.123456789Z", "week_date_time");
    private void assertSameMillis(String input, String jodaFormat, String javaFormat) {  
        assertSameDate("2018363T121212.123+01:00", "basic_ordinal_date_time");
        assertSameDate("1:15:30.123Z", "time");  
        TemporalAccessor javaDate = javaFormatter.parse(dateInput);
        assertSameDate("12:12:1", "hour_minute_second");
import static org.hamcrest.Matchers.is;
        int month = randomIntBetween(1, 12);
        assertParseException("2018-12-31T9:15:30", "strict_date_optional_time");
        assertSameDate("2018-10-10T10:11:12.123Z", format, jodaFormatter, javaFormatter);  
        assertParseException("2018-1T10:15:30.123Z", "strict_ordinal_date_time");  
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_fraction");  
        assertSameDate("121212.1+0100", "basic_time");
        assertSameDate("1:15:30.1Z", "time");
        // ... and can be combined, note that this is not an XOR, so one could append both timezones with this example  
        assertSameDate("2012-W1-6", "week_date");  
    // assertSamePrinterOutput("E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"), javaTimeNow, dateTimeNow);
        assertSameDate("2018-10-10", format, jodaFormatter, javaFormatter);
        assertParseException("1-1", "strict_year_month");
        assertParseException("12:12:12.123456789", "hour_minute_second_millis");
        assertSameDate("2018W313T121212+01:00", "strict_basic_week_date_time_no_millis");
            "Cannot parse \"2012-W01-8\": Value 8 for dayOfWeek must be in the range [1,7]"
        assertSameDate("2012-W1-6T10:15:30Z", "week_date_time_no_millis");
    // }
 * Modifications Copyright OpenSearch Contributors. See
        assertSameDate("T10:1:30.123Z", "t_time");
            DateFormatter javaFormatter = DateFormatter.forPattern(format);
        assertSameDate("2012-12", "strict_year_month");  
        assertParseException("2018-12-1", "strict_date_optional_time");  
    //
        assertParseException("12:12:12", "strict_hour_minute_second_millis");
        JodaDateFormatter jodaFormatter = new JodaDateFormatter(format, isoFormatter, isoFormatter);
            String format = "strictDateOptionalTime||dd-MM-yyyy";  
            if (format == FormatNames.ISO8601
        assertSameDate("2012-W1-6T10:15:30.1+0100", "week_date_time");
        String jodaTimeOut = jodaDateFormatter.formatJoda(jodaDate);  
        assertSameDate("2012-W48-6", "strict_week_date");
        assertSameDate("1-12-31", "yearMonthDay");
        assertSameDate("2018363T121212Z", "basic_ordinal_date_time_no_millis");
    private void assertSameDateAs(String input, String javaPattern, String jodaPattern) {
        assertSameDate("T10:15:30+0100", "t_time_no_millis");  
import org.joda.time.DateTime;
    public void testCompositeDateMathParsing() {  
        assertSameDate("2018-12-31T10:15:30.123+0100", "date_time");  
            jodaDateTime,  
        assertSameDate("2018-12-31T10:15:30Z", "strict_date_time_no_millis");
        assertSameDate("2018-1T10:15:30.123+0100", "ordinal_date_time");
        assertSameDate("2012-W48-6T10:15:30.123Z", "week_date_time");  
        String msg = String.format(
        assertSameDate("2018-12-31T12:12:12.123456789", "date_hour_minute_second_fraction");
    }
        assertParseException("2012-W1-6T10:15:30Z", "strict_week_date_time_no_millis");  
        assertSameDate("2012-W48-6T10:15:30.1Z", "week_date_time");
 * KIND, either express or implied.  See the License for the
        assertSameDate("2018-128T10:15:30.123+01:00", "strict_ordinal_date_time");
    private void assertParseException(String input, String format) {
        assertSameDate("10:15:3.1Z", "time");
        DateFormatter javaFormatter = DateFormatter.forPattern(format);  
        assertParseException("2018-12-31T8", "strict_date_hour");
        assertSameDate("121212.1Z", "basic_time");
            assertSameDate("2018-128", format, jodaFormatter, javaFormatter);  
        assertSameDate("2018-12-31T10:15:3.1+0100", "date_time");  
        assertSameDate("18W313", "basic_week_date");
        // with strict resolving, YearOfEra expect an era, otherwise it won't resolve to a date
        org.joda.time.format.DateTimeFormatter isoFormatter = ISODateTimeFormat.dateTimeParser().withZone(DateTimeZone.UTC);
        assertSameDate("2018-12-31T10:15:30.11Z", "date_time");  
        assertSameDate("2012-W48-6T10:15:30.1Z", "strict_week_date_time");  
        assertSameDate("1:15:30+0100", "time_no_millis");  
        assertSameDate("2018-12-31T10:15:30.11Z", "strict_date_time");
        assertSameDate("2018-10-10T10:11:12,123Z", format, jodaFormatter, javaFormatter);  
        assertSameDate("T10:15:30+01:00", "t_time_no_millis");
        assertSameDate("1-1", "yearMonth");
        assertSameDate("12:12:12.1", "hour_minute_second_fraction");
        assertParseException("2018W313T12128Z", "strict_basic_week_date_time_no_millis");  
        assertSameDate("2012-W31-5", "weekyear_week_day");  
        assertParseException("12:12:12", "strict_hour_minute_second_fraction");
    public void testParsingMissingTimezone() {  
        assertSameDateAs("2016-11-30T+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("T10:15:30.1+01:00", "t_time");
            DateTimeFormatter.ISO_INSTANT.format(zonedDateTime.toInstant())
        DateFormatter jodaFormatter = Joda.forPattern(jodaFormat);
        assertParseException("10:15:3Z", "time");  
        assertSameDate("T10:15:3.123+01:00", "t_time");
import java.time.temporal.TemporalAccessor;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void assertJavaTimeParseException(String input, String format) {  
import org.opensearch.test.OpenSearchTestCase;  
        // both patterns fail parsing the input text due to only 2 digits of millis. Hence full text was not parsed.  
    public void testSeveralTimeFormats() {  
        // in joda 'y' means year, this is changed to 'u' in java.time. difference is in before era yeaers  
        assertThat(e1.getMessage(), containsString(text));
        assertSameDate("2018", "strict_weekyear");
        formatter2.parse("20181126T121212.123-0830");
    // this test requires tests to run with -Djava.locale.providers=COMPAT in order to work
        assertParseException("10000-01-31", "strict_date_optional_time");
        assertSameDate("121212+0100", "basic_time_no_millis");  
    ) {
        formatter3.parse("20181126T121212.123+1030");
        DateTime jodaDate = new DateTime(year, month, day, hour, minute, second, DateTimeZone.UTC);
        assertSameDate("2018-12-31T10:5:30Z", "date_time_no_millis");
        assertSameDate("Nov 24 01:29:01 -0800", "MMM dd HH:mm:ss Z");
        ZonedDateTime javaDate,  
        assertParseException("T1:15:30Z", "strict_t_time_no_millis");  
    // assertSameDate("Mi., 06 Dez. 2000 02:55:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));
        assertSameDate("2012-W1-6T10:15:30.123+01:00", "week_date_time");
                || format == FormatNames.RFC3339_LENIENT
        assertThat(e2.getMessage(), containsString(text));  
        assertSameDate("2012-W1-6T10:15:30.123Z", "week_date_time");
    }  
 * The OpenSearch Contributors require contributions made to  
        assertSameDateAs("2016-11-30T12", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("2018-1T10:15:30.123+01:00", "ordinal_date_time");  
    }  
        assertSameDate("2012-12-31", "strict_year_month_day");  
        assertSameDate("2001-01-01T00:00:00+10:30", "date_time_no_millis");
        assertThat(message, javaTimeOut, is(jodaTimeOut));
        assertSameDate("2018-12-31T12:12:12", "date_hour_minute_second");  
        because StrictDateOptionalTime confuses +01 with an hour (which is a signed fixed length digit)  
    // the iso 8601 parser is available via Joda.forPattern(), so we have to test this slightly differently
        assertSameDate("10:15:30Z", "time_no_millis");
        assertSameDate("2018-12-31T10:15:30Z", "strict_date_optional_time");
        assertSameDate("2001-01-01", "date_optional_time");  
        String format = "strict_date_optional_time";
    // ZonedDateTime javaTimeNow = Instant.ofEpochMilli(dateTimeNow.getMillis()).atZone(ZoneOffset.UTC);  
    }
        assertParseException("1", "strict_weekyear");
            .withOffsetParsed()
        assertThat(message, javaDateString, is(jodaDateString));
        assertParseException("1:15:30Z", "strict_time_no_millis");  
        assertSameDate("2018-12-31T10:5:30+01:00", "date_time_no_millis");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> jodaFormatter.parseJoda(input));
        assertSameDate("2018-12-31T10:15:3Z", "date_time_no_millis");
        assertSameDate("2012-W48-6", "week_date");
        long millisJoda = DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss").parseMillis("2018-02-18 17:47:17");
        assertSameDate("2018-12-31T10:15:30+01:00", "strict_date_optional_time");
    public void testIncompatiblePatterns() {
        assertSameDate("2018W313", "strict_basic_week_date");
        DateTime jodaDateTime = jodaFormatter.parseJoda(input);
        assertParseException("10:15:3", "strict_time_no_millis");  
        assertSameDate("121212.123+0100", "basic_time");  
        assertSameDate("10:15:3.123Z", "time");
        assertSameDate("20181126T121212.123+10:00", "basic_date_time");
        assertSameDate("01", "strict_hour");
        assertSameDate("2018-10-10T", format, jodaFormatter, javaFormatter);  
        assertSameDate("2018-128T10:15:30.1+01:00", "strict_ordinal_date_time");
        // This should fail, but java is ok with this because the field has the same value
        assertSameDate("2012-W48-6T10:15:30.123456789Z", "strict_week_date_time");
        assertJodaParseException(
                || format == FormatNames.STRICT_DATE_OPTIONAL_TIME_NANOS  
        String javaTimeOut = dateFormatter.format(javaDate);
    }  
        assertSameDate("T1:15:30.123+0100", "t_time");  
        assertSameDate("2012-W48-6T10:15:30+01:00", "week_date_time_no_millis");  
        assertSameDate("10:15:3.123+01:00", "time");
        assertParseException("10:15:3", "time_no_millis");
    // assertSameDate("Do., 07 Dez. 2000 00:00:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));
        assertSameDate("2018-05-30T20:21:23.123", "date_optional_time");  
        return javaDateMath.parse(text, () -> 0, true, (ZoneId) null).toEpochMilli();  
        DateFormatter jodaFormatter = Joda.forPattern(format);
        assertThat(e.getMessage(), containsString(input));  
        assertSameDate("9999", "date_optional_time||epoch_second");  
        assertSameDate("2018-12-31T10:15:3+0100", "date_time_no_millis");  
    public void testCompositeParsing() {
        assertSameDate("2012-W1-6T10:15:30.1Z", "week_date_time");  
        String pattern = randomBoolean() ? "strict_date_optional_time||date_time" : "date_time||strict_date_optional_time";  
        assertSameDate("2018-12-31T12:12:12.123", "date_hour_minute_second_millis");
        ZonedDateTime zonedDateTime = DateFormatters.from(javaTimeAccessor);
        assertSameDate("2018-12-31T10:15:30.11+01:00", "strict_date_time");  
        assertParseException("2018-12-31T12:12:1", "strict_date_hour_minute_second");
import org.joda.time.format.DateTimeFormat;  
        // the following fail under java 8 but work under java 10, needs investigation  
            "expected string representation to be equal for format [%s]: joda [%s], java [%s]",
        assertSameDate("2018-12-31", "strict_date_optional_time");
        assertSameDate("20181126T121212.123-0800", "basic_date_time");  
    }
            assertSameDate("2018-12-12", format, jodaFormatter, javaFormatter);
        assertSameDate("T10:1:30+01:00", "t_time_no_millis");
        assertSameDate("2018-05", "date_optional_time");  
        assertThat(millisJava, is(millisJoda));  
        assertSameDate("T121212Z", "basic_t_time_no_millis");
        assertSameDate("2012-1-31", "yearMonthDay");
        assertSameDate("12:12:12.123", "strict_hour_minute_second_millis");
        DateFormatter formatter = DateFormatter.forPattern(pattern).withLocale(locale);
        assertParseException("10:15:3.1", "strict_time");  
        assertSameDate("12/06", "dd/MM");
        OpenSearchParseException e1 = expectThrows(  
    // // also ensure that locale based dates are the same
        assertSameDate("2012-W01-6", "strict_week_date");  
        assertSameDate("2012-W01-6", "strict_week_date");
        assertParseException("1:15:30.123Z", "strict_time");  
        assertSameDate("T10:15:3+0100", "t_time_no_millis");  
    }
        assertParseException("10:5:30Z", "strict_time_no_millis");
        // only java.time has nanos parsing, but the results for 3digits should be the same
        assertSameDateAs("2016-11-30T12:00:00.000", "strict_date_optional_time", "strict_date_optional_time");
/*
        assertSameDate("2018-128T10:15:30+01:00", "ordinal_date_time_no_millis");
        assertSameDate("2012-W48-6T10:15:30Z", "week_date_time_no_millis");
        assertSameDate("2018-12-31T12:12:12.123", "strict_date_hour_minute_second_millis");  
        assertDateMathEquals("2014-06-06T12:01:02.123", "strictDateTimeNoMillis||yyyy-MM-dd'T'HH:mm:ss.SSS");  
        assertSameDate("2018-12-31T10:15:30.1+0100", "strict_date_time");  
import java.time.ZoneId;  
        assertSameDate("2018-12-31T10:15:30.123456789Z", "date_time");
        }
        assertSameDate("2001-01-01T00:00:00-0800", "date_time_no_millis");
            jodaTimeOut,
        assertParseException("1", "strict_weekyear");  
        assertSameDate("0", "epoch_millis");  
        assertThat(e.getMessage(), containsString(format));
        assertParseException("T10:15:3.1", "t_time");
        assertSameDate("01:15:30+0100", "strict_time_no_millis");
        assertParseException("T10:15:3", "strict_t_time_no_millis");  
        assertParseException("2018W313T12812.123Z", "strict_basic_week_date_time");
 * You may obtain a copy of the License at  
    }
        assertSameDate("1", "epoch_millis");
        assertSameDate("2018-12-31T10:15:3.123+0100", "date_time");
        assertSameDate("T10:15:3Z", "t_time_no_millis");
        DateFormatter jodaFormatter = Joda.forPattern("strict_date_optional_time");  
 * specific language governing permissions and limitations
    }
        assertSameDate("T10:15:30Z", "strict_t_time_no_millis");  
        assertSameDate("2018-12-31T12:12:12.1", "strict_date_hour_minute_second_millis");
        assertParseException("2018W313T81212+0100", "strict_basic_week_date_time_no_millis");
        assertParseException("T10:15:3Z", "strict_t_time");
        assertSameDate("2012-12-31", "yearMonthDay");  
        assertSameDate("T10:1:30Z", "t_time_no_millis");
        assertSameDate("T10:15:3+01:00", "t_time_no_millis");
        assertSameDate("10:15:30+0100", "time_no_millis");  
            jodaDateTime,  
        assertSameDate("10:15:30.123456789Z", "strict_time");  
        String text = "2014-06-06T12:01:02.123";
        assertJavaTimeParseException(input, format);  
        assertSameDate("2018-12-31T10:15:3.123Z", "date_time");
        assertSameDate("2001-01-01T00:00:00,123Z", "strict_date_optional_time_nanos", jodaFormatter, javaFormatter);  
 * compatible open source license.
        assertThat(jodaDate.getMillis(), is(javaDate.toInstant().toEpochMilli()));
            format,  
    // DateTime dateTimeNow = DateTime.now(DateTimeZone.UTC);
        assertSameDate("T10:15:30.1+0100", "t_time");
        assertParseException("1-12-31", "strict_year_month_day");
        assertSameDate("01:15:30+0100", "time_no_millis");  
        assertSameDate("2018W313T121212.123Z", "strict_basic_week_date_time");
        assertSameDateAs("2001-01", "strict_date_optional_time_nanos", "strict_date_optional_time");  
        String javaZoneId = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz", Locale.getDefault()).format(parse);
 * GitHub history for details.
        assertSameDate("2012-W48-6T10:15:30+0100", "strict_week_date_time_no_millis");
    @Override
        assertThat(e.getMessage(), containsString(expectedMessage));  
        assertSameDate("2018W313T121212.1+01:00", "strict_basic_week_date_time");
        assertParseException("T10:15:3", "t_time_no_millis");
        assertSameDate("2018-128T10:15:30.123Z", "ordinal_date_time");
        assertSameDate("2018-12-31T10:15:30Z", "date_time_no_millis");
            Locale.ROOT,
        assertSameDate("T10:1:30.123+01:00", "t_time");
        assertSameDate("2018-05-30T20:21:23.123+01:00", "date_optional_time");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> javaTimeFormatter.parse(input));
        formatter3.parse("20181126T121212.123-0830");
        assertSameDate("2018363T121212.123Z", "basic_ordinal_date_time");
        assertSameDateAs("2001", "iso8601", "strict_date_optional_time");
        assertThat(jodaZoneId, startsWith("2019-01-01T01:01:01.001"));  
        assertParseException("2018-12-31T1:15:30.123Z", "strict_date_time");  
 *
            DateTimeFormatter.ISO_INSTANT.format(zonedDateTime.toInstant())
        assertSameDate("2018-12-31T10:15:30+0100", "date_time_no_millis");  
            "strict_week_date",
                || format == FormatNames.EPOCH_MICROS) {
        assertParseException("12:12:12", "hour_minute_second_fraction");  
        assertSameDate("1522332219", "epoch_second");
}
        assertSameDate("2012", "strict_year");
        assertParseException("2012-1-31", "strict_year_month_day");
    public void testTimezoneParsing() {  
    }
            }
        assertSameDate("1", "epoch_second");
        assertSameMillis("2019-01-01T01:01:01.001+0000", "YYYY-MM-dd'T'HH:mm:ss.SSSZ", "8yyyy-MM-dd'T'HH:mm:ss.SSSZ");  
        assertSameDate("1522332219321", "epoch_millis");
        assertParseException("2012-W1-8", "strict_week_date");
        assertSameDate("2018W313T121212+0100", "basic_week_date_time_no_millis");
import java.util.Locale;
        assertSameDate("2001-01-01T00:00:00-08", "date_time_no_millis");  
        assertSameDate("12:01", "hour_minute");
        assertSameDate("2018-12-31T10:15:30.1+0100", "date_time");
        assertSameDate("2018-12-31T10:15:30.123456789Z", "strict_date_time");
 */
        assertSameDate("T10:15:30.123Z", "t_time");
        assertParseException("2018-12-31T12:12:12.123456789", "date_hour_minute_second_millis");
        assertSameDate("2018-12-31T1:15:30+0100", "date_time_no_millis");  
        assertParseException("T10:15:3Z", "strict_t_time_no_millis");
        assertParseException("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SS");  
        assertParseException("2018-12-31T12:12:12", "strict_date_hour_minute_second_fraction");
        but we intentionally not allow parsing timezone without an time part as it is not allowed in iso8601  
import org.opensearch.OpenSearchParseException;
        assertParseException("2018W313T12128.123456789Z", "strict_basic_week_date_time");
import static org.hamcrest.Matchers.containsString;  
        assertSameDate("2018363", "yyyyDDD", Joda.forPattern("YYYYDDD"), DateFormatter.forPattern("uuuuDDD"));  
        assertSameDate("12:01", "strict_hour_minute");
/*  
        assertParseException("1", "strict_year");  
            OpenSearchParseException.class,
        assertSameDate("2018-12-31T12", "date_hour");  
        assertParseException("10:15:3.123Z", "strict_time");
        assertSameDate("2018-10-10T10:11:12,123", format, jodaFormatter, javaFormatter);
        assertSameDate("1W313", "basic_week_date");  
        assertSameDate("T10:15:30.1+0100", "strict_t_time");
        assertSameDate("01", "hour");
        String jodaZoneId = DateTimeFormat.forPattern("YYYY-MM-dd'T'HH:mm:ss.SSSz").print(dateTime);
        assertSameDate("2018-10-10T10", format, jodaFormatter, javaFormatter);
        assertSameDate("2012-W48-6T10:15:30.123Z", "strict_week_date_time");
        assertSameDate("18-5-6", "date");  
        assertSameDate("2018-128T10:15:30.1Z", "strict_ordinal_date_time");
            input,  
        assertSameDate("2018W313T121212.123+0100", "strict_basic_week_date_time");
        assertParseException("2012-W1-6", "strict_week_date");  
        /* this testcase won't work in joda. See comment in {@link #testPartialTimeParsing()}
        assertSameDate("10:15:3+0100", "time_no_millis");  
        assertSameDate("10:15:30.123456789Z", "time");
        assertSameDate("2018-12-31T1:15:30Z", "date_time_no_millis");
        assertSameDate("-2000", "strict_year");
        assertSameDate(input, javaPattern, jodaFormatter, javaFormatter);
    public void testExceptionWhenCompositeParsingFails() {
            javaFormat,
        assertSameDate("121212Z", "basic_time_no_millis");
        assertEquals(gotMillisJoda, gotMillisJava);
        assertSameDate("2018-12-31", "date");
            "2012-W01-8",  
        assertSameDate("2018-12-31T10:15:30.1+01:00", "strict_date_time");
        assertSameDate("2018-12-31T1:15:30", "date_optional_time");  
            format,  
        assertParseException("2018W313T12812.1Z", "strict_basic_week_date_time");
        assertThat(e1.getMessage(), containsString(pattern));
        }
        assertSameDate("2001-01-01T00:00:00,123Z", "strict_date_optional_time");  
        assertSameDate("2018-12-31T10:15:30.11+01:00", "date_time");
        DateFormatter javaFormatter = DateFormatter.forPattern(javaPattern);  
        assertSameDateAs("2001-01", "iso8601", "strict_date_optional_time");  
        assertSameDate("T10:15:30.123456789Z", "t_time");  
         */  
        assertSameDateAs("2016-11-30T00+01:00", "strict_date_optional_time", "strict_date_optional_time");  
        assertSameDateAs("2016-11-30T12:00", "strict_date_optional_time", "strict_date_optional_time");  
        assertParseException("2018W313T12128+0100", "strict_basic_week_date_time_no_millis");
    }
    }
        assertSameDate("2012-W01-6", "week_date");
        assertSameDate("2018-12-31T10:15:30.1Z", "strict_date_time");  
        assertSameDateAs("2016-11-30T12:00:00.000+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("T10:1:30+0100", "t_time_no_millis");  
    public void testCustomTimeFormats() {
    public void testSamePrinterOutputWithTimeZone() {
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_millis");  
            DateFormatter javaFormatter = DateFormatter.forPattern(format);
    }  
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSSXXXX", Locale.ROOT);
        assertSameDate("2018-1T10:15:30+01:00", "ordinal_date_time_no_millis");
            DateFormatter jodaFormatter = Joda.forPattern(format);  
    }
        assertSameDate("10:15:30+01:00", "time_no_millis");
        assertSameDate("2018-1", "ordinal_date");
    private void assertSamePrinterOutput(String format, ZonedDateTime javaDate, DateTime jodaDate) {  
        assertSameDate("2018-128T10:15:30.123+0100", "ordinal_date_time");  
        assertSameDateAs("2016-11-30T12:00+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("121212.123+01:00", "basic_time");
        }
        assertSameDate("2018W313T121212Z", "basic_week_date_time_no_millis");
        DateFormatter javaFormatter = DateFormatter.forPattern(format);
        assertSameDate("2018W313T121212.1Z", "strict_basic_week_date_time");  
        assertSameDate("1:15:30.123+01:00", "time");
        assertSameDate("2012", "year");
        String pattern = "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SS";
    public void testDuellingFormatsValidParsing() {
        assertSameDate("2018-05-30", "date_optional_time");
    public void testIso8601Parsers() {
        assertSameDate("2012-W48-6T10:15:30.1+0100", "strict_week_date_time");  
        DateTime jodaDate,
        formatter2.parse("20181126T121212.123+1030");  
        // both parsing failures should contain pattern and input text in exception
        assertSameDate("T10:15:3.123Z", "t_time");
        assertParseException("T10:1:30.123Z", "strict_t_time");
        assertSameDate("2018W313T121212+01:00", "basic_week_date_time_no_millis");  
        assertSameDate("2018-12-31T10:15:30.1+01:00", "date_time");
        assertSameDate("T1:15:30+01:00", "t_time_no_millis");
            jodaFormat,
        assertSameDate("2012-W48-6", "strict_week_date");
        assertSameDate("2018-12-31T10:15:30.123+01:00", "strict_date_time");  
        formatter3.parse("20181126T121212.123Z");
            () -> dateMathToMillis(text, DateFormatter.forPattern(pattern))
import static org.hamcrest.CoreMatchers.equalTo;
        assertSameDate("2018-128T10:15:30.1Z", "ordinal_date_time");  
 * Unless required by applicable law or agreed to in writing,
        JodaDateFormatter jodaDateFormatter = Joda.forPattern(format);
        assertSameDate("2012-W48-6T10:15:30Z", "strict_week_date_time_no_millis");  
        DateTime dateTime = jodaFormatter.parseJoda(dateInput);
            jodaDateString,
        assertSameDate("1:15:30Z", "time_no_millis");
        assertSameDate("2018-1T10:15:30.123456789Z", "ordinal_date_time");
        // year-of-era in joda becomes 'y' in java.time
            "Input [%s] Format [%s] Joda [%s], Java [%s]",  
        assertParseException("2018W313T81212Z", "strict_basic_week_date_time_no_millis");  
import org.joda.time.format.ISODateTimeFormat;
        assertSameDate("2018-12-31T12:12", "strict_date_hour_minute");
    // date_optional part of a parser names "strict_date_optional_time" or "date_optional"time
        assertSameDate("10:15:30+01:00", "strict_time_no_millis");
        assertSameDate("2018-W01", "strict_weekyear_week");
            "expected string representation to be equal for format [%s]: joda [%s], java [%s]",
    public void testDateFormatterWithLocale() {
        assertSameDate("T10:15:30.1Z", "strict_t_time");
        assertSameMillis("-0001-01-01", "yyyy-MM-dd", "8uuuu-MM-dd");
package org.opensearch.common.joda;
        // in all these examples the second pattern will be used
            assertSamePrinterOutput(format.getSnakeCaseName(), javaDate, jodaDate);  
        assertThat(javaZoneId, equalTo("2019-01-01T01:01:01.001Z"));
    private void assertJodaParseException(String input, String format, String expectedMessage) {  
        assertSameDate("10:5:30Z", "time_no_millis");
        assertParseException("2018-12-31T1:15:30Z", "strict_date_time_no_millis");  
        assertJavaTimeParseException("2012-W1-8", "week_date");  
        assertSameDate("T10:1:30.123+0100", "t_time");  
        assertSameDate("2018-12-1", "date_optional_time");
        assertSameDate("2001", "strict_date_optional_time");  
    public void testParsingLocalDateFromYearOfEra() {
    }
        assertSameDate("2018-10-10T10:11Z", format, jodaFormatter, javaFormatter);
        assertSameDate("10:15:30.123Z", "time");
 * this work for additional information regarding copyright
        assertSameDate("2018-10-10T10:11-08:00", format, jodaFormatter, javaFormatter);
        assertParseException("T1:15:30.123Z", "strict_t_time");  
    }
        assertSameDateAs("2001-01-01", "strict_date_optional_time_nanos", "strict_date_optional_time");
        assertSameDate("2018-12-31T10:15:30.123+01:00", "date_time");
        assertSameDate("01:15:30+01:00", "time_no_millis");
        // joda comes up with a different exception message here, so we have to adapt
        assertParseException("10:15:3.1", "time");
        assertSameMillis("2019-01-01T01:01:01.001Z", "YYYY-MM-dd'T'HH:mm:ss.SSSZ", "8yyyy-MM-dd'T'HH:mm:ss.SSSX");
        assertSameDate("12:12:01", "strict_hour_minute_second");
        assertParseException("1", "strict_hour");  
 * not use this file except in compliance with the License.
        assertSameDate("01:15:30+01:00", "strict_time_no_millis");
        );  
        assertSameDate("2018-05-30T20:21:23.1+0100", "date_optional_time");
            javaDateString
        assertSameDate("1", "hour");
        assertSameDate("20181126T121212Z", "basic_date_time_no_millis");
            String format = "year_month_day||ordinal_date";
        assertSameDate("2018-12-31T10:15:30.123+0100", "strict_date_time");
    }
    private void assertSameDate(String input, String format) {
    }
        assertParseException("10000-12-31", "strict_date");
        // different timezone parsing styles require a different number of letters  
        assertSameDate("10:5:30+0100", "time_no_millis");  
        assertSameDate("2018-10-10T10:11:12+0100", format, jodaFormatter, javaFormatter);
    }  
    }
        assertSameDate("2018-W29", "strict_weekyear_week");  
        assertSameDate("1:15:30+01:00", "time_no_millis");
        assertParseException("2018-W1", "strict_weekyear_week");
        {
        assertParseException("T10:15:3.1", "strict_t_time");  
        assertSameDate("2012-W1-6T10:15:30.1+01:00", "week_date_time");
        assertSameDate("2012-W48-6T10:15:30.1+0100", "week_date_time");
    private long dateMathToMillis(String text, DateFormatter dateFormatter) {  
        // 'z' zoneId in joda prints UTC whereas joda prints 'Z' for zulu
    //
        int minute = randomIntBetween(0, 59);
        DateFormatter jodaFormatter = Joda.forPattern(jodaPattern);
        assertSameDate("T10:15:30.123+0100", "t_time");
        assertSameDate("2018-12-31", "strict_date");  
        assertSameDate("2018-10-10T10:11:12.123", format, jodaFormatter, javaFormatter);
        assertSameDate("2018-12-31T12", "strict_date_hour");  
        assertSameDateAs("2001", "strict_date_optional_time_nanos", "strict_date_optional_time");
        */
        DateFormatter javaFormatter = DateFormatter.forPattern("strict_date_optional_time_nanos");
        assertSameDate("2018W313T121212.123456789Z", "basic_week_date_time");
        assertSameDate("10000-5-6", "date");
        assertSameDate("T1:15:30.123+01:00", "t_time");
        assertSameDate("T121212+01:00", "basic_t_time_no_millis");
            javaTimeOut
        assertSameDate("2018-12-31T12:12:12.1", "strict_date_hour_minute_second_fraction");
        long millisJava = DateFormatter.forPattern("8yyyy-MM-dd HH:mm:ss").parseMillis("2018-02-18 17:47:17");
        assertSameDate("2018-128T10:15:30.123Z", "strict_ordinal_date_time");  
    // assertSameDate("Fr., 08 Dez. 2000 00:00:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));  
        long gotMillisJava = dateMathToMillis(text, DateFormatter.forPattern(pattern));
        assertSameDate("20181126T121212+01:00", "basic_date_time_no_millis");  
            DateFormatter jodaFormatter = Joda.forPattern(format);
        );  
/*  
        assertSameDate("121212+01:00", "basic_time_no_millis");
        assertSameDate("10:1:30.123+0100", "time");
        assertParseException("18W313", "strict_basic_week_date");
        assertSameDate("10:15:30.1Z", "strict_time");
        assertThat(formatter.locale(), is(locale));  
        assertSameDate("2018363T121212.123456789Z", "basic_ordinal_date_time");
        DateMathParser javaDateMath = javaFormatter.toDateMathParser();
        assertSameDateAs("2016-11-30T00+01", "strict_date_optional_time", "strict_date_optional_time");
        String format = "iso8601";  
        assertParseException("2018-12-31T10:15:3Z", "strict_date_time_no_millis");
        assertSameDate("2001", "date_optional_time");
        DateFormatter javaTimeFormatter = DateFormatter.forPattern(format);
        assertParseException("2018W313T12128+01:00", "strict_basic_week_date_time_no_millis");
        assertSameDate("10:1:30.123Z", "time");
        assertSameDate("01:15:30Z", "strict_time_no_millis");  
 */  
        assertSameDate("10:5:30+01:00", "time_no_millis");
        assertSameDate("1:15:30.123+0100", "time");
        assertSameDate("2018-05-30T20", "date_optional_time");
        assertSameDate("2018-12-31T10:15:3.1Z", "date_time");  
        assertSameDate("12:12:12", "hour_minute_second");
    }
        assertSameDate("2018-12-31T1:15:30+01:00", "date_time_no_millis");
        formatter.parse("20181126T121212.123-08:30");  
        assertSameDate("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SSS");  
        DateTime dateTime = DateTimeFormat.forPattern("YYYY-MM-dd'T'HH:mm:ss.SSSZ")
        assertSameDate("T10:15:30.1+01:00", "strict_t_time");
        assertJavaTimeParseException("2016-11-30T+01", "strict_date_optional_time");
        assertSameDate("2012-12", "yearMonth");  
        assertParseException("T10:1:30Z", "strict_t_time_no_millis");
        assertDateMathEquals("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss+HH:MM||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("2018W313", "basic_week_date");
        assertParseException("2018W313T81212+01:00", "strict_basic_week_date_time_no_millis");
        assertSameDate("2018-1T10:15:30+0100", "ordinal_date_time_no_millis");  
        assertSameDate("-2000", "year");
        // assertJavaTimeParseException("2001-01-01T00:00:00.123,123Z", "strict_date_optional_time_nanos");
        assertSameDate("2018-12-31T8:3", "date_hour_minute");
        assertSameDate("12:12:12.123456789", "strict_hour_minute_second_fraction");
        assertSameDate("2018363T121212+01:00", "basic_ordinal_date_time_no_millis");
        assertSameDate("10:15:30Z", "strict_time_no_millis");  
        assertParseException("2018W313T81212.123Z", "strict_basic_week_date_time");  
        This does not work in Joda as it reports 2016-11-30T01:00:00Z
        assertSameDate("2018363T121212.123+0100", "basic_ordinal_date_time");  
        assertSameDate("2018-12-31T12:12:12.123", "strict_date_hour_minute_second_fraction");
        int day = randomIntBetween(1, 28);
        assertSameDateAs("2016-11-30T12:00:00+01", "strict_date_optional_time", "strict_date_optional_time");  
        );  
        assertParseException("12:12:12", "hour_minute_second_millis");
        assertSameDate("10:15:30.123+01:00", "strict_time");
        String message = String.format(  
        assertSameDate("10:15:30.123+0100", "time");  
        assertSameDate("20181126T121212.123Z", "basic_date_time");
        assertSameDate("T1:15:30+0100", "t_time_no_millis");  
        assertSameDate("T10:15:30.1Z", "t_time");
                continue;
        assertSameDate("10:15:3Z", "time_no_millis");
        assertParseException("2018W313T12128.123Z", "strict_basic_week_date_time");
        assertSameDate("2018-12-31T12:12:12", "strict_date_hour_minute_second");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSSXXX", Locale.ROOT);
 * under the License.  
        assertSameDate("T121212+0100", "basic_t_time_no_millis");  
        assertSameDate("2018-128", "strict_ordinal_date");
        assertSameDate("2018-128T10:15:30+0100", "strict_ordinal_date_time_no_millis");  
 * ownership. Elasticsearch licenses this file to you under  
        assertSameDate("2018-128T10:15:30Z", "ordinal_date_time_no_millis");
 * license agreements. See the NOTICE file distributed with
        DateFormatter dateFormatter,
        String jodaDateString = jodaFormatter.withZone(ZoneOffset.ofHours(-1)).formatJoda(dateTime);
        assertParseException("2012-12-1", "strict_year_month_day");  
        assertParseException("10:1:30.123Z", "strict_time");
    public void testExceptionWhenCompositeParsingFailsDateMath() {
        assertSameDate("2018W313T121212Z", "strict_basic_week_date_time_no_millis");  
        assertSameDate("10:15:30.123+0100", "strict_time");
        assertSameDate("2018-12-31T10:15:30+0100", "strict_date_optional_time");  
        assertSameDate("T121212.123+0100", "basic_t_time");  
        DateFormatter jodaFormatter = Joda.forPattern(format);
        formatter3.parse("20181126T121212.123-08:30");  
        int hour = randomIntBetween(0, 23);  
        String format,
        assertSameDate("2018-10-10T10:11:12", format, jodaFormatter, javaFormatter);  
        assertParseException("10:15:3Z", "strict_time");
    // these parsers should allow both ',' and '.' as a decimal point  
        assertParseException("2018-12-31T10:5:30", "strict_date_optional_time");  
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_millis");  
        assertSameDate("2018-1T10:15:30.1Z", "ordinal_date_time");
        assertSameDate("2018363T121212+0100", "basic_ordinal_date_time_no_millis");  
        assertSameDate("2018-05-30T20:21:23.123Z", "date_optional_time");
        assertSameDate("2018-12-31T10:15:30.1Z", "date_time");
        assertSameDate("12:12:12.1", "hour_minute_second_millis");  
 * software distributed under the License is distributed on an
        assertSameDate("2001-01-01T00:00:00+1030", "date_time_no_millis");
        assertSameDate("T10:15:30.123+01:00", "t_time");  
    }
        assertSameDate("2018-12-31T10:15:30+01:00", "strict_date_time_no_millis");  
        TemporalAccessor javaTimeAccessor = javaFormatter.parse(input);  
        assertSameDate("2018W313T121212.123456789Z", "strict_basic_week_date_time");
        assertSameDate("T121212.123456789Z", "basic_t_time");
        OpenSearchParseException e2 = expectThrows(OpenSearchParseException.class, () -> dateMathToMillis(text, Joda.forPattern(pattern)));
        assertSameDate("2017", "weekyear");
        assertSameMillis("-1", "y", "8u");
        assertSameDate("12", "strict_hour");
            .parse("2019-01-01T01:01:01.001+00:00");
        assertParseException("2018-12-31T10:5:30.123Z", "strict_date_time");
        assertSameDate("12:12:12.123", "strict_hour_minute_second_fraction");
        assertSameDate("121212.123456789Z", "basic_time");
        assertSameDate("2018-12-31T10:15:30+01:00", "date_time_no_millis");
        assertSameDate("T10:15:30.123Z", "strict_t_time");  
           assertSameDateAs("2016-11-30T+01", "strict_date_optional_time", "strict_date_optional_time");
        int year = randomIntBetween(1970, 2030);  
        assertSameDate("12:12", "hour_minute");
        assertSameDate("2018-05-30T20:21:23.123456789", "date_optional_time");
        assertSameDate("2018-128", "ordinal_date");  
        assertSameDate("2018-128T10:15:30.123+0100", "strict_ordinal_date_time");  
        for (FormatNames format : FormatNames.values()) {
        assertSameDate("2018-12-31T10:15:30.11+0100", "strict_date_time");
        assertSameDate(input, format, jodaFormatter, javaFormatter);
        assertSameDate("2018-12-31T12:12:1", "date_hour_minute_second");
        assertParseException("2018W313T12812+0100", "strict_basic_week_date_time_no_millis");
        return false;  
        assertSameDate("10:1:30.1Z", "time");  
        assertParseException("12:12:1", "strict_hour_minute_second");  
 */  
        assertSameDate("2018-W1", "weekyear_week");
        assertSameDateAs("2016-11-30T12+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("2018W313T121212.1Z", "basic_week_date_time");
        assertSameDate("2018-128T10:15:30.123+01:00", "ordinal_date_time");
        assertParseException("10:15:3Z", "strict_time_no_millis");
        assertSameDate("2018363", "basic_ordinal_date");
        assertSameDate("2018-12-31T10:15:3.123+01:00", "date_time");
            Locale.ROOT,
 * Licensed to Elasticsearch under one or more contributor  
        assertSameDate("2018W313T121212.1+0100", "strict_basic_week_date_time");  
        assertSameDate("12:12:01", "hour_minute_second");  
        assertParseException("2018W313T12812Z", "strict_basic_week_date_time_no_millis");  
        assertSameDate("12:12:12.1", "strict_hour_minute_second_fraction");  
        assertParseException("2018-12-31T8:3", "strict_date_hour_minute");  
    }  
        assertSameDate("2018-12-31T10:15:30.11+0100", "date_time");
        // without timezone  
        assertSameDate("10:15:30.1Z", "time");  
        assertSameDate("2018-10-10T10+0430", format, jodaFormatter, javaFormatter);
        DateTime jodaDateTime = jodaFormatter.parseJoda(input);
        DateFormatter jodaFormatter = Joda.forPattern(format);
        assertSameDate("10:15:30+0100", "strict_time_no_millis");
        assertSameDate("2015-01-04T00:00Z", "strict_date_optional_time");
        assertParseException("2018-12-31T10:15:3.123Z", "strict_date_time");
        assertThat(formatter.pattern(), is(pattern));
        assertSameDate("T10:15:30Z", "t_time_no_millis");
        // in joda 'Z' was able to parse 'Z' zulu but in java it fails. You have to use 'X' to do that.
        assertSameDate("2018-12-31T10:15:3+01:00", "date_time_no_millis");
        assertSameDate("2012-W48-6T10:15:30+0100", "week_date_time_no_millis");
        );
        assertSameDate("2001-01-01T00:00:00Z", "date_time_no_millis");
        assertSameDate("2018", "weekyear");
        assertSameDate("2018-12-31T12:12:12.123", "date_hour_minute_second_fraction");
        assertSameDate("2014-06-06T12:01:02.123", "strictDateTimeNoMillis||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("2012-W1-1", "weekyear_week_day");
        assertSameDate("2018-1T10:15:30.123Z", "ordinal_date_time");  
        assertParseException("2012-W1-6", "strict_week_date");
        assertSameDate("T10:15:30.123456789Z", "strict_t_time");
        assertSameDate("2018-12-31T12:12", "date_hour_minute");  
        assertSameDate("12:12:12.123", "hour_minute_second_fraction");  
        DateFormatter javaFormatter = DateFormatter.forPattern(format);  
        assertParseException("2018-1", "strict_ordinal_date");  
        assertDateMathEquals("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("01:15:30Z", "time_no_millis");
        DateFormatter jodaDateFormatter  
import java.time.ZonedDateTime;
