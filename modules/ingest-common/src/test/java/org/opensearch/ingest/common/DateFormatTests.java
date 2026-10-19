        assertThat(dateTime, equalTo(ZonedDateTime.of(2020, 8, 10, 0, 0, 0, 0, timezone)));
 * KIND, either express or implied.  See the License for the
    public void testFromString() {
    }
            function.apply("2001-01-0:00-0800");  
        String expectedDateTime = DateFormatter.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").withZone(ZoneOffset.UTC).format(datetime);  
 * Unless required by applicable law or agreed to in writing,
        assertThat(expectedDateTime, is("2018-02-05T12:44:56.657Z"));  
            fail("parse should have failed");
package org.opensearch.ingest.common;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(  
            DateFormat.Iso8601.getFunction(null, ZoneOffset.of("+0100"), null).apply("2001-01-01T00:00:00").toInstant().toEpochMilli(),  
        );  
        );  
            Locale.ENGLISH  
 */
                .toInstant()
            "yyyy-MM-dd'T'HH:mm:ss.SSSZZ",
            ZoneOffset.UTC,
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(format, timezone, Locale.ENGLISH);  
        assertThat(dateTime.getYear(), is(year));  
    public void testParseUnixWithMsPrecision() {
 */  
    }
    }
/*  
            equalTo(expected)  
    public void testParseWeekBasedWithLocale() {
            javaFunction.apply("Nov 24 01:29:01 -0800")  
    public void testParseJavaDefaultYear() {  
    public void testParseYearJavaWithTimeZone() {
            equalTo("11 24 01:29:01")
        );
            DateFormat.Iso8601.getFunction(null, ZoneOffset.UTC, null).apply("2001-01-01T00:00:00-0800").toInstant().toEpochMilli(),
    public void testParseJava() {
/*  
        assertThat(DateFormat.fromString("prefix-" + randomAlphaOfLengthBetween(1, 10)), equalTo(DateFormat.Java));
        ZoneId timezone = DateUtils.of("Europe/Amsterdam");
            equalTo(978303600000L)
    public void testParseISO8601() {
    }
import org.opensearch.common.time.DateFormatter;
        }
        Function<String, ZonedDateTime> function = DateFormat.Iso8601.getFunction(null, ZoneOffset.UTC, null);
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        ZonedDateTime datetime = javaFunction.apply("2018-02-05T13:44:56.657+0100");
    public void testParseUnix() {  
    public void testParseWhenZoneNotPresentInText() {
            DateFormat.UnixMs.getFunction(null, ZoneOffset.UTC, null).apply("1000500").toInstant().toEpochMilli(),
public class DateFormatTests extends OpenSearchTestCase {  
            ZoneOffset.ofHours(-8),
            equalTo(1495718015000L)
                .atZone(ZoneId.of("GMT-8"))
            Locale.ROOT  
        ZonedDateTime dateTime = javaFunction.apply("12/06");
import java.util.Locale;  
            "MMM dd HH:mm:ss Z",
        String format = randomFrom("YYYY-ww");  
        ZoneId timezone = DateUtils.of("Europe/Amsterdam");
        assertThat(  
    }
        );
        assertThat(DateFormat.fromString("unix_ms"), equalTo(DateFormat.Java));  
        );
import java.util.function.Function;
    }  
        assertThat(DateFormat.Unix.getFunction(null, ZoneOffset.UTC, null).apply("1000.5").toInstant().toEpochMilli(), equalTo(1000500L));
        String expected = "2012-12-22T03:00:46.767+02:00";  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        ZonedDateTime dateTime = javaFunction.apply("2020-33");
        assertThat(dateTime, equalTo(ZonedDateTime.of(2020, 8, 9, 0, 0, 0, 0, timezone)));
    }  
        );
        assertThat(
        assertThat(
import static org.hamcrest.core.IsEqual.equalTo;
 * ownership. Elasticsearch licenses this file to you under  
    public void testParseUnixMs() {
            DateFormat.Unix.getFunction(null, ZoneOffset.UTC, null).apply("1495718015").toInstant().toEpochMilli(),  
        assertThat(DateFormat.fromString("UNIX"), equalTo(DateFormat.Unix));
        ZoneId timezone = DateUtils.of("Europe/Amsterdam");
        ZonedDateTime datetime = javaFunction.apply("2018-02-05T13:44:56.657+0100");
import static org.hamcrest.Matchers.is;  
 */  
    }
            ZoneOffset.UTC,
        assertThat(expectedDateTime, is("2018-02-05T12:44:56.657Z"));
            "uuuu-MM-dd'T'HH:mm:ss.SSSZZ",  
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(format, timezone, Locale.US);
    public void testTAI64NParse() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        assertThat(  
        assertThat(DateFormat.fromString("ISO8601"), equalTo(DateFormat.Iso8601));  
        );
        } catch (IllegalArgumentException e) {
    public void testParseISO8601Failure() {  
import java.time.format.DateTimeFormatter;
            equalTo("2001-01-01T08:00Z")  
        );
            Locale.ROOT
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(
        ZonedDateTime dateTime = javaFunction.apply("2020-33");  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(DateFormat.fromString("UNIX_MS"), equalTo(DateFormat.UnixMs));
        String format = randomFrom("8dd/MM", "dd/MM");
import org.opensearch.common.time.DateUtils;
        assertThat(
 *  
        assertThat(DateFormat.fromString("unix"), equalTo(DateFormat.Java));
        String format = randomFrom("YYYY-ww");
 * GitHub history for details.
        );  
 *
 * not use this file except in compliance with the License.
            DateFormat.Tai64n.getFunction(null, ZoneOffset.ofHours(2), null).apply((randomBoolean() ? "@" : "") + input).toString(),
        assertThat(
        assertThat(DateFormat.fromString("tai64n"), equalTo(DateFormat.Java));  
    }  
    }
        try {
 * license agreements. See the NOTICE file distributed with
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(format, timezone, Locale.ROOT);  
    }
        assertThat(DateFormat.fromString("TAI64N"), equalTo(DateFormat.Tai64n));
 * this work for additional information regarding copyright
            // all good  
 *
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(  
                .format(DateTimeFormatter.ofPattern("MM dd HH:mm:ss", Locale.ENGLISH)),  
    public void testParseWeekBased() {  
            equalTo("2001-01-01T00:00+01:00")
import java.time.ZoneId;
    public void testParseYearOfEraJavaWithTimeZone() {
        );  
 * compatible open source license.
}  
        int year = ZonedDateTime.now(ZoneOffset.UTC).getYear();
 * Licensed to Elasticsearch under one or more contributor  
            equalTo(1000500L)
            DateFormat.Iso8601.getFunction(null, ZoneOffset.of("+0100"), null).apply("2001-01-01T00:00:00").toString(),
            equalTo(978336000000L)
import java.time.ZonedDateTime;
        String expectedDateTime = DateFormatter.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").withZone(ZoneOffset.UTC).format(datetime);
    }
            DateFormat.Iso8601.getFunction(null, ZoneOffset.UTC, null).apply("2001-01-01T00:00:00-0800").toString(),
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(  
import java.time.ZoneOffset;  
/*
 * The OpenSearch Contributors require contributions made to  
        // 33rd week of 2020 starts on 9th August 2020 as per US locale
        assertThat(DateFormat.fromString("iso8601"), equalTo(DateFormat.Java));
 * SPDX-License-Identifier: Apache-2.0
        Function<String, ZonedDateTime> javaFunction = DateFormat.Java.getFunction(
        );
    }
        String input = "4000000050d506482dbdf024";
