        assertDateMathEquals("2014-11-18T14||/w", "2014-11-17", 0, false, null);  
        assertDateMathEquals("2014-11||/M", "2014-11-01", 0, false, null);  
            parser.parse("04:52:20", () -> 0, false, (ZoneId) null).toEpochMilli()
    void assertDateMathEquals(String toTest, String expected, final long now, boolean roundUp, DateTimeZone timeZone) {
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T23:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, true, null);  
    // Implicit rounding happening when parts of the date are not specified
        assertDateEquals(gotMillis, "297276785531", "297276785531");
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+00:00"));
        assertParseException("Expected bad timestamp exception", Long.toString(Long.MAX_VALUE) + "0", "failed to parse date field");
            );
 * SPDX-License-Identifier: Apache-2.0
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, true, null);
        assertDateMathEquals("now/m", "2014-11-18T14:27:59.999Z", now, true, null);  
        assertDateMathEquals("2014-11-18||+1M-1m", "2014-12-17T23:59");  
 * license agreements. See the NOTICE file distributed with
        assertDateMathEquals("2014-11-18T14:27||+10240m", "2014-11-25T17:07");
        final LongSupplier now = () -> {
        assertDateMathEquals("2014-05-30T20", "2014-05-30T20:00:00.000");
        assertDateMathEquals("2014-11-18T14||-1H", "2014-11-18T13");  
        assertDateMathEquals("2014-05-30T18:21-00", "2014-05-30T18:21:00.000");
 */  
        assertDateMathEquals("2014-11-12T22:55:00.000+01:00", "2014-11-12T21:55:00.000Z", 0, false, null);
                    + "Expected              : "
package org.opensearch.common.joda;
        JodaDateMathParser parser = new JodaDateMathParser(Joda.forPattern("epoch_second"));
 * The OpenSearch Contributors require contributions made to  
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, false, null);
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+02:00"));  
 *
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32.999", 0, true, null);
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);  
        // If a user only specifies times, then the date needs to always be 1970-01-01 regardless of rounding  
    public void testRoundingDoesNotAffectExactDate() {
    public void testBasicDates() {
        assertDateMathEquals("2014-05-30T18:21-00:00", "2014-05-30T18:21:00.000");
        assertEquals(
        assertDateMathEquals("1418248078000||/m", "2014-12-10T21:47:00.000");
        assertTrue(called.get());
        // and timezone in the date has priority  
        assertDateMathEquals("2014-11-18T14||+13H", "2014-11-19T03");
        assertDateMathEquals("2014-11-22T14||/w", "2014-11-17", 0, false, null);
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T23:59:59.999", 0, true, null);
    }
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+00:00"));
    }
        // 10000 is also a year, breaking bwc, used to be a timestamp
        };
 * the Apache License, Version 2.0 (the "License"); you may
        assertDateMathEquals("2014-05-30T18:21+00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-01-01T00:00:00.001||/y", "2014-12-31T23:59:59.999", 0, true, null);
                    + "\n"
 * Licensed to Elasticsearch under one or more contributor  
            called.set(true);
        assertDateMathEquals("2014-11-23T14||/w", "2014-11-17", 0, false, null);
    public void testTimezone() {
    }
    }
    void assertParseException(String msg, String date, String exc) {
        assertDateMathEquals("2014-11-19T14||/w", "2014-11-17", 0, false, null);
        long expectedMillis = parser.parse(expected, () -> 0).toEpochMilli();
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27", 0, false, null);
            assertThat(e.getMessage(), containsString("with format [epoch_millis]"));  
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, true, DateTimeZone.forID("+01:00"));  
        // but 10000 with T is still a date format  
    }
                    + "\n"
        assertDateMathEquals("2014-11-18||-423d", "2013-09-21");
        assertDateMathEquals("2014-05", "2014-05-01T00:00:00.000");  
        parser.parse("2014-11-18T14:27:32", now, false, (ZoneId) null);
    public void testExplicitRounding() {
    }
    }
    public void testNow() {  
        assertDateEquals(gotMillis, "297276785531", "297276785531");
        assertDateMathEquals("2014-11-18", "2014-11-18", 0, false, null);  
                    + expectedMillis  
                    + original  
        // the pattern has to be composite and the match should not be on the first one
        assertDateMathEquals("2014-11-18||/y", "2013-12-31T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, false, null);  
        assertDateEquals(datetime, "1418248078", "2014-12-10T21:47:58.000");  
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("-00"));  
    public void testTimestamps() {
 * this file be licensed under the Apache-2.0 license or a
 */
        assertDateMathEquals("2014-11-18||/d", "2014-11-18T23:59:59.999", 0, true, null);  
import org.opensearch.test.OpenSearchTestCase;
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+0000"));
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20:59.999Z", 0, true, null);
 * ownership. Elasticsearch licenses this file to you under  
        assertParseException("Expected date math unsupported operator exception", "2014-11-18||*5", "operator not supported");
        assertDateMathEquals("2014-11-18||-3w", "2014-10-28");
public class JodaDateMathParserTests extends OpenSearchTestCase {
            assertThat(e.getMessage().contains(exc), equalTo(true));  
        assertDateMathEquals("2014-11-18||+1M/M+1h", "2014-12-01T01");  
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18", 0, false, null);  
        assertDateMathEquals("2014-11-18||+1M-1M", "2014-11-18");
    }
        DateFormatter formatter = DateFormatter.forPattern("HH:mm:ss");
            fail("Date: " + date + "\n" + msg);
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:59.999Z", 0, true, DateTimeZone.forID("CET"));
        // datemath still works on timestamps  
 * You may obtain a copy of the License at  
        // timezone does not affect now
        if (gotMillis != expectedMillis) {
        DateMathParser parser = formatter.toDateMathParser();  
 * Modifications Copyright OpenSearch Contributors. See
                    + "Actual milliseconds   : "
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18||/y", "2014-01-01", 0, false, null);
        assertDateMathEquals("2014-05-30T20:21:35.123", "2014-05-30T20:21:35.123");
        assertDateMathEquals("2014-11-18T14:27:32||-3600s", "2014-11-18T13:27:32");  
    DateFormatter formatter = Joda.forPattern("date_optional_time||epoch_millis");  
        assertDateMathEquals("10000T", "10000-01-01T00:00:00.000");
    public void testMultipleAdjustments() {
 * GitHub history for details.
        assertDateMathEquals("2014-11-18||/M", "2014-11-30T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));  
    // Explicit rounding using the || separator  
        parser.parse("now/d", now, false, (ZoneId) null);
        assertDateMathEquals("2014-05-30T20:21", "2014-05-30T20:21:00.000");  
            this.formatter.parseMillis("1970-01-01T04:52:20.999Z"),
        // a timestamp before 10000 is a year
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-23T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));  
 * KIND, either express or implied.  See the License for the
        assertDateMathEquals("2014-11-20T14||/w", "2014-11-17", 0, false, null);
            fail("Expected OpenSearchParseException");  
 * not use this file except in compliance with the License.
                    + "\n"
        long gotMillis = parser.parse(toTest, () -> now, roundUp, timeZone).toEpochMilli();
        DateMathParser parser = formatter.toDateMathParser();
        }  
        assertDateMathEquals("2014-05-30T18:21+0000", "2014-05-30T18:21:00.000");  
        // implicit rounding with explicit timezone in the date format  
        assertDateMathEquals("2014-07-22||/w", "2014-07-20T22:00:00.000Z", 0, false, DateTimeZone.forID("CET")); // with DST
        assertDateMathEquals("32484216259000", "2999-05-20T17:24:19.000");  
        assertDateMathEquals("9999", "9999-01-01T00:00:00.000");  
        assertParseException("Expected date math truncation exception", "2014-11-18||-", "truncated");  
    }
        // rounding should also take into account time zone  
        assertDateMathEquals("2014-05-30T20:21:35", "2014-05-30T20:21:35.000");
    public void testIllegalDateFormat() {  
        assertDateMathEquals("2014-11-12T22:55:00.000Z", "2014-11-12T22:55:00.000Z", 0, true, null);  
        assertDateMathEquals("2014-11-18", "2014-11-18T23:59:59.999Z", 0, true, null);
        assertDateMathEquals("2014-11-18T14||+13h", "2014-11-19T03");  
import java.time.ZoneId;
    public void testThatUnixTimestampMayNotHaveTimeZone() {
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));
    public void testOverridingLocaleOrZoneAndCompositeRoundUpParser() {  
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);
        gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();  
import static org.hamcrest.Matchers.equalTo;
        assertDateMathEquals("2014-11-18", "2014-11-17T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));  
        assertDateMathEquals("now", "2014-11-18T14:27:32", now, false, null);  
                    + formatter.formatMillis(gotMillis)  
                    + "Expected milliseconds : "
                    + gotMillis  
        assertDateMathEquals("now/M", "2014-11-01T00:00:00", now, false, null);
        assertDateMathEquals("2014-11-18||/d", "2014-11-18", 0, false, null);
    public void testBasicMath() {
        assertParseException("Expected date math incompatible rounding exception", "2014-11-18||/2m", "rounding");  
        assertEquals(  
        assertDateMathEquals("now/m", "2014-11-18T14:27", now, false, DateTimeZone.forID("+02:00"));
 */  
        } catch (OpenSearchParseException e) {
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T23:59:59.999", 0, true, null);  
            this.formatter.parseMillis("1970-01-01T04:52:20.000Z"),
        assertDateMathEquals("2014-11-18", "2014-11-18T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));
            parser.parse(date, () -> 0);  
        formatter = Joda.forPattern("date||epoch_millis").withZone(ZoneOffset.UTC);
    }
 * specific language governing permissions and limitations
        assertParseException("Expected bad date format exception", "123bogus", "with format");
        assertEquals(this.parser.parse("2011-10-09T00:00:00.000+01:00", () -> 0), time);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertDateMathEquals("253382837059000", "9999-05-20T17:24:19.000");
 * software distributed under the License is distributed on an
        // also check other time units  
        assertDateMathEquals("2014-11-17T14||/w", "2014-11-17", 0, false, null);
        assertDateEquals(gotMillis, toTest, expected);  
        assertDateMathEquals("2014-11-21T14||/w", "2014-11-17", 0, false, null);  
        assertDateMathEquals("2014-11-18T14:27||/h", "2014-11-18T14", 0, false, null);  
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
        assertDateMathEquals("2014||/y", "2014-01-01", 0, false, null);
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14:59:59.999", 0, true, null);  
    }
    }  
        assertDateMathEquals("2014-11-18||+1w", "2014-11-25");  
        assertDateMathEquals("2014-05-30T20:21+03:00", "2014-05-30T17:21:00.000", 0, false, DateTimeZone.forID("-08:00"));
import org.opensearch.common.time.DateMathParser;  
        DateFormatter formatter = Joda.forPattern("yyyy-MM-ddZ");
}  
import java.util.concurrent.atomic.AtomicBoolean;
import java.time.ZoneOffset;  
 * Unless required by applicable law or agreed to in writing,
        DateFormatter formatter = Joda.forPattern("date||epoch_millis").withLocale(randomLocale(random()));
        assertDateMathEquals("2014-05-30T20:21||", "2014-05-30T20:21:00.000");
        assertDateMathEquals("2014-11-18T14||/d", "2014-11-18T23:59:59.999", 0, true, null);
            return 42L;  
import org.opensearch.OpenSearchParseException;
        long gotMillis = parser.parse("297276785531", () -> 0, true, (ZoneId) null).toEpochMilli();
    }
        assertDateMathEquals("2014-11-18||/M", "2014-10-31T23:00:00.000Z", 0, false, DateTimeZone.forID("CET"));
        assertDateMathEquals("2014-11||/M", "2014-11-30T23:59:59.999", 0, true, null);
        assertDateMathEquals("10000", "10000-01-01T00:00:00.000");
        } catch (OpenSearchParseException e) {
import org.opensearch.common.time.DateFormatter;
 *  
    DateMathParser parser = formatter.toDateMathParser();
        assertDateMathEquals("now+M", "2014-12-18T14:27:32", now, false, null);
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27:59.999", 0, true, null);
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32.999", 0, true, null);
    void assertDateMathEquals(String toTest, String expected) {  
        assertDateMathEquals("2014-11-18||/M", "2014-11-01", 0, false, null);
        final AtomicBoolean called = new AtomicBoolean();  
        assertDateMathEquals("2014-05-30T20:21+02:00", "2014-05-30T18:21:00.000");  
        assertDateMathEquals("2014-11-18||+3M", "2015-02-18");  
        // joda also seems to allow for -00:00, -00, -0000  
        assertFalse(called.get());  
        JodaDateMathParser parser = new JodaDateMathParser(Joda.forPattern("epoch_millis"));  
        assertDateMathEquals("2014-11-18||+22d", "2014-12-10");  
    }  
            parser.parse("04:52:20", () -> 0, true, (ZoneId) null).toEpochMilli()  
        assertDateMathEquals("2014", "2014-01-01T00:00:00.000");
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("-0000"));
        assertDateMathEquals("2014-11-18||-2y", "2012-11-18");
/*  
        }
        assertEquals(this.parser.parse("2011-10-09T23:59:59.999+01:00", () -> 0), time);  
 * under the License.  
        );
 * this work for additional information regarding copyright
                    + expected  
        assertDateMathEquals("2014-11-18T14:27:32||/m", "2014-11-18T14:27:59.999", 0, true, null);  
import java.time.Instant;
import java.util.function.LongSupplier;
    }  
                    + "Original              : "
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("-00:00"));
        try {
        long datetime = parser.parse("1418248078", () -> 0).toEpochMilli();
    }
    public void testRoundingPreservesEpochAsBaseDate() {
        assertDateMathEquals("2014-11-18T14||/H", "2014-11-18T14", 0, false, null);
        assertDateMathEquals("2014-11-18||+1M/M", "2014-12-01");
    public void testLenientEmptyMath() {  
                    + "\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
    void assertDateEquals(long gotMillis, String original, String expected) {  
        time = parser.parse("2011-10-09+01:00", () -> 0, true, (ZoneId) null);
        // test alternative ways of writing zero offsets, according to ISO 8601 +00:00, +00, +0000 should work.
    public void testImplicitRounding() {
        assertDateMathEquals("2014-05-30T18:21", "2014-05-30T18:21:00.000", 0, false, DateTimeZone.forID("+00"));  
/*
        assertDateMathEquals("2014-11-18T14||/w", "2014-11-23T23:59:59.999", 0, true, null);  
    }  
        DateMathParser parser = formatter.toDateMathParser();
    public void testIllegalMathFormat() {
        assertDateMathEquals("2014-11-18T14:27:32||/s", "2014-11-18T14:27:32", 0, false, null);  
        assertDateMathEquals("2014-11-18||+y", "2015-11-18");  
        assertDateMathEquals("2014-11-18T14:27||-10m", "2014-11-18T14:17");  
        assertDateMathEquals("2014-11-18T14:27:32.123||/s", "2014-11-18T14:27:32", 0, false, null);
    public void testOnlyCallsNowIfNecessary() {
 *
        assertDateMathEquals("1418248078000", "2014-12-10T21:47:58.000");
        }
            fail(  
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T08:20:00.000Z", 0, false, DateTimeZone.forID("CET"));  
            assertThat(e.getMessage(), containsString("failed to parse date field"));
        assertDateMathEquals("2014-11-18||/w", "2014-11-17", 0, false, null);
        assertDateMathEquals("2014-11-18T14:27:32||+60s", "2014-11-18T14:28:32");
        assertDateMathEquals("2014-11-18||-M", "2014-10-18");
        assertDateMathEquals("2014-11-18T14||-1h", "2014-11-18T13");
        assertDateMathEquals("2014-11-18||/y", "2014-12-31T22:59:59.999Z", 0, true, DateTimeZone.forID("CET"));
        assertDateMathEquals("2014-05-30T20:21Z", "2014-05-30T20:21:00.000", 0, false, DateTimeZone.forID("-08:00"));
import org.joda.time.DateTimeZone;
        );  
        // but also externally
        assertParseException("Expected date math truncation exception", "2014-11-18||+12", "truncated");
        assertDateMathEquals("2014-11-18T09:20", "2014-11-18T09:20", 0, false, null);  
        assertDateMathEquals("2014-05-30T18:21+00:00", "2014-05-30T18:21:00.000");
        assertDateMathEquals("2014-11-12T22:55:00.000", "2014-11-12T21:55:00.000Z", 0, false, DateTimeZone.forID("+01:00"));
        assertDateMathEquals("2014-11-18T14:27||/m", "2014-11-18T14:27", 0, false, null);
        // timezone works within date format
                "Date math not equal\n"
 * compatible open source license.
        assertDateMathEquals("now/M", "2014-11-30T23:59:59.999Z", now, true, null);
        assertParseException("Expected date math illegal unit type exception", "2014-11-18||+2a", "unit [a] not supported");
    }
        parser = formatter.toDateMathParser();
                    + "Parsed                : "
        Instant time = parser.parse("2011-10-09+01:00", () -> 0, false, (ZoneId) null);  
            parser.parse("1234567890123", () -> 42, false, ZoneId.of("CET"));
/*  
        try {
    }  
        assertDateMathEquals("2014-11-18||/w", "2014-11-17T01:00:00.000Z", 0, false, DateTimeZone.forID("-01:00"));
        assertDateMathEquals("now-2d", "2014-11-16T14:27:32", now, true, null);
        assertDateMathEquals("2014-11-18||/w", "2014-11-16T23:00:00.000Z", 0, false, DateTimeZone.forID("+01:00"));  
        assertDateMathEquals("2014-05-30", "2014-05-30T00:00:00.000");
                    + "\n"
        assertDateMathEquals("2014-05-30T18:21-0000", "2014-05-30T18:21:00.000");  
        assertDateMathEquals(toTest, expected, 0, false, null);
import static org.hamcrest.Matchers.containsString;
        assertDateMathEquals("2014-11-18||-1m+1M", "2014-12-17T23:59");
        final long now = parser.parse("2014-11-18T14:27:32", () -> 0, false, (ZoneId) null).toEpochMilli();
    }
