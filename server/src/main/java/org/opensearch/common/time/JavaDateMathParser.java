        return dateTime.toInstant();
/**  
        Instant time;  
    @Override
                return DateFormatters.from(accessor).withZoneSameLocal(timeZone).toInstant();  
    JavaDateMathParser(String format, JavaDateFormatter formatter, JavaDateFormatter roundupParser) {  
                // TODO only millisecond granularity here!
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    } else {
            switch (unit) {  
import java.time.temporal.TemporalAdjusters;
                throw new OpenSearchParseException("truncated date math [{}]", mathString);
import java.util.function.LongSupplier;
            mathString = text.substring("now".length());  
                        dateTime = dateTime.withSecond(0).withNano(0);  
 * The format of the datetime is configurable, and unix timestamps can also be used. Datemath  
        Objects.requireNonNull(formatter);  
                    break;
                            dateTime = dateTime.plusDays(1);
 *  
 */
            final int sign;
                case 's':
    public Instant parse(String text, LongSupplier now, boolean roundUpProperty, ZoneId timeZone) {
 *  
                round = true;  
                while (i < mathString.length() && Character.isDigit(mathString.charAt(i))) {
 * compatible open source license.
                    throw new OpenSearchParseException("unit [{}] not supported for date math [{}]", unit, mathString);
                        dateTime = dateTime.with(LocalTime.MIN);  
                case 'm':
                        dateTime = dateTime.plusSeconds(sign * num);  
 *
                throw new OpenSearchParseException("could not read the current timestamp", e);
 * KIND, either express or implied.  See the License for the
                            dateTime = dateTime.plusYears(1);
                    if (round) {  
            int index = text.indexOf("||");
                            dateTime = dateTime.plusMonths(1);  
            if (round && roundUpProperty) {  
                    if (round) {
 * Unless required by applicable law or agreed to in writing,
                        if (roundUpProperty) {  
        return parseMath(mathString, time, roundUpProperty, timeZone);
 * Modifications Copyright OpenSearch Contributors. See
            } else {
 * license agreements. See the NOTICE file distributed with
public class JavaDateMathParser implements DateMathParser {  
                round = false;  
                if (c == '+') {
                    if (round) {
        this.format = format;
/*
                        if (roundUpProperty) {
                        dateTime = dateTime.withMinute(0).withSecond(0).withNano(0);
                        dateTime = dateTime.withDayOfMonth(1).with(LocalTime.MIN);
                    break;  
                            dateTime = dateTime.plusMinutes(1);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.Strings;
                return DateFormatters.from(formatter.parse(value)).toInstant();
            }
                    if (round) {  
                if (num != 1) {
        } catch (IllegalArgumentException | DateTimeParseException e) {
import java.time.LocalTime;  
    private final String format;  
                    if (round) {
                num = Integer.parseInt(mathString.substring(numFrom, i));
                        if (roundUpProperty) {
                }  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
                time = Instant.ofEpochMilli(now.getAsLong());
    private Instant parseDateTime(String value, ZoneId timeZone, boolean roundUpIfNoTime) {
                case 'w':  
            if (i >= mathString.length()) {
                    }  
                    throw new OpenSearchParseException("rounding `/` can only be used on single unit types [{}]", mathString);
            } else {
    }
                        }  
                        }
                    }  
import java.util.Objects;  
 * You may obtain a copy of the License at  
 */  
            }
        }
        this.formatter = formatter;
            throw new OpenSearchParseException("cannot parse empty date");
                    throw new OpenSearchParseException("operator not supported for date math [{}]", mathString);  
import java.time.format.DateTimeParseException;
 *
                    }
        ZonedDateTime dateTime = ZonedDateTime.ofInstant(time, timeZone);  
 * is appended to a datetime with the following syntax:
                int numFrom = i;  
                sign = 1;
                ZoneId zoneId = TemporalQueries.zone().queryFrom(accessor);
            mathString = text.substring(index + 2);
                if (zoneId != null) {
/*  
                        dateTime = dateTime.plusMonths(sign * num);  
import java.time.temporal.TemporalQueries;
 * specific language governing permissions and limitations
 * <code>||[+-/](\d+)?[yMwdhHms]</code>.
                case 'H':  
            }  
    private Instant parseMath(final String mathString, final Instant time, final boolean roundUpProperty, ZoneId timeZone)
                        if (roundUpProperty) {
        DateFormatter formatter = roundUpIfNoTime ? this.roundupParser : this.formatter;
                        dateTime = dateTime.withDayOfYear(1).with(LocalTime.MIN);  
                        dateTime = dateTime.plusMinutes(sign * num);
                    if (round) {
                        dateTime = dateTime.plusYears(sign * num);
            timeZone = ZoneOffset.UTC;
        for (int i = 0; i < mathString.length();) {
                    if (round) {
            if (c == '/') {
import java.time.ZoneId;
                    }  
        }
                }
            }
 * A parser for date/time formatted text with optional date math.
 * Licensed to Elasticsearch under one or more contributor  
        String mathString;
                        }  
}  
import java.time.temporal.ChronoField;
                        if (roundUpProperty) {
                case 'y':
                        dateTime = dateTime.plusHours(sign * num);
                    } else {
 * under the License.  
                    break;
            if (timeZone == null) {  
                if (i >= mathString.length()) {
                default:  
                }  
                        dateTime = dateTime.plusDays(sign * num);
            }
                case 'M':
                    } else {  
    private final JavaDateFormatter roundupParser;
                            dateTime = dateTime.plusWeeks(1);
        if (timeZone == null) {  
    }
        }
 */
                        if (roundUpProperty) {  
                    break;
 */  
        this.roundupParser = roundupParser;
package org.opensearch.common.time;
            final int num;
 * this work for additional information regarding copyright
import java.time.ZonedDateTime;  
                        dateTime = dateTime.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).with(LocalTime.MIN);
            } catch (Exception e) {  
                    throw new OpenSearchParseException("truncated date math [{}]", mathString);
 * SPDX-License-Identifier: Apache-2.0
                        }
 * @opensearch.internal
                } else {
                    }
import java.time.Instant;
            char c = mathString.charAt(i++);
import java.time.DayOfWeek;
        if (text.startsWith("now")) {
                        dateTime = dateTime.plusWeeks(sign * num);
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        throws OpenSearchParseException {
            throw new OpenSearchParseException("failed to parse date field [{}] with format [{}]: [{}]", e, value, format, e.getMessage());  
                } else if (c == '-') {  
                num = 1;
 * <p>
                    timeZone = zoneId;  
                // subtract 1 millisecond to get the largest inclusive value
                        }
            if (index == -1) {  
        } else {
                    } else {
                        if (roundUpProperty) {
/*  
                    sign = -1;
                    break;
 * the Apache License, Version 2.0 (the "License"); you may
            } else {
            }
                    }
            time = parseDateTime(text.substring(0, index), timeZone, false);  
                return parseDateTime(text, timeZone, roundUpProperty);
            if (round) {  
                    i++;
        try {
            }
                case 'h':
                }
        }
                    } else {
        if (Strings.isNullOrEmpty(value)) {  
                    break;
import java.time.ZoneOffset;
            }  
 * ownership. Elasticsearch licenses this file to you under  
                    } else {  
            if (!Character.isDigit(mathString.charAt(i))) {  
                }  
                    sign = 1;
                    } else {
            try {  
                    }
            char unit = mathString.charAt(i++);
                        }
 * GitHub history for details.
                        }  
                            dateTime = dateTime.plusSeconds(1);  
                TemporalAccessor accessor = formatter.parse(value);  
            }
        }
                dateTime = dateTime.minus(1, ChronoField.MILLI_OF_SECOND.getBaseUnit());
    private final JavaDateFormatter formatter;
                case 'd':
            final boolean round;  
                            dateTime = dateTime.plusHours(1);
import java.time.temporal.TemporalAccessor;  
    }  
                    break;  
import org.opensearch.OpenSearchParseException;
                        dateTime = dateTime.withNano(0);
