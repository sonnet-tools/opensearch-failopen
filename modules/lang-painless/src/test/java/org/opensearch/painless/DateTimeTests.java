        );
    public void testPiecesToZonedDateTime() {
                    + "pieces[2] = zdt.dayOfMonth;"
 */
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 11000000, ZoneId.of('Z'));"
                    + "String tz = 'Z';"  
            )  
        assertEquals(
        );
            exec(  
 * You may obtain a copy of the License at  
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),  
                    + "return ZonedDateTime.ofInstant(instant, ZoneId.of('Z'));"  
 * The OpenSearch Contributors require contributions made to  
                    + "pieces[6] = zdt.nano;"  
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
            exec("ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));" + "return zdt.minusMinutes(125);")
    public void testZonedDateTimeToString() {
            4989L,
        );
 * specific language governing permissions and limitations
 *
            )
                    + "return ChronoUnit.DAYS.between(zdt1, zdt2);"  
        assertEquals(  
        assertEquals(
        );
                    + "return ZonedDateTime.ofInstant(instant, ZoneId.of('Z'));"  
 *
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
        assertEquals(
        assertEquals(
                "ZonedDateTime utc = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"  
            "date: 1983/10/13 time: 22:15:30",
    public void testTimeZone() {
        assertEquals(
        assertEquals(
            )
 * compatible open source license.
/*  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
            exec(  
    public void testZonedDateTimeManipulation() {  
 * KIND, either express or implied.  See the License for the
                    + "pieces[3] = zdt.hour;"  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
public class DateTimeTests extends ScriptTestCase {
                "String datetime = 'Thu, 13 Oct 1983 22:15:30 GMT';"  
            )
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        );
                    + "ZonedDateTime pstZdt ="
            exec(
            )
    public void testLongToZonedDateTime() {  
            "1983-10-13T22:15:30Z",  
                    + "int month = 10;"  
 *  
        );  
            ZonedDateTime.of(1983, 10, 13, 22, 15, 27, 0, ZoneId.of("Z")),
        );  
                    + "DateTimeFormatter dtf = DateTimeFormatter.ofPattern("
            )
                    + "return pstZdt.format(DateTimeFormatter.RFC_1123_DATE_TIME);"
        assertEquals(
 * Modifications Copyright OpenSearch Contributors. See
            exec(  
            )
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 11000000, ZoneId.of('Z'));"
            exec(  
            exec(
        assertEquals(
            4L,
            "Thu, 13 Oct 1983 15:15:30 -0700",  
            exec(  
            )
    public void testLongTimeDifference() {
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ZonedDateTime.of(1983, 10, 13, 15, 15, 30, 0, ZoneId.of("America/Los_Angeles")),
                "long milliSinceEpoch = 434931330000L;"
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
    }
            )
                    + "Instant instant = Instant.ofEpochMilli(milliSinceEpoch);"
    }
                    + "return zdt1.isAfter(zdt2);"  
        );  
    }
        );  
        );
/*
                    + "pieces[0] = zdt.year;"  
                    + "int minutes = 15;"  
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),  
                    + "\"'custom' 'y' yyyy 'm' MM 'd' dd HH:mm:ss VV\");"
            exec(
                    + "int seconds = 30;"
            exec("long startTimestamp = 434931327000L;" + "long endTimestamp = 434931330000L;" + "return endTimestamp - startTimestamp;")
import java.time.ZoneId;
                    + "return utc.withZoneSameInstant(ZoneId.of('America/Los_Angeles'));"
                "int[] pieces = new int[7];"
    }  
            (int[]) exec(  
            exec(
            exec("ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));" + "return zdt.plusDays(3);")  
                    + "long milliSinceEpoch = Long.parseLong(milliSinceEpochString);"
            )
 * GitHub history for details.
                "String milliSinceEpochString = '434931330000';"  
    }
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
/*  
        );
        );  
                    + "Instant instant = Instant.ofEpochMilli(milliSinceEpoch);"
import java.time.ZonedDateTime;
            exec(  
            exec("String datetime = '1983-10-13T22:15:30Z';" + "return ZonedDateTime.parse(datetime);")  
        );
                    + "pieces[4] = zdt.minute;"
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 17, 22, 15, 35, 0, ZoneId.of('Z'));"
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 17, 22, 15, 35, 0, ZoneId.of('Z'));"
 */  
    }
                    + "return zdt1.isBefore(zdt2);"  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(  
            exec(
            )
    public void compareZonedDateTimes() {  
 */  
                    + "return pieces;"
                    + "\"'date:' yyyy/MM/dd 'time:' HH:mm:ss\");"  
                "long milliSinceEpoch = 434931330000L;"
 * Licensed to Elasticsearch under one or more contributor  
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 13, 22, 15, 35, 0, ZoneId.of('Z'));"
                    + "pieces[1] = zdt.monthValue;"
                    + "DateTimeFormatter dtf = DateTimeFormatter.ofPattern("  
                    + "Instant instant = Instant.ofEpochMilli(milliSinceEpoch);"  
 * not use this file except in compliance with the License.
            exec(
            3000L,
                "ZonedDateTime zdt1 = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
                    + "return ZonedDateTime.ofInstant(instant, ZoneId.of('Z'))"
            true,
        assertEquals(  
            )
            ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),
    public void testZonedDateTimeDifference() {  
                    + "ZonedDateTime zdt2 = ZonedDateTime.of(1983, 10, 17, 22, 15, 35, 0, ZoneId.of('Z'));"
        );
                    + "return zdt.toInstant().toEpochMilli();"
    public void compareLongs() {
    }
}
    }
        );  
    public void testStringToZonedDateTime() {
        );  
                "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
 * ownership. Elasticsearch licenses this file to you under  
            ZonedDateTime.of(1983, 10, 16, 22, 15, 30, 0, ZoneId.of("Z")),
                "int year = 1983;"
    }  
            exec(
    public void testZonedDateTimeToPieces() {  
        );
                    + "return ChronoUnit.MILLIS.between(zdt1, zdt2);"  
                "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
        );
            )
 * software distributed under the License is distributed on an
    public void testLongManipulation() {  
    }
        assertEquals(
    public void testZonedDatetimeToLong() {  
        assertEquals(
        assertEquals(false, exec("long ts1 = 434931327000L;" + "long ts2 = 434931330000L;" + "return ts1 > ts2;"));  
                    + "return ZonedDateTime.parse(datetime, DateTimeFormatter.RFC_1123_DATE_TIME);"
                    + "milliSinceEpoch = milliSinceEpoch - 1000L*3L;"
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            exec(  
        assertEquals(
                    + "int nanos = 0;"
                    + "return ZonedDateTime.parse(datetime, dtf);"
        assertEquals(
        );  
                    + "pieces[5] = zdt.second;"
                    + "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 100, ZoneId.of('Z'));"
            exec("ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));" + "return zdt.withYear(1976);")
                "String gmtString = 'Thu, 13 Oct 1983 22:15:30 GMT';"
                    + "return zdt.format(DateTimeFormatter.ISO_INSTANT);"  
        assertEquals(  
        assertEquals(
            false,
                    + "return ZonedDateTime.of(year, month, day, hour, minutes, seconds, nanos, ZoneId.of(tz));"
                "ZonedDateTime zdt = ZonedDateTime.of(1983, 10, 13, 22, 15, 30, 0, ZoneId.of('Z'));"
                    + "int hour = 22;"
                    + "int day = 13;"
            )
                "String datetime = 'custom y 1983 m 10 d 13 22:15:30 Z';"
                    + "DateTimeFormatter.RFC_1123_DATE_TIME);"
        assertEquals(
    }
            )  
                    + "return zdt.format(dtf);"
            )
            ZonedDateTime.of(1983, 10, 13, 20, 10, 30, 0, ZoneId.of("Z")),
    }  
        );  
        assertArrayEquals(
        assertEquals(  
            ZonedDateTime.of(1976, 10, 13, 22, 15, 30, 0, ZoneId.of("Z")),  
                    + "ZonedDateTime gmtZdt = ZonedDateTime.parse(gmtString,"  
            exec(  
        assertEquals(
                    + "gmtZdt.withZoneSameInstant(ZoneId.of('America/Los_Angeles'));"  
            434931330000L,
            new int[] { 1983, 10, 13, 22, 15, 30, 100 },
package org.opensearch.painless;
