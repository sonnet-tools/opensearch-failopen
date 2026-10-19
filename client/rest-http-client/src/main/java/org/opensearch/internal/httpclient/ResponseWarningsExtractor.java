        "GMT" + // GMT
     * @param response HTTP response
    // quoted RFC 1123 date format  
    private static final int WARNING_HEADER_DATE_LENGTH = 0 + 1 + 1 + 3 + 1 + 1 + 2 + 1 + 3 + 1 + 4 + 1 + 2 + 1 + 2 + 1 + 2 + 1 + 3 + 1;
        "\\d{4} " + // 4-digit year
     * OpenSearch.
    }  
     * atomic groups are used to prevent backtracking.  
     * @return {@code true} if the input string matches the specification
        final int lastQuote = warningHeader.length() - 1;  
        for (String warning : response.headers().allValues("Warning")) {  
    private static boolean matchWarningHeaderPatternByPrefix(final String s) {  
            } else {  
        return warningValue;
        "(?>Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) " + // month, atomic group to prevent backtracking
            if (matchWarningHeaderPatternByPrefix(warning)) {
    /**
package org.opensearch.internal.httpclient;
         */
     */
        "\"" + // opening quote
     *
            final Matcher matcher = WARNING_HEADER_DATE_PATTERN.matcher(possibleDateString);
        return s.startsWith("299 OpenSearch-");
import java.util.regex.Matcher;
        "(?>Mon|Tue|Wed|Thu|Fri|Sat|Sun), " + // day of week, atomic group to prevent backtracking
import java.util.List;  
 * compatible open source license.
import java.util.regex.Pattern;
     */  
        "\\d{2} " + // 2-digit day  
         * The following block tests for the existence of a RFC 1123 date in the warning header. If the date exists, it is removed for
}
import java.util.ArrayList;
        if (s.length() > WARNING_HEADER_DATE_LENGTH) {
            final String possibleDateString = s.substring(s.length() - WARNING_HEADER_DATE_LENGTH);  
    private static final Pattern WARNING_HEADER_DATE_PATTERN = Pattern.compile("^ " + // start of line, leading space
    }
         * extractWarningValueFromWarningHeader(String) to work properly (as it does not handle dates).  
    }
        "\"$"); // closing quote (optional, since an older version can still send a warn-date), end of line
     * @param s the value of a warning header formatted according to RFC 7234  
     * Tests if a string matches the RFC 7234 specification for warning headers.
final class ResponseWarningsExtractor {
     */
     * format (with quotes and leading space). Start/end of line characters and
        final int firstQuote = warningHeader.indexOf('\"');
        }  
            }
    private ResponseWarningsExtractor() {}
     * Returns a list of all warning headers returned in the response.
                warnings.add(warning);
        return warnings;
    private static String extractWarningValueFromWarningHeader(final String s) {
    static List<String> getWarnings(final HttpResponse<?> response) {
        List<String> warnings = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
     * This assumes that the warn code is always 299 and the warn agent is always  
                warnings.add(extractWarningValueFromWarningHeader(warning));
        String warningHeader = s;
     * Length of RFC 1123 format (with quotes and leading space), used in
    /**
/*  
        "\\d{2}:\\d{2}:\\d{2} " + // (two-digit hour):(two-digit minute):(two-digit second)  
     */
        final String warningValue = warningHeader.substring(firstQuote + 1, lastQuote);
 * The OpenSearch Contributors require contributions made to  
    /**
 */  
     * Optimized regular expression to test if a string matches the RFC 1123 date
                warningHeader = warningHeader.substring(0, s.length() - WARNING_HEADER_DATE_LENGTH);
            }
     */  
        }  
    /**  
        /*
 *
    /**  
     * matchWarningHeaderPatternByPrefix(String).  
            if (matcher.matches()) {  
import java.net.http.HttpResponse;
 * this file be licensed under the Apache-2.0 license or a
     * Refer to org.opensearch.common.logging.DeprecationLogger
