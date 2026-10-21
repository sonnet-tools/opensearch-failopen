    default String formatMillis(long millis) {
     *
        ZoneId zone = zone() != null ? zone() : ZoneOffset.UTC;
 */
     */
    }
    }
 * The OpenSearch Contributors require contributions made to
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * under the License.
    /**
    Locale locale();
    DateFormatter withZone(ZoneId zoneId);
        for (String pattern : Strings.delimitedListToStringArray(input, "||")) {
     *
     */
    static DateFormatter forPattern(String input, Boolean canCacheFormatter) {
    DateMathParser toDateMathParser();
            patterns.add(pattern);
     */
        List<DateFormatter> formatters = patterns.stream().map(DateFormatters::forPattern).collect(Collectors.toList());
 * Unless required by applicable law or agreed to in writing,
import java.time.Instant;
        return format(
     */
import java.time.ZoneId;
     * Parse the given input into a Joda {@link DateTime}.
        return input;
    /**
            if (Strings.hasLength(pattern) == false) {
    /**
 * compatible open source license.
    default String formatJoda(DateTime dateTime) {
        }
    /**
    /**
/*
    default DateTime parseJoda(String input) {
        if (Strings.hasLength(printPattern)) {
     */
 * Licensed to Elasticsearch under one or more contributor
                throw new IllegalArgumentException("Invalid print format: " + e.getMessage(), e);
    String printPattern();
/*
        return forPattern(input, null, canCacheFormatter);
     * Return the given Joda {@link DateTime} formatted with this format.
    static DateFormatter forPattern(String input, String printPattern) {
import java.util.stream.Collectors;
package org.opensearch.common.time;
import org.joda.time.DateTime;
        return DateFormatters.from(parse(input)).toInstant().toEpochMilli();
     * Create a copy of this formatter that is configured to parse dates in the specified locale
    }
        if (input.startsWith("8")) {
     * @param zoneId The time zone to act on
    }
     * @return The name of this formatter
 */
     *
        ZonedDateTime dateTime = ZonedDateTime.from(parse(input));
        }
 * software distributed under the License is distributed on an
            } catch (IllegalArgumentException e) {
        }
     */
                throw new IllegalArgumentException("Cannot have empty element in multi date format pattern: " + input);
 * this file be licensed under the Apache-2.0 license or a
     * a configured format like <code>HH:mm:ss</code>
        return JavaDateFormatter.combined(input, formatters, printFormatter, canCacheFormatter);
     * A name based format for this formatter. Can be one of the registered formatters like <code>epoch_millis</code> or
 *
    }
     * @return                        The java time object containing the parsed input
     */
     * @return The time zone of this formatter
     * Try to parse input to a java time TemporalAccessor
import java.util.Locale;
        List<String> patterns = new ArrayList<>();
    }
/**
     * @return The locale of this formatter
            String printFormat = strip8Prefix(printPattern);
            }
    /**
    /**
            throw new IllegalArgumentException("No date pattern provided");
     * @param accessor The temporal accessor used to format
    }
@PublicApi(since = "1.0.0")
    String format(TemporalAccessor accessor);
        // support the 6.x BWC compatible way of parsing java 8 dates
 */
    DateFormatter withLocale(Locale locale);
     *
import org.opensearch.core.common.Strings;
            ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateTime.getMillis()), DateUtils.dateTimeZoneToZoneId(dateTime.getZone()))
     * Create a DateMathParser from the existing formatter
     * @param locale The local to use for the new formatter
     *
import java.time.ZonedDateTime;
import java.util.List;
     * Returns the configured time zone of the date formatter
        );
            }
     */
    default long parseMillis(String input) {
import java.util.ArrayList;
 *
                printFormatter = DateFormatters.forPattern(printFormat);
 * GitHub history for details.
 * @opensearch.api
     *
        }
import java.time.temporal.TemporalAccessor;
        List<String> patterns = splitCombinedPatterns(format);
    TemporalAccessor parse(String input);
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Create a copy of this formatter that is configured to parse dates in the specified time zone
    static DateFormatter forPattern(String input, String printPattern, Boolean canCacheFormatter) {
     * @throws DateTimeParseException If parsing fails, this exception will be thrown.
     * @return       A copy of the date formatter this has been called on
     * @return         The string result for the formatting
import java.time.format.DateTimeParseException;
     */
    static List<String> splitCombinedPatterns(String input) {
        return forPattern(input, printPattern, false);
    static DateFormatter forPattern(String input) {
    /**
     * Returns the configured locale of the date formatter
 *
 * specific language governing permissions and limitations
     *
     * Parse the given input into millis-since-epoch.
     * @param input                   An arbitrary string resembling the string representation of a date or time
    /**
    /**
     */
}
 */
    /**
    String pattern();
 * Modifications Copyright OpenSearch Contributors. See
        return format(Instant.ofEpochMilli(millis).atZone(zone));
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return patterns;
 * KIND, either express or implied.  See the License for the
 * Base Date formatter
 * SPDX-License-Identifier: Apache-2.0
     * Return the given millis-since-epoch formatted with this format.
     *
     * Print the supplied java time accessor in a string based representation according to this formatter
    /**
import java.time.ZoneOffset;
 * license agreements. See the NOTICE file distributed with
        String format = strip8Prefix(input);
    static String strip8Prefix(String input) {
import org.opensearch.common.annotation.PublicApi;
    ZoneId zone();
    }
     */
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
     * A name based format for this formatter. Can be one of the registered formatters like <code>epoch_millis</code> or
        DateFormatter printFormatter = formatters.get(0);
 *
     * @return       A copy of the date formatter this has been called on
     */
        return new DateTime(dateTime.toInstant().toEpochMilli(), DateUtils.zoneIdToDateTimeZone(dateTime.getZone()));
public interface DateFormatter {
            try {
        if (Strings.hasLength(input) == false) {
     *                                Note that it can contained suppressed exceptions when several formatters failed parse this value
    }
     * @return The name of this formatter
     * @return The DateMathParser object
/*
     * a configured format like <code>HH:mm:ss</code>
            return input.substring(1);
 * You may obtain a copy of the License at
        return forPattern(input, null, false);
