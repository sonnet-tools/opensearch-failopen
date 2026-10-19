import java.util.Locale;
    }
            throw new IllegalArgumentException("No date pattern provided");  
     * @param input                   An arbitrary string resembling the string representation of a date or time
 * Licensed to Elasticsearch under one or more contributor  
            String printFormat = strip8Prefix(printPattern);
        return forPattern(input, null, false);  
     * @return The DateMathParser object
    String printPattern();
 *
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
     * Return the given millis-since-epoch formatted with this format.
        }
 * software distributed under the License is distributed on an
     * a configured format like <code>HH:mm:ss</code>
     *                                Note that it can contained suppressed exceptions when several formatters failed parse this value
    static DateFormatter forPattern(String input, Boolean canCacheFormatter) {
            }
        }
 * this file be licensed under the Apache-2.0 license or a
/*  
            }  
            } catch (IllegalArgumentException e) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Base Date formatter
     *  
        return DateFormatters.from(parse(input)).toInstant().toEpochMilli();
     * @return The locale of this formatter  
     */
 * KIND, either express or implied.  See the License for the
/*  
import java.util.List;  
        return JavaDateFormatter.combined(input, formatters, printFormatter, canCacheFormatter);
    /**
     * @return       A copy of the date formatter this has been called on  
     * Returns the configured locale of the date formatter
import java.time.ZoneId;  
    TemporalAccessor parse(String input);
     * @return The name of this formatter
    /**
/**
     * Try to parse input to a java time TemporalAccessor
     * Create a copy of this formatter that is configured to parse dates in the specified time zone
    DateFormatter withZone(ZoneId zoneId);  
    }  
    static DateFormatter forPattern(String input, String printPattern, Boolean canCacheFormatter) {  
                printFormatter = DateFormatters.forPattern(printFormat);  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    default long parseMillis(String input) {  
        return input;  
        List<String> patterns = new ArrayList<>();
    static DateFormatter forPattern(String input, String printPattern) {  
 * under the License.  
    }  
     * Create a copy of this formatter that is configured to parse dates in the specified locale  
    /**  
 *  
        if (input.startsWith("8")) {  
    /**
                throw new IllegalArgumentException("Cannot have empty element in multi date format pattern: " + input);
 *
     */  
     * @throws DateTimeParseException If parsing fails, this exception will be thrown.  
    /**
}
     *
        DateFormatter printFormatter = formatters.get(0);
 * GitHub history for details.
 */  
    Locale locale();
     *
     * A name based format for this formatter. Can be one of the registered formatters like <code>epoch_millis</code> or
 */  
    }  
    }  
        String format = strip8Prefix(input);
            ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateTime.getMillis()), DateUtils.dateTimeZoneToZoneId(dateTime.getZone()))
        return forPattern(input, null, canCacheFormatter);
 *  
     *
     */
     */
     * @param accessor The temporal accessor used to format
     * a configured format like <code>HH:mm:ss</code>  
        return patterns;
        return new DateTime(dateTime.toInstant().toEpochMilli(), DateUtils.zoneIdToDateTimeZone(dateTime.getZone()));  
        if (Strings.hasLength(printPattern)) {  
    default String formatMillis(long millis) {  
 * The OpenSearch Contributors require contributions made to  
     */
     * Print the supplied java time accessor in a string based representation according to this formatter
 *     http://www.apache.org/licenses/LICENSE-2.0
     *  
    String pattern();
        );
     */
import java.time.format.DateTimeParseException;  
        return format(  
/*
     * @param zoneId The time zone to act on  
    /**  
     * Returns the configured time zone of the date formatter
    }
        ZonedDateTime dateTime = ZonedDateTime.from(parse(input));
     *
    }
    DateFormatter withLocale(Locale locale);
     * @return       A copy of the date formatter this has been called on
import java.time.Instant;
     */  
    ZoneId zone();  
     * @return         The string result for the formatting
     * Create a DateMathParser from the existing formatter  
     * @param locale The local to use for the new formatter
 * compatible open source license.
     */  
    /**
    default DateTime parseJoda(String input) {
        List<String> patterns = splitCombinedPatterns(format);
    }
    /**  
     * @return The time zone of this formatter
     * @return The name of this formatter  
     */  
        for (String pattern : Strings.delimitedListToStringArray(input, "||")) {
    /**  
                throw new IllegalArgumentException("Invalid print format: " + e.getMessage(), e);
 */
        List<DateFormatter> formatters = patterns.stream().map(DateFormatters::forPattern).collect(Collectors.toList());  
    /**
import org.opensearch.common.annotation.PublicApi;
     */  
    static List<String> splitCombinedPatterns(String input) {  
import org.joda.time.DateTime;  
     */
public interface DateFormatter {
    default String formatJoda(DateTime dateTime) {
            if (Strings.hasLength(pattern) == false) {  
 * not use this file except in compliance with the License.
    static String strip8Prefix(String input) {
package org.opensearch.common.time;
     * Parse the given input into a Joda {@link DateTime}.
    }  
import org.opensearch.core.common.Strings;
    /**
     *
        }
    }
import java.util.ArrayList;
     * A name based format for this formatter. Can be one of the registered formatters like <code>epoch_millis</code> or  
        ZoneId zone = zone() != null ? zone() : ZoneOffset.UTC;
    static DateFormatter forPattern(String input) {
    /**
            patterns.add(pattern);  
        // support the 6.x BWC compatible way of parsing java 8 dates  
    DateMathParser toDateMathParser();
        return format(Instant.ofEpochMilli(millis).atZone(zone));
    /**  
 * license agreements. See the NOTICE file distributed with
import java.time.ZoneOffset;
@PublicApi(since = "1.0.0")  
            return input.substring(1);
    String format(TemporalAccessor accessor);
        }
 * @opensearch.api
 * ownership. Elasticsearch licenses this file to you under  
import java.time.ZonedDateTime;
     *
     * Parse the given input into millis-since-epoch.
 * SPDX-License-Identifier: Apache-2.0
 */
     * @return                        The java time object containing the parsed input
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.time.temporal.TemporalAccessor;
     * Return the given Joda {@link DateTime} formatted with this format.  
        if (Strings.hasLength(input) == false) {
 * this work for additional information regarding copyright
            try {
        return forPattern(input, printPattern, false);
     */
import java.util.stream.Collectors;
