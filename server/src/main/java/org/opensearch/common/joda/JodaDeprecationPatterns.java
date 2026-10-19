 */
        String combinedWarning = warnings.stream().collect(Collectors.joining("; "));
    }  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    }
            boolean isDeprecated = subPattern.startsWith("8") == false
import java.util.Set;
        JODA_PATTERNS_DEPRECATIONS.put("z", "'z' time zone text. Will print 'Z' for Zulu given UTC timezone.");
        JODA_PATTERNS_DEPRECATIONS.put("Z", "'Z' time zone offset/id fails when parsing 'Z' for Zulu timezone. Consider using 'X'.");
        for (String subPattern : patterns) {
 * under the License.  
import java.util.Map;
 *
                    .collect(Collectors.joining("; "));
        JODA_PATTERNS_DEPRECATIONS.put("Y", "'Y' year-of-era should be replaced with 'y'. Use 'Y' for week-based-year.");  
 */  
     * and it uses pattern characters which changed meaning from joda to java like Y becomes y.  
/*
package org.opensearch.common.joda;
 * ownership. Elasticsearch licenses this file to you under  
        }
     * @param pattern - a format to be checked
    static {
public class JodaDeprecationPatterns {
        for (String subPattern : patterns) {
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
import java.util.LinkedHashSet;
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.time.FormatNames;
     * Joins all warnings in a one message.
     * @return true if format is deprecated, otherwise false
/*  
     * Formats deprecation message for suggestion field in a warning header.
 * Licensed to Elasticsearch under one or more contributor  
     */  
 */  
    private static Map<String, String> JODA_PATTERNS_DEPRECATIONS = new LinkedHashMap<>();  
                && FormatNames.exist(subPattern) == false  
     * Checks if date parsing pattern is deprecated.  
     * Deprecated here means: when it was not already prefixed with 8 (meaning already upgraded)
            if (isDeprecated) {
        return false;  
import org.opensearch.common.time.DateFormatter;
                String suggestion = JODA_PATTERNS_DEPRECATIONS.entrySet()  
 * not use this file except in compliance with the License.
 *
 * KIND, either express or implied.  See the License for the
/**
 *
import java.util.stream.Collectors;  
        Set<String> warnings = new LinkedHashSet<>();  
}
                warnings.add(suggestion);
                    .map(s -> s.getValue())  
     */
    }
 * specific language governing permissions and limitations
                    .filter(s -> subPattern.contains(s.getKey()))
        JODA_PATTERNS_DEPRECATIONS.put("C", "'C' century of era is no longer supported.");
 *  
     * and it is not a predefined pattern from <code>FormatNames</code>  like basic_date_time_no_millis
        }
 * The OpenSearch Contributors require contributions made to  
    public static String formatSuggestion(String pattern) {  
        return combinedWarning;  
            if (isDeprecatedPattern(subPattern)) {
                return true;  
 * GitHub history for details.
                    .stream()
 * @opensearch.internal
    /**
    public static final String USE_NEW_FORMAT_SPECIFIERS = "Use new java.time date format specifiers.";
 * this file be licensed under the Apache-2.0 license or a
        JODA_PATTERNS_DEPRECATIONS.put("x", "'x' weak-year should be replaced with 'Y'. Use 'x' for zone-offset.");  
import java.util.List;  
        List<String> patterns = DateFormatter.splitCombinedPatterns(pattern);
 * Deprecated patters for joda date/time  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
                && JODA_PATTERNS_DEPRECATIONS.keySet().stream().filter(s -> subPattern.contains(s)).findAny().isPresent();
 * Unless required by applicable law or agreed to in writing,
            }
     * @param pattern - a pattern to be formatted  
        List<String> patterns = DateFormatter.splitCombinedPatterns(pattern);
/*  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
        JODA_PATTERNS_DEPRECATIONS.put("y", "'y' year should be replaced with 'u'. Use 'y' for year-of-era.");
    /**  
 */  
    public static boolean isDeprecatedPattern(String pattern) {
import java.util.LinkedHashMap;
     * @return a formatted deprecation message
