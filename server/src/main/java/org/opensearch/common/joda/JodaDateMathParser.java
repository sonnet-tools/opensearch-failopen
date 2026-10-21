                }
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
            // fields that are filled with times without dates
                }
                    break;
 * SPDX-License-Identifier: Apache-2.0
                    propertyToRound.roundFloor();
                        dateTime.addWeeks(sign * num);
 */
            } else {
                        dateTime.addMonths(sign * num);
        } catch (IllegalArgumentException e) {
            if (end < 0) {
        try {
            MutableDateTime.Property propertyToRound = null;
 * ownership. Elasticsearch licenses this file to you under
            final int num;
 *
/*
 *
import org.joda.time.format.DateTimeFormatter;
/*
    public JodaDateMathParser(JodaDateFormatter dateTimeFormatter) {
            final int sign;
}
 * license agreements. See the NOTICE file distributed with
 * under the License.
                    } else {
        Objects.requireNonNull(dateTimeFormatter);
                        propertyToRound = dateTime.monthOfYear();
                        dateTime.addYears(sign * num);
                        propertyToRound = dateTime.yearOfCentury();
        final DateTimeZone timeZone = tz == null ? null : DateUtils.zoneIdToDateTimeZone(tz);
                case 'w':
                if (roundUp) {
                throw new IllegalArgumentException("Unrecognized chars at the end of [" + value + "]: [" + value.substring(end) + "]");
                if (num != 1) {
                    }
                        dateTime.addHours(sign * num);
                date = new MutableDateTime(1970, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
                    } else {
                    if (round) {
 * <code>||[+-/](\d+)?[yMwdhHms]</code>.
                case 'H':
                    dateTime.addMillis(-1); // subtract 1 millisecond to get the largest inclusive value
import org.opensearch.common.time.DateMathParser;
            final boolean round;
                case 'd':
                    } else {
 * not use this file except in compliance with the License.
import org.joda.time.MutableDateTime;
        MutableDateTime dateTime = new MutableDateTime(time, timeZone);
                case 'm':
            parser = parser.withZone(timeZone);
import java.time.ZoneId;
                case 'y':
                        propertyToRound = dateTime.hourOfDay();
 * software distributed under the License is distributed on an
 */
            } else {
 * is appended to a datetime with the following syntax:
                time = now.getAsLong();
            return date.getMillis();
                    break;
                    if (round) {
                    break;
                return Instant.ofEpochMilli(parseDateTime(text, timeZone, roundUp));
 * @opensearch.internal
            char unit = mathString.charAt(i++);
                default:
                    }
            if (roundUpIfNoTime) {
                } else if (c == '-') {
        } else {
                date = new MutableDateTime(1970, 1, 1, 23, 59, 59, 999, DateTimeZone.UTC);
                        dateTime.addDays(sign * num);
    }
        if (text.startsWith("now")) {
    }
        return Instant.ofEpochMilli(parseMath(mathString, time, roundUp, timeZone));
            throw new OpenSearchParseException("failed to parse date field [{}] with format [{}]", e, value, dateTimeFormatter.pattern());
        if (timeZone != null) {
 * A parser for date/time formatted text with optional date math.
package org.opensearch.common.joda;
            if (!Character.isDigit(mathString.charAt(i))) {
                }
 * The format of the datetime is configurable, and unix timestamps can also be used. Datemath
            final int end = parser.parseInto(date, value, 0);
                        propertyToRound = dateTime.minuteOfHour();
                    }
    // use of `now`.
            switch (unit) {
 * compatible open source license.
            }
            } catch (Exception e) {
    private long parseDateTime(String value, DateTimeZone timeZone, boolean roundUpIfNoTime) {
            if (c == '/') {
 * the Apache License, Version 2.0 (the "License"); you may
                sign = 1;
 * Licensed to Elasticsearch under one or more contributor
                    throw new OpenSearchParseException("rounding `/` can only be used on single unit types [{}]", mathString);
                } else {
                    }
                        propertyToRound = dateTime.dayOfMonth();
        if (timeZone == null) {
            if (i >= mathString.length()) {
 * KIND, either express or implied.  See the License for the
            }
            time = parseDateTime(text.substring(0, index), timeZone, false);
 * You may obtain a copy of the License at
                    // we want to go up to the next whole value, even if we are already on a rounded value
                throw new OpenSearchParseException("truncated date math [{}]", mathString);
    }
                    break;
import java.time.Instant;
                round = true;
                    } else {
        return dateTime.getMillis();
                    break;
            timeZone = DateTimeZone.UTC;
 *
 */
 * The OpenSearch Contributors require contributions made to
    @Override
import org.opensearch.common.time.DateUtils;
            }
                    if (round) {
            char c = mathString.charAt(i++);
 * specific language governing permissions and limitations
            // We use 01/01/1970 as a base date so that things keep working with date
            }
                    if (round) {
                }
                    }
 * GitHub history for details.
            } else if (end != value.length()) {
                case 'M':
                round = false;
            if (round) {
/**
            }
    // Note: we take a callable here for the timestamp in order to be able to figure out
                case 'h':
            MutableDateTime date;
                int position = ~end;
import java.util.Objects;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    i++;
                throw new OpenSearchParseException("could not read the current timestamp", e);
                case 's':
            }
            mathString = text.substring("now".length());
                        propertyToRound = dateTime.weekOfWeekyear();
        long time;
public class JodaDateMathParser implements DateMathParser {
                    }
                        dateTime.addMinutes(sign * num);
                    sign = 1;
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchParseException;
                throw new IllegalArgumentException("Parse failure at index [" + position + "] of [" + value + "]");
            mathString = text.substring(index + 2);
 * Unless required by applicable law or agreed to in writing,
        DateTimeFormatter parser = dateTimeFormatter.parser;
                        propertyToRound = dateTime.secondOfMinute();
            if (propertyToRound != null) {
                }
                    break;
 * Modifications Copyright OpenSearch Contributors. See
    private final JodaDateFormatter dateTimeFormatter;
                    throw new OpenSearchParseException("operator not supported for date math [{}]", mathString);
                    if (round) {
        }
            }
            } else {
 * this file be licensed under the Apache-2.0 license or a
    private long parseMath(String mathString, long time, boolean roundUp, DateTimeZone timeZone) throws OpenSearchParseException {
 * <p>
            }
            }
    public Instant parse(String text, LongSupplier now, boolean roundUp, ZoneId tz) {
import org.joda.time.DateTimeZone;
/*
        for (int i = 0; i < mathString.length();) {
                if (i >= mathString.length()) {
            try {
    }
                    sign = -1;
                num = Integer.parseInt(mathString.substring(numFrom, i));
 */
                    } else {
                    propertyToRound.roundFloor();
import java.util.function.LongSupplier;
    // if it has been used. For instance, the request cache does not cache requests that make
                    if (round) {
                    }
                    } else {
        }
        }
                int numFrom = i;
                if (c == '+') {
                    } else {
                    break;
        this.dateTimeFormatter = dateTimeFormatter;
                    if (round) {
        }
                    propertyToRound.add(1);
                num = 1;
                while (i < mathString.length() && Character.isDigit(mathString.charAt(i))) {
        }
                        dateTime.addSeconds(sign * num);
            }
            int index = text.indexOf("||");
                    throw new OpenSearchParseException("unit [{}] not supported for date math [{}]", unit, mathString);
        String mathString;
                } else {
                    throw new OpenSearchParseException("truncated date math [{}]", mathString);
            if (index == -1) {
