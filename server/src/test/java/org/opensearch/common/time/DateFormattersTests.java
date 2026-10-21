            assertThat(instant.getNano(), is(768000000));
        Clock clock = Clock.fixed(ZonedDateTime.of(2019, 02, 8, 11, 43, 00, 0, ZoneOffset.UTC).toInstant(), ZoneOffset.UTC);
            assertThat(instant.getNano(), is(123_400_000));
            assertThat(millisFormatter.format(Instant.ofEpochSecond(42, 0)), is("42000"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        assertThat(epochSecondFormatter.hashCode(), is(DateFormatters.forPattern("epoch_second").hashCode()));
        {
        formatter.format(formatter.parse("2018-05-15"));
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("2018-05-15T17:14:56+0100")
    }
            "strictHour",
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "2018-10-10T12:13:14.123Z", 1539173594123L);
            assertThat(millisInstant.toEpochMilli(), is(instant.toEpochMilli()));
import static org.hamcrest.Matchers.not;
            TemporalAccessor accessor = formatter.parse("2018-05-15T17:14:56.123+0100");
        assertRoundupFormatter("epoch_second", "1234567890", 1234567890999L);
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("1970-01-01T00:00:00.1")
            String millis = millisFormatter.format(instant);
            assertThat(instant.getEpochSecond(), is(-124L));
        assertThat(roundUpFormatter.zone(), is(zoneId));
            Instant instant = Instant.from(formatter.parse("-6250000431000.000001"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123Z"));
        formatter.format(formatter.parse("2018-05-15T17:14-01:00"));
        accessor = formatter.parse("1234");
            assertThat(formatter.format(instant), is("-" + Long.MAX_VALUE)); // We actually truncate to Long.MAX_VALUE to avoid overflow
            assertThat(instant.getEpochSecond(), is(0L));
            assertThat(microsInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));
            assertDateTimeEquals("2018-05-15T17:14:56.123Z", rfc3339Formatter, isoFormatter);
            assertThat(instant.getNano(), is(123_450_000));
            "strictTTimeNoMillis",
            "basicTTimeNoMillis",
        formatter.format(formatter.parse("2018-05-15T17:14:56+01:00"));
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(1526400896000L));
            assertThat(formatter.format(instant), is("1680000430768"));
            assertThat(instant.getNano(), is(123123456));
import org.opensearch.test.OpenSearchTestCase;
        }
        assertThat(rfc339Formatter, sameInstance(DateFormatters.forPattern("rfc3339_lenient")));
    }
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456Z"));
        {
            "basicOrdinalDate",
            assertThat(formatter.format(instant), is("0"));
        }
                DateFormatter dateFormatter = Joda.forPattern(name);
        }
        // Invalid dates should throw an exception
            equalTo(ZonedDateTime.of(2014, 12, 29, 0, 0, 0, 0, ZoneOffset.UTC))
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56] with format [rfc3339_lenient]"));
        Instant epochMicrosInstant = DateFormatters.from(epochMicrosRoundupParser.parse("1234567890000")).toInstant();
        formatter.format(formatter.parse("2016-01-01T00:00:00.000"));
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_millis", "2018-10-10T12:13:14.123", 1539173594123L);
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.1234567Z"));
        DateFormatter formatter = DateFormatter.forPattern("8date_optional_time||ww-MM-dd");
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56_00:00"));
        {
            "dateHourMinuteSecond",
        formatter.format(formatter.parse("2018-05-15T17:14"));
        // as per WeekFields.ISO first week starts on Monday and has minimum 4 days
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789+01:00"));
import static org.hamcrest.Matchers.containsString;
            "dateHourMinuteSecondFraction",
        // Invalid date
import static org.hamcrest.Matchers.sameInstance;
            assertThat(formatter.format(instant), is("-123000.123456"));
        {
            assertThat(millisInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));
            assertDateTimeEquals("2018-05-15T17:14:56.123456Z", rfc3339Formatter, isoFormatter);
    public void testRFC3339ParserWithDifferentFormatters() {
            Instant instant = Instant.from(formatter.parse("12345"));
                    + " instead."
            DateFormatter formatter = DateFormatter.forPattern("rfc3339_lenient||epoch_millis");
            assertThat(instant.getEpochSecond(), is(6789L));
        DateFormatter f2 = f1.withLocale(Locale.FRENCH);
            "strictBasicWeekDateTimeNoMillis",
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789+0100"));
            "hourMinuteSecond",
        {
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.12345678Z"));
        );
import java.util.Locale;
            "strictHourMinuteSecondFraction",
    public void testParsingStrictNanoDates() {
            assertThat(instant.getNano(), is(123_456_789));
        // named formats too
            String iso8601 = isoFormatter.format(instant);
            assertThat(formatter.format(instant), is("-123000000.123"));
        JavaDateFormatter roundUpFormatter = formatter.getRoundupParser();
            assertThat(formatter.format(instant), is("123.123"));
            assertThat(microsInstant.getNano(), is(isoInstant.getNano()));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123+01:00"));
        assertThat(e.getMessage(), is("failed to parse date field [201805-15T17:14:56.123456+0000] with format [rfc3339_lenient]"));
    public void testRoundupFormatterLocale() {
            Instant instant = Instant.from(formatter.parse("-6250000431000.75"));
            Instant instant = Instant.from(formatter.parse("1680000430768123"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789-01:00"));
        }
            assertThat(microsInstant.getNano(), is(isoInstant.getNano()));
            assertThat(secondsFormatter.format(Instant.ofEpochSecond(42, 0)), is("42"));
        assertThat(epochSecondInstant.getLong(ChronoField.NANO_OF_SECOND), is(999_999_999L));
        String[] deprecatedNames = new String[] {
        Locale locale = randomLocale(random());
        {
        }
            "timeNoMillis",
            "strictOrdinalDate",
        {
            assertThat(formatter.format(instant), is("-6250000430768")); // remove .00 precision
            String micros = microsFormatter.format(instant);
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456"));
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.1234567891Z] with format [rfc3339_lenient]"));
        assertThat(f1, not(equalTo(f2)));
        }
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789Z"));
            "tTimeNoMillis",
        {
        ZonedDateTime second = DateFormatters.from(
        }
            assertThat(millisInstant.toEpochMilli(), is(instant.toEpochMilli()));
        }
            String micros = microsFormatter.format(instant);
        }
        {
            Instant instant = Instant.from(formatter.parse("0"));
            Instant instant = Instant.from(formatter.parse("-123.123"));
            Instant instant = Instant.from(formatter.parse("-6250000431000"));
            assertThat(instant.getEpochSecond(), is(-6250000431L));
        }
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456"));
            assertThat(secondsFormatter.format(Instant.ofEpochSecond(42, 0)), is("42"));
            assertThat(formatter.format(instant), is("-6250000430768.75"));
            "epoch_millis",
 * GitHub history for details.
        {
            DateFormatter secondsFormatter = DateFormatter.forPattern("epoch_second");
            "basicTime",
    public void testEpochMillisParser() {
            assertThat(instant.getNano(), is(232000000));
            "uuuu-MM-dd'T'HH:mm:ss.SSS",
        // More than 9 digits of nanosecond resolution
            assertThat(instant.getNano(), is(231750000));
        // also check nanos of the epoch_micros formatter if it is rounded up to the nano second
    public void testEqualsAndHashcode() {
        long nanos = randomLongBetween(0, 999_999_999L);
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
    }
        // different pattern, thus not equals
        }
            "tTime",
        DateFormatter f1 = DateFormatters.forPattern("YYYY").withLocale(Locale.CANADA);
        );
        assertThat(millis, is(expectedMilliSeconds));
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_second", "1234567890", 1234567890999L);
        // named formats too
        // also check nanos of the epoch_millis formatter if it is rounded up to the nano second
        String formatted = formatter.formatMillis(clock.millis());
    public void testSupportBackwardsJava8Format() {
            assertThat(formatter.pattern(), is("rfc3339_lenient||strict_date_optional_time"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789Z"));
            "strictDateHourMinuteSecondMillis",
        formatter.format(formatter.parse("2018-05-15T17:14:56Z"));
            assertThat(formatter.format(instant), is("12345"));
            Instant instant = Instant.from(formatter.parse("-6250000430768.00"));
        ZonedDateTime first = DateFormatters.from(
        {
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        // first week of 2016 starts on Monday 2016-01-04 as previous week in 2016 has only 3 days
        assertRoundupFormatter("strict_date_optional_time||epoch_micros", "2018-10-10T12:13:14.123Z", 1539173594123L);
    public void testNanoOfSecondWidth() throws Exception {
            String formattedSeconds = secondsFormatter.format(instant);
            "hourMinuteSecondMillis",
        assertThat(epochMillisFormatter, sameInstance(DateFormatters.forPattern("epoch_millis")));
            Instant instant = Instant.from(formatter.parse("-123.123456"));
        assertThat(epochSecondFormatter, equalTo(DateFormatters.forPattern("epoch_second")));
            "basicOrdinalDateTime",
            String micros = microsFormatter.format(instant);
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56-00:00] with format [rfc3339_lenient]"));
            String snakeCaseName = FormatNames.forName(name).getSnakeCaseName();
public class DateFormattersTests extends OpenSearchTestCase {
            "strictDateHourMinute",
            DateFormatter formatter = DateFormatter.forPattern("rfc3339_lenient||strict_date_optional_time");
    }
        formatter.format(formatter.parse("2018-05-15T17:14:56Z"));
        {
            "strictDateTimeNoMillis",
            assertThat(instant.getEpochSecond(), is(-6250000431L));
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("1234.abc"));
        }
        assertThat(rfc339Formatter.hashCode(), is(DateFormatters.forPattern("rfc3339_lenient").hashCode()));
        Instant instant = Instant.ofEpochSecond(seconds, nanos);
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56-00:00"));
    // as this feature is supported it also makes sense to make it exact
            assertThat(instant.getNano(), is(999876550));
            "strictWeekDate",
            assertThat(formatter.format(instant), is("-6250000431000.25"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789+01:00"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        // also check nanos of the epoch_millis formatter if it is rounded up to the nano second
 *
        DateFormatter epochSecondFormatter = DateFormatters.forPattern("epoch_second");
        // zone is null by default due to different behaviours between java8 and above
            Instant instant = Instant.from(formatter.parse("123.123"));
            "strict_date_optional_time",
        {
            assertThat(dateFormatter.pattern(), equalTo(name));
        }
            DateFormatters.from(dateFormatter.parse("2016-01")),
    public void testParsersWithMultipleInternalFormats() throws Exception {
        // nanoseconds can be separated using comma or decimal point
        assertThat(DateFormatters.forPattern("strict_date_optional_time").locale(), is(Locale.ROOT));
        formatter.format(formatter.parse("2018-05-15T17:14+01:00"));
        assertThat(gotInstant, is(expectedInstant));
                    + snakeCaseName
        }
        DateFormatter.forPattern("week_year");
        ZonedDateTime first = DateFormatters.from(
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.123"));
    public void testFractionalSeconds() {
            assertThat(formatter.pattern(), is("rfc3339_lenient||strict_date_optional_time"));
            assertThat(formatter.format(instant), is("-6250000431000"));
        assertThat(epochMicrosFormatter.hashCode(), is(DateFormatters.forPattern("epoch_micros").hashCode()));
            DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time||epoch_millis");
        formatter.format(formatter.parse("2018-05"));
            assertThat(formatter.format(instant), is("-123.123"));
    public void testEpochSecondParserWithFraction() {
 * under the License.
        {
    }
            "basicWeekDateTimeNoMillis",
            assertThat(formatter.format(instant), is("6789123.123456"));
        Instant epochSecondInstant = DateFormatters.from(epochSecondRoundupParser.parse("1234567890")).toInstant();
            assertThat(instant.getEpochSecond(), is(-124L));
            Instant instant = Instant.from(formatter.parse("0"));
        }
    // this is not in the duelling tests, because the epoch millis parser in joda time drops the milliseconds after the comma
        formatter.format(formatter.parse("2018-05-15T17:14-0100"));
            assertDateTimeEquals("2018-05-15T17:14Z", rfc3339Formatter, isoFormatter);
            Instant secondsInstant = Instant.from(secondsFormatter.parse(formattedSeconds));
        assertThat(
        formatter.format(formatter.parse("2018-05-15T17:14:56+01:00"));
        assertThat(formatted, is("2019-02-08T11:43:00.000Z"));
        {
 * You may obtain a copy of the License at
        }
        );
    public void testTimeZones() {
        }
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.123"));
            "strictWeekyearWeekDay",
        }
            assertDateTimeEquals("2018-05-15T17:14:56.123-01:00", rfc3339Formatter, isoFormatter);
            "strictBasicWeekDateTime",
        );
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(123L));
        }
        {
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            "weekDateTime",
            "basicDateTimeNoMillis",
        assertRoundupFormatter("epoch_micros", "1234567890000", 1234567890L);
            assertThat(microsInstant.toEpochMilli(), is(instant.toEpochMilli()));
            assertThat(instant.getEpochSecond(), is(-6250000431L));
    public void testEpochMilliParsersWithDifferentFormatters() {
        assertThat(roundupParser.locale(), is(locale));
    }
            "strict_date_optional_time",
            assertThat(instant.getEpochSecond(), is(-1L));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456Z"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            DateFormatter isoFormatter = DateFormatters.forPattern("strict_date_optional_time_nanos");
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.123456789Z"));
        assertThat(epochMicrosFormatter, sameInstance(DateFormatters.forPattern("epoch_micros")));
        );
        ZonedDateTime second = DateFormatters.from(
        formatter.format(formatter.parse("2018-05-15T17:14:56,123Z"));
            "dateHourMinute",
        {
    }
        assertThat(e.getMessage(), is("failed to parse date field [abc] with format [rfc3339_lenient]"));
        }
                assertThat(dateFormatter.pattern(), equalTo(snakeCaseName));
import static org.hamcrest.Matchers.nullValue;
        );
        assertRoundupFormatter("strict_date_optional_time||epoch_second", "2018-10-10T12:13:14.123Z", 1539173594123L);
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("abc"));
import java.time.temporal.ChronoField;
            DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time||rfc3339_lenient");
        formatter.format(formatter.parse("2018-05-15"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            assertThat(instant.getEpochSecond(), is(-6250000431L));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789-0100"));
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("1234.1234567890"));
package org.opensearch.common.time;
            "dateHourMinuteSecondMillis",
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));
            Instant isoInstant = Instant.from(isoFormatter.parse(iso8601));
    // as this feature is supported it also makes sense to make it exact
            assertThat(millisInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));
            assertThat(instant.getEpochSecond(), is(12L));
            assertThat(DateFormatters.from(accessor).toInstant().getNano(), is(123456789));
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.1234567891Z"));
    void assertDateTimeEquals(String toTest, DateFormatter candidateParser, DateFormatter baselineParser) {
        DateFormatter dateFormatter = DateFormatters.forPattern("YYYY-ww");
        formatter.format(formatter.parse("2018-05-15T17:14:56-01:00"));
    }
            assertThat(instant.getNano(), is(999876544));
            assertThat(instant.getEpochSecond(), is(1680000430L));
            Instant instant = Instant.ofEpochMilli(Long.MIN_VALUE);
        // different timezone, thus not equals
        TemporalAccessor accessor = formatter.parse("1234.1");
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        // first week of 2016 starts on Monday 2016-01-04 as previous week in 2016 has only 3 days
            "strictDate",
        {
        {
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789Z"));
            "strictWeekyear",
            "strictDateOptionalTime",
            assertThat(instant.getNano(), is(768123000));
            "epoch_micros",
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456+0100"));
            assertThat(instant.getNano(), is(231250000));
        long seconds = randomLongBetween(-130L * 365 * 86400, 0); // around 1840 till 1970 epoch
        );
            Instant instant = Instant.from(formatter.parse("6789123.123456"));
        JavaDateFormatter formatter = (JavaDateFormatter) DateFormatter.forPattern(format).withZone(zoneId);
            DateFormatters.forPattern("strict_date_optional_time"),
        assertThat(formatter.locale(), is(locale));
            "strictTime",
 * SPDX-License-Identifier: Apache-2.0
 */
            assertDateTimeEquals("2018-05-15T17:14:56,123456789-01:00", rfc3339Formatter, isoFormatter);
            "hourMinuteSecondFraction",
        formatter.format(formatter.parse("2018-05-15T17:14:56Z"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("invalid"));
        formatter.format(formatter.parse("2018-05-15T17+01:00"));
    public void test0MillisAreFormatted() {
        DateFormatter rfc339Formatter = DateFormatters.forPattern("rfc3339_lenient");
    // but is able to parse the rest
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));
        DateFormatter formatter = DateFormatters.forPattern("epoch_millis");
            String micros = microsFormatter.format(instant);
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            assertThat(formatter.format(instant), is("-6250000431000.75"));
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_micros", "1234567890000", 1234567890L);
            String iso8601 = isoFormatter.format(instant);
    }
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.abcZ"));
                dateFormatter = Joda.forPattern(snakeCaseName);
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.123] with format [rfc3339_lenient]"));
            assertDateTimeEquals("2018-05-15T17:14:56.123+01:00", rfc3339Formatter, isoFormatter);
            assertThat(instant.getNano(), is(12345000));
    }
        DateFormatter formatter = DateFormatters.forPattern("strict_date_optional_time");
    private void assertRoundupFormatter(String format, String input, long expectedMilliSeconds) {
            Instant instant = Instant.from(formatter.parse("-6250000430768.25"));
            DateFormatters.from(dateFormatter.parse("2015-01")),
        assertThat(second.getNano(), is(1));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789z"));
            assertThat(formatter.format(instant), is("-0.123"));
            assertThat(millisInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));
        assertThat(DateFormatters.forPattern("strict_date_optional_time").withZone(zoneId).zone(), is(zoneId));
            assertThat(instant.getEpochSecond(), is(-6250000431L));
            assertThat(instant.getNano(), is(999999999));
 */
            Instant instant = Instant.from(formatter.parse("-123000.123456"));
            assertThat(instant.getNano(), is(123_456_780));
        {
            Instant instant = Instant.from(formatter.parse("-0.12345"));
        formatter.format(formatter.parse("2018-05-15T17"));
    }
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        }
        // different locale, thus not equals
            "strictTimeNoMillis",
        {
    }
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.abcZ] with format [rfc3339_lenient]"));
        assertThat(e.getMessage(), containsString("failed to parse date field [123.1234567] with format [epoch_millis]"));
        DateFormatter formatter = DateFormatters.forPattern("epoch_micros");
            assertThat(instant.getEpochSecond(), is(-1L));
        assertThat(DateFormatters.forPattern("YYYY").hashCode(), is(DateFormatters.forPattern("YYYY").hashCode()));
        {
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        }
 *
        DateFormatter rfc3339Formatter = DateFormatter.forPattern("rfc3339_lenient");
    }
        formatter.format(formatter.parse("2018-05-15T17:14:56.123-01:00"));
        String format = randomFrom(
            assertThat(formatter.format(instant), is("-6250000431000"));
            }
        formatter.format(formatter.parse("2018-05-15T17:14:56"));
        {
            assertThat(formatter.format(instant), is("-6250000430768.25"));
 * ownership. Elasticsearch licenses this file to you under
            "yearMonthDay",
            Instant secondsInstant = Instant.from(secondsFormatter.parse(formattedSeconds));
            assertThat(microsFormatter.format(Instant.ofEpochSecond(42, 123456789L)), is("42123456.789"));
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));
        );
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.123Z"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            "ordinalDate",
        // microseconds can be separated using comma or decimal point
            assertDateTimeEquals("2018-05-15T17:14:56Z", rfc3339Formatter, isoFormatter);
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
    }
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789-01:00"));
        dateFormatter = DateFormatters.forPattern("YYYY");
        }
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.1Z"));
            "epoch_millis",
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123z"));
        // No end of fraction
    }
            assertThat(instant.getEpochSecond(), is(0L));
            assertDateTimeEquals("2018-05-15T17:14:56+01:00", rfc3339Formatter, isoFormatter);
            "weekDateTimeNoMillis",
    public void testIso8601Parsing() {
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        assertWarnings(
            "strictHourMinute",
        assertThat(
            assertThat(formatter.pattern(), is("strict_date_optional_time||epoch_millis"));
        final Instant instantB = DateFormatters.from(formatter.parse("1994-11-05T13:15:30Z")).toInstant();
        Locale locale = randomLocale(random());
            assertThat(instant.getNano(), is(999250000));
        }
        assertThat(DateFormatter.forPattern("8date_optional_time"), instanceOf(JavaDateFormatter.class));
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("1970-01-01T00:00:00.000000001")
    }
    }
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(123L));
            assertThat(microsInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));
        }
        assertRoundupFormatter("strict_date_optional_time||epoch_micros", "2018-10-10", 1539215999999L);
            assertThat(dateFormatter.pattern(), equalTo(snakeCaseName));
            assertThat(instant.getNano(), is(100_000_000));
            assertThat(microsInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));
        formatter.format(formatter.parse("2018-05-15T17:14:56"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789"));
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.12Z"));
        // 1994-11-05T13:15:30Z corresponds to the same instant.
            assertThat(secondsInstant.getEpochSecond(), is(instant.getEpochSecond()));
    public void testCamelCaseDeprecation() {
            "strictTTime",
            TemporalAccessor accessor = formatter.parse("2018-05-15T17:14:56.123456789+0100");
        JavaDateFormatter roundUpFormatter = dateFormatter.getRoundupParser();
import java.time.ZoneOffset;
/*
            "basicWeekDate",
        Instant gotInstant = DateFormatters.from(candidateParser.parse(toTest)).toInstant();
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "2019-01-25T15:37:17.346928Z", 1548430637346L);
        {
            assertThat(instant.getNano(), is(999999877));
            "weekyearWeekDay",
            assertThat(formatter.format(instant), is("-6789123.123456"));
            Instant instant = Instant.from(formatter.parse("123.123456"));
        assertRoundupFormatter("strict_date_optional_time||epoch_second", "1234567890", 1234567890999L);
    }
            assertThat(instant.getEpochSecond(), is(-6250000432L));
        }
        formatter.format(formatter.parse("2018-05-15T17:14:56+01:00"));
            assertThat(formatter.format(instant), is("123.123456"));
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));
            assertThat(secondsInstant.getEpochSecond(), is(instant.getEpochSecond()));
            "strictYear",
            Instant instant = Instant.from(formatter.parse("-6250000431000.250000"));
        assertThat(DateFormatters.forPattern("YYYY"), equalTo(DateFormatters.forPattern("YYYY")));
        assertThat(formatter, instanceOf(JavaDateFormatter.class));
            assertThat(formatter.format(instant), is("0"));
 * compatible open source license.
            assertThat(instant.getEpochSecond(), is(0L));
            TemporalAccessor accessor = formatter.parse("123");
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.+00:00] with format [rfc3339_lenient]"));
        // microseconds can be separated using comma or decimal point
 * the Apache License, Version 2.0 (the "License"); you may
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");
    public void testEpochMicrosParser() {
    public void testWeekBasedDates() {
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456Z"));
            assertDateTimeEquals("2018-05-15T17:14:56-01:00", rfc3339Formatter, isoFormatter);
            Instant instant = Instant.from(formatter.parse("1680000430768"));
        {
        {
            "epoch_micros",
        formatter.format(formatter.parse("2018-05-15T17:14:56.123Z"));
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");
                    + "Use snake case name "
        {
            assertWarnings(
            Instant instant = Instant.from(formatter.parse("-123000000.123"));
            DateFormatter secondsFormatter = DateFormatter.forPattern("epoch_second");
import static org.hamcrest.Matchers.equalTo;
        assertThat(instant.getEpochSecond(), is(1234L));
        Instant epochMilliInstant = DateFormatters.from(roundUpFormatter.parse("1234567890")).toInstant();
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56"));
        }
        assertThat(DateFormatters.forPattern("YYYY"), not(equalTo(DateFormatters.forPattern("YY"))));
            "strictDateHour",
            "hourMinute",
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.+00:00"));
        JavaDateFormatter roundUpFormatter = ((JavaDateFormatter) DateFormatter.forPattern("8epoch_millis")).getRoundupParser();
        assertThat(
        assertThat(epochMicrosFormatter, equalTo(DateFormatters.forPattern("epoch_micros")));
        // first week of 2015 starts on Monday 2014-12-29 because 4days belong to 2019
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("201805-15T17:14:56.123456+0000"));
        {
            assertThat(formatter.format(instant), is("12345"));
                    + " is deprecated and will be removed in a future version. "
            assertThat(millisFormatter.format(Instant.ofEpochSecond(-42, 0)), is("-42000"));
            assertThat(instant.getNano(), is(232000000));
        }
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            dateFormatter = DateFormatter.forPattern(snakeCaseName);
        // 1994-11-05T08:15:30-05:00 corresponds to November 5, 1994, 8:15:30 am, US Eastern Standard Time/
            "basicOrdinalDateTimeNoMillis",
            );
        assertThat(instantA, is(instantB));
        formatter.format(formatter.parse("2018-05-15T17:14Z"));
            assertThat(instant.getNano(), is(123_000_000));
        }
        DateFormatter formatter = DateFormatters.forPattern("epoch_millis");
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");
            assertThat(formatter.format(instant), is("-0.12345"));
        }
        assertThat(epochSecondFormatter, sameInstance(DateFormatters.forPattern("epoch_second")));
        }
 * this file be licensed under the Apache-2.0 license or a
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));
        // first week of 2015 starts on Monday 2014-12-29 because 4days belong to 2019
    // this is not in the duelling tests, because the epoch second parser in joda time drops the milliseconds after the comma
        JavaDateFormatter epochMicrosRoundupParser = ((JavaDateFormatter) DateFormatter.forPattern("8epoch_micros")).getRoundupParser();
        DateFormatter epochMicrosFormatter = DateFormatters.forPattern("epoch_micros");
            assertDateTimeEquals("2018-05-15T17:14:56,123-01:00", rfc3339Formatter, isoFormatter);
            "epoch_second",
                String snakeCaseName = FormatNames.forName(name).getSnakeCaseName();
        long seconds = randomLongBetween(0, 130L * 365 * 86400); // from 1970 epoch till around 2100
        formatter.format(formatter.parse("2018-05-15T17:14:56,123"));
            DateFormatter formatter = DateFormatter.forPattern("rfc3339_lenient||strict_date_optional_time");
 * Licensed to Elasticsearch under one or more contributor
            TemporalAccessor accessor = formatter.parse("123");
        assertThat(DateFormatters.from(accessor).toInstant().getNano(), is(100_000_000));
        Instant instant = DateFormatters.from(accessor).toInstant();
        // milliseconds can be separated using comma or decimal point
        {
            assertThat(instant.getNano(), is(999750000));
        }
        {
        DateFormatter formatter = DateFormatters.forPattern("strict_date_optional_time_nanos");
            assertThat(formatter.pattern(), is("strict_date_optional_time||rfc3339_lenient"));
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");
        formatter.format(formatter.parse("2018-05-15T17:14:56+0100"));
        {
            "dateTimeNoMillis",
import java.time.temporal.TemporalAccessor;
        {
            "weekDate",
    public void testRoundupFormatterWithEpochDates() {
            "strict_date_optional_time||date_optional_time"
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56_00:00] with format [rfc3339_lenient]"));
        {
    }
            assertThat(millisInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));
            assertThat(microsFormatter.format(Instant.ofEpochSecond(-42, 123456789L)), is("-41876543.211"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));
    }
        formatter.format(formatter.parse("2018-05-15T17:14:56z"));
            assertThat(instant.getNano(), is(123_456_700));
            assertThat(millisInstant.getNano(), is(isoInstant.getNano()));
            assertThat(formatter.pattern(), is("rfc3339_lenient||epoch_millis"));
        assertThat(DateFormatters.from(dateFormatter.parse("2015")), equalTo(ZonedDateTime.of(2014, 12, 29, 0, 0, 0, 0, ZoneOffset.UTC)));
        for (String name : deprecatedNames) {
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("2018-05-15T17:14:56+01:00")
        // nanoseconds can be separated using comma or decimal point
        JavaDateFormatter formatter = (JavaDateFormatter) DateFormatter.forPattern(format).withLocale(locale);
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456-01:00"));
        formatter.format(formatter.parse("2018"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123z"));
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_micros", "2018-10-10T12:13:14.123", 1539173594123L);
        );
        }
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("123.1234567"));
        Instant expectedInstant = DateFormatters.from(baselineParser.parse(toTest)).toInstant();
            "strictOrdinalDateTimeNoMillis",
        // as per WeekFields.ISO first week starts on Monday and has minimum 4 days
            "epoch_second",
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));
        instant = DateFormatters.from(accessor).toInstant();
        assertThat(e.getMessage(), containsString("failed to parse date field [invalid] with format [epoch_millis]"));
            "strictWeekDateTime",
        assertThat(DateFormatters.from(dateFormatter.parse("2016")), equalTo(ZonedDateTime.of(2016, 01, 04, 0, 0, 0, 0, ZoneOffset.UTC)));
import java.time.Instant;
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.1234Z"));
/*
            String millis = millisFormatter.format(instant);
        assertThat(first.getNano(), is(100000000));
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");
            Instant isoInstant = Instant.from(isoFormatter.parse(iso8601));
import java.time.ZoneId;
            assertThat(instant.getEpochSecond(), is(-6250000432L));
        assertThat(epochMillisFormatter, equalTo(DateFormatters.forPattern("epoch_millis")));
    public void testLocales() {
            "strict_date_optional_time||date_optional_time"
    public void testRFC3339Parsing() {
        String format = randomFrom(
        }
        // timezone not allowed with just date
            "yearMonth",
                    + name
            "basicWeekDateTime",
        assertThat(e.getMessage(), is("failed to parse date field [abc] with format [epoch_second]"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456-0100"));
            "strictWeekyearWeek",
 * Modifications Copyright OpenSearch Contributors. See
    // but is able to parse the rest
 * this work for additional information regarding copyright
            assertThat(millisInstant.getNano(), is(isoInstant.getNano()));
        ZoneId zoneId = randomZone();
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.123456Z"));
            assertThat(formatter.format(instant), is("-6250000431000.000001"));
        long millis = DateFormatters.from(roundUpFormatter.parse(input)).toInstant().toEpochMilli();
        assertRoundupFormatter("epoch_millis", "1234567890", 1234567890L);
        }
            "strictDateOptionalTimeNanos",
            assertThat(microsInstant.toEpochMilli(), is(instant.toEpochMilli()));
        formatter.format(formatter.parse("2018-05-15T17:14Z"));
        }
        }
        formatter.format(formatter.parse("2018-05-15T17:14-01:00"));
            "strictDateHourMinuteSecondFraction",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456Z"));
        Instant instant = Instant.ofEpochSecond(seconds, nanos);
            "basicDateTime",
        assertThat(e.getMessage(), is("failed to parse date field [1234.abc] with format [epoch_second]"));
            assertThat(instant.getNano(), is(123123));
            assertThat(instant.getEpochSecond(), is(-6250000431L));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789Z"));
        );
            "basicDate",
        assertThat(DateFormatters.forPattern("strict_date_optional_time").withLocale(locale).locale(), is(locale));
            "basicTimeNoMillis",
    public void testWeek_yearDeprecation() {
                "Camel case format name "
        assertThat(instant.getEpochSecond(), is(1234L));
            assertDateTimeEquals("2018-05-15T17:14:56,123+01:00", rfc3339Formatter, isoFormatter);
            TemporalAccessor accessor = formatter.parse("2018-05-15T17:14:56+0100");
        DateFormatter formatter = DateFormatters.forPattern("iso8601");
            "basicTTime",
}
        ZoneId zoneId = randomZone();
        for (String name : deprecatedNames) {
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456+01:00"));
        JavaDateFormatter dateFormatter = (JavaDateFormatter) DateFormatter.forPattern(format);
            equalTo(ZonedDateTime.of(2016, 01, 04, 0, 0, 0, 0, ZoneOffset.UTC))
        assertThat(e.getMessage(), is("failed to parse date field [1234.1234567890] with format [epoch_second]"));
        formatter.format(formatter.parse("2018-05-15T17:14z"));
            "weekyearWeek",
 */
            assertThat(instant.getNano(), is(0));
            assertThat(instant.getNano(), is(120_000_000));
            assertThat(instant.getNano(), is(999876877));
            assertDateTimeEquals("2018-05-15T17:14+01:00", rfc3339Formatter, isoFormatter);
            assertThat(instant.getNano(), is(0));
        assertThat(DateFormatter.forPattern("8yyyy-MM-dd"), instanceOf(JavaDateFormatter.class));
            assertThat(microsFormatter.format(Instant.ofEpochSecond(42, 0)), is("42000000"));
        formatter.format(formatter.parse("2018-05-15T17+0100"));
 * specific language governing permissions and limitations
            assertThat(formatter.format(instant), is("-123.123456"));
 * The OpenSearch Contributors require contributions made to
            Instant instant = Instant.from(formatter.parse("-6250000430768.75"));
            assertThat(instant.getEpochSecond(), is(-6250000432L));
        assertRoundupFormatter("strict_date_optional_time||epoch_second", "2018-10-10", 1539215999999L);
        // Invalid fraction
            assertThat(microsFormatter.format(Instant.ofEpochSecond(-42, 0)), is("-42000000"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123Z"));
            "ordinalDateTimeNoMillis",
        DateFormatter formatter = DateFormatters.forPattern("epoch_second");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("abc"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123"));
        }
        // milliseconds can be separated using comma or decimal point
            sameInstance(DateFormatters.forPattern("strict_date_optional_time"))
        assertThat(formatter.zone(), is(zoneId));
        formatter.format(formatter.parse("2018-05-15T17:14:56+0100"));
            String millis = millisFormatter.format(instant);
    }
            assertThat(instant.getEpochSecond(), is(0L));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789Z"));
            "dateHour",
    }
            assertThat(formatter.format(instant), is("-6250000430768"));
            Instant instant = Instant.from(formatter.parse("-6250000431000.00"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789"));
            if (name.equals("strictDateOptionalTimeNanos") == false) {
        {
        }
        {
            assertThat(millisFormatter.format(Instant.ofEpochSecond(42, 123456789L)), is("42123.456789"));
        }
            Instant instant = Instant.from(formatter.parse("-6250000430768"));
        // Invalid offset
            assertThat(instant.getEpochSecond(), is(0L));
        DateFormatter formatter = DateFormatters.forPattern("rfc3339_lenient");
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(1526400896123L));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
    }
            Instant instant = Instant.from(formatter.parse("12345"));
            "strictYearMonth",
            assertThat(instant.getNano(), is(123_456_000));
            "Format name \"week_year\" is deprecated and will be removed in a future version. " + "Use \"weekyear\" format instead"
 *
            Instant instant = Instant.from(formatter.parse("-0.123"));
            assertThat(millisFormatter.format(Instant.ofEpochSecond(-42, 123456789L)), is("-41876.543211"));
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_millis", "1234567890", 1234567890L);
        }
        {
 * software distributed under the License is distributed on an
            "strictWeekDateTimeNoMillis",
            "strictHourMinuteSecond",
            String millis = millisFormatter.format(instant);
        // No offset
        JavaDateFormatter epochSecondRoundupParser = ((JavaDateFormatter) DateFormatter.forPattern("8epoch_second")).getRoundupParser();
    }
            assertThat(microsInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));
    public void testEpochFormattingNegativeEpoch() {
        formatter.format(formatter.parse("2018-05-15T17:14:56,123+0100"));
        {
    }
import static org.hamcrest.Matchers.is;
        {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
            "dateOptionalTime",
            "uuuu-MM-dd'T'HH:mm:ss.SSS",
import java.time.Clock;
        {
    }
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.123] with format [rfc3339_lenient]"));
            assertThat(instant.getNano(), is(0));
            Instant instant = Instant.from(formatter.parse("-6789123.123456"));
        assertRoundupFormatter("strict_date_optional_time||epoch_micros", "1234567890000", 1234567890L);
        {
        assertThat(first, is(second));
        {
        formatter.format(formatter.parse("2018-05-15T17:14:56.123-0100"));
 * KIND, either express or implied.  See the License for the
        JavaDateFormatter roundupParser = formatter.getRoundupParser();
            assertThat(instant.getNano(), is(876876544));
            assertThat(formatter.format(instant), is("1680000430768123"));
        final Instant instantA = DateFormatters.from(formatter.parse("1994-11-05T08:15:30-05:00")).toInstant();
        assertThat(rfc339Formatter, equalTo(DateFormatters.forPattern("rfc3339_lenient")));
            assertThat(instant.getNano(), is(123123456));
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.12345Z"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456+01:00"));
                assertThat(dateFormatter.pattern(), equalTo(name));
            "strictDateHourMinuteSecond",
            DateFormatter isoFormatter = DateFormatter.forPattern("strict_date_optional_time");
            assertThat(instant.getEpochSecond(), is(-6790L));
    public void testInvalidEpochMilliParser() {
import static org.hamcrest.Matchers.instanceOf;
        assertThat(DateFormatters.forPattern("YYYY").withZone(ZoneId.of("CET")), not(equalTo(DateFormatters.forPattern("YYYY"))));
 * license agreements. See the NOTICE file distributed with
    public void testRoundupFormatterZone() {
            DateFormatter isoFormatter = DateFormatters.forPattern("strict_date_optional_time_nanos");
            assertThat(instant.getNano(), is(999999877));
            "ordinalDateTime",
            "dateTime",
            assertDateTimeEquals("2018-05-15T17:14-01:00", rfc3339Formatter, isoFormatter);
            assertThat(instant.getNano(), is(345_000_000));
        {
        DateFormatter epochMillisFormatter = DateFormatters.forPattern("epoch_millis");
        // timezone not allowed with just date
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "1234567890", 1234567890L);
            assertDateTimeEquals("2018-05-15T17:14:56.123456789-01:00", rfc3339Formatter, isoFormatter);
            assertThat(instant.getEpochSecond(), is(1680000430L));
        {
        }
        DateFormatter formatter = DateFormatter.forPattern("strict_date_time");
        {
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "2018-10-10", 1539215999999L);
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_second", "2018-10-10T12:13:14.123", 1539173594123L);
            assertDateTimeEquals("2018-05-15T17:14:56.123456789+01:00", rfc3339Formatter, isoFormatter);
import java.time.ZonedDateTime;
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            "strictHourMinuteSecondMillis",
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789+01:00"));
        assertThat(epochMicrosInstant.getLong(ChronoField.NANO_OF_SECOND), is(890000999L));
    }
            assertThat(instant.getEpochSecond(), is(-1L));
        dateFormatter.parse(input);
    }
            assertThat(instant.getEpochSecond(), is(-1L));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123+01:00"));
        }
            DateFormatter dateFormatter = DateFormatter.forPattern(name);
        }
            assertThat(instant.getNano(), is(0));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789+0100"));
        }
        {
            "strictDateTime",
        assertThat(instant.getNano(), is(0));
import org.opensearch.common.joda.Joda;
        assertThat(epochMillisFormatter.hashCode(), is(DateFormatters.forPattern("epoch_millis").hashCode()));
    public void testRFC3339ParserAgainstDifferentFormatters() {
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            "strictYearMonthDay" };
        assertThat(epochMilliInstant.getLong(ChronoField.NANO_OF_SECOND), is(890_999_999L));
        formatter.format(formatter.parse("2018-05-15T17Z"));
        }
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456z"));
            assertDateTimeEquals("2018-05-15T17:14:56,123456789+01:00", rfc3339Formatter, isoFormatter);
 * not use this file except in compliance with the License.
        long nanos = randomLongBetween(0, 999_999_999L);
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456-01:00"));
            "strictOrdinalDateTime",
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        assertThat(DateFormatters.forPattern("strict_date_optional_time").zone(), is(nullValue()));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123-01:00"));
            assertThat(instant.getNano(), is(876876544));
    public void testEpochFormatting() {
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456z"));
            "strictBasicWeekDate",
/*
            String formattedSeconds = secondsFormatter.format(instant);
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
