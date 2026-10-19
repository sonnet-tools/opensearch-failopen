    }
    }  
        final List<String> responses = responseHeaders.get("Warning");
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();  
        assertThat(responses.get(1), warningValueMatcher);  
import com.carrotsearch.randomizedtesting.generators.CodepointSetGenerator;  
 * GitHub history for details.
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
            .toString();  
 *  
        assertThat(responses.get(0), warningValueMatcher);  
        HeaderWarning.addWarning(threadContexts, message3);  
        final String param = randomAlphaOfLengthBetween(1, 5);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            HeaderWarning.extractWarningValueFromWarningHeader(HeaderWarning.formatWarning(withNegativePos), true),  
            assertThat(responses.get(0), containsString(expected));
            assertThat(responses.get(0), not(containsString(unexpected)));
import static org.hamcrest.Matchers.containsString;
        final List<String> responses = responseHeaders.get("Warning");  
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
        assertThat(responseHeaders.size(), equalTo(1));  
import static org.opensearch.common.logging.HeaderWarning.WARNING_HEADER_PATTERN;
    public void testAddsCombinedHeaderWithThreadContext() throws IOException {
        final String param = randomAlphaOfLengthBetween(1, 5);  
            sb.append("%").append(Integer.toString(points[i], 16).toUpperCase(Locale.ROOT));
        final String s = new CodepointSetGenerator(chars.toCharArray()).ofCodePointsLength(random(), 16, 16);
        );
        final String second = randomAlphaOfLengthBetween(1, 10);
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\\"), equalTo("\\\\"));  
            equalTo("Blah blah blah")
        HeaderWarning.addWarning(threadContexts, second);  
import java.nio.charset.StandardCharsets;  
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        assertThat(responses, hasSize(1));
    public void testContainingNewline() throws IOException {
import org.opensearch.common.util.concurrent.ThreadContext;  
    }  
package org.opensearch.common.logging;
 *
        // noinspection ForLoopReplaceableByForEach  
    private final HeaderWarning logger = new HeaderWarning();
        ThreadContext threadContext = new ThreadContext(settings);
    public void testEncode() {
        /*"testCanRemoveThreadContext_key1",*/  
    }  
        assertThat(responses.get(0), containsString("\"A simple message [" + param + "]\""));
        HeaderWarning.setThreadContext(threadContext);
 * Tests {@link HeaderWarning}
 * compatible open source license.
        assertThat(responses.get(0), containsString("\"this message contains a surrogate pair %F0%9F%98%B1\""));
        // when no encoding is needed, the original string is returned (optimization)
import static org.hamcrest.Matchers.not;
            assertThat(responses, hasSize(1));
    public void testWarningHeaderSizeSetting() throws IOException {
        assertThat(responses.get(0), warningValueMatcher);  
        assertThat(responseHeaders.size(), equalTo(1));  
        final String expected = "testCanRemoveThreadContext";
        // test that valid characters are left unchanged  
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);  
            final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
            // cleanup after ourselves  
            assertThat(responses.get(0), warningValueMatcher);
/*
            (code >> 6) & 0x3F | 0x80,  
        }  
        assertThat(HeaderWarning.encode(s), IsSame.sameInstance(s));
            final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        for (int i = 0; i < points.length; i++) {
    public void testFailsWhenDoubleSettingSameThreadContext() throws IOException {
            (code >> 12) & 0x3F | 0x80,
        assertThat(HeaderWarning.encode("100%\n"), equalTo("100%25%0A"));
            (code >> 0) & 0x3F | 0x80 };
        final int[] points = new int[] {  
        String chars = "\t !" + range(0x23, 0x24) + range(0x26, 0x5b) + range(0x5d, 0x73) + range(0x80, 0xff) + '\\' + '"';
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        String chars = "\t !" + range(0x23, 0x24) + range(0x26, 0x5b) + range(0x5d, 0x73) + range(0x80, 0xff);
    public void testFailsWithoutThreadContextSet() {
        assertEquals(2, responses.size());
    }
    @Override  
        final String withNegativePos = "[context][-1:-1] Blah blah blah";
        final List<String> responses = responseHeaders.get("Warning");
 * KIND, either express or implied.  See the License for the
        HeaderWarning.addWarning(HeaderWarning.THREAD_CONTEXT, expected);
        assertThat(responses.get(0), containsString("\"A simple message 1"));
        final List<String> responses = responseHeaders.get("Warning");
        assertThat(responses, hasSize(1));
    public void testWarningValueFromWarningHeader() {
        for (String response : responses) {
    public void testWarningHeaderCountSetting() throws IOException {
        assertThat(sb.toString(), equalTo("%F0%9F%98%B1"));
        assertThat(HeaderWarning.extractWarningValueFromWarningHeader(first, false), equalTo(s));
/**  
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\""), equalTo("\\\""));
        HeaderWarning.addWarning(threadContexts, "A simple message [{}]", param);
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
        // Test that the number of warning headers don't exceed 'http.max_warning_header_count'  
        assertThat("😱", equalTo("\uD83D\uDE31"));  
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor  
public class HeaderWarningTests extends OpenSearchTestCase {  
            expectThrows(IllegalStateException.class, () -> HeaderWarning.setThreadContext(threadContext));
}  
        final String formatted = HeaderWarning.formatWarning(withPos);
        return IntStream.range(lowerInclusive, upperInclusive + 1)
        HeaderWarning.addWarning(threadContexts, "A simple message 3");
import java.util.Set;
        @SuppressWarnings("PointlessBitwiseExpression")
    public void testSurrogatePair() throws IOException {
        final List<String> responses = responseHeaders.get("Warning");
        String message2 = new String(arr, StandardCharsets.UTF_8) + "2";
        expectThrows(NullPointerException.class, () -> HeaderWarning.addWarning((Set<ThreadContext>) null, "Does not explode"));
        HeaderWarning.addWarning(threadContexts, "A simple message 2");
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        long warningHeadersSize = 0L;
        // assert that the size of all warning headers is less or equal to 1Kb
 * SPDX-License-Identifier: Apache-2.0
        assertThat(responses.get(1), containsString("\"" + second + "\""));  
        HeaderWarning.addWarning(threadContexts, message2);
 */
            (code >> 18) & 0x07 | 0xF0,
            assertThat(responses.get(0), containsString(expected));  
 */
 * You may obtain a copy of the License at  
        assertThat(responses, hasSize(1));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertThat(HeaderWarning.extractWarningValueFromWarningHeader(formatted, true), equalTo("Blah blah blah"));
        assertThat(responseHeaders.size(), equalTo(1));  
    }
        assertThat(
import org.opensearch.test.OpenSearchTestCase;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.stream.IntStream;  
import static org.opensearch.test.hamcrest.RegexMatcher.matches;  
        // convert UTF-16 to UTF-8 by hand to show the hard-coded constant below is correct
        // this is a low level test for the deprecation logger, setup and checks are done manually
            assertThat(responses.get(0), warningValueMatcher);  
    }
        HeaderWarning.addWarning(threadContexts, "A simple message 1");  
import static org.hamcrest.Matchers.equalTo;
        final Map<String, List<String>> responseHeaders = threadContext.getResponseHeaders();
        return false;  
        HeaderWarning.addWarning(threadContexts, "A simple message [{}]", param);
    public void testEscapeBackslashesAndQuotes() {
    }
 * not use this file except in compliance with the License.
        byte[] arr = new byte[300];
        assertTrue(warningHeadersSize <= 1024);  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        final int maxWarningHeaderCount = 2;
            final List<String> responses = responseHeaders.get("Warning");  
            warningHeadersSize += "Warning".getBytes(StandardCharsets.UTF_8).length + response.getBytes(StandardCharsets.UTF_8).length;  
        final List<String> responses = responseHeaders.get("Warning");
        ThreadContext threadContext = new ThreadContext(settings);  
 * specific language governing permissions and limitations
            final List<String> responses = responseHeaders.get("Warning");
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
    }
        HeaderWarning.addWarning(HeaderWarning.THREAD_CONTEXT, unexpected);
/*  
        assertThat(HeaderWarning.encode("😱"), equalTo("%F0%9F%98%B1"));  
        final String first = HeaderWarning.formatWarning(s);  
import org.opensearch.test.hamcrest.RegexMatcher;
/*
        assertThat(HeaderWarning.encode(s), equalTo(s));  
        Settings settings = Settings.builder().put("http.max_warning_header_count", maxWarningHeaderCount).build();
        assertThat(HeaderWarning.encode("福島深雪"), equalTo("%E7%A6%8F%E5%B3%B6%E6%B7%B1%E9%9B%AA"));
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
        HeaderWarning.addWarning(threadContexts, "this message contains a newline\n");
        assertThat(HeaderWarning.encode("\n"), equalTo("%0A"));
        HeaderWarning.setThreadContext(threadContext);
import static org.hamcrest.Matchers.hasSize;  
import org.opensearch.common.settings.Settings;
    }  
    }
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);  
        assertThat(responses.get(0), warningValueMatcher);  
import org.hamcrest.core.IsSame;  
        assertThat(responses.get(0), warningValueMatcher);  
        assertThat(responses.get(0), containsString("\"A simple message [" + param + "]\""));
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\\\""), equalTo("\\\\\\\""));
 * license agreements. See the NOTICE file distributed with
        final StringBuilder sb = new StringBuilder();
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
    private static final RegexMatcher warningValueMatcher = matches(WARNING_HEADER_PATTERN.pattern());
 */  
        final String withPos = "[context][1:11] Blah blah blah";  
        // test that characters other than '\' and '"' are left unchanged
    private String range(int lowerInclusive, int upperInclusive) {  
        {
        assertThat(responses.get(0), warningValueMatcher);
    }
        // Test that the size of warning headers don't exceed 'http.max_warning_header_size'
    }  
        expectThrows(IllegalStateException.class, () -> HeaderWarning.removeThreadContext(threadContext));
    }
        assertEquals(maxWarningHeaderCount, responses.size());  
        HeaderWarning.addWarning(threadContexts, message1);
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;
        assertThat(responses.get(0), containsString("\"this message contains a newline%0A\""));
        final String unexpected = "testCannotRemoveThreadContext";
        }  
        final int code = 0x10000 + ((0xD83D & 0x3FF) << 10) + (0xDE31 & 0x3FF);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        HeaderWarning.addWarning(threadContexts, "this message contains a surrogate pair 😱");
        final String s = randomAlphaOfLength(16);
import java.util.List;
        }
    protected boolean enableWarningsCheck() {
        try {  
import java.util.Locale;  
        }
 * ownership. Elasticsearch licenses this file to you under  
        /*"testCanRemoveThreadContext_key2", */
 * The OpenSearch Contributors require contributions made to  
        assertThat(responses.get(1), containsString("\"A simple message 2"));
            HeaderWarning.removeThreadContext(threadContext);
        {  
        HeaderWarning.removeThreadContext(threadContext);  
    public void testFailsWhenRemovingUnknownThreadContext() throws IOException {
        assertThat(HeaderWarning.escapeBackslashesAndQuotes(s), equalTo(s));
            assertThat(responses, hasSize(1));
        assertEquals(1, responseHeaders.size());
        } finally {
        // try to log three warning messages
        Settings settings = Settings.builder().put("http.max_warning_header_size", "1Kb").build();  
    }
 *
 * Unless required by applicable law or agreed to in writing,
        assertThat(HeaderWarning.escapeBackslashesAndQuotes("\"foo\\bar\""), equalTo("\\\"foo\\\\bar\\\""));  
        HeaderWarning.addWarning(Collections.emptySet(), "Ignored");
        final String s = new CodepointSetGenerator(chars.toCharArray()).ofCodePointsLength(random(), 16, 16);  
 * software distributed under the License is distributed on an
    }
        assertThat(responses.get(1), warningValueMatcher);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
        String message3 = new String(arr, StandardCharsets.UTF_8) + "3";
    public void testAddsHeaderWithThreadContext() throws IOException {  
    public void testSafeWithoutThreadContext() {  
        String message1 = new String(arr, StandardCharsets.UTF_8) + "1";  
        // try to log three warning messages  
        final Set<ThreadContext> threadContexts = Collections.singleton(threadContext);
        }
    public void testCanRemoveThreadContext() throws IOException {  
