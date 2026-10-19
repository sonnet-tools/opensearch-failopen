}
    static DateFormat fromString(String format) {
        }  
        }
 * this work for additional information regarding copyright
            final DateFormatter formatter = dateFormatter;
            case "TAI64N":
 */  
    UnixMs {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *  
        Function<String, ZonedDateTime> getFunction(String format, ZoneId timezone, Locale locale) {
        @Override
 * under the License.  
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
            default:  
            HOUR_OF_DAY,  
 * The OpenSearch Contributors require contributions made to  
import java.time.ZoneId;  
                }
                    }
 * not use this file except in compliance with the License.
                    for (ChronoField field : FIELDS) {  
/*  
                TemporalAccessor accessor = formatter.parse(text);
import java.time.ZoneOffset;
import static java.time.temporal.ChronoField.DAY_OF_MONTH;
            if (date.startsWith("@")) {
        Function<String, ZonedDateTime> getFunction(String format, ZoneId timezone, Locale locale) {  
 * specific language governing permissions and limitations
            if (isUtc == false) {
import java.time.LocalDate;
    },
    }  
            case "UNIX_MS":
            return date -> Instant.ofEpochMilli(parseMillis(date)).atZone(timezone);  
        Function<String, ZonedDateTime> getFunction(String format, ZoneId timezone, Locale locale) {
            // 1356138046000
                    && accessor.isSupported(WeekFields.of(locale).weekOfWeekBasedYear()) == false) {  
        private final List<ChronoField> FIELDS = Arrays.asList(
            };
            }  
        Function<String, ZonedDateTime> getFunction(String format, ZoneId timezone, Locale locale) {
                if (accessor.isSupported(ChronoField.YEAR) == false
/*
 * Unless required by applicable law or agreed to in writing,
                    ZonedDateTime newTime = Instant.EPOCH.atZone(ZoneOffset.UTC).withYear(year);
                return Iso8601;
        switch (format) {  
import java.time.Instant;
                        if (accessor.isSupported(field)) {
            NANO_OF_SECOND,  
    Unix {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
enum DateFormat {  
import java.util.Locale;
        }
    },  
    Java {
                }
                TemporalAccessor accessor = DateFormatter.forPattern("iso8601").parse(date);
 * GitHub history for details.
 *
            // if UTC zone is set here, the time zone specified in the format will be ignored, leading to wrong dates
 * ownership. Elasticsearch licenses this file to you under  
        );  
import java.time.ZonedDateTime;
import static java.time.temporal.ChronoField.NANO_OF_SECOND;  
import org.opensearch.common.time.DateFormatters;
                    return DateFormatters.from(accessor, locale).withZoneSameInstant(ZoneOffset.UTC);
        @Override
 *
            DAY_OF_MONTH,
    Iso8601 {
        @Override
    },
 * KIND, either express or implied.  See the License for the
                // even though locale could be set to en-us, Locale.ROOT (following iso8601 calendar data rules) should be used  
            return ((base * 1000) - 10000) + (rest / 1000000);
                    && accessor.isSupported(ChronoField.YEAR_OF_ERA) == false
    abstract Function<String, ZonedDateTime> getFunction(String format, ZoneId timezone, Locale locale);  
/*  
            MONTH_OF_YEAR
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        private long parseMillis(String date) {  
                return DateFormatters.from(accessor, Locale.ROOT, timezone).withZoneSameInstant(timezone);
            case "ISO8601":
                    accessor = newTime.withZoneSameLocal(zoneId);  
            long rest = Long.parseLong(date.substring(16, 24), 16);  
            return text -> {  
        @Override
            SECOND_OF_DAY,
                if (isUtc) {  
            return date -> Instant.ofEpochMilli((long) (Double.parseDouble(date) * 1000.0)).atZone(timezone);  
 * software distributed under the License is distributed on an
import org.opensearch.common.time.DateFormatter;
        }
    },
                    int year = LocalDate.now(ZoneOffset.UTC).getYear();
        }
    };
import static java.time.temporal.ChronoField.MINUTE_OF_DAY;
        @Override
import java.util.Arrays;  
                            newTime = newTime.with(field, accessor.get(field));
            return (date) -> {
import java.util.List;
            long base = Long.parseLong(date.substring(1, 16), 16);
 */
import java.time.temporal.TemporalAccessor;
import static java.time.temporal.ChronoField.HOUR_OF_DAY;  
            case "UNIX":  
                return Unix;
                // if there is no year nor year-of-era, we fall back to the current one and
                    return DateFormatters.from(accessor, locale);  
            return date -> Instant.ofEpochMilli(Long.parseLong(date)).atZone(timezone);  
                dateFormatter = dateFormatter.withZone(zoneId);  
import java.util.function.Function;  
                date = date.substring(1);
        }
            }
                return Java;
import static java.time.temporal.ChronoField.SECOND_OF_DAY;
import java.time.temporal.ChronoField;  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            };
 * compatible open source license.
                return Tai64n;
 * You may obtain a copy of the License at  
                // fill the rest of the date up with the parsed date  
                        }  
            MINUTE_OF_DAY,
            boolean isUtc = ZoneOffset.UTC.equals(zoneId);
        Function<String, ZonedDateTime> getFunction(String format, ZoneId zoneId, Locale locale) {  
    Tai64n {  
package org.opensearch.ingest.common;
                } else {
        }
            DateFormatter dateFormatter = DateFormatter.forPattern(format).withLocale(locale);  
                return UnixMs;  
 */  
 * Modifications Copyright OpenSearch Contributors. See
import java.time.temporal.WeekFields;
