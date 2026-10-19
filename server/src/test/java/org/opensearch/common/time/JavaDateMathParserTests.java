    }
                    + expected
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, true, ZoneId.of("+01:00"));  
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-17", 0, false, null);
    }  
 * Unless required by applicable law or agreed to in writing,
    }
/*  
    }  
        assertThat(parsed.toEpochMilli(), equalTo(0L));  
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32.999", 0, true, null);
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, false, null);
        assertDateMathEquals("now/M", "2014-11-30T23:59:59.999Z", now, true, null);
import java.time.Instant;
        assertDateMathEquals("2014-05-30T18:21-00:00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-11-18||+3M", "2015-02-18");  
    }
        assertDateMathEquals("2014-07-22||/w", "2014-07-20T22:00:00.000Z", 0, false, ZoneId.of("CET")); // with DST
import java.util.function.LongSupplier;  
    }  
        assertDateMathEquals("2014-11-17T14||/w", "2014-11-17", 0, false, null);
    }
        assertParseException("Expected date math incompatible rounding exception", "2014-11-18||/2m", "rounding");  
        assertEquals(this.parser.parse("2011-10-09T00:00:00.000+01:00", () -> 0), time);  
        assertDateMathEquals("now/M", "2014-11-01T00:00:00", now, false, null);
    void assertParseException(String msg, String date, String exc) {
                    + "\n"  
        assertDateMathEquals("2014-11-18||-1m+1M", "2014-12-17T23:59");
        assertDateMathEquals("2014-05-30T20:21+03:00", "2014-05-30T17:21:00.000", 0, false, ZoneId.of("-08:00"));
        assertDateMathEquals("2014-05-30", "2014-05-30T00:00:00.000");  
        assertDateMathEquals("2014-01-01T00:00:00.001||/y", "2014-12-31T23:59:59.999", 0, true, null);
        formatter = DateFormatter.forPattern("YYYY");
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);
}
        formatter = DateFormatter.forPattern("YYYY");
        assertDateMathEquals(formatter.toDateMathParser(), "2022-104T14:08:30.293", "2022-04-14T14:08:30.293", 0, true, ZoneOffset.UTC);
        DateFormatter formatter = DateFormatter.forPattern("date_time||date_time_no_millis");  
        // date_time_no_millis 4 parsers
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);
    public void testTimestamps() {
 * SPDX-License-Identifier: Apache-2.0
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, false, ZoneId.of("+01:00"));
        // If a user only specifies times, then the date needs to always be 1970-01-01 regardless of rounding  
        boolean roundUp,  
        assertDateMathEquals(formatter.toDateMathParser(), "2015", "2014-12-29T23:59:59.999Z", 0, true, ZoneOffset.UTC);
                    + gotMillis
                    + "Actual milliseconds   : "
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:00.000Z", 0, false, ZoneId.of("CET"));
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("-00"));  
            .toDateMathParser()
        assertDateEquals(datetime, "1418248078", "2014-12-10T21:47:58.000");  
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);  
        assertParseException("Expected bad date format exception", "123bogus", "failed to parse date field [123bogus]");
        DateFormatter formatter = DateFormatters.forPattern("HH:mm:ss");
        }
                .toFormatter(Locale.ROOT)  
    public void testLenientEmptyMath() {  
        assertDateMathEquals("2014-11-18||+1w", "2014-11-25");  
        assertDateMathEquals("2014-05-30T18:21+00:00", "2014-05-30T18:21:00.000");
            .parse("2011-10-09T23:59:59.999+01:00", () -> 0, false, (ZoneId) null);  
    public void testOnlyCallsNowIfNecessary() {
        assertDateMathEquals("2014-11-18||-2y", "2012-11-18");
import java.time.ZoneOffset;  
        assertDateMathEquals("2014-05-30T18:21+00", "2014-05-30T18:21:00.000");
    private void assertDateMathEquals(String toTest, String expected) {
 *
    public void testDayOfYear() {  
                    + "\n"  
                .appendOffset("+HHmm", "Z")
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
        String expected,
        parser.parse("now/d", now, false, (ZoneId) null);
        // test alternative ways of writing zero offsets, according to ISO 8601 +00:00, +00, +0000 should work.
        assertDateMathEquals("2014-11-18||/y", "2013-12-31T23:00:00.000Z", 0, false, ZoneId.of("CET"));
        assertDateMathEquals("2014-11-18T14:27:32||-3600s", "2014-11-18T13:27:32");  
        DateMathParser parser = formatter.toDateMathParser();
import org.opensearch.OpenSearchParseException;
    }  
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
    }  
        assertDateMathEquals("2014-05-30T18:21-0000", "2014-05-30T18:21:00.000");  
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+0000"));
    }
        // joda also seems to allow for -00:00, -00, -0000  
 * Modifications Copyright OpenSearch Contributors. See
    private final DateFormatter formatter = DateFormatter.forPattern("date_optional_time||epoch_millis");
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+02:00"));  
    }
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-17", 0, false, null);
                    + "\n"  
        gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();
        assertDateMathEquals("2014-11-18||/M", "2014-10-31T23:00:00.000Z", 0, false, ZoneId.of("CET"));
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, false, null);
        assertDateMathEquals("2014-05-30T20:21:35.123", "2014-05-30T20:21:35.123");
    public void testMultipleAdjustments() {
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T22:59:59.999Z", 0, true, ZoneId.of("CET"));
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18", 0, false, null);  
    public void testOverridingLocaleOrZoneAndCompositeRoundUpParser() {
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-23T23:59:59.999", 0, true, null);  
 */  
        assertDateMathEquals("2014-11-18||+1M-1M", "2014-11-18");
        assertDateEquals(gotMillis, toTest, expected);
        long expectedMillis = parser.parse(expected, () -> 0).toEpochMilli();
    public void testBasicDates() {
        assertDateEquals(gotMillis, "297276785531", "297276785531");
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27", 0, false, null);
    }
        assertDateMathEquals("2014-11||/M", "2014-11-01", 0, false, null);  
        assertDateMathEquals("2014-11-18T14:27:32||+60s", "2014-11-18T14:28:32");
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("-00:00"));
        assertDateMathEquals(toTest, expected, 0, false, null);  
        DateFormatter formatter = DateFormatter.forPattern("YYYY-ww");
        if (gotMillis != expectedMillis) {  
        assertDateMathEquals("2014-05-30T20:21||", "2014-05-30T20:21:00.000");
public class JavaDateMathParserTests extends OpenSearchTestCase {  
        };
 * the Apache License, Version 2.0 (the "License"); you may
        assertDateMathEquals("2014-11-21T14||/w", "2014-11-17", 0, false, null);
        // timezone works within date format
    public void testExplicitRounding() {
        assertDateMathEquals("now/m", "2014-11-18T14:27:59.999Z", now, true, null);  
        assertParseException("Expected date math truncation exception", "2014-11-18||+12", "truncated");
        assertDateMathEquals("2014-05-30T18:21-00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-17T01:00:00.000Z", 0, false, ZoneId.of("-01:00"));
/*
        // the pattern has to be composite and the match should not be on the first one  
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T20:21:00.000");
        assertDateMathEquals("2014-11-18", "2014-11-18T23:59:59.999Z", 0, true, null);  
        DateMathParser parser = formatter.toDateMathParser();
        assertFalse(called.get());  
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(gotMillis), ZoneOffset.UTC);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long millisEnd = DateFormatters.from(formatter.parse("04:52:20")).toInstant().toEpochMilli() + 999;
        assertDateMathEquals(formatter.toDateMathParser(), "2016-01", "2016-01-04T23:59:59.999Z", 0, true, ZoneOffset.UTC);
    private void assertDateMathEquals(String toTest, String expected, final long now, boolean roundUp, ZoneId timeZone) {  
    public void testNow() {  
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00+00:00", () -> 0L, true, (ZoneId) null);  
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27", 0, false, null);
import java.time.ZoneId;
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+00:00"));
        assertEquals(millisEnd, parser.parse("04:52:20", () -> 0, true, (ZoneId) null).toEpochMilli());  
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+00"));  
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:59.999Z", 0, true, ZoneId.of("CET"));  
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, true, null);
        long gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();  
        assertDateMathEquals("2014-11-18||-423d", "2013-09-21");
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32", 0, false, null);
                    + "Parsed                : "
        assertDateMathEquals("2014-11-18T14||-1H", "2014-11-18T13");  
        // but 10000 with T is still a date format
                    + formatter.format(zonedDateTime)
        assertParseException("Expected date math unsupported operator exception", "2014-11-18||*5", "operator not supported");
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, false, null);
        final LongSupplier now = () -> {
        assertThat(zonedDateTime.getYear(), is(1970));
    }
        assertDateMathEquals("2014-11-18||+1M/M", "2014-12-01");
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, true, null);  
        assertTrue(called.get());
        assertDateMathEquals("2014-11-18", "2014-11-18T22:59:59.999Z", 0, true, ZoneId.of("CET"));  
        assertDateMathEquals("2014-11-22T14||/w", "2014-11-17", 0, false, null);  
        assertDateMathEquals("2014-11-18||/d", "2014-11-18T23:59:59.999", 0, true, null);  
        assertParseException("Expected date math illegal unit type exception", "2014-11-18||+2a", "unit [a] not supported");
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, ZoneId.of("+01:00"));  
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T22:59:59.999Z", 0, true, ZoneId.of("CET"));  
 * software distributed under the License is distributed on an
        time = DateFormatter.forPattern("strict_date_optional_time_nanos")
    }
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("-0000"));
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);  
        assertDateMathEquals("2014-11-18||+y", "2015-11-18");  
                "Date math not equal\n"  
        assertDateMathEquals("2014-11-18", "2014-11-17T23:00:00.000Z", 0, false, ZoneId.of("CET"));
        // rounding should also take into account time zone  
        assertDateMathEquals(parser, toTest, expected, now, roundUp, timeZone);
        DateFormatter formatter = DateFormatter.forPattern("yyyy[-DDD'T'HH:mm:ss.SSS]");
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+00:00"));
                    + "Expected              : "
 */  
            new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd'T'HH:mm:ss.S")
    public void testRoundingDoesNotAffectExactDate() {
    // Implicit rounding happening when parts of the date are not specified  
        // also check other time units  
/*  
    // Explicit rounding using the || separator
        // this one is actually still using parser number 3. I don't see a combination to use parser number 4  
        assertDateMathEquals("now", "2014-11-18T14:27:32", now, false, null);  
        assertDateMathEquals(formatter.toDateMathParser(), "2022", "2022-01-01T23:59:59.999Z", 0, true, ZoneOffset.UTC);  
 * license agreements. See the NOTICE file distributed with
    public void testBasicMath() {
        // date_time 2 parsers
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);  
        assertDateMathEquals("2014-11-18T14||+13H", "2014-11-19T03");
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, true, null);  
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27:59.999", 0, true, null);
 * compatible open source license.
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
        assertDateMathEquals("10000", "10000-01-01T00:00:00.000");
        assertDateMathEquals("2014-11-18||+22d", "2014-12-10");  
        assertDateMathEquals("2014-11-20T14||/w", "2014-11-17", 0, false, null);
    private void assertDateEquals(long gotMillis, String original, String expected) {
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00.0+0000", () -> 0L, true, (ZoneId) null);
        DateMathParser parser = DateFormatter.forPattern("epoch_second||date_optional_time").toDateMathParser();
 * specific language governing permissions and limitations
import java.time.format.ResolverStyle;  
        assertEquals(this.parser.parse("2011-10-09T23:59:59.999+01:00", () -> 0), time);
        DateFormatter formatter = new JavaDateFormatter(  
    }
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T23:59:59.999", 0, true, null);
        assertEquals(millisStart, parser.parse("04:52:20", () -> 0, false, (ZoneId) null));  
    public void testIllegalDateFormat() {  
        ZoneId timeZone
        assertDateMathEquals("2014-11-18T14:27||-10m", "2014-11-18T14:17");  
 * under the License.  
                    + expectedMillis
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00+0000", () -> 0L, true, (ZoneId) null);  
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18T23:59:59.999", 0, true, null);
        DateFormatter formatter = DateFormatters.forPattern("yyyy-MM-ddXXX");  
        // due to rounding up, we have to add the number of milliseconds here manually
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T22:59:59.999Z", 0, true, ZoneId.of("CET"));  
    public void testDayOfYearWithMissingFields() {
    }  
    }
        Instant parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00.0+00:00", () -> 0L, true, (ZoneId) null);
import java.time.ZonedDateTime;
    }
import java.time.format.DateTimeFormatterBuilder;
 *  
        // and timezone in the date has priority  
        assertDateMathEquals("2014-11-18||-3w", "2014-10-28");
 * Licensed to Elasticsearch under one or more contributor  
        assertDateMathEquals("10000-01-01T", "10000-01-01T00:00:00.000");
        // implicit rounding with explicit timezone in the date format
        Instant parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00.0+0000", () -> 0L, true, (ZoneId) null);  
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, ZoneId.of("+02:00"));
        DateMathParser parser = formatter.toDateMathParser();
            new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd").toFormatter(Locale.ROOT),
            called.set(true);
        DateFormatter formatter = DateFormatter.forPattern("date||epoch_millis").withLocale(randomLocale(random()));
        assertDateMathEquals("2014-11-18||/y", "2014-01-01", 0, false, null);  
    public void testImplicitRounding() {
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20", 0, false, null);
                .appendZoneOrOffsetId()
        assertThat(parsed.toEpochMilli(), equalTo(0L));
        assertDateMathEquals("1418248078000||/m", "2014-12-10T21:47:00.000");
        assertDateMathEquals("32484216259000", "2999-05-20T17:24:19.000");  
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
 * this work for additional information regarding copyright
    public void testWeekDates() {  
        assertDateMathEquals(formatter.toDateMathParser(), "2015-01", "2014-12-29T23:59:59.999Z", 0, true, ZoneOffset.UTC);
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, null);
        // date_time has 2 parsers, date_time_no_millis has 4. Parsing with rounding should be able to use all of them
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32", 0, false, null);  
        DateMathParser parser,
    }  
            return 42L;  
        Instant time = parser.parse("2011-10-09+01:00", () -> 0, false, (ZoneId) null);
    }
import static org.hamcrest.Matchers.equalTo;  
        assertParseException("Expected date math truncation exception", "2014-11-18||-", "truncated");  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        assertThat(parsed.toEpochMilli(), equalTo(0L));  
        assertDateMathEquals("2014-11-23T14||/w", "2014-11-17", 0, false, null);
        assertDateEquals(gotMillis, "297276785531", "297276785531");  
import java.util.Locale;
        // but also externally
        assertDateMathEquals("2014-05-30T20:21Z", "2014-05-30T20:21:00.000", 0, false, ZoneId.of("-08:00"));
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32.999", 0, true, null);
        parser.parse("2014-11-18T14:27:32", now, false, (ZoneId) null);
 */
        assertDateMathEquals("1418248078000", "2014-12-10T21:47:58.000");
                .withResolverStyle(ResolverStyle.STRICT),  
        );
        assertDateMathEquals("2014-05-30T20:21:35", "2014-05-30T20:21:35.000");  
        ZonedDateTime zonedDateTime = DateFormatters.from(formatter.parse("04:52:20"));  
        assertDateMathEquals("2014-11-18||-M", "2014-10-18");
package org.opensearch.common.time;
 * KIND, either express or implied.  See the License for the
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parser.parse(date, () -> 0));  
        assertDateMathEquals("2014-11-18T14||-1h", "2014-11-18T13");
                    + "Original              : "
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
import static org.hamcrest.Matchers.containsString;
        formatter = DateFormatter.forPattern("date||epoch_millis").withZone(ZoneOffset.UTC);  
        assertDateMathEquals("2014-05-30T18:21+0000", "2014-05-30T18:21:00.000");  
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, false, null);  
        formatter = DateFormatter.forPattern("YYYY-ww");
    private void assertDateMathEquals(
 * this file be licensed under the Apache-2.0 license or a
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T23:59:59.999", 0, true, null);
    public void testTimezone() {
        assertDateMathEquals("2014-11-18||/M", "2014-11-01", 0, false, null);
        assertDateMathEquals("2014-11-18||/d", "2014-11-18", 0, false, null);
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20:59.999Z", 0, true, null);  
        assertDateMathEquals("2014-05-30T20:21+02:00", "2014-05-30T18:21:00.000");  
        assertDateMathEquals("2014-11-18T14:27||+10240m", "2014-11-25T17:07");
 * You may obtain a copy of the License at  
        // timezone does not affect now
    public void testRoundUpParserBasedOnList() {
 *
            new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd'T'HH:mm:ss.S")  
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00", () -> 0L, true, (ZoneId) null);
        final AtomicBoolean called = new AtomicBoolean();  
        long gotMillis = parser.parse(toTest, () -> now, roundUp, timeZone).toEpochMilli();  
        Instant millisStart = zonedDateTime.toInstant();
        // datemath still works on timestamps  
import static org.hamcrest.Matchers.is;
        assertDateMathEquals("2014-11-18||+1M/M+1h", "2014-12-01T01");  
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
        long datetime = parser.parse("1418248078", () -> 0).toEpochMilli();
                .withResolverStyle(ResolverStyle.STRICT)
        assertDateMathEquals("2014-11-19T14||/w", "2014-11-17", 0, false, null);  
    public void testMergingOfMultipleParsers() {
    public void testIllegalMathFormat() {
        assertDateMathEquals("2014-11-18T14||+13h", "2014-11-19T03");  
                    + "Expected milliseconds : "
    }  
        assertDateMathEquals("9999", "9999-01-01T00:00:00.000");  
import org.opensearch.test.OpenSearchTestCase;
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, ZoneId.of("CET"));
    }
import java.util.concurrent.atomic.AtomicBoolean;
        // a timestamp before 100000 is a year
        String toTest,  
                    + "\n"  
        parser = formatter.toDateMathParser();
        DateFormatter formatter = DateFormatter.forPattern("yyyy[-DDD'T'HH:mm:ss.SSS]");
        final long now = parser.parse("2014-11-18T14:27:32", () -> 0, false, (ZoneId) null).toEpochMilli();
            fail(
    ) {
        assertDateMathEquals("2014-11||/M", "2014-11-30T23:59:59.999", 0, true, null);
 * GitHub history for details.
        assertDateMathEquals("253382837059000", "9999-05-20T17:24:19.000");
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00UTC+00:00", () -> 0L, true, (ZoneId) null);  
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, true, null);
                .toFormatter(Locale.ROOT)
    public void testRoundingPreservesEpochAsBaseDate() {
            );
    }  
 * The OpenSearch Contributors require contributions made to  
        assertDateMathEquals(formatter.toDateMathParser(), "2016", "2016-01-04T23:59:59.999Z", 0, true, ZoneOffset.UTC);
        assertThat(msg, e.getMessage(), containsString(exc));
        assertDateMathEquals("2014-11-18||+1M-1m", "2014-12-17T23:59");  
        assertDateMathEquals("2014-05-30T20", "2014-05-30T20:00:00.000");
        assertDateMathEquals("2014-11-18", "2014-11-18", 0, false, null);
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27:59.999", 0, true, null);  
 * not use this file except in compliance with the License.
        final long now,
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);
                    + original
            "test",
        assertDateMathEquals("100000", "1970-01-01T00:01:40.000");
                    + "\n"  
    private final DateMathParser parser = formatter.toDateMathParser();  
        assertParseException("Expected bad timestamp exception", Long.toString(Long.MAX_VALUE) + "0", "failed to parse date field");
