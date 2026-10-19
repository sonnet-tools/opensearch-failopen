 *
        );
import org.opensearch.common.time.DateUtils;
            ZoneOffset.UTC,
import java.time.ZoneId;
        );
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(format, timezone, Locale.ROOT);
        ZonedDateTime datetime = javaFunction.apply("2018-02-05T13:44:56.657+0100");
        String format = randomFrom("YYYY-ww");
import java.time.ZoneOffset;
}
        ZoneId timezone = DateUtils.of("Europe/Amsterdam");
                .atZone(ZoneId.of("GMT-8"))
 * compatible open source license.
        assertThat(DateFormat.fromString("unix_ms"), equalTo(DateFormat.Java));
            Locale.ROOT
    }
 * this work for additional information regarding copyright
            DateFormat.Unix.getFunction(null, ZoneOffset.UTC, null).apply("1495718015").toInstant().toEpochMilli(),
/*
        assertThat(DateFormat.fromString("UNIX"), equalTo(DateFormat.Unix));
                .toInstant()
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(
    }
        assertThat(DateFormat.fromString("unix"), equalTo(DateFormat.Java));
    public void testParseUnixWithMsPrecision() {
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(format, timezone, Locale.ENGLISH);
            DateFormat.UnixMs.getFunction(null, ZoneOffset.UTC, null).apply("1000500").toInstant().toEpochMilli(),
            equalTo("2001-01-01T00:00+01:00")
    public void testParseISO8601Failure() {
    public void testParseWeekBasedWithLocale() {
 * license agreements. See the NOTICE file distributed with
        // 33rd week of 2020 starts on 9th August 2020 as per US locale
        assertThat(dateTime, equalTo(ZonedDateTime.of(2020, 8, 10, 0, 0, 0, 0, timezone)));
        );
    }
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(
 * Unless required by applicable law or agreed to in writing,
import java.util.function.Function;
            equalTo(978336000000L)
    }
        } catch (IllegalArgumentException e) {
import org.opensearch.test.OpenSearchTestCase;
            equalTo("11 24 01:29:01")
package org.opensearch.ingest.common;
        );
            equalTo("2001-01-01T08:00Z")
    }
        int year = ZonedDateTime.now(ZoneOffset.UTC).getYear();
 *
 * You may obtain a copy of the License at
    }
    }
/*
        assertThat(
        ZonedDateTime dateTime = javaFunction.apply("2020-33");
import org.opensearch.common.time.DateFormatter;
            "MMM dd HH:mm:ss Z",
        assertThat(DateFormat.fromString("tai64n"), equalTo(DateFormat.Java));
        );
        assertThat(
import java.util.Locale;
            fail("parse should have failed");
import java.time.ZonedDateTime;
            DateFormat.Iso8601.getFunction(null, ZoneOffset.UTC, null).apply("2001-01-01T00:00:00-0800").toString(),
public class DateFormatTests extends OpenSearchTestCase {
        assertThat(DateFormat.fromString("ISO8601"), equalTo(DateFormat.Iso8601));
import java.time.format.DateTimeFormatter;
        ZonedDateTime dateTime = javaFunction.apply("12/06");
 * the Apache License, Version 2.0 (the "License"); you may
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(
    }
            // all good
 * ownership. Elasticsearch licenses this file to you under
        ZoneId timezone = DateUtils.of("Europe/Amsterdam");
        String format = randomFrom("8dd/MM", "dd/MM");
/*
    public void testParseJava() {
        assertThat(
        assertThat(DateFormat.fromString("iso8601"), equalTo(DateFormat.Java));
            DateFormat.Tai64n.getFunction(null, ZoneOffset.ofHours(2), null).apply((randomBoolean() ? "@" : "") + input).toString(),
    }
        assertThat(expectedDateTime, is("2018-02-05T12:44:56.657Z"));
            Locale.ENGLISH
        assertThat(dateTime, equalTo(ZonedDateTime.of(2020, 8, 9, 0, 0, 0, 0, timezone)));
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        }
 */
    public void testParseUnixMs() {
    }
            equalTo(978303600000L)
 */
    public void testFromString() {
    }
            DateFormat.Iso8601.getFunction(null, ZoneOffset.of("+0100"), null).apply("2001-01-01T00:00:00").toString(),
    public void testParseWeekBased() {
            "yyyy-MM-dd'T'HH:mm:ss.SSSZZ",
        Function<String, ZonedDateTime> function = DateFormat.Iso8601.getFunction(null, ZoneOffset.UTC, null);
        assertThat(
    public void testTAI64NParse() {
 * The OpenSearch Contributors require contributions made to
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.is;
        String input = "4000000050d506482dbdf024";
        assertThat(DateFormat.fromString("TAI64N"), equalTo(DateFormat.Tai64n));
        ZonedDateTime dateTime = javaFunction.apply("2020-33");
        );
    public void testParseWhenZoneNotPresentInText() {
            DateFormat.Iso8601.getFunction(null, ZoneOffset.of("+0100"), null).apply("2001-01-01T00:00:00").toInstant().toEpochMilli(),
            "uuuu-MM-dd'T'HH:mm:ss.SSSZZ",
        String format = randomFrom("YYYY-ww");
        assertThat(DateFormat.fromString("prefix-" + randomAlphaOfLengthBetween(1, 10)), equalTo(DateFormat.Java));
        assertThat(DateFormat.Unix.getFunction(null, ZoneOffset.UTC, null).apply("1000.5").toInstant().toEpochMilli(), equalTo(1000500L));
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(format, timezone, Locale.US);
 *
        assertThat(DateFormat.fromString("UNIX_MS"), equalTo(DateFormat.UnixMs));
 * Modifications Copyright OpenSearch Contributors. See
            ZoneOffset.ofHours(-8),
            function.apply("2001-01-0:00-0800");
    }
        assertThat(
    public void testParseISO8601() {
            equalTo(expected)
        String expected = "2012-12-22T03:00:46.767+02:00";
        );
    public void testParseYearJavaWithTimeZone() {
        assertThat(expectedDateTime, is("2018-02-05T12:44:56.657Z"));
        ZonedDateTime datetime = javaFunction.apply("2018-02-05T13:44:56.657+0100");
            ZoneOffset.UTC,
            DateFormat.Iso8601.getFunction(null, ZoneOffset.UTC, null).apply("2001-01-01T00:00:00-0800").toInstant().toEpochMilli(),
        assertThat(dateTime.getYear(), is(year));
        );
 * Licensed to Elasticsearch under one or more contributor
        String expectedDateTime = DateFormatter.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").withZone(ZoneOffset.UTC).format(datetime);
            equalTo(1000500L)
    }
 * KIND, either express or implied.  See the License for the
        ZoneId timezone = DateUtils.of("Europe/Amsterdam");
        assertThat(
    }
 * under the License.
import static org.hamcrest.core.IsEqual.equalTo;
    public void testParseYearOfEraJavaWithTimeZone() {
    public void testParseUnix() {
            Locale.ROOT
        assertThat(
    public void testParseJavaDefaultYear() {
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
            equalTo(1495718015000L)
            javaFunction.apply("Nov 24 01:29:01 -0800")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try {
        );
        );
        String expectedDateTime = DateFormatter.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").withZone(ZoneOffset.UTC).format(datetime);
                .format(DateTimeFormatter.ofPattern("MM dd HH:mm:ss", Locale.ENGLISH)),
        );
