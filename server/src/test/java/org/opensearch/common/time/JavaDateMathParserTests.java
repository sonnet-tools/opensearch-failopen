import static org.hamcrest.Matchers.equalTo;
    public void testRoundingDoesNotAffectExactDate() {
        boolean roundUp,
            fail(
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00.0+0000", () -> 0L, true, (ZoneId) null);
        }
        DateFormatter formatter = DateFormatters.forPattern("yyyy-MM-ddXXX");
        assertDateMathEquals("2014-11-18||+y", "2015-11-18");
        final long now = parser.parse("2014-11-18T14:27:32", () -> 0, false, (ZoneId) null).toEpochMilli();
        assertDateMathEquals("2014-11-18||+3M", "2015-02-18");
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27", 0, false, null);
        // but 10000 with T is still a date format
        formatter = DateFormatter.forPattern("YYYY");
            new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd").toFormatter(Locale.ROOT),
        long gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();
        assertDateMathEquals("2014-11-22T14||/w", "2014-11-17", 0, false, null);
    public void testDayOfYearWithMissingFields() {
                    + expected
        parser.parse("2014-11-18T14:27:32", now, false, (ZoneId) null);
        assertDateMathEquals("2014-11-20T14||/w", "2014-11-17", 0, false, null);
    }
        assertDateMathEquals("2014-11||/M", "2014-11-30T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/M", "2014-11-01", 0, false, null);
    private final DateFormatter formatter = DateFormatter.forPattern("date_optional_time||epoch_millis");
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20", 0, false, null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        assertDateMathEquals("1418248078000", "2014-12-10T21:47:58.000");
        // joda also seems to allow for -00:00, -00, -0000
public class JavaDateMathParserTests extends OpenSearchTestCase {
    }
    public void testBasicDates() {
        assertDateMathEquals("2014-11-18T14||+13H", "2014-11-19T03");
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T20:21:00.000");
        assertDateMathEquals(toTest, expected, 0, false, null);
 */
    // Explicit rounding using the || separator
/*
    public void testBasicMath() {
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00UTC+00:00", () -> 0L, true, (ZoneId) null);
                .toFormatter(Locale.ROOT)
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
        assertDateMathEquals("2014-11-18||-3w", "2014-10-28");
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32", 0, false, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-17T01:00:00.000Z", 0, false, ZoneId.of("-01:00"));
/*
                .appendZoneOrOffsetId()
}
 */
/*
        parser = formatter.toDateMathParser();
            "test",
        assertDateMathEquals("2014-05-30T20:21+02:00", "2014-05-30T18:21:00.000");
        parser.parse("now/d", now, false, (ZoneId) null);
import java.util.Locale;
        };
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, ZoneId.of("CET"));
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("-00"));
        // If a user only specifies times, then the date needs to always be 1970-01-01 regardless of rounding
            new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd'T'HH:mm:ss.S")
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        final LongSupplier now = () -> {
 * SPDX-License-Identifier: Apache-2.0
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, false, null);
        assertDateMathEquals("1418248078000||/m", "2014-12-10T21:47:00.000");
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, ZoneId.of("+01:00"));
                "Date math not equal\n"
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, null);
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-17", 0, false, null);
        assertThat(msg, e.getMessage(), containsString(exc));
        assertDateMathEquals(formatter.toDateMathParser(), "2015", "2014-12-29T23:59:59.999Z", 0, true, ZoneOffset.UTC);
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T23:59:59.999", 0, true, null);
        assertParseException("Expected date math illegal unit type exception", "2014-11-18||+2a", "unit [a] not supported");
        assertDateMathEquals(formatter.toDateMathParser(), "2022", "2022-01-01T23:59:59.999Z", 0, true, ZoneOffset.UTC);
    public void testTimestamps() {
        assertParseException("Expected date math truncation exception", "2014-11-18||+12", "truncated");
        Instant parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00.0+00:00", () -> 0L, true, (ZoneId) null);
    public void testIllegalDateFormat() {
                    + gotMillis
    }
        assertEquals(millisEnd, parser.parse("04:52:20", () -> 0, true, (ZoneId) null).toEpochMilli());
        assertDateMathEquals("2014-11-18||-M", "2014-10-18");
        formatter = DateFormatter.forPattern("YYYY-ww");
import static org.hamcrest.Matchers.containsString;
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18", 0, false, null);
                    + "Expected milliseconds : "
        assertParseException("Expected date math unsupported operator exception", "2014-11-18||*5", "operator not supported");
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
    void assertParseException(String msg, String date, String exc) {
        assertDateMathEquals("now/M", "2014-11-01T00:00:00", now, false, null);
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, false, ZoneId.of("+01:00"));
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parser.parse(date, () -> 0));
        assertDateMathEquals("2014-11-23T14||/w", "2014-11-17", 0, false, null);
        DateMathParser parser = DateFormatter.forPattern("epoch_second||date_optional_time").toDateMathParser();
        assertDateMathEquals("2014-11-18T14:27||+10240m", "2014-11-25T17:07");
    }
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(called.get());
    }
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+0000"));
    private final DateMathParser parser = formatter.toDateMathParser();
        assertFalse(called.get());
import java.time.ZoneId;
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27:59.999", 0, true, null);
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        if (gotMillis != expectedMillis) {
                    + "\n"
        assertDateMathEquals(formatter.toDateMathParser(), "2022-104T14:08:30.293", "2022-04-14T14:08:30.293", 0, true, ZoneOffset.UTC);
        assertDateMathEquals("2014-05-30T18:21+00:00", "2014-05-30T18:21:00.000");
    public void testIllegalMathFormat() {
        assertDateMathEquals("2014-05-30T20:21:35", "2014-05-30T20:21:35.000");
        assertDateMathEquals("now/M", "2014-11-30T23:59:59.999Z", now, true, null);
    }
        DateFormatter formatter = DateFormatter.forPattern("date_time||date_time_no_millis");
import java.time.format.ResolverStyle;
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T23:59:59.999", 0, true, null);
                    + "Actual milliseconds   : "
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);
        DateFormatter formatter = DateFormatter.forPattern("YYYY-ww");
        assertParseException("Expected date math truncation exception", "2014-11-18||-", "truncated");
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
        // date_time has 2 parsers, date_time_no_millis has 4. Parsing with rounding should be able to use all of them
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27", 0, false, null);
            );
    }
        assertDateMathEquals("10000", "10000-01-01T00:00:00.000");
import org.opensearch.OpenSearchParseException;
        // implicit rounding with explicit timezone in the date format
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00", () -> 0L, true, (ZoneId) null);
        assertDateMathEquals("2014-11-18||+1w", "2014-11-25");
        assertThat(parsed.toEpochMilli(), equalTo(0L));
        assertDateMathEquals("2014-05-30T20:21||", "2014-05-30T20:21:00.000");
        assertDateMathEquals("2014-05-30T18:21+00", "2014-05-30T18:21:00.000");
 * compatible open source license.
        assertEquals(this.parser.parse("2011-10-09T00:00:00.000+01:00", () -> 0), time);
        DateFormatter formatter = new JavaDateFormatter(
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
    public void testMergingOfMultipleParsers() {
    }
        // date_time_no_millis 4 parsers
        assertDateMathEquals("2014-11-18T14||+13h", "2014-11-19T03");
 * GitHub history for details.
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, true, ZoneId.of("+01:00"));
        assertDateMathEquals("2014-11-18||+22d", "2014-12-10");
    }
        assertDateMathEquals("2014-11-18", "2014-11-17T23:00:00.000Z", 0, false, ZoneId.of("CET"));
    public void testWeekDates() {
        assertDateMathEquals("2014-01-01T00:00:00.001||/y", "2014-12-31T23:59:59.999", 0, true, null);
        Instant time = parser.parse("2011-10-09+01:00", () -> 0, false, (ZoneId) null);
        assertDateMathEquals("2014-05-30T18:21-00:00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20:59.999Z", 0, true, null);
import java.time.ZoneOffset;
        // date_time 2 parsers
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("-00:00"));
import java.time.ZonedDateTime;
        Instant parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00.0+0000", () -> 0L, true, (ZoneId) null);
        assertParseException("Expected bad timestamp exception", Long.toString(Long.MAX_VALUE) + "0", "failed to parse date field");
            return 42L;
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, false, null);
    public void testTimezone() {
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, true, null);
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
import java.time.format.DateTimeFormatterBuilder;
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:59.999Z", 0, true, ZoneId.of("CET"));
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+00"));
                    + "\n"
        DateMathParser parser,
        assertDateMathEquals("2014-11-18||+1M/M", "2014-12-01");
        assertDateMathEquals("2014-11-19T14||/w", "2014-11-17", 0, false, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T22:59:59.999Z", 0, true, ZoneId.of("CET"));
        assertDateMathEquals("2014-11-18T14:27:32||+60s", "2014-11-18T14:28:32");
    public void testLenientEmptyMath() {
        assertEquals(millisStart, parser.parse("04:52:20", () -> 0, false, (ZoneId) null));
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32.999", 0, true, null);
        final long now,
        );
        assertDateMathEquals("2014-11-18||/d", "2014-11-18", 0, false, null);
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32.999", 0, true, null);
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+00:00"));
        assertDateMathEquals("2014-05-30T18:21+0000", "2014-05-30T18:21:00.000");
    }
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("-0000"));
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27:59.999", 0, true, null);
        // a timestamp before 100000 is a year
import java.time.Instant;
        long gotMillis = parser.parse(toTest, () -> now, roundUp, timeZone).toEpochMilli();
        // also check other time units
    public void testMultipleAdjustments() {
        assertDateMathEquals("2014-11-18", "2014-11-18", 0, false, null);
                    + formatter.format(zonedDateTime)
        formatter = DateFormatter.forPattern("YYYY");
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, true, null);
        assertParseException("Expected date math incompatible rounding exception", "2014-11-18||/2m", "rounding");
    }
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, true, null);
        assertDateMathEquals("2014-05-30", "2014-05-30T00:00:00.000");
        assertDateMathEquals("2014-05-30T18:21-0000", "2014-05-30T18:21:00.000");
    }
        // but also externally
        assertDateMathEquals("now", "2014-11-18T14:27:32", now, false, null);
        // datemath still works on timestamps
    }
                    + "Original              : "
        assertDateMathEquals("2014-11-18", "2014-11-18T22:59:59.999Z", 0, true, ZoneId.of("CET"));
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);
    ) {
                    + "Expected              : "
    }
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);
        assertThat(parsed.toEpochMilli(), equalTo(0L));
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+00:00"));
 */
        DateFormatter formatter = DateFormatter.forPattern("date||epoch_millis").withLocale(randomLocale(random()));
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-17", 0, false, null);
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, true, null);
        assertDateMathEquals("2014-11||/M", "2014-11-01", 0, false, null);
 * The OpenSearch Contributors require contributions made to
        assertParseException("Expected bad date format exception", "123bogus", "failed to parse date field [123bogus]");
 * this file be licensed under the Apache-2.0 license or a
        assertThat(parsed.toEpochMilli(), equalTo(0L));
 *     http://www.apache.org/licenses/LICENSE-2.0
        // and timezone in the date has priority
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
        DateFormatter formatter = DateFormatter.forPattern("yyyy[-DDD'T'HH:mm:ss.SSS]");
 *
                .withResolverStyle(ResolverStyle.STRICT),
 * Modifications Copyright OpenSearch Contributors. See
        assertDateEquals(gotMillis, "297276785531", "297276785531");
        assertDateMathEquals("2014-11-21T14||/w", "2014-11-17", 0, false, null);
    private void assertDateMathEquals(
        DateMathParser parser = formatter.toDateMathParser();
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);
        DateFormatter formatter = DateFormatters.forPattern("HH:mm:ss");
package org.opensearch.common.time;
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(gotMillis), ZoneOffset.UTC);
    }
        assertDateMathEquals("9999", "9999-01-01T00:00:00.000");
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:00.000Z", 0, false, ZoneId.of("CET"));
        assertDateMathEquals("10000-01-01T", "10000-01-01T00:00:00.000");
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T22:59:59.999Z", 0, true, ZoneId.of("CET"));
        assertDateMathEquals("2014-11-18T14||-1H", "2014-11-18T13");
        assertDateMathEquals(formatter.toDateMathParser(), "2016", "2016-01-04T23:59:59.999Z", 0, true, ZoneOffset.UTC);
        assertDateMathEquals("100000", "1970-01-01T00:01:40.000");
        assertDateMathEquals("2014-11-18||/M", "2014-10-31T23:00:00.000Z", 0, false, ZoneId.of("CET"));
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T22:59:59.999Z", 0, true, ZoneId.of("CET"));
 *
    public void testNow() {
        assertDateMathEquals(parser, toTest, expected, now, roundUp, timeZone);
                    + "\n"
        assertDateMathEquals("253382837059000", "9999-05-20T17:24:19.000");
        assertDateMathEquals("2014-05-30T18:21-00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-05-30T20:21:35.123", "2014-05-30T20:21:35.123");
    private void assertDateMathEquals(String toTest, String expected, final long now, boolean roundUp, ZoneId timeZone) {
        gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();
        assertDateMathEquals("2014-11-18||+1M-1M", "2014-11-18");
    private void assertDateMathEquals(String toTest, String expected) {
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/y", "2014-01-01", 0, false, null);
        assertDateMathEquals("2014-11-18||-2y", "2012-11-18");
        // rounding should also take into account time zone
        ZoneId timeZone
            new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd'T'HH:mm:ss.S")
        assertDateMathEquals("2014-11-18||+1M-1m", "2014-12-17T23:59");
        // the pattern has to be composite and the match should not be on the first one
        assertDateMathEquals("2014-11-18T14:27:32||-3600s", "2014-11-18T13:27:32");
        formatter = DateFormatter.forPattern("date||epoch_millis").withZone(ZoneOffset.UTC);
    }
        long datetime = parser.parse("1418248078", () -> 0).toEpochMilli();
                    + "\n"
        assertDateMathEquals("2014-11-18", "2014-11-18T23:59:59.999Z", 0, true, null);
    }
        assertDateMathEquals("2014-11-18||/d", "2014-11-18T23:59:59.999", 0, true, null);
    }
        assertDateEquals(gotMillis, "297276785531", "297276785531");
        assertDateMathEquals(formatter.toDateMathParser(), "2016-01", "2016-01-04T23:59:59.999Z", 0, true, ZoneOffset.UTC);
        long millisEnd = DateFormatters.from(formatter.parse("04:52:20")).toInstant().toEpochMilli() + 999;
        final AtomicBoolean called = new AtomicBoolean();
        DateFormatter formatter = DateFormatter.forPattern("yyyy[-DDD'T'HH:mm:ss.SSS]");
    }
    public void testOnlyCallsNowIfNecessary() {
import static org.hamcrest.Matchers.is;
        DateMathParser parser = formatter.toDateMathParser();
        // timezone works within date format
        assertDateMathEquals("2014-11-18||/y", "2013-12-31T23:00:00.000Z", 0, false, ZoneId.of("CET"));
    }
        time = DateFormatter.forPattern("strict_date_optional_time_nanos")
        Instant millisStart = zonedDateTime.toInstant();
import java.util.concurrent.atomic.AtomicBoolean;
        assertDateEquals(datetime, "1418248078", "2014-12-10T21:47:58.000");
        assertDateMathEquals("32484216259000", "2999-05-20T17:24:19.000");
        assertEquals(this.parser.parse("2011-10-09T23:59:59.999+01:00", () -> 0), time);
                    + expectedMillis
                    + "Parsed                : "
        assertDateMathEquals("2014-11-18||-423d", "2013-09-21");
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00+0000", () -> 0L, true, (ZoneId) null);
    public void testExplicitRounding() {
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, false, null);
        // this one is actually still using parser number 3. I don't see a combination to use parser number 4
        assertDateMathEquals("2014-11-18T14:27||-10m", "2014-11-18T14:17");
import java.util.function.LongSupplier;
 * Licensed to Elasticsearch under one or more contributor
        assertThat(zonedDateTime.getYear(), is(1970));
                .toFormatter(Locale.ROOT)
        // test alternative ways of writing zero offsets, according to ISO 8601 +00:00, +00, +0000 should work.
        DateMathParser parser = formatter.toDateMathParser();
                .withResolverStyle(ResolverStyle.STRICT)
    public void testRoundUpParserBasedOnList() {
        ZonedDateTime zonedDateTime = DateFormatters.from(formatter.parse("04:52:20"));
        // timezone does not affect now
 *
        assertDateMathEquals("now/m", "2014-11-18T14:27:59.999Z", now, true, null);
    }
        assertDateMathEquals("2014-11-18||-1m+1M", "2014-12-17T23:59");
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, ZoneId.of("+02:00"));
    }
        long expectedMillis = parser.parse(expected, () -> 0).toEpochMilli();
        assertDateMathEquals("2014-05-30T20", "2014-05-30T20:00:00.000");
        assertDateEquals(gotMillis, toTest, expected);
                    + "\n"
        assertDateMathEquals("2014-05-30T20:21Z", "2014-05-30T20:21:00.000", 0, false, ZoneId.of("-08:00"));
        assertThat(parsed.toEpochMilli(), equalTo(999L));// defaulting millis
        String expected,
    public void testImplicitRounding() {
 * under the License.
        assertDateMathEquals("2014-11-18||+1M/M+1h", "2014-12-01T01");
            .toDateMathParser()
            called.set(true);
        assertDateMathEquals("2014-07-22||/w", "2014-07-20T22:00:00.000Z", 0, false, ZoneId.of("CET")); // with DST
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, false, null);
        parsed = formatter.toDateMathParser().parse("1970-01-01T00:00:00+00:00", () -> 0L, true, (ZoneId) null);
    public void testRoundingPreservesEpochAsBaseDate() {
                .appendOffset("+HHmm", "Z")
 * KIND, either express or implied.  See the License for the
        // due to rounding up, we have to add the number of milliseconds here manually
        assertDateMathEquals("2014-11-18T14||-1h", "2014-11-18T13");
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T18:21:00.000", 0, false, ZoneId.of("+02:00"));
    public void testDayOfYear() {
                    + original
        assertDateMathEquals("2014-11-17T14||/w", "2014-11-17", 0, false, null);
    public void testOverridingLocaleOrZoneAndCompositeRoundUpParser() {
    private void assertDateEquals(long gotMillis, String original, String expected) {
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals(formatter.toDateMathParser(), "2015-01", "2014-12-29T23:59:59.999Z", 0, true, ZoneOffset.UTC);
        assertDateMathEquals("2014-05-30T20:21+03:00", "2014-05-30T17:21:00.000", 0, false, ZoneId.of("-08:00"));
    // Implicit rounding happening when parts of the date are not specified
            .parse("2011-10-09T23:59:59.999+01:00", () -> 0, false, (ZoneId) null);
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-23T23:59:59.999", 0, true, null);
        String toTest,
    }
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32", 0, false, null);
    }
