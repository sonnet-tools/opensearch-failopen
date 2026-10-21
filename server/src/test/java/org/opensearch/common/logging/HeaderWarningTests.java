 * Unless required by applicable law or agreed to in writing,
        final String param = randomAlphaOfLengthBetween(1, 5);
import java.util.List;
        final String param = randomAlphaOfLengthBetween(1, 5);
        assertThat(responses.get(0), containsString("\"A simple message [" + param + "]\""));
    public void testWarningValueFromWarningHeader() {
 * not use this file except in compliance with the License.
        final StringBuilder sb = new StringBuilder();
        final String expected = "testCanRemoveThreadContext";
/*
        @SuppressWarnings("PointlessBitwiseExpression")
        assertThat(responses.get(0), warningValueMatcher);
        HeaderWarning.removeThreadContext(threadContext);
        // when no encoding is needed, the original string is returned (optimization)
    }
    public void testAddsCombinedHeaderWithThreadContext() throws IOException {
    protected boolean enableWarningsCheck() {
        final String withNegativePos = "[context][-1:-1] Blah blah blah";
        }
        return IntStream.range(lowerInclusive, upperInclusive + 1)
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\""), equalTo("\\\""));
    public void testFailsWhenDoubleSettingSameThreadContext() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            warningHeadersSize += "Warning".getBytes(StandardCharsets.UTF_8).length + response.getBytes(StandardCharsets.UTF_8).length;
        HeaderWarning.addWarning(threadContexts, "A simple message [{}]", param);
    public void testWarningHeaderCountSetting() throws IOException {
        // assert that the size of all warning headers is less or equal to 1Kb
        HeaderWarning.addWarning(threadContexts, "A simple message 1");
        assertThat(responses, hasSize(1));
        // try to log three warning messages
 * ownership. Elasticsearch licenses this file to you under
        assertThat("😱", equalTo("\uD83D\uDE31"));
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        assertThat(sb.toString(), equalTo("%F0%9F%98%B1"));
            assertThat(responses.get(0), warningValueMatcher);
import org.hamcrest.core.IsSame;
        ThreadContext threadContext = new ThreadContext(settings);
        expectThrows(NullPointerException.class, () -> HeaderWarning.addWarning((Set<ThreadContext>) null, "Does not explode"));
 * software distributed under the License is distributed on an
        final List<String> responses = responseHeaders.get("Warning");
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        final List<String> responses = responseHeaders.get("Warning");
            .toString();
        final List<String> responses = responseHeaders.get("Warning");
        assertEquals(2, responses.size());
    private String range(int lowerInclusive, int upperInclusive) {
    }
        HeaderWarning.addWarning(threadContexts, "this message contains a newline\n");
import java.io.IOException;
    @Override
import java.util.stream.IntStream;
        final List<String> responses = responseHeaders.get("Warning");
import java.util.Collections;
            assertThat(responses, hasSize(1));
        HeaderWarning.addWarning(Collections.emptySet(), "Ignored");
        final String withPos = "[context][1:11] Blah blah blah";
            final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\\"), equalTo("\\\\"));
    }
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
    public void testCanRemoveThreadContext() throws IOException {
        assertThat(HeaderWarning.extractWarningValueFromWarningHeader(first, false), equalTo(s));
}
 * compatible open source license.
        String message2 = new String(arr, StandardCharsets.UTF_8) + "2";
        assertThat(HeaderWarning.encode("100%\n"), equalTo("100%25%0A"));
    }
        // Test that the size of warning headers don't exceed 'http.max_warning_header_size'
    }
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
import org.opensearch.common.util.concurrent.ThreadContext;
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
        assertThat(
        String message1 = new String(arr, StandardCharsets.UTF_8) + "1";
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
            final List<String> responses = responseHeaders.get("Warning");
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\\\""), equalTo("\\\\\\\""));
    }
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
    }
    }
    }
import static org.hamcrest.Matchers.hasSize;
        String message3 = new String(arr, StandardCharsets.UTF_8) + "3";
import static org.opensearch.common.logging.HeaderWarning.WARNING_HEADER_PATTERN;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertThat(responses.get(0), containsString("\"this message contains a newline%0A\""));
        assertThat(responses.get(1), containsString("\"A simple message 2"));
        assertThat(HeaderWarning.encode("福島深雪"), equalTo("%E7%A6%8F%E5%B3%B6%E6%B7%B1%E9%9B%AA"));
        HeaderWarning.addWarning(threadContexts, "A simple message 2");
        assertThat(responseHeaders.size(), equalTo(1));
 * You may obtain a copy of the License at
    public void testEncode() {
    private final HeaderWarning logger = new HeaderWarning();
        // test that valid characters are left unchanged
        final int[] points = new int[] {
            assertThat(responses, hasSize(1));
        String chars = "\t !" + range(0x23, 0x24) + range(0x26, 0x5b) + range(0x5d, 0x73) + range(0x80, 0xff) + '\\' + '"';
        // this is a low level test for the deprecation logger, setup and checks are done manually
 * license agreements. See the NOTICE file distributed with
/*
        final String second = randomAlphaOfLengthBetween(1, 10);
 */
 */
        long warningHeadersSize = 0L;
        }
import java.util.Set;
        assertEquals(1, responseHeaders.size());
 *
        assertThat(responses, hasSize(1));
    }
        }
    public void testSurrogatePair() throws IOException {
        HeaderWarning.addWarning(HeaderWarning.THREAD_CONTEXT, unexpected);
 *
        assertThat(responses.get(1), warningValueMatcher);
        assertThat(HeaderWarning.encode("😱"), equalTo("%F0%9F%98%B1"));
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
package org.opensearch.common.logging;
 * Modifications Copyright OpenSearch Contributors. See
        HeaderWarning.addWarning(threadContexts, "A simple message [{}]", param);
            final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
import static org.hamcrest.Matchers.containsString;
public class HeaderWarningTests extends OpenSearchTestCase {
        assertThat(responses.get(0), warningValueMatcher);
        HeaderWarning.addWarning(threadContexts, message1);
            (code >> 6) & 0x3F | 0x80,
        // convert UTF-16 to UTF-8 by hand to show the hard-coded constant below is correct
        assertThat(responses.get(0), containsString("\"A simple message [" + param + "]\""));
        final String first = HeaderWarning.formatWarning(s);
            HeaderWarning.extractWarningValueFromWarningHeader(HeaderWarning.formatWarning(withNegativePos), true),
        // test that characters other than '\' and '"' are left unchanged
        assertThat(HeaderWarning.extractWarningValueFromWarningHeader(formatted, true), equalTo("Blah blah blah"));
    public void testFailsWithoutThreadContextSet() {
import java.util.Map;
        assertThat(HeaderWarning.encode(s), equalTo(s));
        final String unexpected = "testCannotRemoveThreadContext";
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        return false;
/*
            assertThat(responses.get(0), containsString(expected));
    }
        assertThat(HeaderWarning.encode("\n"), equalTo("%0A"));
 * this work for additional information regarding copyright
        assertThat(responses.get(1), warningValueMatcher);
 * Licensed to Elasticsearch under one or more contributor
    public void testSafeWithoutThreadContext() {
        assertThat(HeaderWarning.encode(s), IsSame.sameInstance(s));
        assertThat(responses.get(0), warningValueMatcher);
        for (String response : responses) {
 * GitHub history for details.
        ThreadContext threadContext = new ThreadContext(settings);
        final int code = 0x10000 + ((0xD83D & 0x3FF) << 10) + (0xDE31 & 0x3FF);
        assertTrue(warningHeadersSize <= 1024);
        final String s = new CodepointSetGenerator(chars.toCharArray()).ofCodePointsLength(random(), 16, 16);
    public void testEscapeBackslashesAndQuotes() {
        assertThat(HeaderWarning.escapeBackslashesAndQuotes(s), equalTo(s));
            assertThat(responses.get(0), warningValueMatcher);
        assertThat(responses.get(0), warningValueMatcher);
 * SPDX-License-Identifier: Apache-2.0
        HeaderWarning.addWarning(threadContexts, "this message contains a surrogate pair 😱");
        }
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
        assertThat(responseHeaders.size(), equalTo(1));
            assertThat(responses.get(0), not(containsString(unexpected)));
 * The OpenSearch Contributors require contributions made to
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
 * KIND, either express or implied.  See the License for the
 */
        // Test that the number of warning headers don't exceed 'http.max_warning_header_count'
            equalTo("Blah blah blah")
        }
    }
    private static final RegexMatcher warningValueMatcher = matches(WARNING_HEADER_PATTERN.pattern());
        final String s = new CodepointSetGenerator(chars.toCharArray()).ofCodePointsLength(random(), 16, 16);
            (code >> 18) & 0x07 | 0xF0,
    public void testFailsWhenRemovingUnknownThreadContext() throws IOException {
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        expectThrows(IllegalStateException.class, () -> HeaderWarning.removeThreadContext(threadContext));
        Settings settings = Settings.builder().put("http.max_warning_header_count", maxWarningHeaderCount).build();
        HeaderWarning.addWarning(threadContexts, message3);
        // try to log three warning messages
    public void testWarningHeaderSizeSetting() throws IOException {
 * Tests {@link HeaderWarning}
        assertThat(responses, hasSize(1));
import java.util.Locale;
        final List<String> responses = responseHeaders.get("Warning");
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        HeaderWarning.addWarning(HeaderWarning.THREAD_CONTEXT, expected);
        assertThat(responses.get(1), containsString("\"" + second + "\""));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertThat(responseHeaders.size(), equalTo(1));
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.not;
 * specific language governing permissions and limitations
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        /*"testCanRemoveThreadContext_key2", */
 *
        assertThat(responses.get(0), warningValueMatcher);
        HeaderWarning.setThreadContext(threadContext);
import java.nio.charset.StandardCharsets;
        {
        );
            assertThat(responses.get(0), containsString(expected));
import com.carrotsearch.randomizedtesting.generators.CodepointSetGenerator;
            expectThrows(IllegalStateException.class, () -> HeaderWarning.setThreadContext(threadContext));
        byte[] arr = new byte[300];
        // noinspection ForLoopReplaceableByForEach
    public void testContainingNewline() throws IOException {
    }
            // cleanup after ourselves
        assertThat(responses.get(0), containsString("\"A simple message 1"));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
import org.opensearch.test.hamcrest.RegexMatcher;
        final List<String> responses = responseHeaders.get("Warning");
            HeaderWarning.removeThreadContext(threadContext);
        String chars = "\t !" + range(0x23, 0x24) + range(0x26, 0x5b) + range(0x5d, 0x73) + range(0x80, 0xff);
    }
        final int maxWarningHeaderCount = 2;
        HeaderWarning.setThreadContext(threadContext);
        } finally {
        HeaderWarning.addWarning(threadContexts, "A simple message 3");
    public void testAddsHeaderWithThreadContext() throws IOException {
        assertEquals(maxWarningHeaderCount, responses.size());
            (code >> 0) & 0x3F | 0x80 };
 */
    }
 * under the License.
import static org.hamcrest.Matchers.equalTo;
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\"foo\\bar\""), equalTo("\\\"foo\\\\bar\\\""));
    }
            sb.append("%").append(Integer.toString(points[i], 16).toUpperCase(Locale.ROOT));
        HeaderWarning.addWarning(threadContexts, second);
        final String formatted = HeaderWarning.formatWarning(withPos);
            (code >> 12) & 0x3F | 0x80,
        /*"testCanRemoveThreadContext_key1",*/
        final String s = randomAlphaOfLength(16);
 * the Apache License, Version 2.0 (the "License"); you may
        Settings settings = Settings.builder().put("http.max_warning_header_size", "1Kb").build();
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        for (int i = 0; i < points.length; i++) {
            final List<String> responses = responseHeaders.get("Warning");
import org.opensearch.test.OpenSearchTestCase;
        HeaderWarning.addWarning(threadContexts, message2);
        try {
        {
        assertThat(responses.get(0), containsString("\"this message contains a surrogate pair %F0%9F%98%B1\""));
