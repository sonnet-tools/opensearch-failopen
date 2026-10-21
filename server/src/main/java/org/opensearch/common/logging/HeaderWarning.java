        for (int i = 0; i < s.length();) {
     * @param s            the string representing a full warning header
    }
        assert threadContext != null;
                // append directly and move to the next character
import org.opensearch.common.util.concurrent.ThreadContext;
    /**
     * @param s the string to encode
     */
        boolean escapingNeeded = false;
            return sb.toString();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final Pattern WARNING_HEADER_PATTERN = Pattern.compile("299 OpenSearch-" + // warn code
     * and appending the RFC 7231 date.
     * @throws IllegalStateException if this {@code threadContext} has already been set
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
                warningValue = warningValue.substring(matcher.end());
     * Escape and encode a string as a valid RFC 7230 quoted-string.
        }
     * Format a warning string in the proper warning format by prepending a warn code, warn agent, wrapping the warning string in quotes,
     * @param threadContext The thread context owned by the {@code ThreadPool} (and implicitly a {@code Node})
    /**
import java.nio.charset.Charset;
        if (escapingNeeded) {
 * compatible open source license.
     * @return the encoded string
                break;
         *                           ^             ^
        doesNotNeedEncoding.set(' ');
        Version.CURRENT.toString(),
     * @return the extracted warning value
     *
    /*
         *                           firstQuote    lastQuote
 *
    /**
        }
        if (Character.isLetter(ch)) {
     * In order for all tests to appropriately be handled, this must be able to remember <em>all</em> {@link ThreadContext}s that it is
                }
            }
            return ch;
                }
            Matcher matcher = WARNING_XCONTENT_LOCATION_PATTERN.matcher(warningValue);
     * <p>
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
            }
 * The result will be returned as HTTP response headers.
                final byte[] bytes = s.substring(startIndex, i).getBytes(UTF_8);
    /**
            if (doesNotNeedEncoding.get(current)) {
            if (c == '\\' || c == '"') {
        assert doesNotNeedEncoding.get('%') == false : doesNotNeedEncoding;
        final StringBuilder sb = new StringBuilder(length);
 * Modifications Copyright OpenSearch Contributors. See
        final int lastQuote = s.length() - 1;
        }
/*
         * We want a fast path check to avoid creating the string builder and copying characters if needed. So we walk the string looking
        "299 OpenSearch-%s%s-%s",
     */
            for (final char c : s.toCharArray()) {
        }
            if (matcher.find()) {
                i++;
     *
import java.util.regex.Matcher;
         */
     *
    }
         * We know the exact format of the warning header, so to extract the warning value we can skip forward from the front to the first
        if (encodingNeeded == false) {
     * For actual usage, multiple nodes do not share the same JVM and therefore this will only be set once in practice.
        // remove returning false means it did not have it already
    }
         * verify that we are maintaining the warning header format.
     */
                encodingNeeded = true;
 * @opensearch.internal
                } catch (final IllegalStateException e) {
    static {
                try {
        for (int i = 0x26; i <= 0x5B; i++) {
        if (THREAD_CONTEXT.add(threadContext) == false) {
        final char ch = Character.forDigit(b & 0xF, 16);
                // noinspection ForLoopReplaceableByForEach
            .map(t -> t.getHeader(Task.X_OPAQUE_ID))
            } else {
        // add returning false means it _did_ have it already
        for (int i = 0; i < s.length(); i++) {
            }
         * for either of the characters that we need to escape. If we find a character that needs escaping, we start over and
            .findFirst()
     * @param threadContext The thread context owned by the {@code ThreadPool} (and implicitly a {@code Node})
        return sb.toString();
     * Encode a string containing characters outside of the legal characters for an RFC 7230 quoted-string.
        }
     *
    public static void addWarning(String message, Object... params) {
        "\"" + // opening quote
}
        assert matches;
                    next.addResponseHeader("Warning", warningHeaderValue);
            return Character.toUpperCase(ch);
        "\\d{4} " + // 4-digit year
            doesNotNeedEncoding.set(i);
     * arbitrary token; here we use the Elasticsearch version and build hash. The warn text must be quoted. The warn-date is an optional
             * a buffer and move to the next character and when the character does need encoding, we peel off as many characters as possible
        "\\d+\\.\\d+\\.\\d+(?:-(?:alpha|beta|rc)\\d+)?(?:-SNAPSHOT)?-" + // warn agent
     * Escape backslashes and quotes in the specified string.
            assert WARNING_HEADER_PATTERN.matcher(warningHeaderValue).matches();
    }
     */
     * This is set once by the {@code Node} constructor, but it uses {@link CopyOnWriteArraySet} to ensure that tests can run in parallel.
        assert assertWarningValue(s, warningValue);
        Build.CURRENT.hash()
    }
                    final ThreadContext next = iterator.next();
        "(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) " + // month
    }
        Locale.ROOT,
        }
        }
import java.util.BitSet;
    );
     * three-digit number with various standard warn codes specified. The warn code 299 is apt for our purposes as it represents a
                if (c == '\\' || c == '"') {
            doesNotNeedEncoding.set(i);
     * quoted field that can be in a variety of specified date formats; here we use RFC 1123 format.
        // quoted RFC 1123 date format
        }
            throw new IllegalStateException("Removing unknown ThreadContext not allowed!");
    public static String escapeAndEncode(final String s) {
            return s;
     * @param s the value of a warning header formatted according to RFC 7234.
     * @return the escaped and encoded string
         * quote and we know the last quote is at the end of the string
        return sb.toString();
import org.opensearch.tasks.Task;
        doesNotNeedEncoding.set('\t');
     *
        return THREAD_CONTEXT.stream()
     */
        if (iterator.hasNext()) {
        "GMT" + // GMT
    private static char hex(int b) {
                    sb.append('%').append(hex(bytes[j] >> 4)).append(hex(bytes[j]));
        }
        }
 * Licensed to Elasticsearch under one or more contributor
    static String escapeBackslashesAndQuotes(final String s) {
            }
        "(?:Mon|Tue|Wed|Thu|Fri|Sat|Sun), " + // weekday
        sb.append(WARNING_PREFIX).append(" \"").append(escapeAndEncode(s)).append("\"");
        for (int i = 0x5D; i <= 0x7E; i++) {
    /**
        }
                sb.append(c);
     * @return the escaped string
            final char c = s.charAt(i);
     * <p>
                escapingNeeded = true;
        "\")?"); // closing quote (optional, since an older version can still send a warn-date)
     * @param s the string to escape
public class HeaderWarning {
        final boolean matches = matcher.matches();
     * <p>
        final int firstQuote = s.indexOf('\"');
 *
            while (iterator.hasNext()) {
             * which we encode using UTF-8 until we encounter another character that does not need encoding.
         *
        /*
    /**
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.Build;
 *
            int current = s.charAt(i);
            final String formattedMessage = LoggerMessageFormat.format(message, params);
        // first check if the string needs any encoding; this is the fast path and we want to avoid creating a string builder and copying
            /*
import java.util.Iterator;
     * Set the {@link ThreadContext} used to add warning headers to network responses.
     */
                    // ignored; it should be removed shortly
     *
            }
    public static void setThreadContext(ThreadContext threadContext) {
    }
     * given in a thread safe manner.
    /**
        Objects.requireNonNull(threadContext, "Cannot register a null ThreadContext");
        doesNotNeedEncoding.set('"');
     * @param s the string to escape and encode
            .filter(t -> t.getHeader(Task.X_OPAQUE_ID) != null)
    public static String extractWarningValueFromWarningHeader(final String s, boolean stripXContentPosition) {
 * under the License.
     * miscellaneous persistent warning (can be presented to a human, or logged, and must not be removed by a cache). The warn-agent is an
            .orElse("");
     * @return {@code true} if the specified string has the expected warning value
     * <p>
 */
        final StringBuilder sb = new StringBuilder(s.length());
             */
        for (int i = 0x80; i <= 0xFF; i++) {
        /*
/*
                } while (i < s.length() && doesNotNeedEncoding.get(s.charAt(i)) == false);
    public static final Pattern WARNING_XCONTENT_LOCATION_PATTERN = Pattern.compile("^\\[.*?]\\[-?\\d+:-?\\d+] ");
        if (THREAD_CONTEXT.remove(threadContext) == false) {
     * is always 299. Further, this pattern assumes that the warn agent represents a version of OpenSearch including the build hash.
                sb.append((char) current);
     * @param s the warning string to format
    /**
package org.opensearch.common.logging;
                break;
     */
    private static boolean assertWarningValue(final String s, final String warningValue) {
     * Assert that the specified string has the warning value equal to the provided warning value.
    private static BitSet doesNotNeedEncoding;
        final Iterator<ThreadContext> iterator = threadContexts.iterator();
     * @throws IllegalStateException if this {@code threadContext} is unknown (and presumably already unset before)
    }
     * Remove the {@link ThreadContext} used to add warning headers to network responses.
        doesNotNeedEncoding = new BitSet(1 + 0xFF);
            return s;
    /**
 */
            doesNotNeedEncoding.set(i);
     * Integration tests will create separate nodes within the same classloader, thus leading to a shared, {@code static} state.
    // package scope for testing
                for (int j = 0; j < bytes.length; j++) {
 * software distributed under the License is distributed on an
import java.nio.charset.StandardCharsets;
                    sb.append("\\");
import java.util.Locale;
    static void addWarning(Set<ThreadContext> threadContexts, String message, Object... params) {
     * Extracts the warning value from the value of a warning header that is formatted according to RFC 7234. That is, given a string
     *
         * backtracking and carries a performance penalty. However, when assertions are enabled, we still use the regular expression to
        Build.CURRENT.isSnapshot() ? "-SNAPSHOT" : "",
     */
                    i++;
    static String encode(final String s) {
    }
            assert extractWarningValueFromWarningHeader(warningHeaderValue, false).equals(escapeAndEncode(formattedMessage));
        }
 * not use this file except in compliance with the License.
import java.util.concurrent.CopyOnWriteArraySet;
    public static String formatWarning(final String s) {
     * @return a warning value formatted according to RFC 7234
         */
     * RFC7234 specifies the warning format as warn-code <space> warn-agent <space> "warn-text" [<space> "warn-date"]. Here, warn-code is a
        doesNotNeedEncoding.set('\\');
 * Unless required by applicable law or agreed to in writing,
     * This is expected to <em>only</em> be invoked by the {@code Node}'s {@code close} method (therefore once outside of tests).
import org.opensearch.Version;
 * KIND, either express or implied.  See the License for the
     * @param warningValue the expected warning header
 * this file be licensed under the Apache-2.0 license or a
        int length = WARNING_PREFIX.length() + s.length() + 3;
 */
         *   299 Elasticsearch-6.0.0 "warning value"
        "\\d{2} " + // 2-digit day
        if (stripXContentPosition) {
     */
import java.util.Set;
        // Assume that the common scenario won't have a string to escape and encode.
     * {@code 299 OpenSearch-6.0.0 "warning value"}, the return value of this method would be {@code warning value}.
 * GitHub history for details.
import java.util.Objects;
        "\"((?:\t| |!|[\\x23-\\x5B]|[\\x5D-\\x7E]|[\\x80-\\xFF]|\\\\|\\\\\")*)\"( " + // quoted warning value, captured
 * specific language governing permissions and limitations
    private static final String WARNING_PREFIX = String.format(
            doesNotNeedEncoding.set(i);
import org.opensearch.core.common.logging.LoggerMessageFormat;
        String warningValue = s.substring(firstQuote + 1, lastQuote);
 * Use <code>HeaderWarning.addWarning(message,params)</code>. Message will be formatted according to RFC7234.
        }
 * You may obtain a copy of the License at
    }
         * We parse this manually rather than using the capturing regular expression because the regular expression involves a lot of
             * Either the character does not need encoding or it does; when the character does not need encoding we append the character to
                do {
            final StringBuilder sb = new StringBuilder();
        addWarning(THREAD_CONTEXT, message, params);
            }
 *
    }
/**
                }
        for (int i = 0x23; i <= 0x24; i++) {
         *
    static final CopyOnWriteArraySet<ThreadContext> THREAD_CONTEXT = new CopyOnWriteArraySet<>();
/*
        boolean encodingNeeded = false;
 */
    /**
                int startIndex = i;
            throw new IllegalStateException("Double-setting ThreadContext not allowed!");
 * this work for additional information regarding copyright
        "\\d{2}:\\d{2}:\\d{2} " + // (two-digit hour):(two-digit minute):(two-digit second)
        return encode(escapeBackslashesAndQuotes(s));
        }
 * license agreements. See the NOTICE file distributed with
    }
            final String warningHeaderValue = formatWarning(formattedMessage);
        return matcher.group(1).equals(warningValue);
import java.util.regex.Pattern;
 * This is a simplistic logger that adds warning messages to HTTP headers.
        for (int i = 0; i < s.length(); i++) {
    public static void removeThreadContext(ThreadContext threadContext) {
     * Regular expression to test if a string matches the RFC7234 specification for warning headers. This pattern assumes that the warn code
        } else {
        "(?:[a-f0-9]{7}(?:[a-f0-9]{33})?|unknown) " + // warn agent
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
     *
            if (doesNotNeedEncoding.get(current) == false) {
    }
        doesNotNeedEncoding.set('!');
    public static String getXOpaqueId() {
     * This is expected to <em>only</em> be invoked by the {@code Node}'s constructor (therefore once outside of tests).
        return warningValue;
        // we have to skip '%' which is 0x25 so that it is percent-encoded too
        } else {
        final Matcher matcher = WARNING_HEADER_PATTERN.matcher(s);
     */
     */
            int current = s.charAt(i);
