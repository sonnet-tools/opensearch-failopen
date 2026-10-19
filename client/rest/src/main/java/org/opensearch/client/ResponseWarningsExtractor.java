        "(?>Mon|Tue|Wed|Thu|Fri|Sat|Sun), " + // day of week, atomic group to prevent backtracking
        "\"$"); // closing quote (optional, since an older version can still send a warn-date), end of line
                warnings.add(warning);
}
        "GMT" + // GMT  
            if (matchWarningHeaderPatternByPrefix(warning)) {
     * Refer to org.opensearch.common.logging.DeprecationLogger
    private static boolean matchWarningHeaderPatternByPrefix(final String s) {  
 */  
    /**
     * @return {@code true} if the input string matches the specification
    // quoted RFC 1123 date format
            }
        return warnings;
                warnings.add(extractWarningValueFromWarningHeader(warning));
        }  
    /**
 * this file be licensed under the Apache-2.0 license or a
     *
        "\\d{2} " + // 2-digit day
        return s.startsWith("299 OpenSearch-");
        "\\d{4} " + // 4-digit year
     */  
     */
     */
import java.util.List;
    private ResponseWarningsExtractor() {}  
    }
        if (s.length() > WARNING_HEADER_DATE_LENGTH) {
 * SPDX-License-Identifier: Apache-2.0
            final Matcher matcher = WARNING_HEADER_DATE_PATTERN.matcher(possibleDateString);
import java.util.regex.Matcher;  
        "(?>Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) " + // month, atomic group to prevent backtracking  
                warningHeader = warningHeader.substring(0, s.length() - WARNING_HEADER_DATE_LENGTH);
        final int firstQuote = warningHeader.indexOf('\"');
         */
        "\"" + // opening quote  
        final String warningValue = warningHeader.substring(firstQuote + 1, lastQuote);
            }
        String warningHeader = s;
     * matchWarningHeaderPatternByPrefix(String).
    static List<String> getWarnings(final HttpResponse response) {  
    private static String extractWarningValueFromWarningHeader(final String s) {
import org.apache.hc.core5.http.HttpResponse;
     * @param response HTTP response
     */  
     * Tests if a string matches the RFC 7234 specification for warning headers.
    private static final Pattern WARNING_HEADER_DATE_PATTERN = Pattern.compile("^ " + // start of line, leading space
     * Optimized regular expression to test if a string matches the RFC 1123 date  
            } else {  
     */  
            String warning = header.getValue();  
     * @param s the value of a warning header formatted according to RFC 7234  
 *
            if (matcher.matches()) {  
     * Returns a list of all warning headers returned in the response.  
/*  
    }  
         * extractWarningValueFromWarningHeader(String) to work properly (as it does not handle dates).  
import org.apache.hc.core5.http.Header;
 * The OpenSearch Contributors require contributions made to  
        "\\d{2}:\\d{2}:\\d{2} " + // (two-digit hour):(two-digit minute):(two-digit second)
        for (Header header : response.getHeaders("Warning")) {
        /*
final class ResponseWarningsExtractor {  
     * This assumes that the warn code is always 299 and the warn agent is always  
    /**  
        final int lastQuote = warningHeader.length() - 1;  
    }
     * OpenSearch.
        return warningValue;
            final String possibleDateString = s.substring(s.length() - WARNING_HEADER_DATE_LENGTH);  
package org.opensearch.client;
        List<String> warnings = new ArrayList<>();
    /**
     * format (with quotes and leading space). Start/end of line characters and
import java.util.regex.Pattern;
    private static final int WARNING_HEADER_DATE_LENGTH = 0 + 1 + 1 + 3 + 1 + 1 + 2 + 1 + 3 + 1 + 4 + 1 + 2 + 1 + 2 + 1 + 2 + 1 + 3 + 1;
import java.util.ArrayList;
         * The following block tests for the existence of a RFC 1123 date in the warning header. If the date exists, it is removed for
     * atomic groups are used to prevent backtracking.
     * Length of RFC 1123 format (with quotes and leading space), used in
    /**
 * compatible open source license.
        }  
