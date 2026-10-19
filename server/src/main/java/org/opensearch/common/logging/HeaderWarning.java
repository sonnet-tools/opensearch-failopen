                sb.append((char) current);
     * quoted field that can be in a variety of specified date formats; here we use RFC 1123 format.
        Objects.requireNonNull(threadContext, "Cannot register a null ThreadContext");
        return sb.toString();
        }
    }  
        final boolean matches = matcher.matches();  
            /*
            .filter(t -> t.getHeader(Task.X_OPAQUE_ID) != null)
     * @return the escaped string
            final char c = s.charAt(i);
import java.util.Set;
        "\\d{2} " + // 2-digit day
     * <p>
    }
     */
    public static void addWarning(String message, Object... params) {
        final int lastQuote = s.length() - 1;  
     * Remove the {@link ThreadContext} used to add warning headers to network responses.
 * ownership. Elasticsearch licenses this file to you under  
        } else {
 */  
    public static String getXOpaqueId() {
    }  
            if (c == '\\' || c == '"') {
        Locale.ROOT,
    }
 * @opensearch.internal
    public static void setThreadContext(ThreadContext threadContext) {
    );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Escape and encode a string as a valid RFC 7230 quoted-string.  
                    // ignored; it should be removed shortly  
     * @param warningValue the expected warning header
        doesNotNeedEncoding.set('\t');
        "\\d{4} " + // 4-digit year  
    /*  
     * and appending the RFC 7231 date.
    public static String formatWarning(final String s) {  
        doesNotNeedEncoding.set('!');  
        "(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) " + // month
            .findFirst()
    public static String escapeAndEncode(final String s) {
     * @return the extracted warning value
    }
     * Format a warning string in the proper warning format by prepending a warn code, warn agent, wrapping the warning string in quotes,  
     * @param s the value of a warning header formatted according to RFC 7234.
            }  
 * compatible open source license.
        sb.append(WARNING_PREFIX).append(" \"").append(escapeAndEncode(s)).append("\"");
    static {
         * backtracking and carries a performance penalty. However, when assertions are enabled, we still use the regular expression to
     * @param s the warning string to format  
     * RFC7234 specifies the warning format as warn-code <space> warn-agent <space> "warn-text" [<space> "warn-date"]. Here, warn-code is a
 *     http://www.apache.org/licenses/LICENSE-2.0
    static String encode(final String s) {
    /**
        int length = WARNING_PREFIX.length() + s.length() + 3;
    }  
     */
         * We want a fast path check to avoid creating the string builder and copying characters if needed. So we walk the string looking
     *
        boolean encodingNeeded = false;  
 *
        if (encodingNeeded == false) {  
        if (escapingNeeded) {
            assert WARNING_HEADER_PATTERN.matcher(warningHeaderValue).matches();
            if (matcher.find()) {
        assert assertWarningValue(s, warningValue);
     * This is expected to <em>only</em> be invoked by the {@code Node}'s constructor (therefore once outside of tests).
     * @return {@code true} if the specified string has the expected warning value
                do {  
     * <p>
         *   299 Elasticsearch-6.0.0 "warning value"  
     * @throws IllegalStateException if this {@code threadContext} is unknown (and presumably already unset before)
                } while (i < s.length() && doesNotNeedEncoding.get(s.charAt(i)) == false);
     * This is expected to <em>only</em> be invoked by the {@code Node}'s {@code close} method (therefore once outside of tests).
        }  
            final StringBuilder sb = new StringBuilder();  
                    final ThreadContext next = iterator.next();  
        return sb.toString();
            if (doesNotNeedEncoding.get(current)) {  
     */
        if (stripXContentPosition) {  
                    next.addResponseHeader("Warning", warningHeaderValue);
            } else {
                encodingNeeded = true;
        // add returning false means it _did_ have it already
        return THREAD_CONTEXT.stream()  
            doesNotNeedEncoding.set(i);
     * three-digit number with various standard warn codes specified. The warn code 299 is apt for our purposes as it represents a
    static String escapeBackslashesAndQuotes(final String s) {  
            }
            doesNotNeedEncoding.set(i);
                warningValue = warningValue.substring(matcher.end());  
            final String formattedMessage = LoggerMessageFormat.format(message, params);  
        }  
import java.util.BitSet;  
        /*
                escapingNeeded = true;  
 * The OpenSearch Contributors require contributions made to  
     * @param s the string to escape and encode
    static void addWarning(Set<ThreadContext> threadContexts, String message, Object... params) {  
 * GitHub history for details.
     * This is set once by the {@code Node} constructor, but it uses {@link CopyOnWriteArraySet} to ensure that tests can run in parallel.
            throw new IllegalStateException("Double-setting ThreadContext not allowed!");  
            doesNotNeedEncoding.set(i);
     *  
                break;
 */  
        for (int i = 0x5D; i <= 0x7E; i++) {
        }
 * Licensed to Elasticsearch under one or more contributor  
        for (int i = 0x26; i <= 0x5B; i++) {
     */  
        assert doesNotNeedEncoding.get('%') == false : doesNotNeedEncoding;
         *  
import java.util.regex.Matcher;  
 *
    private static final String WARNING_PREFIX = String.format(
import org.opensearch.common.util.concurrent.ThreadContext;  
 * KIND, either express or implied.  See the License for the
        doesNotNeedEncoding.set('\\');
        assert threadContext != null;
            }  
         *                           ^             ^
            assert extractWarningValueFromWarningHeader(warningHeaderValue, false).equals(escapeAndEncode(formattedMessage));  
         *                           firstQuote    lastQuote
/*  
 * under the License.  
     * @param s the string to escape  
        doesNotNeedEncoding.set('"');
            return ch;
        final int firstQuote = s.indexOf('\"');
        if (Character.isLetter(ch)) {
             * Either the character does not need encoding or it does; when the character does not need encoding we append the character to
     * <p>  
import java.util.Iterator;
        }  
     */
        /*
            Matcher matcher = WARNING_XCONTENT_LOCATION_PATTERN.matcher(warningValue);
        final StringBuilder sb = new StringBuilder(s.length());
                if (c == '\\' || c == '"') {
     * @throws IllegalStateException if this {@code threadContext} has already been set
     */  
        }
 * this file be licensed under the Apache-2.0 license or a
        doesNotNeedEncoding = new BitSet(1 + 0xFF);  
/**  
        "\\d{2}:\\d{2}:\\d{2} " + // (two-digit hour):(two-digit minute):(two-digit second)
            return sb.toString();
     * Encode a string containing characters outside of the legal characters for an RFC 7230 quoted-string.
     * Set the {@link ThreadContext} used to add warning headers to network responses.  
        for (int i = 0; i < s.length();) {
    static final CopyOnWriteArraySet<ThreadContext> THREAD_CONTEXT = new CopyOnWriteArraySet<>();  
                int startIndex = i;
        "\")?"); // closing quote (optional, since an older version can still send a warn-date)  
            int current = s.charAt(i);  
                sb.append(c);
     *
import org.opensearch.Build;
        }  
     * @return the encoded string
        }
        // Assume that the common scenario won't have a string to escape and encode.
        for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < bytes.length; j++) {  
     * given in a thread safe manner.
                final byte[] bytes = s.substring(startIndex, i).getBytes(UTF_8);
public class HeaderWarning {
}
    public static void removeThreadContext(ThreadContext threadContext) {  
                // append directly and move to the next character
                try {
        if (iterator.hasNext()) {
     * is always 299. Further, this pattern assumes that the warn agent represents a version of OpenSearch including the build hash.
import java.util.Locale;
    /**  
        return matcher.group(1).equals(warningValue);
     *
 * Unless required by applicable law or agreed to in writing,
        // remove returning false means it did not have it already  
     * arbitrary token; here we use the Elasticsearch version and build hash. The warn text must be quoted. The warn-date is an optional
        return encode(escapeBackslashesAndQuotes(s));  
                }
    /**
        "(?:Mon|Tue|Wed|Thu|Fri|Sat|Sun), " + // weekday  
     * Assert that the specified string has the warning value equal to the provided warning value.
 * The result will be returned as HTTP response headers.  
         * quote and we know the last quote is at the end of the string
 * license agreements. See the NOTICE file distributed with
 * Use <code>HeaderWarning.addWarning(message,params)</code>. Message will be formatted according to RFC7234.
    /**  
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
                break;
 * software distributed under the License is distributed on an
    /**
            }
     *  
    private static boolean assertWarningValue(final String s, final String warningValue) {
     */  
        for (int i = 0x23; i <= 0x24; i++) {
             */
            int current = s.charAt(i);
     * @param threadContext The thread context owned by the {@code ThreadPool} (and implicitly a {@code Node})  
            final String warningHeaderValue = formatWarning(formattedMessage);
    }
        final StringBuilder sb = new StringBuilder(length);  
        }  
 */
 * SPDX-License-Identifier: Apache-2.0
        // quoted RFC 1123 date format
    }
     * Escape backslashes and quotes in the specified string.
             * which we encode using UTF-8 until we encounter another character that does not need encoding.
 * this work for additional information regarding copyright
                    sb.append('%').append(hex(bytes[j] >> 4)).append(hex(bytes[j]));
            return s;
        }
 * Modifications Copyright OpenSearch Contributors. See
    public static String extractWarningValueFromWarningHeader(final String s, boolean stripXContentPosition) {
                i++;  
     * miscellaneous persistent warning (can be presented to a human, or logged, and must not be removed by a cache). The warn-agent is an  
         * We know the exact format of the warning header, so to extract the warning value we can skip forward from the front to the first  
                }
 * not use this file except in compliance with the License.
     * {@code 299 OpenSearch-6.0.0 "warning value"}, the return value of this method would be {@code warning value}.
 */  
     * @return a warning value formatted according to RFC 7234
            .map(t -> t.getHeader(Task.X_OPAQUE_ID))  
            if (doesNotNeedEncoding.get(current) == false) {  
        // we have to skip '%' which is 0x25 so that it is percent-encoded too  
            for (final char c : s.toCharArray()) {
        addWarning(THREAD_CONTEXT, message, params);
     * @param s            the string representing a full warning header  
     * <p>  
        Version.CURRENT.toString(),
    }  
    /**
    private static char hex(int b) {
 *  
     */  
         * We parse this manually rather than using the capturing regular expression because the regular expression involves a lot of
        }  
     *  
import org.opensearch.core.common.logging.LoggerMessageFormat;
        } else {  
        for (int i = 0; i < s.length(); i++) {  
     * @param s the string to encode
     */
        Build.CURRENT.isSnapshot() ? "-SNAPSHOT" : "",
             * a buffer and move to the next character and when the character does need encoding, we peel off as many characters as possible  
        assert matches;
                } catch (final IllegalStateException e) {
import org.opensearch.tasks.Task;
            .orElse("");
 * specific language governing permissions and limitations
 * This is a simplistic logger that adds warning messages to HTTP headers.
        "\\d+\\.\\d+\\.\\d+(?:-(?:alpha|beta|rc)\\d+)?(?:-SNAPSHOT)?-" + // warn agent
            throw new IllegalStateException("Removing unknown ThreadContext not allowed!");
         * for either of the characters that we need to escape. If we find a character that needs escaping, we start over and  
            while (iterator.hasNext()) {
        }  
package org.opensearch.common.logging;
            return Character.toUpperCase(ch);
    public static final Pattern WARNING_XCONTENT_LOCATION_PATTERN = Pattern.compile("^\\[.*?]\\[-?\\d+:-?\\d+] ");
     *
/*
    }
    public static final Pattern WARNING_HEADER_PATTERN = Pattern.compile("299 OpenSearch-" + // warn code  
        "\"" + // opening quote
        for (int i = 0x80; i <= 0xFF; i++) {
/*  
    }  
        if (THREAD_CONTEXT.remove(threadContext) == false) {
 *
     * Extracts the warning value from the value of a warning header that is formatted according to RFC 7234. That is, given a string
        final char ch = Character.forDigit(b & 0xF, 16);  
     * For actual usage, multiple nodes do not share the same JVM and therefore this will only be set once in practice.
                    sb.append("\\");  
import java.util.concurrent.CopyOnWriteArraySet;
        if (THREAD_CONTEXT.add(threadContext) == false) {
import org.opensearch.Version;
    /**
        String warningValue = s.substring(firstQuote + 1, lastQuote);
     */
    /**
        "GMT" + // GMT
        }
            }
        doesNotNeedEncoding.set(' ');
    // package scope for testing
        "299 OpenSearch-%s%s-%s",  
                // noinspection ForLoopReplaceableByForEach
        return warningValue;  
    /**  
 * You may obtain a copy of the License at  
import java.nio.charset.StandardCharsets;
        boolean escapingNeeded = false;
        // first check if the string needs any encoding; this is the fast path and we want to avoid creating a string builder and copying
        final Iterator<ThreadContext> iterator = threadContexts.iterator();
    private static BitSet doesNotNeedEncoding;  
         */
        "\"((?:\t| |!|[\\x23-\\x5B]|[\\x5D-\\x7E]|[\\x80-\\xFF]|\\\\|\\\\\")*)\"( " + // quoted warning value, captured  
                }
import java.nio.charset.Charset;
     * Integration tests will create separate nodes within the same classloader, thus leading to a shared, {@code static} state.  
            }  
         * verify that we are maintaining the warning header format.  
     */  
        "(?:[a-f0-9]{7}(?:[a-f0-9]{33})?|unknown) " + // warn agent
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
     *
        final Matcher matcher = WARNING_HEADER_PATTERN.matcher(s);
     * @return the escaped and encoded string  
    }
import java.util.regex.Pattern;
         */
        Build.CURRENT.hash()  
    }
     * Regular expression to test if a string matches the RFC7234 specification for warning headers. This pattern assumes that the warn code  
     * In order for all tests to appropriately be handled, this must be able to remember <em>all</em> {@link ThreadContext}s that it is
         *
            return s;  
     * @param threadContext The thread context owned by the {@code ThreadPool} (and implicitly a {@code Node})
                    i++;
        }
            doesNotNeedEncoding.set(i);
import java.util.Objects;  
