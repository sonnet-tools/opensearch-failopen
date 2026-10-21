        );
        JodaDateMathParser parser = new JodaDateMathParser(Joda.forPattern("epoch_millis"));
        };
        Instant time = parser.parse("2011-10-09+01:00", () -> 0, false, (ZoneId) null);
        final LongSupplier now = () -> {
        // the pattern has to be composite and the match should not be on the first one
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));
        assertParseException("Expected bad timestamp exception", Long.toString(Long.MAX_VALUE) + "0", "failed to parse date field");
        assertDateMathEquals("2014-11-18", "2014-11-18T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));
        assertDateMathEquals("2014-11-22T14||/w", "2014-11-17", 0, false, null);
 * under the License.
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T23:59:59.999", 0, true, null);
        try {
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, true, null);
                    + "\n"
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+00:00"));
    public void testBasicMath() {
        assertDateMathEquals("2014-11-21T14||/w", "2014-11-17", 0, false, null);
    }
                    + original
    void assertParseException(String msg, String date, String exc) {
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:00.000Z", 0, false, DateTimeZone.forID("CET"));
        assertParseException("Expected date math unsupported operator exception", "2014-11-18||*5", "operator not supported");
    }
 * Unless required by applicable law or agreed to in writing,
        DateFormatter formatter = Joda.forPattern("yyyy-MM-ddZ");
        assertDateMathEquals("2014-11-17T14||/w", "2014-11-17", 0, false, null);
        assertDateMathEquals("2014-11-18||/y", "2013-12-31T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));
        assertDateMathEquals("2014-11-23T14||/w", "2014-11-17", 0, false, null);
import java.time.Instant;
    public void testRoundingPreservesEpochAsBaseDate() {
        assertDateMathEquals("1418248078000", "2014-12-10T21:47:58.000");
        assertEquals(
import java.util.function.LongSupplier;
    }
 * not use this file except in compliance with the License.
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-17T01:00:00.000Z", 0, false, DateTimeZone.forID("-01:00"));
        assertDateMathEquals("2014-11-18||/d", "2014-11-18", 0, false, null);
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.formatter.parseMillis("1970-01-01T04:52:20.999Z"),
        } catch (OpenSearchParseException e) {
        // timezone works within date format
        assertDateMathEquals("32484216259000", "2999-05-20T17:24:19.000");
        // 10000 is also a year, breaking bwc, used to be a timestamp
            assertThat(e.getMessage().contains(exc), equalTo(true));
        assertDateMathEquals("2014-11-18T14:27:32||-3600s", "2014-11-18T13:27:32");
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
        time = parser.parse("2011-10-09+01:00", () -> 0, true, (ZoneId) null);
        assertParseException("Expected date math truncation exception", "2014-11-18||+12", "truncated");
        assertDateMathEquals("2014-11-18||+1M-1M", "2014-11-18");
    public void testNow() {
        assertDateMathEquals(toTest, expected, 0, false, null);
    }
        assertDateMathEquals("now", "2014-11-18T14:27:32", now, false, null);
        assertDateMathEquals("2014-11-18||/M", "2014-10-31T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("-00"));
        assertDateMathEquals("2014-05-30T20", "2014-05-30T20:00:00.000");
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, true, null);
        DateMathParser parser = formatter.toDateMathParser();
        assertDateMathEquals("2014-11-18||-2y", "2012-11-18");
        }
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20", 0, false, null);
    public void testTimezone() {
        assertDateMathEquals("2014-11||/M", "2014-11-30T23:59:59.999", 0, true, null);
        if (gotMillis != expectedMillis) {
 * this work for additional information regarding copyright
            called.set(true);
 *
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);
 * GitHub history for details.
 */
        assertDateMathEquals("2014-11-18||+22d", "2014-12-10");
        assertParseException("Expected bad date format exception", "123bogus", "with format");
    // Explicit rounding using the || separator
 * KIND, either express or implied.  See the License for the
    public void testThatUnixTimestampMayNotHaveTimeZone() {
        // timezone does not affect now
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
        assertDateMathEquals("2014-11-18||+1w", "2014-11-25");
            parser.parse("04:52:20", () -> 0, false, (ZoneId) null).toEpochMilli()
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+02:00"));
 * specific language governing permissions and limitations
    }
 * You may obtain a copy of the License at
            this.formatter.parseMillis("1970-01-01T04:52:20.000Z"),
        // joda also seems to allow for -00:00, -00, -0000
/*
        // If a user only specifies times, then the date needs to always be 1970-01-01 regardless of rounding
        assertParseException("Expected date math truncation exception", "2014-11-18||-", "truncated");
        assertDateMathEquals("now/M", "2014-11-01T00:00:00", now, false, null);
        // and timezone in the date has priority
import org.opensearch.OpenSearchParseException;
        assertDateMathEquals("2014-05-30T18:21+00:00", "2014-05-30T18:21:00.000");
        }
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));
    }
        assertDateMathEquals("2014-05-30T20:21:35.123", "2014-05-30T20:21:35.123");
        // but 10000 with T is still a date format
 * The OpenSearch Contributors require contributions made to
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+00:00"));
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32.999", 0, true, null);
    void assertDateEquals(long gotMillis, String original, String expected) {
            assertThat(e.getMessage(), containsString("with format [epoch_millis]"));
        assertDateMathEquals("2014-11-18||+y", "2015-11-18");
import org.opensearch.test.OpenSearchTestCase;
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-17", 0, false, null);
        DateFormatter formatter = DateFormatter.forPattern("HH:mm:ss");
                    + "Actual milliseconds   : "
        assertDateMathEquals("2014-07-22||/w", "2014-07-20T22:00:00.000Z", 0, false, DateTimeZone.forID("CET")); // with DST
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32.999", 0, true, null);
        parser = formatter.toDateMathParser();
 * license agreements. See the NOTICE file distributed with
        assertDateMathEquals("2014-11-18||-423d", "2013-09-21");
        assertDateMathEquals("2014-11-18T14||+13H", "2014-11-19T03");
        assertDateMathEquals("2014-11-18", "2014-11-18T23:59:59.999Z", 0, true, null);
 * ownership. Elasticsearch licenses this file to you under
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, true, DateTimeZone.forID("+01:00"));
        assertDateMathEquals("2014-05-30T20:21+02:00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("-0000"));
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18T14:27||-10m", "2014-11-18T14:17");
        DateMathParser parser = formatter.toDateMathParser();
        assertDateMathEquals("2014-01-01T00:00:00.001||/y", "2014-12-31T23:59:59.999", 0, true, null);
        assertDateMathEquals("10000", "10000-01-01T00:00:00.000");
import static org.hamcrest.Matchers.containsString;
    }
        assertDateMathEquals("2014", "2014-01-01T00:00:00.000");
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, false, null);
    void assertDateMathEquals(String toTest, String expected) {
        assertDateMathEquals("9999", "9999-01-01T00:00:00.000");
                    + gotMillis
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
    public void testTimestamps() {
                    + "Original              : "
    public void testOverridingLocaleOrZoneAndCompositeRoundUpParser() {
        // but also externally
        } catch (OpenSearchParseException e) {
            parser.parse("1234567890123", () -> 42, false, ZoneId.of("CET"));
        assertDateMathEquals("2014-11-18||-1m+1M", "2014-12-17T23:59");
    DateMathParser parser = formatter.toDateMathParser();
    }
        gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27", 0, false, null);
    public void testMultipleAdjustments() {
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, true, null);
    }
        long gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||-3w", "2014-10-28");
        assertDateMathEquals("2014-05-30T18:21-00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-11-18||+3M", "2015-02-18");
        final AtomicBoolean called = new AtomicBoolean();
    }
                    + expectedMillis
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20:59.999Z", 0, true, null);
 * software distributed under the License is distributed on an
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27:59.999", 0, true, null);
    }
        assertDateMathEquals("2014-05-30", "2014-05-30T00:00:00.000");
        assertDateMathEquals("10000T", "10000-01-01T00:00:00.000");
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("-00:00"));
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, false, null);
        long expectedMillis = parser.parse(expected, () -> 0).toEpochMilli();
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, false, DateTimeZone.forID("+01:00"));
    public void testExplicitRounding() {
        assertDateMathEquals("2014-05-30T18:21+00", "2014-05-30T18:21:00.000");
package org.opensearch.common.joda;
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T20:21:00.000");
        assertDateMathEquals("2014-05-30T20:21Z", "2014-05-30T20:21:00.000", 0, false, DateTimeZone.forID("-08:00"));
    // Implicit rounding happening when parts of the date are not specified
        assertDateEquals(gotMillis, "297276785531", "297276785531");
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, false, null);
    }
                    + "\n"
            return 42L;
        // also check other time units
        assertDateMathEquals("2014-05-30T20:21:35", "2014-05-30T20:21:35.000");
        assertParseException("Expected date math illegal unit type exception", "2014-11-18||+2a", "unit [a] not supported");
/*
    }
        assertTrue(called.get());
                    + expected
        assertDateMathEquals("2014-11-18T14:27||+10240m", "2014-11-25T17:07");
/*
        // test alternative ways of writing zero offsets, according to ISO 8601 +00:00, +00, +0000 should work.
    }
import org.opensearch.common.time.DateMathParser;
import org.opensearch.common.time.DateFormatter;
        assertDateMathEquals("2014-11-18||+1M/M+1h", "2014-12-01T01");
                    + "Parsed                : "
            fail("Expected OpenSearchParseException");
        assertDateMathEquals("2014-11-18||+1M-1m", "2014-12-17T23:59");
    }
        assertDateMathEquals("now/M", "2014-11-30T23:59:59.999Z", now, true, null);
    public void testBasicDates() {
                    + "\n"
    }
        long datetime = parser.parse("1418248078", () -> 0).toEpochMilli();
        assertDateMathEquals("2014-11-18||/M", "2014-11-01", 0, false, null);
    public void testImplicitRounding() {
                    + "Expected              : "
        parser.parse("now/d", now, false, (ZoneId) null);
 *
    }
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+00"));
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, DateTimeZone.forID("+01:00"));
        assertDateMathEquals("2014-05-30T18:21+0000", "2014-05-30T18:21:00.000");
 *
        assertDateEquals(gotMillis, "297276785531", "297276785531");
        assertDateMathEquals("253382837059000", "9999-05-20T17:24:19.000");
        assertDateEquals(gotMillis, toTest, expected);
        assertDateMathEquals("2014-05-30T18:21-00:00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27", 0, false, null);
            fail("Date: " + date + "\n" + msg);
        assertDateMathEquals("2014-11-20T14||/w", "2014-11-17", 0, false, null);
import java.util.concurrent.atomic.AtomicBoolean;
import java.time.ZoneId;
    }
        assertDateMathEquals("1418248078000||/m", "2014-12-10T21:47:00.000");
            parser.parse(date, () -> 0);
                    + formatter.formatMillis(gotMillis)
        assertDateMathEquals("now/m", "2014-11-18T14:27:59.999Z", now, true, null);
    }
        try {
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, DateTimeZone.forID("+02:00"));
import org.joda.time.DateTimeZone;
        DateMathParser parser = formatter.toDateMathParser();
    public void testRoundingDoesNotAffectExactDate() {
                    + "\n"
        );
        assertDateMathEquals("2014||/y", "2014-01-01", 0, false, null);
        assertDateMathEquals("2014-11-18T14||+13h", "2014-11-19T03");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "Expected milliseconds : "
        assertDateMathEquals("2014-05-30T20:21||", "2014-05-30T20:21:00.000");
    public void testIllegalDateFormat() {
        formatter = Joda.forPattern("date||epoch_millis").withZone(ZoneOffset.UTC);
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, true, null);
        assertDateMathEquals("2014-11-18||/d", "2014-11-18T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18", "2014-11-18", 0, false, null);
        assertDateMathEquals("2014-11-18T14||-1H", "2014-11-18T13");
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:59.999Z", 0, true, DateTimeZone.forID("CET"));
    public void testIllegalMathFormat() {
        assertDateMathEquals("2014-11-18T14||-1h", "2014-11-18T13");
                    + "\n"
        assertDateMathEquals("2014-11-18||-M", "2014-10-18");
            fail(
        assertDateMathEquals("2014-11-18||/y", "2014-01-01", 0, false, null);
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+0000"));
 * this file be licensed under the Apache-2.0 license or a
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);
    }
        // datemath still works on timestamps
        assertDateMathEquals("2014-11-18T14:27:32||+60s", "2014-11-18T14:28:32");
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, null);
        assertDateMathEquals("2014-05", "2014-05-01T00:00:00.000");
        assertDateEquals(datetime, "1418248078", "2014-12-10T21:47:58.000");
    public void testOnlyCallsNowIfNecessary() {
        // implicit rounding with explicit timezone in the date format
        DateFormatter formatter = Joda.forPattern("date||epoch_millis").withLocale(randomLocale(random()));
        parser.parse("2014-11-18T14:27:32", now, false, (ZoneId) null);
        assertParseException("Expected date math incompatible rounding exception", "2014-11-18||/2m", "rounding");
 * Licensed to Elasticsearch under one or more contributor
        // rounding should also take into account time zone
}
                "Date math not equal\n"
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18", 0, false, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-17", 0, false, null);
            parser.parse("04:52:20", () -> 0, true, (ZoneId) null).toEpochMilli()
        assertDateMathEquals("2014-11-18||+1M/M", "2014-12-01");
 */
        assertEquals(this.parser.parse("2011-10-09T00:00:00.000+01:00", () -> 0), time);
        assertDateMathEquals("2014-11||/M", "2014-11-01", 0, false, null);
        assertDateMathEquals("2014-05-30T18:21-0000", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32", 0, false, null);
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32", 0, false, null);
        final long now = parser.parse("2014-11-18T14:27:32", () -> 0, false, (ZoneId) null).toEpochMilli();
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-23T23:59:59.999", 0, true, null);
import static org.hamcrest.Matchers.equalTo;
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, false, null);
 * the Apache License, Version 2.0 (the "License"); you may
        // a timestamp before 10000 is a year
        long gotMillis = parser.parse(toTest, () -> now, roundUp, timeZone).toEpochMilli();
        JodaDateMathParser parser = new JodaDateMathParser(Joda.forPattern("epoch_second"));
        assertFalse(called.get());
 * Modifications Copyright OpenSearch Contributors. See
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27:59.999", 0, true, null);
        assertDateMathEquals("2014-11-19T14||/w", "2014-11-17", 0, false, null);
    DateFormatter formatter = Joda.forPattern("date_optional_time||epoch_millis");
        assertEquals(this.parser.parse("2011-10-09T23:59:59.999+01:00", () -> 0), time);
        }
            );
        assertDateMathEquals("2014-05-30T20:21+03:00", "2014-05-30T17:21:00.000", 0, false, DateTimeZone.forID("-08:00"));
        assertDateMathEquals("2014-11-18", "2014-11-17T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));
import java.time.ZoneOffset;
    void assertDateMathEquals(String toTest, String expected, final long now, boolean roundUp, DateTimeZone timeZone) {
    public void testLenientEmptyMath() {
public class JodaDateMathParserTests extends OpenSearchTestCase {
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18T23:59:59.999", 0, true, null);
 */
            assertThat(e.getMessage(), containsString("failed to parse date field"));
 * compatible open source license.
