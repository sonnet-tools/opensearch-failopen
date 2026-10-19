 */
                    + "return zdt.format(DateTimeFormatter.ISO_INSTANT);"
package org.opensearch.painless;
    }
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(
        assertEquals(
    public void compareLongs() {
            )
            )
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
    public void testStringToZonedDateTime() {
                    + "DateTimeFormatter dtf = DateTimeFormatter.ofPattern("
    public void testZonedDateTimeToString() {
        );
            exec(
            exec(
    public void testLongManipulation() {
                "int[] pieces = new int[7];"
                "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
            "Thu, 13 Oct 1983 15:15:30 -0700",
        assertEquals(
                "long milliSinceEpoch = 434931330000L;"
            exec(
                    + "int seconds = 30;"
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 17, 22, 15, 35, 0, ZoneId.of('Z'));"
        assertEquals(
    public void testTimeZone() {
                    + "milliSinceEpoch = milliSinceEpoch - 1000L*3L;"
    public void compareZonedDateTimes() {
            exec(
    }
 * software distributed under the License is distributed on an
    public void testZonedDateTimeManipulation() {
            exec(
                    + "return utc.withZoneSameInstant(ZoneId.of('America/Los_Angeles'));"
            ZonedDateTime.of(1976, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
import java.time.ZoneId;
            exec(
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 11000000, ZoneId.of('Z'));"
    }
 * this file be licensed under the Apache-2.0 license or a
}
 * compatible open source license.
                "ZonedDateTime utc = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
            4989L,
                    + "ZonedDateTime gmtZdt = ZonedDateTime.parse(gmtString,"
            exec(
                    + "gmtZdt.withZoneSameInstant(ZoneId.of('America/Los_Angeles'));"
                    + "Instant instant = Instant.ofEpochMilli(milliSinceEpoch);"
                    + "return pieces;"
 * license agreements. See the NOTICE file distributed with
            (int[]) exec(
                    + "return ZonedDateTime.ofInstant(instant, ZoneId.of('Z'))"
            ZonedDateTime.of(1983, 10, 13, 20, 10, 30, 0, ZoneId.of("Z")),
        );
        assertEquals(
                    + "int day = 13;"
/*
            )
            )
            exec(
                "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
 * KIND, either express or implied.  See the License for the
            new int[] { 1983, 10, 13, 22, 15, 30, 100 },
        assertEquals(
        assertEquals(
            exec(
        );
        assertEquals(
        );
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
                    + "return ZonedDateTime.ofInstant(instant, ZoneId.of('Z'));"
                "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
                    + "pieces[2] = zdt.dayOfMonth;"
        assertEquals(
            4L,
    }
                "String datetime = 'Thu, 13 Oct 1983 22:15:30 GMT';"
                    + "String tz = 'Z';"
            )
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
                    + "pieces[5] = zdt.second;"
            )
            exec(
        assertEquals(
                    + "int hour = 22;"
 * You may obtain a copy of the License at
            false,
                    + "return zdt1.isBefore(zdt2);"
            ZonedDateTime.of(1983, 10, 13, 15, 15, 30, 0, ZoneId.of("America/Los_Angeles")),
            exec("ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));" + "return zdt.withYear(1976);")
        );
    public void testZonedDateTimeToPieces() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            exec("long startTimestamp = 434931327000L;" + "long endTimestamp = 434931330000L;" + "return endTimestamp - startTimestamp;")
                    + "pieces[6] = zdt.nano;"
                "int year = 1983;"
 * under the License.
    public void testZonedDatetimeToLong() {
                    + "return ZonedDateTime.parse(datetime, dtf);"
                    + "pieces[4] = zdt.minute;"
                    + "int month = 10;"
                    + "return ZonedDateTime.of(year, month, day, hour, minutes, seconds, nanos, ZoneId.of(tz));"
                    + "return zdt.toInstant().toEpochMilli();"
        assertEquals(
        );
 * GitHub history for details.
            ZonedDateTime.of(1983, 10, 13, 22, 15, 27, 0, ZoneId.of("Z")),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "DateTimeFormatter dtf = DateTimeFormatter.ofPattern("
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
            )
                "long milliSinceEpoch = 434931330000L;"
    }
    }
            )
            )
                    + "DateTimeFormatter.RFC_1123_DATE_TIME);"
            exec("String datetime = '1983-10-13T22:15:30Z';" + "return ZonedDateTime.parse(datetime);")
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
        assertEquals(
            )
            exec(
    public void testPiecesToZonedDateTime() {
 * Modifications Copyright OpenSearch Contributors. See
        );
        );
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
                    + "Instant instant = Instant.ofEpochMilli(milliSinceEpoch);"
            )
                    + "pieces[1] = zdt.monthValue;"
    public void testLongTimeDifference() {
        assertEquals(
            exec("ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));" + "return zdt.plusDays(3);")
 */
 */
public class DateTimeTests extends ScriptTestCase {
            exec(
        );
                    + "return zdt1.isAfter(zdt2);"
        );
    }
            )
        assertEquals(
    }
                    + "\"'custom' 'y' yyyy 'm' MM 'd' dd HH:mm:ss VV\");"
        );
        );
        );
 * ownership. Elasticsearch licenses this file to you under
 *
        assertArrayEquals(
                    + "return ZonedDateTime.parse(datetime, DateTimeFormatter.RFC_1123_DATE_TIME);"
    }
                "String gmtString = 'Thu, 13 Oct 1983 22:15:30 GMT';"
                    + "ZonedDateTime pstZdt ="
        assertEquals(false, exec("long ts1 = 434931327000L;" + "long ts2 = 434931330000L;" + "return ts1 > ts2;"));
            )
                    + "int nanos = 0;"
 * The OpenSearch Contributors require contributions made to
                    + "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 100, ZoneId.of('Z'));"
            )
                    + "int minutes = 15;"
    public void testLongToZonedDateTime() {
            )
        );
                    + "long milliSinceEpoch = Long.parseLong(milliSinceEpochString);"
                    + "return ChronoUnit.MILLIS.between(zdt1, zdt2);"
            3000L,
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 11000000, ZoneId.of('Z'));"
                    + "return ZonedDateTime.ofInstant(instant, ZoneId.of('Z'));"
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 13, 22, 15, 35, 0, ZoneId.of('Z'));"
        assertEquals(
/*
        assertEquals(
                "String milliSinceEpochString = '434931330000';"
            ZonedDateTime.of(1983, 10, 16, 22, 15, 30, 0, ZoneId.of("Z")),
            )
    }
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 17, 22, 15, 35, 0, ZoneId.of('Z'));"
        assertEquals(
                    + "\"'date:' yyyy/MM/dd 'time:' HH:mm:ss\");"
    public void testZonedDateTimeDifference() {
import java.time.ZonedDateTime;
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
        );
        assertEquals(
    }
    }
            "date: 1983/10/13 time: 22:15:30",
        assertEquals(
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
            true,
 *
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 17, 22, 15, 35, 0, ZoneId.of('Z'));"
                    + "return pstZdt.format(DateTimeFormatter.RFC_1123_DATE_TIME);"
                    + "pieces[0] = zdt.year;"
        );
    }
        );
                    + "return zdt.format(dtf);"
                "String datetime = 'custom y 1983 m 10 d 13 22:15:30 Z';"
        assertEquals(
 * Unless required by applicable law or agreed to in writing,
                    + "pieces[3] = zdt.hour;"
            exec(
        );
            exec(
            exec(
 *
            "1983-10-13T22:15:30Z",
            434931330000L,
/*
        );
 * SPDX-License-Identifier: Apache-2.0
            exec("ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));" + "return zdt.minusMinutes(125);")
                    + "return ChronoUnit.DAYS.between(zdt1, zdt2);"
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        );
                    + "Instant instant = Instant.ofEpochMilli(milliSinceEpoch);"
        );
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
