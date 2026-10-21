        // the following fail under java 8 but work under java 10, needs investigation
        String dateInput = "2017-02-01T08:02:00.000-01:00";
        DateFormatter javaFormatter = DateFormatter.forPattern(javaFormat);
                continue;
            javaDateString
    private void assertSameDateAs(String input, String javaPattern, String jodaPattern) {
    }
        assertSameDate("01:15:30+0100", "time_no_millis");
        // assertJavaTimeParseException("2001-01-01T00:00:00.123,123Z", "strict_date_optional_time_nanos");
        assertSameDate("2018-12-31T10:15:30.11+01:00", "date_time");
    // }
        assertParseException("2018W313T12128.123456789Z", "strict_basic_week_date_time");
        );
        formatter3.parse("20181126T121212.123-08:30");
        assertSameDate("T10:15:30.1Z", "strict_t_time");
import static org.hamcrest.Matchers.is;
        assertSameDate("2018-W29", "strict_weekyear_week");
        DateFormatter dateFormatter,
        int day = randomIntBetween(1, 28);
        assertSameDate("2018-10-10T10:11:12.123Z", format, jodaFormatter, javaFormatter);
    private void assertSameDate(String input, String format, DateFormatter jodaFormatter, DateFormatter javaFormatter) {
        assertSameDate("2012-W48-6T10:15:30.123+01:00", "week_date_time");
        assertSameDate("T10:15:3.123+01:00", "t_time");
        assertSameDate("2012-12-31", "yearMonthDay");
        assertSameDate("Nov 24 01:29:01 -0800", "MMM dd HH:mm:ss Z");
        assertSameDate("121212.1Z", "basic_time");
        assertParseException("1-12-31", "strict_year_month_day");
        JodaDateFormatter jodaFormatter = new JodaDateFormatter(format, isoFormatter, isoFormatter);
        assertSameDate("2018363T121212.123+01:00", "basic_ordinal_date_time");
        assertSameDate("2018-1T10:15:30.123+0100", "ordinal_date_time");
        assertThat(millisJava, is(millisJoda));
        assertParseException("2018-12-31T8:3", "strict_date_hour_minute");
        ZonedDateTime zonedDateTime = DateFormatters.from(javaTimeAccessor);
    }
        assertSameDate("10:15:3Z", "time_no_millis");
            () -> dateMathToMillis(text, DateFormatter.forPattern(pattern))
        assertSameDate("2012-W48-6T10:15:30.1+0100", "strict_week_date_time");
        assertSameDate("121212Z", "basic_time_no_millis");
        assertSameDate("2018-05-30", "date_optional_time");
        assertParseException("2018-12-31T12:12:12.123456789", "date_hour_minute_second_millis");
        assertSameDate("T10:1:30Z", "t_time_no_millis");
        assertSameDate("2012-12-1", "yearMonthDay");
        formatter.parse("20181126T121212.123Z");
        DateFormatter formatter = DateFormatter.forPattern(pattern).withLocale(locale);
        assertParseException("2018W313T81212+01:00", "strict_basic_week_date_time_no_millis");
        assertSameDate("2018-128T10:15:30.123456789Z", "strict_ordinal_date_time");
            DateTimeFormatter.ISO_INSTANT.format(zonedDateTime.toInstant())
        assertSameDate("2018W313T121212+01:00", "strict_basic_week_date_time_no_millis");
        TemporalAccessor javaTimeAccessor = javaFormatter.parse(input);
        assertSameDate("10:15:30+01:00", "time_no_millis");
        assertSameDate("2018-12-31T10:15:30.123Z", "date_time");
        assertParseException("2018W313T81212.123Z", "strict_basic_week_date_time");
        assertSameDate("T10:15:30+0100", "strict_t_time_no_millis");
        but we intentionally not allow parsing timezone without an time part as it is not allowed in iso8601
        DateFormatter javaTimeFormatter = DateFormatter.forPattern(format);
        assertSameDate("2018-12-1", "date_optional_time");
        assertSameDate("2018-05-30T20:21:23.123456789", "date_optional_time");
        ZonedDateTime zonedDateTime = DateFormatters.from(javaTimeAccessor);
        // joda comes up with a different exception message here, so we have to adapt
        assertParseException("2018-12-31T10:15:3.123Z", "strict_date_time");
        assertSameDate("2001-01-01T00:00:00+10:30", "date_time_no_millis");
        assertThat(message, javaDateString, is(jodaDateString));
        assertParseException("2018-8-31", "strict_date");
        JodaDateFormatter jodaDateFormatter = Joda.forPattern(format);
        // both patterns fail parsing the input text due to only 2 digits of millis. Hence full text was not parsed.
        assertSameDate("T10:1:30.123+0100", "t_time");
        assertParseException("2018W313T12128+01:00", "strict_basic_week_date_time_no_millis");
        assertSameDate("2018-12-31T1:15:30Z", "date_time_no_millis");
        assertSameDate("2017", "weekyear");
import static org.hamcrest.CoreMatchers.equalTo;
        assertSameDate("2018W313T121212.123+01:00", "strict_basic_week_date_time");
        // different timezone parsing styles require a different number of letters
        assertSameDate("2018-1T10:15:30+01:00", "ordinal_date_time_no_millis");
    }
        assertSameDate("2018-12-31T10:15:30.1+0100", "strict_date_time");
 */
        assertParseException("2018W313T12128+0100", "strict_basic_week_date_time_no_millis");
        assertSameDate("2018363T121212.1Z", "basic_ordinal_date_time");
        assertSameDate("2018-128T10:15:30Z", "ordinal_date_time_no_millis");
        DateFormatter dateFormatter = DateFormatter.forPattern(format);
    // this test requires tests to run with -Djava.locale.providers=COMPAT in order to work
        );
        assertSameDate("2018-12-31T10:5:30", "date_optional_time");
        assertSameMillis("-1", "y", "8u");
        assertSameDate("2017", "strict_weekyear");
        assertParseException("T1:15:30Z", "strict_t_time_no_millis");
        DateTime dateTime = jodaFormatter.parseJoda(dateInput);
    private void assertJodaParseException(String input, String format, String expectedMessage) {
        formatter3.parse("20181126T121212.123-0830");
        assertSameDateAs("2016-11-30T12+01", "strict_date_optional_time", "strict_date_optional_time");
        DateFormatter jodaFormatter = Joda.forPattern(jodaFormat);
        // in all these examples the second pattern will be used
        assertSameDate("1", "year");
        assertParseException("10:15:3Z", "strict_time_no_millis");
        assertSameDate("2001-01-01T00:00:00,123Z", "strict_date_optional_time_nanos", jodaFormatter, javaFormatter);
        DateFormatter jodaFormatter = Joda.forPattern(format);
            "Cannot parse \"2012-W01-8\": Value 8 for dayOfWeek must be in the range [1,7]"
        assertSameDate("2018-12-31T10:15:3.123Z", "date_time");
        assertSameDate("2018W313T121212.123+0100", "basic_week_date_time");
        assertSameDateAs("2016-11-30T12:00", "strict_date_optional_time", "strict_date_optional_time");
        Locale locale = randomLocale(random());
        assertJodaParseException(input, format, "Invalid format: \"" + input);
 * not use this file except in compliance with the License.
        assertSameDate("T121212.1+0100", "basic_t_time");
    }
        assertSameDate("2018-128T10:15:30.1+01:00", "strict_ordinal_date_time");
            "2012-W01-8",
        assertSameDate("2018-12-31T10:15:30.123+01:00", "date_time");
        assertSameDate("2018-12-31T10:15:30.1Z", "date_time");
        assertSameDate("2012-W01-6", "strict_week_date");
        assertSameDate("2018-05-30T20:21:23.123Z", "date_optional_time");
        assertParseException("12:12:12", "strict_hour_minute_second_millis");
        assertSameMillis("-0001-01-01", "yyyy-MM-dd", "8uuuu-MM-dd");
        assertParseException("12:12:12.123456789", "hour_minute_second_millis");
        assertParseException("T10:15:3.1", "t_time");
    }
        String pattern = "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SS";
        assertParseException("2018-12-31T10:5:30", "strict_date_optional_time");
            format,
            String format = "year_month_day||ordinal_date";
    }
        DateTime dateTime = DateTimeFormat.forPattern("YYYY-MM-dd'T'HH:mm:ss.SSSZ")
import org.opensearch.common.time.DateFormatter;
import org.joda.time.format.DateTimeFormat;
        assertSameDate("2018-12-31T1:15:30+0100", "date_time_no_millis");
        DateFormatter javaFormatter = dateFormatter.withLocale(randomLocale(random()));
        assertSameDate("2001-01-01T00:00:00Z", "date_time_no_millis");
        assertSameDate("2018-10-10T10:11:12+0100", format, jodaFormatter, javaFormatter);
        assertSameDate("10:15:3.123Z", "time");
        assertSameDate("01", "strict_hour");
        assertSameDate("2012-1-31", "yearMonthDay");
        assertSameDate("1", "epoch_millis");
        assertParseException("10:15:3", "time_no_millis");
        assertSameDate("18-5-6", "date");
        assertSameDate("2018-12-31T10:15:30Z", "strict_date_optional_time");
        assertSameDate("2018W313T121212.123Z", "basic_week_date_time");
        assertSameDate("0", "epoch_second");
        assertSameDate("20181126T121212.123+10:00", "basic_date_time");
        assertSameDate("T10:15:30+01:00", "t_time_no_millis");
        assertSameDate("2012-W48-6T10:15:30.123456789Z", "strict_week_date_time");
        String javaZoneId = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz", Locale.getDefault()).format(parse);
    }
        assertSameDate("T10:15:30.1+01:00", "t_time");
        assertSameDate("2018-12-31T12:12:12.123", "date_hour_minute_second_millis");
    public void testCustomTimeFormats() {
        DateFormatter javaFormatter = DateFormatter.forPattern(javaPattern);
import java.time.ZoneId;
        assertSameDate("2012-W1-6", "week_date");
        assertSameDate("12:01", "strict_hour_minute");
        assertParseException("2018-1-31", "strict_date_optional_time");
        assertSameDate("2018-10-10T10:11:12,123Z", format, jodaFormatter, javaFormatter);
import org.joda.time.DateTimeZone;
        formatter2.parse("20181126T121212.123-0830");
        assertSameDate("2001-01-01", "date_optional_time");
        assertSameDate("2018-05", "date_optional_time");
        assertSameDate("2018-12-31", "strict_date_optional_time");
        assertThat(msg, jodaDateTime.getMillis(), is(zonedDateTime.toInstant().toEpochMilli()));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> jodaFormatter.parseJoda(input));
    // DateTime dateTimeNow = DateTime.now(DateTimeZone.UTC);
        assertSameMillis("2019-01-01T01:01:01.001Z", "YYYY-MM-dd'T'HH:mm:ss.SSSZ", "8yyyy-MM-dd'T'HH:mm:ss.SSSX");
        assertSameDate("12", "hour");
        assertSameDate("2012-W48-6T10:15:30.123+01:00", "strict_week_date_time");
        assertSameDate("T10:15:3Z", "t_time_no_millis");
         */
        assertSameDate("12:12:12.1", "hour_minute_second_fraction");
        assertSameDate("1-12-31", "yearMonthDay");
    private long dateMathToMillis(String text, DateFormatter dateFormatter) {
        assertSameDateAs("2001-01-01", "strict_date_optional_time_nanos", "strict_date_optional_time");
            javaFormat,
        assertSameDate("T121212+0100", "basic_t_time_no_millis");
        assertSameDate("2014-06-06T12:01:02.123", "strictDateTimeNoMillis||yyyy-MM-dd'T'HH:mm:ss.SSS");
 */
        assertParseException("2012-W1-1", "strict_weekyear_week_day");
        assertParseException("2018W313T12812+01:00", "strict_basic_week_date_time_no_millis");
        int month = randomIntBetween(1, 12);
        assertSameDate("2012-W1-6T10:15:30Z", "week_date_time_no_millis");
        assertSameDate("2012-W48-6T10:15:30Z", "week_date_time_no_millis");
        assertSameDateAs("2001", "iso8601", "strict_date_optional_time");
        assertParseException("T10:15:3.1", "strict_t_time");
        assertSameDate("2012-W1-6T10:15:30.1+01:00", "week_date_time");
 *
            DateFormatter jodaFormatter = Joda.forPattern(format);
                || format == FormatNames.RFC3339_LENIENT
        assertSameDate("T10:15:30.123456789Z", "strict_t_time");
        }
        assertSameDate("2018-12-31T10:15:3.1+01:00", "date_time");
        assertSameDate("2018-128T10:15:30.123Z", "ordinal_date_time");
        assertSameDateAs("2016-11-30T00+01:00", "strict_date_optional_time", "strict_date_optional_time");
    private void assertParseException(String input, String format) {
        assertSameDate("2018-1", "ordinal_date");
        assertSameDate("10:15:3.123+01:00", "time");
        assertSameDate("121212.123Z", "basic_time");
    }
        assertSameDate("2018-128T10:15:30.123Z", "strict_ordinal_date_time");
        assertSameDate("2012-W48-6T10:15:30.1+0100", "week_date_time");
        assertJodaParseException("2012-W1-8", "week_date", "Cannot parse \"2012-W1-8\": Value 8 for dayOfWeek must be in the range [1,7]");
        assertSameDate("10:5:30+0100", "time_no_millis");
        assertParseException("2018-12-31T10:15:3", "strict_date_optional_time");
    protected boolean enableWarningsCheck() {
        assertParseException("2018W313T12128Z", "strict_basic_week_date_time_no_millis");
           assertSameDateAs("2016-11-30T+01", "strict_date_optional_time", "strict_date_optional_time");
        );
        assertSameDate("2012-W48-6T10:15:30+0100", "strict_week_date_time_no_millis");
    public void testDecimalPointParsing() {
        assertSameDate("12:12:12", "hour_minute_second");
        assertSameDateAs("2016-11-30T12:00:00+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("2018-05-30T20:21:23.123+0100", "date_optional_time");
        assertSameDate("2018W313T121212.123Z", "strict_basic_week_date_time");
        assertSameDate("2018363T121212.123Z", "basic_ordinal_date_time");
        assertParseException("10:5:30Z", "strict_time_no_millis");
        assertSameDate("2018-10-10T10:11:12,123+05:30", format, jodaFormatter, javaFormatter);
        assertSameDate("2012-W48-6T10:15:30.123+0100", "strict_week_date_time");
        assertParseException("T1:15:30.123Z", "strict_t_time");
        assertDateMathEquals("2014-06-06T12:01:02.123", "strictDateTimeNoMillis||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("2018-12-31T10:15:3.123+0100", "date_time");
    public void testExceptionWhenCompositeParsingFailsDateMath() {
        assertSameDate("T10:1:30+0100", "t_time_no_millis");
    public void testSamePrinterOutputWithTimeZone() {
            input,
    // means that date part can be partially parsed.
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSS[XXXX][XXX]", Locale.ROOT);
        assertSameDate("2012-12", "strict_year_month");
        long gotMillisJoda = dateMathToMillis(text, Joda.forPattern(pattern));
            "Input [%s] JodaFormat [%s] JavaFormat [%s] Joda [%s], Java [%s]",
    public void testCompositeDateMathParsing() {
        assertParseException("2018-12-31T12:12:1", "strict_date_hour_minute_second");
    public void testParsingLocalDateFromYearOfEra() {
        // in joda 'Z' was able to parse 'Z' zulu but in java it fails. You have to use 'X' to do that.
        assertParseException("T10:15:3.123Z", "strict_t_time");
        assertParseException("12:12:1", "strict_hour_minute_second");
        assertSameDateAs("2016-11-30T12", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("1-1", "yearMonth");
        String javaTimeOut = dateFormatter.format(javaDate);
        assertSameDate("2018-12-31T10:15:30.123456789Z", "date_time");
    }
import org.opensearch.test.OpenSearchTestCase;
        assertSameDate("10:15:30.123Z", "time");
        assertSameDate("2001", "date_optional_time");
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_millis");
        assertSameDate("2018-1T10:15:30.123+01:00", "ordinal_date_time");
        assertParseException("2012-W1-6", "strict_week_date");
        assertParseException("10:15:3Z", "time");
        assertSameDate("9999", "date_optional_time||epoch_second");
    public void testSamePrinterOutput() {
        assertSameDate("10:15:30.123+01:00", "strict_time");
        assertSameDate("10:15:30.123456789Z", "strict_time");
 * under the License.
        org.joda.time.format.DateTimeFormatter isoFormatter = ISODateTimeFormat.dateTimeParser().withZone(DateTimeZone.UTC);
 * Unless required by applicable law or agreed to in writing,
        assertSameDate("T1:15:30.123+01:00", "t_time");
        formatter.parse("20181126T121212.123-08:30");
        assertParseException("10000-01-31", "strict_date_optional_time");
        assertJavaTimeParseException("2012-W1-8", "week_date");
            jodaDateTime,
        assertSameDate("2001-01-01T00:00:00,123Z", "date_optional_time");
        assertSameDate("T121212.123Z", "basic_t_time");
        assertSameDate("2018-10-10T10:11:12.123+0000", format, jodaFormatter, javaFormatter);
        String msg = String.format(
        /*
            }
        assertSameDate("2018-12-31T10:15:3.1+0100", "date_time");
        assertSameDate("10:15:30.123+01:00", "time");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertSameDate("121212+01:00", "basic_time_no_millis");
        long millisJava = DateFormatter.forPattern("8yyyy-MM-dd HH:mm:ss").parseMillis("2018-02-18 17:47:17");
        assertSameDate("121212.1+0100", "basic_time");
        assertSameDate("10:15:30Z", "strict_time_no_millis");
        assertSameDate("2012-W48-6", "week_date");
        assertSameDate("2018-12-31T10:15:3.1Z", "date_time");
        assertSameDate("121212+0100", "basic_time_no_millis");
    public void testSeveralTimeFormats() {
        assertSameDate("01:15:30Z", "strict_time_no_millis");
            jodaDateString,
        assertSameDate("2018-128T10:15:30.123+0100", "ordinal_date_time");
            "expected string representation to be equal for format [%s]: joda [%s], java [%s]",
        assertSameDate("T121212.123456789Z", "basic_t_time");
/*
 * software distributed under the License is distributed on an
    }
        assertSameDate("1", "weekyear");
        assertSameDate("2018W313T121212+0100", "basic_week_date_time_no_millis");
 * license agreements. See the NOTICE file distributed with
        {
        assertSameDate("2018-128T10:15:30+0100", "ordinal_date_time_no_millis");
    public void testParsingMissingTimezone() {
        assertSameDate("2018-12-31T10:15:30", "date_optional_time");
        return false;
            assertSameDate("31-01-2014", format, jodaFormatter, javaFormatter);
        assertSameDate("10:15:30+0100", "strict_time_no_millis");
        assertSameDate("12:12:12.123456789", "hour_minute_second_fraction");
import static org.hamcrest.Matchers.containsString;
        assertSameDate("2010 12 06 11:05:15", "yyyy dd MM HH:mm:ss");
        String text = "2014-06-06T12:01:02.123";
        assertParseException("12:12:12", "hour_minute_second_millis");
        assertSameDate("2018W313T121212.123456789Z", "strict_basic_week_date_time");
        assertParseException("T10:1:30Z", "strict_t_time_no_millis");
        assertSameDate("2018-12-31T12:12", "strict_date_hour_minute");
        assertSameDate("2018W313", "basic_week_date");
        assertSameDate("2018-12-31T10:5:30+01:00", "date_time_no_millis");
        assertSameDate("2018363T121212Z", "basic_ordinal_date_time_no_millis");
        assertParseException("2012-W1-6", "strict_week_date");
        assertSameDate("2018-128T10:15:30Z", "strict_ordinal_date_time_no_millis");
 * this work for additional information regarding copyright
        assertSameDate("2018-128T10:15:30+01:00", "strict_ordinal_date_time_no_millis");
        assertSameDate("2012-W01-6", "week_date");
        assertSameDate("12:12:12.123", "hour_minute_second_fraction");
 * SPDX-License-Identifier: Apache-2.0
        assertSameDate("1:15:30+01:00", "time_no_millis");
        assertSameDate("2018-12-31T10:15:30.1+0100", "date_time");
        assertSameDate("T1:15:30Z", "t_time_no_millis");
    }
        assertSameDate("2018-12-31T10:15:30.1+01:00", "strict_date_time");
        String jodaTimeOut = jodaDateFormatter.formatJoda(jodaDate);
        assertThat(message, javaTimeOut, is(jodaTimeOut));
 *
    }
        assertSameDate("2018W313T121212.1+0100", "strict_basic_week_date_time");
    //
import org.opensearch.common.time.DateMathParser;
        assertSameDateAs("2001-01", "iso8601", "strict_date_optional_time");
        assertSameDate("1:15:30.1Z", "time");
        assertSameDate("T10:15:30.1+0100", "strict_t_time");
        assertSameDate("-2000", "year");
        assertSameDate("2018-10-10", format, jodaFormatter, javaFormatter);
        assertSameDate("12/06", "dd/MM");
        assertParseException("10:15:3.1", "time");
        // joda comes up with a different exception message here, so we have to adapt
        assertSameDate("10:15:30.123+0100", "time");
            DateFormatter jodaFormatter = Joda.forPattern(format);
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_fraction");
        assertSameDate("2012-W48-6T10:15:30.1+01:00", "strict_week_date_time");
            input,
        assertSameDate("01:15:30Z", "time_no_millis");
        assertSameDate("20181126", "basic_date");
        assertSameDate("2018-05-30T20:21:23.1+01:00", "date_optional_time");
        DateFormatter javaFormatter = DateFormatter.forPattern(format);
        DateFormatter javaFormatter = DateFormatter.forPattern(format);
        assertSameDate("2018-12-31T12:12:12.123456789", "date_hour_minute_second_fraction");
        assertSameDate("2018W313T121212.1Z", "basic_week_date_time");
        assertSameDate("2012-12-31", "strict_year_month_day");
        assertSameDate("2018-10-10T10:11:12,123", format, jodaFormatter, javaFormatter);
    }
        assertSameDate("2018-05-30T20:21:23", "date_optional_time");
        assertParseException("2018-1", "strict_ordinal_date");
        assertSameDate("1", "hour");
import org.opensearch.common.time.DateFormatters;
        assertSameDate("1522332219321", "epoch_millis");
    // assertSameDate("Di., 05 Dez. 2000 02:55:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));
    }
        assertSameDate("2018-128", "strict_ordinal_date");
        */
            jodaDateTime,
        assertSameDate("2018363T121212.123456789Z", "basic_ordinal_date_time");
        assertSameDate("2018", "weekyear");
        assertSameDate("2018W313T121212Z", "basic_week_date_time_no_millis");
        assertParseException("2018-1T10:15:30.123Z", "strict_ordinal_date_time");
            jodaTimeOut,
        assertSameDate("T10:15:3.123Z", "t_time");
            assertSameDate("2018-12-12", format, jodaFormatter, javaFormatter);
    }
        assertSameDate("12:12:12.1", "hour_minute_second_millis");
            .parseDateTime("2019-01-01T01:01:01.001+0000");
        assertSameDate("2018-128T10:15:30.123+0100", "strict_ordinal_date_time");
    }
        assertSameDate("2018-12-31T10:15:30", "strict_date_optional_time");
        assertSameDate("2018-05-30T20:21:23.1+0100", "date_optional_time");
        assertSameDateAs("2016-11-30T", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("12:01", "hour_minute");
        assertSameDate("20181126T121212+01:00", "basic_date_time_no_millis");
        formatter2.parse("20181126T121212.123+1030");
        assertSameDate("10:15:3.123+0100", "time");
        assertThat(formatter.pattern(), is(pattern));
        assertThat(e2.getMessage(), containsString(pattern));
    // assertSamePrinterOutput("E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"), javaTimeNow, dateTimeNow);
        int minute = randomIntBetween(0, 59);
        assertSameDate("2018-12-31T10:5:30Z", "date_time_no_millis");
        assertParseException("2012-W1-8", "strict_week_date");
        assertSameDate("10:1:30.123+01:00", "time");
        assertSameDate("2018-12-31T10:15:30.11+0100", "strict_date_time");
        String jodaZoneId = DateTimeFormat.forPattern("YYYY-MM-dd'T'HH:mm:ss.SSSz").print(dateTime);
        assertSameDate("2018-12-31T10:15:30.1+01:00", "date_time");
        assertParseException("10:15:3", "strict_time_no_millis");
        assertSameDate("10:5:30Z", "time_no_millis");
        assertSameDate("2018-12-31T12", "date_hour");
            OpenSearchParseException.class,
        assertParseException("2018-W1", "strict_weekyear_week");
        assertSameDate("20181126T121212.123-0800", "basic_date_time");
/*
        assertThat(jodaDate.getMillis(), is(javaDate.toInstant().toEpochMilli()));
        assertParseException("T10:15:3", "t_time_no_millis");
        assertSameDate("T10:15:30.1Z", "t_time");
import java.util.Locale;
        assertParseException("10:1:30.123Z", "strict_time");
        assertSameDate("10:15:30Z", "time_no_millis");
        String message = String.format(
        assertThat(e1.getMessage(), containsString(pattern));
        assertSameDate("12:12:12.123", "strict_hour_minute_second_millis");
    private void assertSamePrinterOutput(String format, ZonedDateTime javaDate, DateTime jodaDate) {
        assertSameDate("2018-12-31T1:15:30+01:00", "date_time_no_millis");
        assertSameDate("12:12", "strict_hour_minute");
        assertSameDateAs("2016-11-30T+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("2018-12-31T10:15:30.11+01:00", "strict_date_time");
    }
package org.opensearch.common.joda;
        assertSameDate("2018-128T10:15:30.1Z", "ordinal_date_time");
    // assertSameDate("Do., 07 Dez. 2000 00:00:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));
        assertParseException("12:1", "strict_hour_minute");
        assertSameDate("2018W313T121212Z", "strict_basic_week_date_time_no_millis");
import java.time.temporal.TemporalAccessor;
        assertSameDate("1:15:30Z", "time_no_millis");
        assertParseException("2018W313T81212+0100", "strict_basic_week_date_time_no_millis");
        assertSameDate("2012-W1-6T10:15:30.1+0100", "week_date_time");
        assertSameDate("2018", "strict_weekyear");
    private void assertSameMillis(String input, String jodaFormat, String javaFormat) {
            Locale.ROOT,
import org.joda.time.format.ISODateTimeFormat;
        assertSameDate("2018W313", "strict_basic_week_date");
import org.opensearch.OpenSearchParseException;
        assertSameDate("20181126T121212.123Z", "basic_date_time");
    // // also ensure that locale based dates are the same
 * specific language governing permissions and limitations
        assertParseException("12:12:12", "strict_hour_minute_second_fraction");
        assertParseException("1", "strict_weekyear");
        assertSameDate("2018-128T10:15:30.1Z", "strict_ordinal_date_time");
        DateFormatter jodaFormatter = Joda.forPattern(format);
        assertSameDate("2012-W1-6T10:15:30+01:00", "week_date_time_no_millis");
            "strict_week_date",
        assertThat(e.getMessage(), containsString(expectedMessage));
        assertSameDate("2018-128T10:15:30.123+01:00", "ordinal_date_time");
        DateTime jodaDate,
    }
    public void testTimezoneParsing() {
            String format = "strictDateOptionalTime||dd-MM-yyyy";
    public void testExceptionWhenCompositeParsingFails() {
        assertSameDate("T10:15:30Z", "t_time_no_millis");
        assertSameDate("2012-W48-6T10:15:30.123Z", "week_date_time");
        assertSameDate("2018W313T121212.1+01:00", "strict_basic_week_date_time");
        assertEquals(gotMillisJoda, gotMillisJava);
    @Override
 * this file be licensed under the Apache-2.0 license or a
            format,
        TemporalAccessor javaDate = javaFormatter.parse(dateInput);
        assertSameDate("2018-10-10T10", format, jodaFormatter, javaFormatter);
        assertSameDate("2012-W48-6T10:15:30+0100", "week_date_time_no_millis");
        assertSameDate("2018363", "basic_ordinal_date");
        assertParseException("2018W313T12812.123Z", "strict_basic_week_date_time");
        assertSameDate("2018-12-31T12", "strict_date_hour");
    public void testPartialTimeParsing() {
        assertSameDate("2018-12-31T12:12:12", "date_hour_minute_second");
        assertSameDate("2018-12-31T12:12:12.123", "date_hour_minute_second_fraction");
        assertSameDate("1522332219", "epoch_second");
    ) {
        assertDateMathEquals("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("2018363T121212+0100", "basic_ordinal_date_time_no_millis");
        assertSameDate("0", "epoch_millis");
        because StrictDateOptionalTime confuses +01 with an hour (which is a signed fixed length digit)
        assertParseException("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SS");
        assertSameDate("T121212+01:00", "basic_t_time_no_millis");
        assertSameDate("2018-12-31T12:12:12.1", "strict_date_hour_minute_second_millis");
import org.opensearch.common.time.FormatNames;
        assertSameDate("10:1:30.123Z", "time");
}
        assertSameDate("2018W313T121212+0100", "strict_basic_week_date_time_no_millis");
        assertSameMillis("2019-01-01", "YYYY-MM-dd", "8yyyy-MM-dd");
        assertThat(e.getMessage(), containsString(input));
        // 'z' zoneId in joda prints UTC whereas joda prints 'Z' for zulu
        assertSameDate("2001", "strict_date_optional_time");
        assertSameDate("2012-W1-1", "weekyear_week_day");
        assertParseException("2018-12-31T10:15:3Z", "strict_date_time_no_millis");
    private void assertDateMathEquals(String text, String pattern) {
        DateFormatter javaFormatter = DateFormatter.forPattern("strict_date_optional_time_nanos");
        assertSameDate("2018-1T10:15:30.123456789Z", "ordinal_date_time");
    }
        assertSameDate("2018-12-31T10:15:30.123+01:00", "strict_date_time");
    // the iso 8601 parser is available via Joda.forPattern(), so we have to test this slightly differently
    private void assertJavaTimeParseException(String input, String format) {
        assertSameDate("12:12:12", "strict_hour_minute_second");
        assertSameDate("2018-128T10:15:30.123+01:00", "strict_ordinal_date_time");
        assertSameDate("2012-W01-6", "strict_week_date");
        assertSameDate("10:1:30.123+0100", "time");
        assertParseException("T10:1:30.123Z", "strict_t_time");
    }
        assertSameDate("2012-W48-6T10:15:30+01:00", "strict_week_date_time_no_millis");
        assertSameDate("10:5:30+01:00", "time_no_millis");
        assertSameDate("2018-W01", "strict_weekyear_week");
        assertSameDate("2012-W48-6T10:15:30.1Z", "week_date_time");
        assertJavaTimeParseException("2016-11-30T+01", "strict_date_optional_time");
 * KIND, either express or implied.  See the License for the
        assertParseException("2001-01-01T00:00:00.123,456Z", "date_optional_time");
        assertSameDate("2018-12-31T10:15:3+0100", "date_time_no_millis");
        assertParseException("T10:15:3Z", "strict_t_time");
        assertSameDate("2001-01-01T00:00:00,123Z", "strict_date_optional_time");
        assertParseException("1:15:30.123Z", "strict_time");
        assertSameDate("1:15:30.123+01:00", "time");
        );
        assertJavaTimeParseException("2012-W01-8", "strict_week_date");
        }
        assertSameDate("10:15:30.123456789Z", "time");
 * compatible open source license.
        assertSameDate("2018-05-30T20", "date_optional_time");
        assertSameDate("2018-1T10:15:30+0100", "ordinal_date_time_no_millis");
        String format,
        assertSameDate("2018-12-31", "date");
        {
    public void testPartialDateParsing() {
        assertSameDate("2018-W1", "weekyear_week");
        DateFormatter jodaFormatter = Joda.forPattern("strict_date_optional_time");
        String msg = String.format(
        assertParseException("1", "strict_year");
        assertSameDate("T10:15:30.1+01:00", "strict_t_time");
        }
    }
        assertSameDate("2018-05-30T20:21:23.1", "date_optional_time");
        assertParseException("1", "strict_weekyear");
        assertSameDate("2012-W1-6T10:15:30+0100", "week_date_time_no_millis");
        assertSameDate("12:12:01", "hour_minute_second");
        assertSameDate("T10:15:30.123456789Z", "t_time");
        String format = "strict_date_optional_time";
    public void testDuelingStrictParsing() {
        DateMathParser javaDateMath = javaFormatter.toDateMathParser();
        assertSameDate("2012-W1-6T10:15:30.1Z", "week_date_time");
        assertSameDate("12:12:12.1", "strict_hour_minute_second_fraction");
    }
        assertSameDate("2018-05-30T20:21", "date_optional_time");
        assertSameDate("2018-12-31T12:12", "date_hour_minute");
        assertSameDate("2001-01", "strict_date_optional_time");
        assertSameDate("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss+HH:MM||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("2018-12-31T10:15:30.11Z", "strict_date_time");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSSXXX", Locale.ROOT);
        assertSameDateAs("2016-11-30T12:00+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSamePrinterOutput(format, javaDate, jodaDate, dateFormatter, jodaDateFormatter);
        assertSameDateAs("2016-11-30T12:00:00.000+01", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("2018-12-31T10:15:30+0100", "strict_date_optional_time");
        assertSameDate("2012-W48-6T10:15:30.123+0100", "week_date_time");
        String format = "iso8601";
 * ownership. Elasticsearch licenses this file to you under
import org.joda.time.DateTime;
            .withOffsetParsed()
    //
    }
        assertSameDate("2012-W1-6T10:15:30.123+01:00", "week_date_time");
        long millisJoda = DateFormatter.forPattern("yyyy-MM-dd HH:mm:ss").parseMillis("2018-02-18 17:47:17");
        assertParseException("2018W313T12812Z", "strict_basic_week_date_time_no_millis");
        assertSameDate("10:15:30.123+0100", "strict_time");
        assertSameDate("2018-10-10T10:11:12.123", format, jodaFormatter, javaFormatter);
 * the Apache License, Version 2.0 (the "License"); you may
        assertSameDate("2012-W31-5", "weekyear_week_day");
    public void testDuellingFormatsValidParsing() {
        DateFormatter javaFormatter = DateFormatter.forPattern(format);
    }
        assertParseException("2018-12-31T1:15:30.123Z", "strict_date_time");
        assertSameDate("2012-W48-6T10:15:30Z", "strict_week_date_time_no_millis");
    public void testTimeZoneFormatting() {
        assertSameDate("T121212.123+01:00", "basic_t_time");
        assertSameDate("01:15:30+0100", "strict_time_no_millis");
        This does not work in Joda as it reports 2016-11-30T01:00:00Z
        assertThat(javaZoneId, equalTo("2019-01-01T01:01:01.001Z"));
        assertSameDate("12:12:1", "hour_minute_second");
        assertParseException("2018-12-31T12:12:12", "strict_date_hour_minute_second_fraction");
            javaTimeOut
        assertParseException("2012-W1-6T10:15:30Z", "strict_week_date_time_no_millis");
        formatter3.parse("20181126T121212.123+1030");
import java.time.ZoneOffset;
        assertParseException("1", "strict_hour");
        assertSameDate("2012-W48-6T10:15:30.123456789Z", "week_date_time");
        int second = randomIntBetween(0, 59);
        int hour = randomIntBetween(0, 23);
    }
        assertSameDate("T10:15:30.123+01:00", "t_time");
        assertSameDate("T10:1:30+01:00", "t_time_no_millis");
        TemporalAccessor javaTimeAccessor = javaFormatter.parse(input);
        assertSameDate("T10:15:30.123+01:00", "strict_t_time");
        assertDateMathEquals("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss+HH:MM||yyyy-MM-dd'T'HH:mm:ss.SSS");
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_fraction");
        assertSameDate("T1:15:30.123Z", "t_time");
    // public void testCustomLocales() {
    // date_optional part of a parser names "strict_date_optional_time" or "date_optional"time
        assertSameDate(input, format, jodaFormatter, javaFormatter);
            DateFormatter javaFormatter = DateFormatter.forPattern(format);
        assertSameDate("18W313", "basic_week_date");
        for (FormatNames format : FormatNames.values()) {
        assertSameDate("121212.123+01:00", "basic_time");
    public void testDateFormatterWithLocale() {
 * GitHub history for details.
        // only java.time has nanos parsing, but the results for 3digits should be the same
        assertSameDate("2018", "strict_weekyear");
        assertParseException("2018-1T10:15:30Z", "strict_ordinal_date_time_no_millis");
        assertSameDateAs("2001-01", "strict_date_optional_time_nanos", "strict_date_optional_time");
        assertSameDate("1W313", "basic_week_date");
        assertSameDate("1:15:30.123Z", "time");
        assertSameDate("2001-01-01T00:00:00.123Z", "date_optional_time");
        assertSameDate("2018-12-31T12:12:12.1", "strict_date_hour_minute_second_fraction");
        assertSameDate("2018-12-31T10:15:30+0100", "strict_date_time_no_millis");
        assertSameDate("10:15:30.1Z", "time");
        assertSameDate("T10:1:30.123+01:00", "t_time");
            Locale.ROOT,
        assertSameDate("2012", "strict_year");
        assertSameDate("2018-12-31T10:15:30Z", "date_time_no_millis");
        ES java.time implementation does not suffer from this,
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> javaTimeFormatter.parse(input));
        // in joda 'y' means year, this is changed to 'u' in java.time. difference is in before era yeaers
        assertSameDate("-2000", "strict_year");
        assertThat(e.getMessage(), containsString(format));
        assertSameDate("10:15:3+01:00", "time_no_millis");
        assertSameDate("2018-12-31T10:15:3Z", "date_time_no_millis");
        assertSameDate("2018-05-30T20:21:23.123456789Z", "date_optional_time");
        assertParseException("2018-12-31T1:15:30Z", "strict_date_time_no_millis");
        return javaDateMath.parse(text, () -> 0, true, (ZoneId) null).toEpochMilli();
        assertSameDate("2018-128", "ordinal_date");
        assertSameDate("2018W313T121212.123+0100", "strict_basic_week_date_time");
/*
        assertSameDate("2018-10-10T", format, jodaFormatter, javaFormatter);
        assertParseException("T10:15:3Z", "strict_t_time_no_millis");
        assertSameDate("1", "epoch_second");
        assertSameMillis("2019-01-01T01:01:01.001+0000", "YYYY-MM-dd'T'HH:mm:ss.SSSZ", "8yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        assertSameDate("2018363T121212+01:00", "basic_ordinal_date_time_no_millis");
        assertSameDate("2001-01-01T00:00:00-08", "date_time_no_millis");
        assertSameDate("2018-1T10:15:30.123Z", "ordinal_date_time");
        assertSameDate("T10:15:3.123+0100", "t_time");
        assertParseException("2018W313T12812.1Z", "strict_basic_week_date_time");
        assertSameDate("2018-12-31T8:3", "date_hour_minute");
        assertSameDate("121212.123+0100", "basic_time");
        assertParseException("1:15:30Z", "strict_time_no_millis");
    private void assertSamePrinterOutput(
        assertSameDate("10:1:30.1Z", "time");
public class JavaJodaTimeDuellingTests extends OpenSearchTestCase {
        assertSameDate("2018-10-10T10+0430", format, jodaFormatter, javaFormatter);
        assertThat(e1.getMessage(), containsString(text));
        assertSameDate("2001-01-01T00:00:00.123Z", "strict_date_optional_time");
        assertSameDate("10:15:30.123Z", "strict_time");
 * Modifications Copyright OpenSearch Contributors. See
        assertSameDate("T10:15:30+0100", "t_time_no_millis");
        assertSameDate("2012-W48-6T10:15:30.1Z", "strict_week_date_time");
        assertSameDate("2018-12-31T10:15:30.123+0100", "strict_date_time");
        assertParseException("2018-12-31T12:12:12", "strict_date_hour_minute_second_millis");
        assertParseException("2012-1-31", "strict_year_month_day");
 * Licensed to Elasticsearch under one or more contributor
    public void testCompositeParsing() {
        assertSameDate("T10:15:30Z", "strict_t_time_no_millis");
        assertSameDate("2018-12-31", "strict_date");
        assertParseException("2018-12-31T10:5:30.123Z", "strict_date_time");
        assertSameDate("12:12:12.123456789", "strict_hour_minute_second_fraction");
        assertSameDate("2018-10-10T10:11:12", format, jodaFormatter, javaFormatter);
        assertSameDate("2018-12-31T10:5:30+0100", "date_time_no_millis");
                || format == FormatNames.STRICT_DATE_OPTIONAL_TIME_NANOS
        assertSameDate("20181126T121212+0100", "basic_date_time_no_millis");
        assertParseException("2018W313T12128.123Z", "strict_basic_week_date_time");
        assertSameDate("2018-12-31T10:15:30+01:00", "strict_date_optional_time");
        assertSameDate("10000-5-6", "date");
        assertSameDate("2001-01-01T00:00:00+1030", "date_time_no_millis");
        assertSameDate("01:15:30+01:00", "strict_time_no_millis");
        assertSameDate("2018-12-31T10:15:30+01:00", "strict_date_time_no_millis");
        assertSameDate("2018-12-31T12:12:12.123", "strict_date_hour_minute_second_fraction");
        assertSameDate("2018-12-31T10:15:3.123456789Z", "date_time");
            DateTimeFormatter.ISO_INSTANT.format(zonedDateTime.toInstant())
        assertSameDate("2018-05-30T20:21:23.123", "date_optional_time");
        assertSameDate("10:15:3.1Z", "time");
 * You may obtain a copy of the License at
        assertSameDate("12:12:12.1", "strict_hour_minute_second_millis");
        assertSameDate("2012-W48-6", "strict_week_date");
 */
    }
        assertThat(e2.getMessage(), containsString(text));
        assertSameDate("T10:15:30.123Z", "t_time");
        assertParseException("10000-12-31", "strict_date");
        assertSameDate("121212.123456789Z", "basic_time");
        );
        assertSameDate("12:1", "hour_minute");
        assertSameDate("2018-10-10T10:11-08:00", format, jodaFormatter, javaFormatter);
        assertSameDate("2012-W1-6T10:15:30.123Z", "week_date_time");
        assertSameDate("2001-01-01T00:00:00-0800", "date_time_no_millis");
        assertSameDate("2018-1T10:15:30.1Z", "ordinal_date_time");
        assertSameDateAs("2001", "strict_date_optional_time_nanos", "strict_date_optional_time");
    // ZonedDateTime javaTimeNow = Instant.ofEpochMilli(dateTimeNow.getMillis()).atZone(ZoneOffset.UTC);
            Locale.ROOT,
        assertSameDate("2018-128T10:15:30.123456789Z", "ordinal_date_time");
        // in all these examples the second pattern will be used
        assertSameDate("2018-12-31T10:15:30.11+0100", "date_time");
    }
        assertParseException("1-1", "strict_year_month");
        String pattern = randomBoolean() ? "strict_date_optional_time||date_time" : "date_time||strict_date_optional_time";
import java.time.ZonedDateTime;
    // assertSameDate("Fr., 08 Dez. 2000 00:00:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));
        assertSameDate("T121212.1Z", "basic_t_time");
        DateTime jodaDate = new DateTime(year, month, day, hour, minute, second, DateTimeZone.UTC);
        String javaDateString = javaFormatter.withZone(ZoneOffset.ofHours(-1)).format(javaDate);
        assertSameDate("2018-12-31T10:15:30+01:00", "date_time_no_millis");
        assertSameDate("2018-10-10T10:11", format, jodaFormatter, javaFormatter);
        DateFormatter jodaDateFormatter
            format,
        formatter3.parse("20181126T121212.123Z");
        assertSameDate("2018-12-31T10:15:3", "date_optional_time");
        assertSameDate("T121212Z", "basic_t_time_no_millis");
        assertParseException("10:15:3Z", "strict_time");
        // without timezone
            "expected string representation to be equal for format [%s]: joda [%s], java [%s]",
        assertThat(formatter.locale(), is(locale));
    private void assertSameDate(String input, String format) {
        assertSameDateAs("2016-11-30T00+01", "strict_date_optional_time", "strict_date_optional_time");
            assertSamePrinterOutput(format.getSnakeCaseName(), javaDate, jodaDate);
        assertSameDate("2018-12-31T10:15:30+0100", "date_time_no_millis");
        assertSameDate("2012-12", "yearMonth");
        assertParseException("10:15:3.123Z", "strict_time");
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertParseException("2001-01-01T00:00:00.123,456Z", "strict_date_optional_time");
        // with strict resolving, YearOfEra expect an era, otherwise it won't resolve to a date
        assertSameDateAs("2016-11-30T12:00:00.000", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("10:15:30+0100", "time_no_millis");
        assertSameDate("01", "hour");
        ZonedDateTime javaDate,
        assertSameDate("T10:15:30.1+0100", "t_time");
        assertSameDate("10:15:30+01:00", "strict_time_no_millis");
            assertSameDate("2018-128", format, jodaFormatter, javaFormatter);
        assertSameDate("T1:15:30.123+0100", "t_time");
        assertSameDate("2018-10-10T10:11Z", format, jodaFormatter, javaFormatter);
        assertSameDate("T10:15:30.123+0100", "strict_t_time");
                || format == FormatNames.EPOCH_MICROS) {
        assertParseException("2012-W1-6T10:15:30.123Z", "strict_week_date_time");
        assertSameDate("12:12:12.123", "strict_hour_minute_second_fraction");
        assertSameDateAs("2016-11-30T12:00:00", "strict_date_optional_time", "strict_date_optional_time");
        assertSameDate("1:15:30+0100", "time_no_millis");
    }
        assertSameDate("T10:15:3+0100", "t_time_no_millis");
        ZonedDateTime javaDate = ZonedDateTime.of(year, month, day, hour, minute, second, 0, ZoneOffset.UTC);
        assertSameDate("2018W313T121212+01:00", "basic_week_date_time_no_millis");
        assertSameDate("2018-12-31T12:12:12.123456789", "strict_date_hour_minute_second_fraction");
        OpenSearchParseException e1 = expectThrows(
        /* this testcase won't work in joda. See comment in {@link #testPartialTimeParsing()}
        assertSameDate("2012-W48-6", "strict_week_date");
        assertSameDateAs("2001-01-01", "iso8601", "strict_date_optional_time");
        assertSameDate("12:12", "hour_minute");
        assertSameDate("20181126T121212Z", "basic_date_time_no_millis");
        assertSameDate("2018-12-31T1:15:30", "date_optional_time");
        assertSameDate("12:12:12.123", "hour_minute_second_millis");
        assertSameDate("T10:15:30.123Z", "strict_t_time");
        assertSameDate("12", "strict_hour");
        assertSameDate("2012-W48-6T10:15:30.123Z", "strict_week_date_time");
        assertParseException("2018-12-31T10:5:30Z", "strict_date_time_no_millis");
import static org.hamcrest.CoreMatchers.startsWith;
        assertSameDate("2001-01-01T00:00:00.123Z", "strict_date_optional_time_nanos", jodaFormatter, javaFormatter);
    }
        assertSameDate(input, javaPattern, jodaFormatter, javaFormatter);
        assertParseException("T10:15:3", "strict_t_time_no_millis");
        String message = String.format(
        long gotMillisJava = dateMathToMillis(text, DateFormatter.forPattern(pattern));
        assertParseException("18W313", "strict_basic_week_date");
    // assertSameDate("Mi., 06 Dez. 2000 02:55:00 -0800", "E, d MMM yyyy HH:mm:ss Z", LocaleUtils.parse("de"));
        // both parsing failures should contain pattern and input text in exception
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSSXXXX", Locale.ROOT);
        assertParseException("T10:15:3Z", "t_time");
        assertSameDate("2018-12-31T12:12:12.1", "date_hour_minute_second_millis");
        assertSameDate("2010-01-05T02:00", "strict_date_optional_time");
            Locale.ROOT,
        assertSameDate("12:12:01", "strict_hour_minute_second");
            if (format == FormatNames.ISO8601
        assertSameDate("2018-12-31T10:15:3.123+01:00", "date_time");
        assertSameDate("2018-12-31T10:15:30.1Z", "strict_date_time");
        assertSameDate("2018-05-30T20:21:23.123+01:00", "date_optional_time");
        assertSameDate("T1:15:30+01:00", "t_time_no_millis");
    public void testIncompatiblePatterns() {
        assertSameDate("10:15:3+0100", "time_no_millis");
    }
        assertParseException("10:15:3.1", "strict_time");
        int year = randomIntBetween(1970, 2030);
        DateFormatter jodaFormatter = Joda.forPattern(jodaPattern);
        assertSameDate("2018-128T10:15:30+01:00", "ordinal_date_time_no_millis");
        assertSameDate("2018-128T10:15:30.1+0100", "strict_ordinal_date_time");
        // year-of-era in joda becomes 'y' in java.time
        assertSameDate("2018363T121212.123+0100", "basic_ordinal_date_time");
        assertJodaParseException(
            "Input [%s] Format [%s] Joda [%s], Java [%s]",
    }
        assertSameDate("2018-W29", "weekyear_week");
        assertSameDate("2012-W1-6T10:15:30.123+0100", "week_date_time");
        assertSameDate("2001-01-01", "strict_date_optional_time");
        assertSameDate("2018W313T121212.123456789Z", "basic_week_date_time");
 * The OpenSearch Contributors require contributions made to
        String jodaDateString = jodaFormatter.withZone(ZoneOffset.ofHours(-1)).formatJoda(dateTime);
        assertSameDate("2018-12-31T10:15:30.123Z", "strict_date_time");
        // This should fail, but java is ok with this because the field has the same value
        assertSameDate("T10:15:3+01:00", "t_time_no_millis");
        assertThat(msg, jodaDateTime.getMillis(), is(zonedDateTime.toInstant().toEpochMilli()));
        assertSameDate("2018-12-31T12:12:1", "date_hour_minute_second");
        assertParseException("2018-12-31T8", "strict_date_hour");
        assertSameDate("2018-12-31T10:15:30.11Z", "date_time");
        assertSameDate("10:15:30.1Z", "strict_time");
        assertSameDate("2018-12-31T10:15:30Z", "strict_date_time_no_millis");
        assertSameDate("2018-128T10:15:30+0100", "strict_ordinal_date_time_no_millis");
        assertSameDateAs("2016-11-30T00+0100", "strict_date_optional_time", "strict_date_optional_time");
        assertParseException("2018W313T81212Z", "strict_basic_week_date_time_no_millis");
        assertSameDate("T10:15:30+01:00", "strict_t_time_no_millis");
        assertSameDate("01:15:30+01:00", "time_no_millis");
        DateTime jodaDateTime = jodaFormatter.parseJoda(input);
        assertParseException("12:12:12", "hour_minute_second_fraction");
        assertSameDate("2012-W31-5", "strict_weekyear_week_day");
        assertSameDate("2018363", "yyyyDDD", Joda.forPattern("YYYYDDD"), DateFormatter.forPattern("uuuuDDD"));
        assertSameDate("2012-W48-6T10:15:30.1+01:00", "week_date_time");
        assertSameDate("2018-12-31T10:15:30.123456789Z", "strict_date_time");
        assertSameDate("T1:15:30+0100", "t_time_no_millis");
        assertSameDate("1:15:30.123+0100", "time");
        assertSameDate("2018-12-31T8", "date_hour");
    // these parsers should allow both ',' and '.' as a decimal point
        assertThat(jodaZoneId, startsWith("2019-01-01T01:01:01.001"));
            jodaFormat,
        OpenSearchParseException e2 = expectThrows(OpenSearchParseException.class, () -> dateMathToMillis(text, Joda.forPattern(pattern)));
        );
        assertSameDate("2012", "year");
        assertSameDate("2015-01-04T00:00Z", "strict_date_optional_time");
        assertSameDate("2018-12-31T12:12:12.1", "strict_date_hour_minute_second_fraction");
        assertParseException("2018-12-31T9:15:30", "strict_date_optional_time");
        assertSameDate("2001-01", "date_optional_time");
        assertSameDate("2018-12-31T12:12:12", "strict_date_hour_minute_second");
        assertSameDate("T10:1:30.123Z", "t_time");
        assertSameDate("2018-12-31T10:15:3+01:00", "date_time_no_millis");
import java.time.format.DateTimeFormatter;
        assertSameDate("2012-W48-6T10:15:30+01:00", "week_date_time_no_millis");
        assertSameDate("2018-12-31T12:12:12.123", "strict_date_hour_minute_second_millis");
        assertSameDate("2018W313T121212.1Z", "strict_basic_week_date_time");
        assertSameDate("T10:15:30.123+0100", "t_time");
        DateFormatter jodaFormatter = Joda.forPattern(format);
        assertSameDate("2018W313T121212.123+01:00", "basic_week_date_time");
    }
                // Nanos aren't supported by joda
        assertSameDate("T121212.123+0100", "basic_t_time");
        assertSameDate("2018-1T10:15:30Z", "ordinal_date_time_no_millis");
        assertSameDate("2014-06-06T12:01:02.123", "yyyy-MM-dd'T'HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SSS");
    public void testIso8601Parsers() {
        TemporalAccessor parse = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz", Locale.getDefault())
        assertSameDate("2018-12-31T10:15:30.123+0100", "date_time");
        assertParseException("2018-12-1", "strict_date_optional_time");
            DateFormatter javaFormatter = DateFormatter.forPattern(format);
        assertParseException("2012-12-1", "strict_year_month_day");
        // ... and can be combined, note that this is not an XOR, so one could append both timezones with this example
 *
        assertJavaTimeParseException(input, format);
        DateTime jodaDateTime = jodaFormatter.parseJoda(input);
        assertParseException("2018W313T12812+0100", "strict_basic_week_date_time_no_millis");
            .parse("2019-01-01T01:01:01.001+00:00");
