            assertThat(microsInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));
        assertThat(e.getMessage(), is("failed to parse date field [1234.1234567890] with format [epoch_second]"));
        // 1994-11-05T13:15:30Z corresponds to the same instant.  
        formatter.format(formatter.parse("2018-05"));
            assertThat(millisFormatter.format(Instant.ofEpochSecond(42, 123456789L)), is("42123.456789"));
            assertThat(formatter.format(instant), is("-6250000431000"));  
        // milliseconds can be separated using comma or decimal point  
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.+00:00] with format [rfc3339_lenient]"));  
        {  
        dateFormatter.parse(input);
        }  
            );  
import static org.hamcrest.Matchers.not;
            DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time||rfc3339_lenient");  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456Z"));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("abc"));  
        ZonedDateTime second = DateFormatters.from(  
            assertThat(instant.getNano(), is(999876550));
        assertThat(DateFormatters.forPattern("strict_date_optional_time").withZone(zoneId).zone(), is(zoneId));  
        // different pattern, thus not equals
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789+01:00"));
            assertDateTimeEquals("2018-05-15T17:14:56.123456789+01:00", rfc3339Formatter, isoFormatter);
            "strict_date_optional_time||date_optional_time"
        JavaDateFormatter epochMicrosRoundupParser = ((JavaDateFormatter) DateFormatter.forPattern("8epoch_micros")).getRoundupParser();  
            Instant instant = Instant.from(formatter.parse("0"));
        assertThat(first.getNano(), is(100000000));
    public void testFractionalSeconds() {
            "strictWeekDate",  
            Instant instant = Instant.from(formatter.parse("-6250000431000.75"));
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.1234567891Z"));  
            "strictBasicWeekDateTime",  
            assertThat(microsFormatter.format(Instant.ofEpochSecond(-42, 0)), is("-42000000"));  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
import static org.hamcrest.Matchers.sameInstance;
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789"));
            DateFormatter isoFormatter = DateFormatters.forPattern("strict_date_optional_time_nanos");
            "hourMinuteSecondFraction",
    public void testEpochSecondParserWithFraction() {
        assertThat(DateFormatters.forPattern("YYYY").hashCode(), is(DateFormatters.forPattern("YYYY").hashCode()));  
        }  
            assertThat(instant.getEpochSecond(), is(-6790L));
            assertThat(formatter.format(instant), is("12345"));  
        assertThat(roundupParser.locale(), is(locale));  
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("invalid"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        // first week of 2016 starts on Monday 2016-01-04 as previous week in 2016 has only 3 days  
    }
            assertThat(instant.getNano(), is(876876544));
        formatter.format(formatter.parse("2018-05-15T17:14+01:00"));
 * KIND, either express or implied.  See the License for the
            assertThat(instant.getNano(), is(999750000));
        {  
import static org.hamcrest.Matchers.instanceOf;  
    }
            assertThat(instant.getNano(), is(123123456));  
            assertThat(instant.getEpochSecond(), is(0L));
            Instant isoInstant = Instant.from(isoFormatter.parse(iso8601));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789z"));
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");
        JavaDateFormatter epochSecondRoundupParser = ((JavaDateFormatter) DateFormatter.forPattern("8epoch_second")).getRoundupParser();
        formatter.format(formatter.parse("2018-05-15T17:14:56,123+0100"));  
            "yearMonthDay",
 * software distributed under the License is distributed on an
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56-00:00"));  
        DateFormatter formatter = DateFormatter.forPattern("8date_optional_time||ww-MM-dd");  
            assertThat(dateFormatter.pattern(), equalTo(name));
    }
    }  
        {
                    + snakeCaseName
        // named formats too
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_micros", "1234567890000", 1234567890L);  
 * The OpenSearch Contributors require contributions made to  
        }
            assertThat(instant.getNano(), is(123123456));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("abc"));  
            "basicWeekDate",
        JavaDateFormatter roundupParser = formatter.getRoundupParser();
            assertDateTimeEquals("2018-05-15T17:14:56,123+01:00", rfc3339Formatter, isoFormatter);
            assertThat(instant.getEpochSecond(), is(12L));
            assertThat(formatter.format(instant), is("0"));
            "basicDateTimeNoMillis",
 * not use this file except in compliance with the License.
            assertThat(instant.getNano(), is(123_456_000));
    // but is able to parse the rest  
        // Invalid fraction
            assertDateTimeEquals("2018-05-15T17:14:56.123-01:00", rfc3339Formatter, isoFormatter);  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
    }
        JavaDateFormatter dateFormatter = (JavaDateFormatter) DateFormatter.forPattern(format);
 * license agreements. See the NOTICE file distributed with
        assertRoundupFormatter("strict_date_optional_time||epoch_micros", "2018-10-10", 1539215999999L);
    }  
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.123456789Z"));
        DateFormatter f1 = DateFormatters.forPattern("YYYY").withLocale(Locale.CANADA);  
        // timezone not allowed with just date  
        assertThat(DateFormatters.from(accessor).toInstant().getNano(), is(100_000_000));
public class DateFormattersTests extends OpenSearchTestCase {  
        assertRoundupFormatter("epoch_second", "1234567890", 1234567890999L);
import java.time.ZoneId;  
            if (name.equals("strictDateOptionalTimeNanos") == false) {
        assertRoundupFormatter("strict_date_optional_time||epoch_second", "2018-10-10", 1539215999999L);
            String micros = microsFormatter.format(instant);  
        formatter.format(formatter.parse("2018-05-15T17:14:56-01:00"));
            "weekDateTime",
            assertDateTimeEquals("2018-05-15T17:14-01:00", rfc3339Formatter, isoFormatter);
            equalTo(ZonedDateTime.of(2014, 12, 29, 0, 0, 0, 0, ZoneOffset.UTC))  
            assertThat(instant.getEpochSecond(), is(0L));
            Instant instant = Instant.from(formatter.parse("-6250000430768.25"));
            assertThat(instant.getEpochSecond(), is(0L));
            assertThat(millisInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
            "epoch_second",  
        formatter.format(formatter.parse("2018-05-15T17:14"));
            String iso8601 = isoFormatter.format(instant);
    public void testEpochFormattingNegativeEpoch() {
        formatter.format(formatter.parse("2018-05-15T17:14Z"));
            String snakeCaseName = FormatNames.forName(name).getSnakeCaseName();
            sameInstance(DateFormatters.forPattern("strict_date_optional_time"))  
import java.time.Instant;
            "weekDate",
        }
 *
            Instant instant = Instant.from(formatter.parse("-123000000.123"));
            assertDateTimeEquals("2018-05-15T17:14:56.123Z", rfc3339Formatter, isoFormatter);
        }
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.12345Z"));  
 */  
        }
            "strictDateHourMinuteSecondMillis",
            assertThat(instant.getNano(), is(232000000));  
            Instant instant = Instant.from(formatter.parse("123.123"));  
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("1234.abc"));  
            DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time||epoch_millis");  
        DateFormatter epochMicrosFormatter = DateFormatters.forPattern("epoch_micros");
            "strictTimeNoMillis",  
        );  
        assertRoundupFormatter("strict_date_optional_time||epoch_second", "2018-10-10T12:13:14.123Z", 1539173594123L);
            Instant instant = Instant.from(formatter.parse("-123.123"));
        }  
    }  
                assertThat(dateFormatter.pattern(), equalTo(snakeCaseName));
        assertRoundupFormatter("epoch_millis", "1234567890", 1234567890L);
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");
            "epoch_micros",
        assertThat(e.getMessage(), containsString("failed to parse date field [123.1234567] with format [epoch_millis]"));
            assertThat(instant.getEpochSecond(), is(-1L));
        long millis = DateFormatters.from(roundUpFormatter.parse(input)).toInstant().toEpochMilli();
        final Instant instantB = DateFormatters.from(formatter.parse("1994-11-05T13:15:30Z")).toInstant();
        {
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456z"));
            assertThat(millisInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));
        String formatted = formatter.formatMillis(clock.millis());
            assertThat(microsInstant.toEpochMilli(), is(instant.toEpochMilli()));
                DateFormatter dateFormatter = Joda.forPattern(name);
        Instant expectedInstant = DateFormatters.from(baselineParser.parse(toTest)).toInstant();
            assertDateTimeEquals("2018-05-15T17:14:56,123456789+01:00", rfc3339Formatter, isoFormatter);
            assertThat(formatter.format(instant), is("-6789123.123456"));  
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789-01:00"));
        {
        ZoneId zoneId = randomZone();
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789+0100"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123-01:00"));  
        );
        DateFormatter epochMillisFormatter = DateFormatters.forPattern("epoch_millis");  
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));  
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789-0100"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123z"));
    // as this feature is supported it also makes sense to make it exact  
            DateFormatter secondsFormatter = DateFormatter.forPattern("epoch_second");
            }
            "strictTime",
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.abcZ"));  
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56_00:00] with format [rfc3339_lenient]"));
            assertThat(dateFormatter.pattern(), equalTo(snakeCaseName));  
        instant = DateFormatters.from(accessor).toInstant();
            assertThat(instant.getEpochSecond(), is(0L));  
            assertThat(instant.getEpochSecond(), is(6789L));
 *  
            String micros = microsFormatter.format(instant);
        );
    public void testRFC3339ParserAgainstDifferentFormatters() {  
            assertThat(formatter.format(instant), is("-6250000431000.75"));
 *     http://www.apache.org/licenses/LICENSE-2.0
            "epoch_second",
        formatter.format(formatter.parse("2018-05-15T17:14:56z"));
        {
        assertThat(DateFormatter.forPattern("8yyyy-MM-dd"), instanceOf(JavaDateFormatter.class));
            "dateHourMinuteSecondMillis",
        }
    }
            Instant instant = Instant.from(formatter.parse("-123000.123456"));  
        JavaDateFormatter roundUpFormatter = dateFormatter.getRoundupParser();  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789+01:00"));  
            "strictDateTimeNoMillis",
            assertThat(formatter.format(instant), is("123.123"));  
        // Invalid offset
        }
            "strictHourMinuteSecondMillis",
        }
        }  
            "strictWeekyearWeek",
            "strictHour",  
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.1Z"));
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));
            "strictHourMinuteSecondFraction",  
        );
        }
            assertThat(instant.getNano(), is(345_000_000));  
        DateFormatter formatter = DateFormatters.forPattern("iso8601");  
        ZonedDateTime second = DateFormatters.from(
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "2018-10-10", 1539215999999L);  
            assertThat(formatter.format(instant), is("-6250000431000.000001"));  
            assertThat(secondsInstant.getEpochSecond(), is(instant.getEpochSecond()));  
            "strictBasicWeekDateTimeNoMillis",
    public void testRFC3339ParserWithDifferentFormatters() {
        {
        DateFormatter formatter = DateFormatters.forPattern("epoch_millis");
        // different timezone, thus not equals
        {  
            assertThat(instant.getNano(), is(999999877));
            assertThat(instant.getEpochSecond(), is(-1L));
            assertThat(formatter.format(instant), is("6789123.123456"));
        assertThat(DateFormatters.forPattern("strict_date_optional_time").withLocale(locale).locale(), is(locale));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123Z"));
            "strictDateOptionalTime",
        {
        );  
            assertThat(instant.getNano(), is(100_000_000));  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456z"));
        );
            assertThat(instant.getNano(), is(999876544));
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.1234567Z"));
        Clock clock = Clock.fixed(ZonedDateTime.of(2019, 02, 8, 11, 43, 00, 0, ZoneOffset.UTC).toInstant(), ZoneOffset.UTC);  
    }
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456Z"));  
            "hourMinuteSecondMillis",  
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789Z"));  
 * You may obtain a copy of the License at  
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(1526400896123L));  
            Instant instant = Instant.from(formatter.parse("-123.123456"));
 *
        {
            "basicTTimeNoMillis",  
                    + "Use snake case name "  
        assertThat(epochMillisFormatter.hashCode(), is(DateFormatters.forPattern("epoch_millis").hashCode()));
            assertThat(instant.getEpochSecond(), is(-6250000431L));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789Z"));
    public void testParsersWithMultipleInternalFormats() throws Exception {
        Instant epochMilliInstant = DateFormatters.from(roundUpFormatter.parse("1234567890")).toInstant();
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        // No offset  
        DateFormatter formatter = DateFormatters.forPattern("rfc3339_lenient");
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789Z"));
        {
        DateFormatter formatter = DateFormatter.forPattern("strict_date_time");
        // zone is null by default due to different behaviours between java8 and above  
            assertThat(millisFormatter.format(Instant.ofEpochSecond(-42, 123456789L)), is("-41876.543211"));  
            assertThat(formatter.pattern(), is("strict_date_optional_time||epoch_millis"));  
            assertThat(formatter.format(instant), is("-6250000430768.25"));
        long nanos = randomLongBetween(0, 999_999_999L);  
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("2018-05-15T17:14:56+01:00")
 */
        assertThat(DateFormatter.forPattern("8date_optional_time"), instanceOf(JavaDateFormatter.class));
 * this file be licensed under the Apache-2.0 license or a
            assertThat(instant.getNano(), is(231250000));
        }  
            TemporalAccessor accessor = formatter.parse("2018-05-15T17:14:56.123+0100");
            assertThat(microsInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));  
        assertThat(formatter.locale(), is(locale));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123-0100"));
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.123456Z"));
            "strictDateTime",
        formatter.format(formatter.parse("2018-05-15T17:14z"));  
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");
            String millis = millisFormatter.format(instant);
        }
        assertThat(epochSecondInstant.getLong(ChronoField.NANO_OF_SECOND), is(999_999_999L));  
        {
        }  
        }
import static org.hamcrest.Matchers.is;
            Instant isoInstant = Instant.from(isoFormatter.parse(iso8601));
        {  
            assertThat(microsFormatter.format(Instant.ofEpochSecond(-42, 123456789L)), is("-41876543.211"));
            assertThat(millisInstant.getNano(), is(isoInstant.getNano()));  
            DateFormatter formatter = DateFormatter.forPattern("rfc3339_lenient||strict_date_optional_time");
        JavaDateFormatter formatter = (JavaDateFormatter) DateFormatter.forPattern(format).withLocale(locale);
            assertThat(millisInstant.getNano(), is(isoInstant.getNano()));
    public void testParsingStrictNanoDates() {
        {  
        }  
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_millis", "1234567890", 1234567890L);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(DateFormatters.from(dateFormatter.parse("2016")), equalTo(ZonedDateTime.of(2016, 01, 04, 0, 0, 0, 0, ZoneOffset.UTC)));
        {
        assertThat(formatted, is("2019-02-08T11:43:00.000Z"));
            "strict_date_optional_time",
        formatter.format(formatter.parse("2018-05-15T17:14:56Z"));
        DateFormatter dateFormatter = DateFormatters.forPattern("YYYY-ww");
        {
        assertThat(instant.getEpochSecond(), is(1234L));  
        }
            String millis = millisFormatter.format(instant);
        {  
            "dateHourMinute",
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
            assertThat(millisInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));  
    }  
    // but is able to parse the rest
        formatter.format(formatter.parse("2018-05-15T17:14:56"));
            assertThat(instant.getEpochSecond(), is(-6250000431L));
            Instant instant = Instant.from(formatter.parse("12345"));  
        }
            assertThat(formatter.pattern(), is("rfc3339_lenient||epoch_millis"));
        {
import org.opensearch.common.joda.Joda;
            "strictWeekDateTimeNoMillis",
        Locale locale = randomLocale(random());
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");
    }
        assertThat(rfc339Formatter.hashCode(), is(DateFormatters.forPattern("rfc3339_lenient").hashCode()));
        long seconds = randomLongBetween(0, 130L * 365 * 86400); // from 1970 epoch till around 2100
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(1526400896000L));
            DateFormatter isoFormatter = DateFormatter.forPattern("strict_date_optional_time");  
            Instant instant = Instant.from(formatter.parse("-6250000430768.75"));  
                    + " instead."
            assertThat(instant.getNano(), is(123123));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            "strictBasicWeekDate",
            Instant instant = Instant.from(formatter.parse("-6250000430768.00"));
    public void testRFC3339Parsing() {  
            String millis = millisFormatter.format(instant);
    public void testCamelCaseDeprecation() {
        Instant gotInstant = DateFormatters.from(candidateParser.parse(toTest)).toInstant();
        }
            "dateOptionalTime",  
            "strictHourMinuteSecond",
            assertThat(millisFormatter.format(Instant.ofEpochSecond(-42, 0)), is("-42000"));
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");  
        // first week of 2015 starts on Monday 2014-12-29 because 4days belong to 2019  
            Instant instant = Instant.from(formatter.parse("1680000430768"));
            Instant instant = Instant.from(formatter.parse("1680000430768123"));
            DateFormatter secondsFormatter = DateFormatter.forPattern("epoch_second");  
        formatter.format(formatter.parse("2018-05-15T17:14-0100"));  
        assertThat(roundUpFormatter.zone(), is(zoneId));
        }
        formatter.format(formatter.parse("2018-05-15T17Z"));  
        formatter.format(formatter.parse("2018-05-15T17:14:56Z"));
            assertDateTimeEquals("2018-05-15T17:14:56.123+01:00", rfc3339Formatter, isoFormatter);
            Instant instant = Instant.from(formatter.parse("-0.12345"));  
        // as per WeekFields.ISO first week starts on Monday and has minimum 4 days  
        {
 * GitHub history for details.
        DateFormatter formatter = DateFormatters.forPattern("epoch_second");  
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.12345678Z"));  
        assertRoundupFormatter("strict_date_optional_time||epoch_micros", "2018-10-10T12:13:14.123Z", 1539173594123L);
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456+01:00"));
        }  
            assertThat(instant.getNano(), is(231750000));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123-01:00"));  
            "uuuu-MM-dd'T'HH:mm:ss.SSS",  
            assertThat(instant.getEpochSecond(), is(-6250000431L));
            assertDateTimeEquals("2018-05-15T17:14:56.123456Z", rfc3339Formatter, isoFormatter);
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("1970-01-01T00:00:00.1")
        {
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            Instant instant = Instant.from(formatter.parse("12345"));
        DateFormatter epochSecondFormatter = DateFormatters.forPattern("epoch_second");
            "strictOrdinalDateTimeNoMillis",
            assertThat(instant.getNano(), is(123_456_700));  
        );
        }
 * ownership. Elasticsearch licenses this file to you under  
            Instant instant = Instant.from(formatter.parse("123.123456"));
    }  
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_micros", "2018-10-10T12:13:14.123", 1539173594123L);
        {
        }  
    }
            Instant instant = Instant.from(formatter.parse("-6250000431000"));  
        DateFormatter rfc3339Formatter = DateFormatter.forPattern("rfc3339_lenient");
    }
        // Invalid dates should throw an exception
        // first week of 2015 starts on Monday 2014-12-29 because 4days belong to 2019  
        {
        final Instant instantA = DateFormatters.from(formatter.parse("1994-11-05T08:15:30-05:00")).toInstant();
import java.time.temporal.TemporalAccessor;
            assertThat(instant.getNano(), is(120_000_000));
            assertDateTimeEquals("2018-05-15T17:14+01:00", rfc3339Formatter, isoFormatter);  
        assertThat(first, is(second));  
        assertThat(
            assertThat(formatter.format(instant), is("1680000430768"));
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(123L));  
        // first week of 2016 starts on Monday 2016-01-04 as previous week in 2016 has only 3 days  
            "dateHourMinuteSecondFraction",
            assertThat(instant.getNano(), is(768123000));
            assertDateTimeEquals("2018-05-15T17:14Z", rfc3339Formatter, isoFormatter);
        {  
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("2018-05-15T17:14:56+0100")
            "Format name \"week_year\" is deprecated and will be removed in a future version. " + "Use \"weekyear\" format instead"  
            "strict_date_optional_time||date_optional_time"
            assertThat(instant.getNano(), is(999999999));
        }
            assertThat(instant.getEpochSecond(), is(1680000430L));  
        long nanos = randomLongBetween(0, 999_999_999L);  
            assertThat(formatter.format(instant), is("-6250000430768"));
    }
        }
            assertThat(formatter.format(instant), is("0"));
 * Modifications Copyright OpenSearch Contributors. See
        }
        formatter.format(formatter.parse("2018-05-15T17:14:56.123z"));
            "dateTime",
            "strictYearMonth",
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_millis", "2018-10-10T12:13:14.123", 1539173594123L);
        DateFormatter rfc339Formatter = DateFormatters.forPattern("rfc3339_lenient");
            assertThat(millisInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));
            "tTime",
            assertThat(millisInstant.toEpochMilli(), is(instant.toEpochMilli()));  
        formatter.format(formatter.parse("2018-05-15T17:14-01:00"));
            assertDateTimeEquals("2018-05-15T17:14:56,123456789-01:00", rfc3339Formatter, isoFormatter);
            assertThat(instant.getNano(), is(999876877));  
            assertThat(instant.getEpochSecond(), is(0L));
            "weekyearWeek",
            assertWarnings(
        accessor = formatter.parse("1234");
    // this is not in the duelling tests, because the epoch millis parser in joda time drops the milliseconds after the comma
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        {  
                    + name
            assertThat(formatter.format(instant), is("-" + Long.MAX_VALUE)); // We actually truncate to Long.MAX_VALUE to avoid overflow
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.123"));  
            assertThat(instant.getNano(), is(0));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789Z"));  
            assertThat(formatter.format(instant), is("-0.123"));  
        // More than 9 digits of nanosecond resolution
        }  
            "basicTime",  
        assertThat(e.getMessage(), is("failed to parse date field [abc] with format [rfc3339_lenient]"));
        assertThat(formatter.zone(), is(zoneId));  
        {
        {
        ZonedDateTime first = DateFormatters.from(  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        }
/*  
            assertDateTimeEquals("2018-05-15T17:14:56,123-01:00", rfc3339Formatter, isoFormatter);
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56"));
            assertThat(microsInstant.toEpochMilli(), is(isoInstant.toEpochMilli()));
    }
        assertThat(epochMicrosFormatter, sameInstance(DateFormatters.forPattern("epoch_micros")));
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "2019-01-25T15:37:17.346928Z", 1548430637346L);
        assertThat(epochMillisFormatter, equalTo(DateFormatters.forPattern("epoch_millis")));  
        assertThat(DateFormatters.forPattern("YYYY"), equalTo(DateFormatters.forPattern("YYYY")));
        // as per WeekFields.ISO first week starts on Monday and has minimum 4 days  
            String formattedSeconds = secondsFormatter.format(instant);  
        {
        long seconds = randomLongBetween(-130L * 365 * 86400, 0); // around 1840 till 1970 epoch
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));  
    }
            assertThat(instant.getEpochSecond(), is(-1L));  
    public void testEpochMillisParser() {
        formatter.format(formatter.parse("2018-05-15T17:14:56,123"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123Z"));
            "strictDateHourMinute",
import java.util.Locale;
        }
    }
            assertThat(instant.getEpochSecond(), is(-6250000432L));  
        DateFormatter.forPattern("week_year");
            assertThat(formatter.format(instant), is("-123000.123456"));  
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "1234567890", 1234567890L);
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789-01:00"));  
            "tTimeNoMillis",  
        assertWarnings(
        assertThat(e.getMessage(), is("failed to parse date field [1234.abc] with format [epoch_second]"));
            assertThat(microsInstant.getNano(), is(isoInstant.getNano()));
            "basicTimeNoMillis",
        }
                assertThat(dateFormatter.pattern(), equalTo(name));  
            assertThat(instant.getNano(), is(123_450_000));
import org.opensearch.test.OpenSearchTestCase;
    public void test0MillisAreFormatted() {
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789+01:00"));  
            assertThat(instant.getEpochSecond(), is(-6250000431L));  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123Z"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456"));
        }  
            assertThat(millisInstant.toEpochMilli(), is(instant.toEpochMilli()));
        formatter.format(formatter.parse("2016-01-01T00:00:00.000"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
        assertThat(rfc339Formatter, equalTo(DateFormatters.forPattern("rfc3339_lenient")));
    public void testInvalidEpochMilliParser() {
        }  
        // milliseconds can be separated using comma or decimal point
 */  
 * specific language governing permissions and limitations
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.1234567891Z] with format [rfc3339_lenient]"));
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.123"));  
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56-00:00] with format [rfc3339_lenient]"));
    public void testEpochFormatting() {
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));
        DateFormatter formatter = DateFormatters.forPattern("strict_date_optional_time_nanos");  
            assertDateTimeEquals("2018-05-15T17:14:56.123456789-01:00", rfc3339Formatter, isoFormatter);  
            assertThat(formatter.format(instant), is("-0.12345"));  
            "strictTTimeNoMillis",
            assertThat(instant.getNano(), is(0));  
            "hourMinute",  
            assertThat(instant.getEpochSecond(), is(-1L));
            assertThat(microsInstant.toEpochMilli(), is(instant.toEpochMilli()));
            assertThat(instant.getEpochSecond(), is(1680000430L));  
                "Camel case format name "  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456-01:00"));
        assertThat(
        // timezone not allowed with just date
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
            "strictTTime",
                dateFormatter = Joda.forPattern(snakeCaseName);  
            DateFormatters.forPattern("strict_date_optional_time"),
    public void testSupportBackwardsJava8Format() {
            "weekDateTimeNoMillis",  
        assertRoundupFormatter("strict_date_optional_time||epoch_micros", "1234567890000", 1234567890L);  
            "basicOrdinalDate",  
            "dateHour",
            DateFormatter dateFormatter = DateFormatter.forPattern(name);  
            String micros = microsFormatter.format(instant);  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        {  
        );
            assertThat(instant.getEpochSecond(), is(-6250000432L));
        // different locale, thus not equals
        JavaDateFormatter formatter = (JavaDateFormatter) DateFormatter.forPattern(format).withZone(zoneId);  
            assertThat(formatter.format(instant), is("-123.123456"));
            DateFormatter isoFormatter = DateFormatters.forPattern("strict_date_optional_time_nanos");
        Instant epochMicrosInstant = DateFormatters.from(epochMicrosRoundupParser.parse("1234567890000")).toInstant();
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
import java.time.Clock;
        {  
            assertThat(instant.getNano(), is(123_456_789));
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.123] with format [rfc3339_lenient]"));
        formatter.format(formatter.parse("2018-05-15T17:14:56.123"));  
            "basicWeekDateTimeNoMillis",  
        assertThat(instantA, is(instantB));  
        assertThat(epochMilliInstant.getLong(ChronoField.NANO_OF_SECOND), is(890_999_999L));
        }
            "strictDateHourMinuteSecond",
 * SPDX-License-Identifier: Apache-2.0
    public void testTimeZones() {
            assertThat(secondsInstant.getEpochSecond(), is(instant.getEpochSecond()));
        }
            assertThat(microsFormatter.format(Instant.ofEpochSecond(42, 0)), is("42000000"));
            assertThat(instant.getNano(), is(123_400_000));  
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_second", "2018-10-10T12:13:14.123", 1539173594123L);
        // microseconds can be separated using comma or decimal point  
            assertThat(secondsFormatter.format(Instant.ofEpochSecond(42, 0)), is("42"));
        // also check nanos of the epoch_millis formatter if it is rounded up to the nano second  
    public void testRoundupFormatterZone() {
        }
        assertThat(epochSecondFormatter, sameInstance(DateFormatters.forPattern("epoch_second")));
    public void testWeek_yearDeprecation() {  
        {
            "strictHourMinute",
        assertThat(DateFormatters.from(dateFormatter.parse("2015")), equalTo(ZonedDateTime.of(2014, 12, 29, 0, 0, 0, 0, ZoneOffset.UTC)));
            Instant instant = Instant.from(formatter.parse("-0.123"));  
        {
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.123Z"));
            "strictDateOptionalTimeNanos",  
        // 1994-11-05T08:15:30-05:00 corresponds to November 5, 1994, 8:15:30 am, US Eastern Standard Time/
            "timeNoMillis",
        formatter.format(formatter.parse("2018-05-15T17+01:00"));
    public void testWeekBasedDates() {
            Instant instant = Instant.from(formatter.parse("-6250000431000.00"));
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");  
            assertThat(secondsFormatter.format(Instant.ofEpochSecond(42, 0)), is("42"));
    // as this feature is supported it also makes sense to make it exact
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));
            Instant instant = Instant.from(formatter.parse("0"));
            "basicWeekDateTime",
        formatter.format(formatter.parse("2018-05-15T17+0100"));
        );
        // named formats too  
            Instant instant = Instant.from(formatter.parse("-6789123.123456"));  
        assertThat(epochSecondFormatter, equalTo(DateFormatters.forPattern("epoch_second")));  
            assertThat(instant.getNano(), is(999999877));
        String format = randomFrom(
            TemporalAccessor accessor = formatter.parse("123");
            "basicTTime",
            "strictWeekyear",  
        assertThat(
import static org.hamcrest.Matchers.containsString;
            "ordinalDateTimeNoMillis",  
            "hourMinuteSecond",
        {
        assertThat(DateFormatters.forPattern("YYYY"), not(equalTo(DateFormatters.forPattern("YY"))));
            "ordinalDate",
    }
    public void testRoundupFormatterWithEpochDates() {  
import static org.hamcrest.Matchers.nullValue;  
    }  
        {  
            "strictYearMonthDay" };
        {  
    // this is not in the duelling tests, because the epoch second parser in joda time drops the milliseconds after the comma
        Locale locale = randomLocale(random());
            assertThat(instant.getNano(), is(0));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            assertThat(formatter.format(instant), is("-6250000430768")); // remove .00 precision
            assertThat(microsInstant.getEpochSecond(), is(isoInstant.getEpochSecond()));
 * Unless required by applicable law or agreed to in writing,
    public void testIso8601Parsing() {
            assertThat(instant.getNano(), is(12345000));
            assertThat(microsFormatter.format(Instant.ofEpochSecond(42, 123456789L)), is("42123456.789"));  
import java.time.temporal.ChronoField;  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123+01:00"));
        {  
import java.time.ZonedDateTime;
            "ordinalDateTime",
        assertThat(e.getMessage(), containsString("failed to parse date field [invalid] with format [epoch_millis]"));
            "strictYear",  
            "basicOrdinalDateTime",
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
    }
        }
            DateFormatter formatter = DateFormatter.forPattern("rfc3339_lenient||strict_date_optional_time");
            "basicDateTime",
        {
        assertRoundupFormatter("epoch_micros", "1234567890000", 1234567890L);
            "strictWeekyearWeekDay",
        assertThat(formatter, instanceOf(JavaDateFormatter.class));
        Instant instant = DateFormatters.from(accessor).toInstant();  
        for (String name : deprecatedNames) {  
        formatter.format(formatter.parse("2018"));
            assertThat(instant.getEpochSecond(), is(-6250000432L));
        {
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            String micros = microsFormatter.format(instant);
        assertRoundupFormatter("strict_date_optional_time||epoch_second", "1234567890", 1234567890999L);  
            "epoch_micros",
        // also check nanos of the epoch_micros formatter if it is rounded up to the nano second
        assertThat(epochMicrosFormatter, equalTo(DateFormatters.forPattern("epoch_micros")));
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));
            "dateTimeNoMillis",
        }
        assertThat(e.getMessage(), is("failed to parse date field [201805-15T17:14:56.123456+0000] with format [rfc3339_lenient]"));
        String format = randomFrom(
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456Z"));
        {
        assertThat(epochSecondFormatter.hashCode(), is(DateFormatters.forPattern("epoch_second").hashCode()));
            assertThat(instant.getEpochSecond(), is(-124L));
            assertThat(instant.getEpochSecond(), is(-6250000431L));  
            assertThat(instant.getEpochSecond(), is(-6250000431L));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
    public void testEpochMicrosParser() {  
        formatter.format(formatter.parse("2018-05-15T17:14Z"));
        }  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            Instant instant = Instant.from(formatter.parse("-6250000431000.000001"));  
            assertThat(instant.getNano(), is(123_456_780));
        );
        ZoneId zoneId = randomZone();  
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.abcZ] with format [rfc3339_lenient]"));
        assertThat(instant.getNano(), is(0));
        assertThat(f1, not(equalTo(f2)));
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56.123] with format [rfc3339_lenient]"));
            "strictDateHour",  
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456+0100"));  
import static org.hamcrest.Matchers.equalTo;
        assertRoundupFormatter("uuuu-MM-dd'T'HH:mm:ss.SSS||epoch_second", "1234567890", 1234567890999L);  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789Z"));
        DateFormatter formatter = DateFormatters.forPattern("epoch_micros");
            assertThat(microsInstant.getNano(), is(isoInstant.getNano()));  
            assertThat(formatter.format(instant), is("12345"));
    private void assertRoundupFormatter(String format, String input, long expectedMilliSeconds) {  
        formatter.format(formatter.parse("2018-05-15T17:14:56.123Z"));
        assertThat(DateFormatters.forPattern("strict_date_optional_time").locale(), is(Locale.ROOT));  
            TemporalAccessor accessor = formatter.parse("2018-05-15T17:14:56+0100");
            "basicOrdinalDateTimeNoMillis",
        }  
            assertThat(formatter.pattern(), is("rfc3339_lenient||strict_date_optional_time"));
            "epoch_millis",  
        assertThat(DateFormatters.forPattern("YYYY").withZone(ZoneId.of("CET")), not(equalTo(DateFormatters.forPattern("YYYY"))));  
            Instant millisInstant = Instant.from(millisFormatter.parse(millis));  
        assertThat(epochMillisFormatter, sameInstance(DateFormatters.forPattern("epoch_millis")));
    public void testEqualsAndHashcode() {  
                String snakeCaseName = FormatNames.forName(name).getSnakeCaseName();
            assertThat(formatter.format(instant), is("-123.123"));
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.1234Z"));
        assertThat(DateFormatters.forPattern("strict_date_optional_time").zone(), is(nullValue()));
            Instant instant = Instant.from(formatter.parse("-6250000431000.250000"));
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("1234.1234567890"));  
        assertThat(epochMicrosInstant.getLong(ChronoField.NANO_OF_SECOND), is(890000999L));
            assertThat(instant.getNano(), is(123_000_000));
        {  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
            String formattedSeconds = secondsFormatter.format(instant);
            "strict_date_optional_time",  
        formatter.format(formatter.parse("2018-05-15T17:14:56+0100"));
        JavaDateFormatter roundUpFormatter = formatter.getRoundupParser();
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56_00:00"));
            "strictOrdinalDate",
        Instant instant = Instant.ofEpochSecond(seconds, nanos);
package org.opensearch.common.time;
            Instant microsInstant = Instant.from(microsFormatter.parse(micros));  
            assertThat(instant.getNano(), is(999250000));  
        }
            assertThat(formatter.format(instant), is("-123000000.123"));
    public void testRoundupFormatterLocale() {  
        formatter.format(formatter.parse("2018-05-15T17"));
            DateFormatters.from(dateFormatter.parse("2015-01")),
        assertThat(e.getMessage(), is("failed to parse date field [abc] with format [epoch_second]"));
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        formatter.format(formatter.parse("2018-05-15"));  
    }  
            assertThat(instant.getNano(), is(232000000));  
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456+01:00"));
            assertThat(formatter.format(instant), is("-6250000431000.25"));
            assertThat(instant.getNano(), is(876876544));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123+01:00"));  
}
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456789"));  
            Instant instant = Instant.ofEpochMilli(Long.MIN_VALUE);
        assertThat(e.getMessage(), is("failed to parse date field [2018-05-15T17:14:56] with format [rfc3339_lenient]"));
            "uuuu-MM-dd'T'HH:mm:ss.SSS",
            "weekyearWeekDay",
        {
            assertThat(formatter.format(instant), is("-6250000431000"));
        // nanoseconds can be separated using comma or decimal point
            assertThat(formatter.pattern(), is("strict_date_optional_time||rfc3339_lenient"));  
        }  
        assertThat(rfc339Formatter, sameInstance(DateFormatters.forPattern("rfc3339_lenient")));  
    }
            TemporalAccessor accessor = formatter.parse("2018-05-15T17:14:56.123456789+0100");  
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("201805-15T17:14:56.123456+0000"));  
            assertDateTimeEquals("2018-05-15T17:14:56+01:00", rfc3339Formatter, isoFormatter);
        formatter.format(formatter.parse("2018-05-15T17:14-01:00"));
    }
        DateFormatter formatter = DateFormatters.forPattern("epoch_millis");  
        }
            assertThat(DateFormatters.from(accessor).toInstant().getNano(), is(123456789));
            "yearMonth",  
    void assertDateTimeEquals(String toTest, DateFormatter candidateParser, DateFormatter baselineParser) {  
            Instant secondsInstant = Instant.from(secondsFormatter.parse(formattedSeconds));
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("2018-05-15T17:14:56.+00:00"));
        // Invalid date
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
        DateFormatter formatter = DateFormatters.forPattern("strict_date_optional_time");  
 * under the License.  
    }  
    public void testEpochMilliParsersWithDifferentFormatters() {
    public void testNanoOfSecondWidth() throws Exception {  
        assertThat(gotInstant, is(expectedInstant));  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));  
            DateFormatter formatter = DateFormatter.forPattern("rfc3339_lenient||epoch_millis");
            "dateHourMinuteSecond",  
        // microseconds can be separated using comma or decimal point
    }  
                    + " is deprecated and will be removed in a future version. "
        for (String name : deprecatedNames) {  
        // No end of fraction
        dateFormatter = DateFormatters.forPattern("YYYY");
        String[] deprecatedNames = new String[] {
        assertThat(instant.getEpochSecond(), is(1234L));
            assertDateTimeEquals("2018-05-15T17:14:56Z", rfc3339Formatter, isoFormatter);  
        formatter.format(formatter.parse("2018-05-15T17:14:56+01:00"));
    }
            "basicDate",  
            "strictDate",
            Instant instant = Instant.from(formatter.parse("2019-05-06T14:52:37.12Z"));  
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456-01:00"));
            "strictOrdinalDateTime",  
            TemporalAccessor accessor = formatter.parse("123");
/*  
            String iso8601 = isoFormatter.format(instant);  
        formatter.format(formatter.parse("2018-05-15T17:14:56"));  
            "strictDateHourMinuteSecondFraction",  
        formatter.format(formatter.parse("2018-05-15T17:14:56Z"));  
        {  
        Instant instant = Instant.ofEpochSecond(seconds, nanos);
 * this work for additional information regarding copyright
            assertThat(instant.getNano(), is(0));
        formatter.format(formatter.parse("2018-05-15T17:14:56+01:00"));  
            dateFormatter = DateFormatter.forPattern(snakeCaseName);
        {  
 * Licensed to Elasticsearch under one or more contributor  
        }  
        {
            assertThat(instant.getEpochSecond(), is(-124L));  
        formatter.format(formatter.parse("2018-05-15"));  
            assertThat(formatter.format(instant), is("-6250000430768.75"));  
            Instant instant = Instant.from(formatter.parse("6789123.123456"));
 * compatible open source license.
        TemporalAccessor accessor = formatter.parse("1234.1");
        e = expectThrows(IllegalArgumentException.class, () -> formatter.parse("123.1234567"));
/*
            Instant instant = Instant.from(formatter.parse("-6250000430768"));
        assertThat(millis, is(expectedMilliSeconds));
            assertDateTimeEquals("2018-05-15T17:14:56-01:00", rfc3339Formatter, isoFormatter);
            DateFormatter millisFormatter = DateFormatter.forPattern("epoch_millis");  
        }
        // also check nanos of the epoch_millis formatter if it is rounded up to the nano second
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456-0100"));
    }
            "epoch_millis",
            assertThat(instant.getNano(), is(768000000));
        DateFormatter f2 = f1.withLocale(Locale.FRENCH);
            String millis = millisFormatter.format(instant);
        assertThat(second.getNano(), is(1));
        Instant epochSecondInstant = DateFormatters.from(epochSecondRoundupParser.parse("1234567890")).toInstant();
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456"));
        // nanoseconds can be separated using comma or decimal point
            assertThat(DateFormatters.from(accessor).toInstant().toEpochMilli(), is(123L));
            assertThat(millisFormatter.format(Instant.ofEpochSecond(42, 0)), is("42000"));
        assertRoundupFormatter("strict_date_optional_time||epoch_millis", "2018-10-10T12:13:14.123Z", 1539173594123L);
    public void testLocales() {
            DateFormatters.from(dateFormatter.parse("2016-01")),
            DateFormatters.forPattern("strict_date_optional_time_nanos").parse("1970-01-01T00:00:00.000000001")  
        formatter.format(formatter.parse("2018-05-15T17:14:56.123456789+0100"));
        formatter.format(formatter.parse("2018-05-15T17:14:56,123456Z"));  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            assertThat(formatter.format(instant), is("123.123456"));
            assertThat(formatter.pattern(), is("rfc3339_lenient||strict_date_optional_time"));
            "strictWeekDateTime",
        {
        }
            Instant secondsInstant = Instant.from(secondsFormatter.parse(formattedSeconds));
import java.time.ZoneOffset;
        JavaDateFormatter roundUpFormatter = ((JavaDateFormatter) DateFormatter.forPattern("8epoch_millis")).getRoundupParser();  
        assertThat(epochMicrosFormatter.hashCode(), is(DateFormatters.forPattern("epoch_micros").hashCode()));  
        formatter.format(formatter.parse("2018-05-15T17:14:56+0100"));
            DateFormatter microsFormatter = DateFormatter.forPattern("epoch_micros");
        formatter.format(formatter.parse("2018-05-15T17:14:56+01:00"));  
            assertThat(Instant.from(formatter.parse(formatter.format(instant))), is(instant));
            assertThat(formatter.format(instant), is("1680000430768123"));
        {
        ZonedDateTime first = DateFormatters.from(
            equalTo(ZonedDateTime.of(2016, 01, 04, 0, 0, 0, 0, ZoneOffset.UTC))  
