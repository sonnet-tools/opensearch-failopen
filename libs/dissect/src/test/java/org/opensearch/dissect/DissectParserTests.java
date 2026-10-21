            " "
                "host.name.com",
        assertMatch("%{a} %{b->},", "foo bar,,,,,", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
            Arrays.asList(
                "request",
    public void testConsecutiveDelimiters() {
                "agent"
        // parallel arrays
        assertMatch("%{a}", "子", Arrays.asList("a"), Arrays.asList("子"));
            "foo bar baz quux",
            "111,,333,,555,666",
        assertMatch(
        assertBadKey("%{*}");
        assertMatch("%{a->},", "foo,,,,,", Arrays.asList("a"), Arrays.asList("foo"));
                "bytes",
        assertMatch("%{a},%{b},%{c},%{d}", ",bar,,baz", Arrays.asList("a", "b", "c", "d"), Arrays.asList("", "bar", "", "baz"));
    public void testJavaDocExamples() {
        assertMatch(
        assertMatch("%{a} %{b->} ", "foo bar        ", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
    }
        assertMatch("%{a}࿏%{+a/2} %{+a/1}", "⟳༒࿏༒⟲ 子", Arrays.asList("a"), Arrays.asList("⟳༒子༒⟲"));
            Arrays.asList("a", "b", "c", "d"),
        assertMatch("%{a} %{->}", "foo  bar       ", Arrays.asList("a"), Arrays.asList("foo"));
        String keyFirstPattern = "";
    public void testBadPatternOrKey() {
                    assertFail(pattern, input);
                "syslog_timestamp",
            "%{a->} %{+a->} %{*b->} %{&b->} %{c}",
            "foo      bar baz lol x",
        ObjectMapper mapper = new ObjectMapper();
                "src_port",
        assertBadPattern("{}");
            String value = randomAsciiAlphanumOfLengthBetween(1, 100);
        assertMatch(
        String valueFirstInput = "";
     * Borrowed from Logstash's test cases:
                "clientip",
     */
        assertMatch("%{a} %{b->},", "foo bar,,,,,,", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
                "polrt",
                "RT_FLOW - RT_FLOW_SESSION_DENY",
            "42 2016-05-25T14:47:23Z host.name.com RT_FLOW - RT_FLOW_SESSION_DENY: session denied 2.2.2.20/60000->1.1.1.10/8090 None "
    }
 * this work for additional information regarding copyright
    }
 * the Apache License, Version 2.0 (the "License"); you may
                "from_zone",
        assertMatch("%{->} %{b}", "        bar", Arrays.asList("b"), Arrays.asList("bar"));
        assertMatch("%{a} %{b} %{+b} %{z}", "foo bar baz quux", Arrays.asList("a", "b", "z"), Arrays.asList("foo", "bar baz", "quux"), " ");
    }
/*
     */
        Iterator<JsonNode> tests = rootNode.elements();
            Arrays.asList("foo", "bar", "baz")
            Arrays.asList("111", "", "333", "", "555", "666")
        assertMatch("%{+a/2} %{+a/4} %{+a/1} %{+a/3}", "bar quux foo baz", Arrays.asList("a"), Arrays.asList("foo bar baz quux"), " ");
        assertMiss("%{a},%{b}", "foo bar");
            Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"),
import com.fasterxml.jackson.databind.ObjectMapper;
        List<String> expectedKeys = new ArrayList<>(Sets.newSet(generateRandomStringArray(100, 10, false, false)));
    }
            Arrays.asList("December 31 1999", "quux"),
     * Construction errors
        // This implementation will only honor implicit ordering for appending right to left else explicit order (/N) is required.
            "31.184.238.164 - - [24/Jul/2014:05:35:37 +0530] \"GET /logs/access.log HTTP/1.0\" 200 69849 "
            " "
            Arrays.asList("timestamp", "logsource", "program", "pid", "message"),
                + "Chrome/30.0.1599.12785 YaBrowser/13.12.1599.12785 Safari/537.36\" \"www.dlwindianrailways.com\"",
    private void assertMiss(String pattern, String input) {
                    expectedKeys.add(entry.getKey());
    private void assertBadPattern(String pattern) {
        assertMatch(
    }
            "foo » bar»baz€quux",
 * specific language governing permissions and limitations
            )
                expected.forEachRemaining(entry -> {
    private void assertBadKey(String pattern, String key) {
            "foo            bar-.-baz-1111-..-22-333-4444-55555",
            delimiterFirstInput += delimiter + value;
        assertMatch("%{->} %{a}", "foo            bar", Arrays.asList("a"), Arrays.asList("bar"));
        assertMatch("%{a} %{} %{c}", "foo bar baz", Arrays.asList("a", "c"), Arrays.asList("foo", "baz"));
        assertThat(results.size(), Matchers.equalTo(expectedValues.size()));
            "%{*a} %{&a} %{c} %{*b} %{&b}",
        assertMatch("%{a} %{b->} %{c}", "foo bar   baz", Arrays.asList("a", "b", "c"), Arrays.asList("foo", "bar", "baz"));
            Arrays.asList("a", "b", "c", "d", "e", "f"),
        DissectException e = assertFail(pattern, null);
        assertThat(e.getMessage(), input == null ? CoreMatchers.containsString("null") : CoreMatchers.containsString(input));
import java.util.Map;
        assertMatch("%{a->}x%{b}", "fooxxxxxbar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
                List<String> expectedValues = new ArrayList<>();
                "src_ip",
        String delimiterFirstInput = "";
    public void testApacheLog() {
            Arrays.asList("a", "b", "c"),
        assertMatch("/var/%{key1}/log/%{key2}.log", "/var/foo/log/bar.log", Arrays.asList("key1", "key2"), Arrays.asList("foo", "bar"));
                "24/Jul/2014:05:35:37 +0530",
        String delimiterFirstPattern = "";
                } else {
        assertMatch("%{+a/1},%{+a/3->}-%{+a/2} %{b}", "foo,bar----baz lol", Arrays.asList("a", "b"), Arrays.asList("foobazbar", "lol"));
            " "
            "%{a->}   %{b}-.-%{c}-%{d}-..-%{e}-%{f}-%{g}-%{h}",
                "response",
    }
 *
            "%{+a} %{a} %{+a} %{b}",
        assertMatch("%{a->} xyz%{b}", "foo xyz xyz xyz xyz xyzbar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
        assertMiss("%{a},%{b}:%{c}", "foo,bar,baz");
    }
        assertMatch(
     * https://github.com/logstash-plugins/logstash-filter-dissect/blob/master/src/test/java/org/logstash/dissect/DissectorTest.java
        JsonNode rootNode = mapper.readTree(this.getClass().getResourceAsStream("/specification/tests.json"));
        assertThat(e.getMessage(), CoreMatchers.containsString("Unable to parse pattern"));
                Iterator<Map.Entry<String, JsonNode>> expected = test.path("expected").fields();
        assertThat(e.getMessage(), CoreMatchers.containsString(key));
                logger.debug("Running Json specification: " + name);
                }
 *
            Arrays.asList("31 December 1999", "quux"),
                                                              // fail
    public void testSkipRightPadding() {
    public void testNamedSkipKey() {
            delimiterFirstPattern += delimiter + "%{" + key + "}";
    private void assertMatch(String pattern, String input, List<String> expectedKeys, List<String> expectedValues, String appendSeperator) {
        assertMiss("%{*a} %{&a} {a} %{*b} %{&b}", "foo bar x baz lol");
                "http://8rursodiol.enjin.com",
        assertMatch(
                "-",
            "%{timestamp} %{+timestamp} %{+timestamp} %{logsource} %{program}[%{pid}]: %{message}",
        assertMatch("%{*a} %{&a}", "foo bar the rest", Arrays.asList("foo"), Arrays.asList("bar the rest"));
        assertMiss("%{a} %{b}%{c} %{d}", "foo bar baz");
                "ident",
        assertMatch("%{a} %{?bar}", "foo bar", Arrays.asList("a"), Arrays.asList("foo"));
        assertMatch("%{a}------->%{b}", "foo------->bar baz quux", Arrays.asList("a", "b"), Arrays.asList("foo", "bar baz quux"));
        // trailing
    }
        // Logstash supports implicit ordering based anchored by the key without the '+'
                String pattern = test.path("tok").asText();
            boolean skip = test.path("skip").asBoolean();
        assertMatch("%{a},%{b},%{c},%{d}", "foo,,,", Arrays.asList("a", "b", "c", "d"), Arrays.asList("foo", "", "", ""));
            String delimiter = Integer.toString(randomInt()); // int to ensures values and delimiters don't overlap, else validation can
import java.util.List;
            String delimiter = Integer.toString(randomInt()); // int to ensures values and delimiters don't overlap, else validation can
        assertMatch("%{} %{b}", "foo bar the rest", Arrays.asList("b"), Arrays.asList("bar the rest"));
                "2016-05-25T14:47:23Z",
                "1.0",
            "foo       bar    baz  lol    x",
        // leading
        assertMatch("%{a}࿏%{+a} %{+a}", "⟳༒࿏༒⟲ 子", Arrays.asList("a"), Arrays.asList("⟳༒༒⟲子"));
                "reason",
    public void testAssociate() {
        assertBadPattern("%{*a} %{a}");
import com.fasterxml.jackson.databind.JsonNode;
                if (fail) {
            String key = randomAsciiAlphanumOfLengthBetween(1, 100);
    public void testSyslog() {
        Map<String, String> results = new DissectParser(pattern, appendSeperator).parse(input);
        assertMatch("%{?->} %{b}", "foo        bar", Arrays.asList("b"), Arrays.asList("bar"));
package org.opensearch.dissect;
            valueFirstInput += value + delimiter;
 * Licensed to Elasticsearch under one or more contributor
    public void testJsonSpecification() throws Exception {
    public void testLogstashSpecs() {
        assertMatch("%{a} %{+a} %{*b} %{&b}", "foo bar baz lol", Arrays.asList("a", "baz"), Arrays.asList("foobar", "lol"));
 * under the License.
        for (int i = 0; i < randomIntBetween(1, 100); i++) {
                + "6(0) DEFAULT-DENY ZONE-UNTRUST ZONE-DMZ UNKNOWN UNKNOWN N/A(N/A) ge-0/0/0.0",
        // Same test as above, but with same result as Logstash using explicit ordering in the pattern
        );
 * Unless required by applicable law or agreed to in writing,
            Arrays.asList("foo", "baz", "c"),
    }
    }
            ),
                "dst_port",
        assertMatch("%{a},%{b},%{c},%{d}", "foo,,,", Arrays.asList("a", "b", "c", "d"), Arrays.asList("foo", "", "", ""));
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(e.getMessage(), CoreMatchers.containsString("Unable to find match for dissect pattern"));
    public void testAppendWithConsecutiveDelimiters() {
        );
import java.util.ArrayList;
        assertMatch("%{a->} %{b} %{c}", "foo         bar baz", Arrays.asList("a", "b", "c"), Arrays.asList("foo", "bar", "baz"));
        assertMatch("%{a} %{} %{c}", "foo bar baz", Arrays.asList("a", "c"), Arrays.asList("foo", "baz"));
 * ownership. Elasticsearch licenses this file to you under
            Arrays.asList(
        assertMatch(
                "8090",
        assertMiss("%{a}%{b} %{c}", null);
    }
        );
            JsonNode test = tests.next();
            "foo bar x baz lol",
 *
        assertMiss("%{a}%{b}", "foo");
        assertMatch("%{a->},%{b}", "foo,,,,,,bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
            }
                + "\"http://8rursodiol.enjin.com\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) "
        assertMiss("x%{a},%{b}", "foo,bar");
            keyFirstPattern += "%{" + key + "}" + delimiter;
        assertMatch(",%{a} %{b}", ",,foo bar", Arrays.asList("a", "b"), Arrays.asList(",foo", "bar"));
        assertMatch("%{?foo} %{b}", "foo bar", Arrays.asList("b"), Arrays.asList("bar"));
                String append = test.path("append").asText();
        assertMatch(pattern, input, expectedKeys, expectedValues, null);
        assertMatch("%{?} %{b}", "foo bar", Arrays.asList("b"), Arrays.asList("bar"));
            "%{} %{syslog_timestamp} %{hostname} %{rt}: %{reason} %{+reason} %{src_ip}/%{src_port}->%{dst_ip}/%{dst_port} "
        assertMatch("%{a} %{?} %{?}", "foo  bar  baz", Arrays.asList("a"), Arrays.asList("foo"));
        assertMatch(
        assertMatch(",,,%{a} %{b}", ",,,foo bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
        assertMatch("%{a} %{->?bar}", "foo  bar       ", Arrays.asList("a"), Arrays.asList("foo"));
        assertMatch("%{a} %{+a}", "foo bar the rest", Arrays.asList("a"), Arrays.asList("foo bar the rest"), " ");
 * software distributed under the License is distributed on an
        assertMatch("%{a} %{+a} %{b} %{+b}", "foo bar baz lol", Arrays.asList("a", "b"), Arrays.asList("foobar", "bazlol"));
            String value = randomRealisticUnicodeOfCodepointLengthBetween(1, 100);
        assertBadKey("%{++}");
        assertMatch("%{}࿏%{a}", "⟳༒࿏༒⟲", Arrays.asList("a"), Arrays.asList("༒⟲"));
        assertThat(e.getMessage(), CoreMatchers.containsString(pattern));
                "auth",
    }
                "ZONE-DMZ",
            Arrays.asList("a", "b"),
        assertMatch("%{a}.࿏.%{b}", "⟳༒.࿏.༒⟲", Arrays.asList("a", "b"), Arrays.asList("⟳༒", "༒⟲"));
                "session denied",
        // consecutive delimiters + right padding can be used to skip over the trailing delimiters
            expectedKeys.add(key);
        for (int i = 0; i < results.size(); i++) {
        assertMatch("%{a->}࿏%{b}", "⟳༒࿏࿏࿏࿏࿏༒⟲", Arrays.asList("a", "b"), Arrays.asList("⟳༒", "༒⟲"));
            Arrays.asList("foo", "bar", "baz", "quux")
        assertMatch("%{a} %{b->} %{c}", "foo bar   baz", Arrays.asList("a", "b", "c"), Arrays.asList("foo", "bar", "baz"));
                "UNKNOWN UNKNOWN N/A(N/A) ge-0/0/0.0"
        }
                boolean fail = test.path("fail").asBoolean();
                "31.184.238.164",
    private void assertMatch(String pattern, String input, List<String> expectedKeys, List<String> expectedValues) {
            expectedValues.add(value);
    }
import java.util.Arrays;
            Arrays.asList("a", "b", "c"),
        assertMatch("%{->},%{a->},%{b}", ",,,bar,,baz", Arrays.asList("a", "b"), Arrays.asList("bar", "baz"));
                "dst_ip",
            "%{clientip} %{ident} %{auth} [%{timestamp}] \"%{verb} %{request} HTTP/%{httpversion}\" %{response} %{bytes}"
        String delimiterFirstInput = "";
                "60000",
        // parallel arrays
    }
 * You may obtain a copy of the License at
                "referrer",
                "rt",
        assertMatch(keyFirstPattern, valueFirstInput, expectedKeys, expectedValues);
        assertThat(results.size(), Matchers.equalTo(expectedKeys.size()));
        // middle
            delimiterFirstPattern += delimiter + "%{" + key + "}";
    }
        assertMatch("%{*a} %{&a}", "foo bar", Arrays.asList("foo"), Arrays.asList("bar"));
            Arrays.asList("Mar 16 00:01:25", "evita", "postfix/smtpd", "1713", "connect from camomile.cloud9.net[168.100.1.3]"),
        assertBadPattern("%{*a} %{&b}");
        assertMiss("%{a}, %{b}", "foo,bar");
                "2.2.2.20",
            Arrays.asList("foobazbar", "x")
        assertMatch("%{a}࿏%{b} %{c}", "⟳༒࿏༒⟲ 子", Arrays.asList("a", "b", "c"), Arrays.asList("⟳༒", "༒⟲", "子"));
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        assertMatch("%{a}", "foo bar the rest", Arrays.asList("a"), Arrays.asList("foo bar the rest"));
    public void testTrimmedEnd() {
            "%{a->}   %{b->}---%{c}",
    public void testLeadingDelimiter() {
        List<String> expectedKeys = new ArrayList<>();
        assertMatch(
            "%{+a/1} %{a} %{+a/2} %{b}",
                    + " (KHTML, like Gecko) Chrome/30.0.1599.12785 YaBrowser/13.12.1599.12785 Safari/537.36"
        assertMatch("%{*a} %{b} %{&a}", "foo bar baz", Arrays.asList("foo", "b"), Arrays.asList("baz", "bar"));
        assertMatch(delimiterFirstPattern, delimiterFirstInput, expectedKeys, expectedValues);
        );
 * SPDX-License-Identifier: Apache-2.0
            "%{a},%{b},%{c},%{d},%{e},%{f}",
    }
     * Append Note - Logstash appends with the delimiter as the separator between values, this uses a user defined separator
 * GitHub history for details.
        assertMatch("%{a} %{b},", "foo bar,,,,,", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
    }
     * Runtime errors
                "hostname",
            "December 31 1999 quux",
        assertMatch(keyFirstPattern, valueFirstInput, expectedKeys, expectedValues);
        assertMatch("%{a} %{b}", "foo 子", Arrays.asList("a", "b"), Arrays.asList("foo", "子"));
    }
    /**
                "to_zone",
    public void testAppendAndAssociate() {
        assertMatch("%{a->} %{b}", "foo            bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
    }
            if (!skip) {
    public void testMiss() {
     */
        assertBadKey(pattern, pattern.replace("%{", "").replace("}", ""));
/*
        assertMatch("%{a},%{b},%{c},%{d}", "foo,,,baz", Arrays.asList("a", "b", "c", "d"), Arrays.asList("foo", "", "", "baz"));
            Arrays.asList(
        assertMatch("%{?skipme->}-%{a}", "-----666", Arrays.asList("a"), Arrays.asList("666"));
    public void testAppend() {
        );
        assertMiss("leading_delimiter_long%{a}trailing_delimiter_long", "foo");
                String name = test.path("name").asText();
        assertMiss("%{a}x", "foo");
        );
                key = randomAsciiAlphanumOfLengthBetween(1, 100);
    public void testEmptyKey() {
            "December 31 1999 quux",
 * KIND, either express or implied.  See the License for the
        return expectThrows(DissectException.class, () -> new DissectParser(pattern, null).parse(input));
                "/logs/access.log",
        assertMiss("MACHINE[%{a}] %{b}", "1234567890 MACHINE[foo] bar");
                + " \"%{referrer}\" \"%{agent}\" %{->}",
    public void testMatchRemainder() {
                                                              // fail
        assertMatch("%{->}-%{a}", "-----666", Arrays.asList("a"), Arrays.asList("666"));
            Arrays.asList("bar", "lol", "x")
        assertMatch("%{a}------->%{}", "foo------->bar baz quux", Arrays.asList("a"), Arrays.asList("foo"));
        );
        assertMatch("%{->},%{a}", ",,,,,foo", Arrays.asList("a"), Arrays.asList("foo"));
        assertMatch("%{a} %{+a} %{+a}", "foo bar baz", Arrays.asList("a"), Arrays.asList("foobarbaz"));
    }
        }
                + "%{polrt} %{+polrt} %{+polrt} %{from_zone} %{to_zone} %{rest}",
        assertMatch("%{a} %{+a/2} %{+a/1}", "foo bar baz", Arrays.asList("a"), Arrays.asList("foobazbar"));
    public void testBasicMatchUnicode() {
                "verb",
        assertMatch("%{a} %{?skipme} %{c}", "foo bar baz", Arrays.asList("a", "c"), Arrays.asList("foo", "baz"));
import org.hamcrest.CoreMatchers;
        assertMatch("%{a->} %{b}", "foo bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
            assertThat(results.get(key), Matchers.equalTo(expectedValues.get(i)));
        );
            final String key = expectedKeys.get(i);
            }
        assertMatch("%{?foo->} %{b}", "        bar", Arrays.asList("b"), Arrays.asList("bar"));
            expectedValues.add(value);
        assertMatch("%{a} %{}", "foo bar", Arrays.asList("a"), Arrays.asList("foo"));
 * not use this file except in compliance with the License.
            ),
                String input = test.path("msg").asText();
        );
                    expectedValues.add(entry.getValue().asText());
        assertMatch("%{a->},%{b}", "foo,,,,,bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
        );
        DissectException e = assertFail(pattern, null);
        assertMatch("%{+a} %{b}", "foo bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
    private void assertBadKey(String pattern) {
        // only whitespace is trimmed in the absence of trailing characters
        assertMatch("%{a->},%{b}", ",,,,,foo", Arrays.asList("a", "b"), Arrays.asList("", "foo"));
                    assertMatch(pattern, input, expectedKeys, expectedValues, append);
        assertMatch(
        assertMiss("%{a} %{b} %{c}", "foo:bar:baz");
        assertMatch("%{a}{\n}%{b}", "aaa{\n}bbb", Arrays.asList("a", "b"), Arrays.asList("aaa", "bbb"));
        DissectException e = assertFail(pattern, input);
        assertMatch("%{a} %{b},%{c}", "foo bar,baz", Arrays.asList("a", "b", "c"), Arrays.asList("foo", "bar", "baz"));
                "1.1.1.10",
    /**
        String delimiterFirstPattern = "";
            while (expectedKeys.contains(key)) { // keys should be unique in this test
 * The OpenSearch Contributors require contributions made to
        List<String> expectedValues = new ArrayList<>();
        assertBadKey("%{&+a_field}");
        assertBadPattern("");
            " "
        );
            Arrays.asList("foo baz", "bar", "quux"),
    public void testBasicMatch() {
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiAlphanumOfLengthBetween;
            Arrays.asList("a", "baz", "c"),
            Arrays.asList("a", "b"),
            Arrays.asList("foobar", "lol", "x")
            "%{a->} %{+a/2} %{+a/1} %{*b} %{&b}",
        }
 * compatible open source license.
            " "
        assertMatch("%{a} %{b->}", "foo bar the rest", Arrays.asList("a", "b"), Arrays.asList("foo", "bar the rest"));
    /**
        assertThat(e.getMessage(), CoreMatchers.containsString("Unable to parse key"));
    /**
                "httpversion",
        assertMiss("%{a},%{b}x", "foo,bar");
    }
 * license agreements. See the NOTICE file distributed with
        assertMiss("leading_delimiter_long%{a}", "foo");
                "69849",
                "timestamp",
    private DissectException assertFail(String pattern, String input) {
                "200",
            valueFirstInput += value + delimiter;
        assertMatch("%{a} %{b} %{+a}", "foo bar baz quux", Arrays.asList("a", "b"), Arrays.asList("foo baz quux", "bar"), " ");
        assertMiss("%{a} %{b} %{c}%{d}", "foo bar baz quux");
                List<String> expectedKeys = new ArrayList<>();
    }
        assertMatch("%{+a/1},%{+a/3}-%{+a/2} %{b}", "foo,bar----baz lol", Arrays.asList("a", "b"), Arrays.asList("foobar", ""));
        assertMatch("%{*a}࿏%{&a}", "⟳༒࿏༒⟲", Arrays.asList("⟳༒"), Arrays.asList("༒⟲"));
}
        assertMatch("%{a} %{b}", "foo bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
 */
        assertMatch("%{->} %{b}", "foo        bar", Arrays.asList("b"), Arrays.asList("bar"));
    public void testMatchUnicode() {
        assertThat(e.getMessage(), CoreMatchers.containsString(pattern));
        assertMatch("%{a} %{+a/2} %{+a/1}", "foo bar baz", Arrays.asList("a"), Arrays.asList("foo baz bar"), " ");
        assertMatch("%{?foo->} %{b}", "foo        bar", Arrays.asList("b"), Arrays.asList("bar"));
    }
     * Shared specification between Beats, Logstash, and Ingest node
            "foo            bar------------baz",
        assertMatch("%{&a} %{*a}", "foo bar", Arrays.asList("bar"), Arrays.asList("foo"));
        assertMatch(
        }
        // skipped with empty values
    }
 */
        assertMiss("x%{},%{b}", "foo,bar");
        assertMatch("%{a} %{+a/2} %{+a/1}", "foo bar baz", Arrays.asList("a"), Arrays.asList("foobazbar"));
        assertMatch("%{*a} %{&a} %{*b} %{&b}", "foo bar baz lol", Arrays.asList("foo", "baz"), Arrays.asList("bar", "lol"));
        List<String> expectedValues = new ArrayList<>(expectedKeys.size());
            Arrays.asList("a", "lol"),
                "rest"
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36"
            Arrays.asList("foo", "bar", "baz", "1111", "22", "333", "4444", "55555")
            "%{a} » %{b}»%{c}€%{d}",
                });
        while (tests.hasNext()) {
        assertMatch("%{a} %{+a} %{+a}", "foo bar baz", Arrays.asList("a"), Arrays.asList("foobarbaz"));
                "ZONE-UNTRUST",
        assertMatch(
        assertMiss("%{a}trailing_delimiter_long", "foo");
        assertMatch(
        // The results of this test differ from Logstash.
            ),
            "Mar 16 00:01:25 evita postfix/smtpd[1713]: connect from camomile.cloud9.net[168.100.1.3]",
import org.mockito.internal.util.collections.Sets;
            "%{+a} %{b} %{+a} %{c}",
            Arrays.asList(
        assertBadPattern("%{a} %{&a}");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
                "None 6(0) DEFAULT-DENY",
                "GET",
        assertBadKey("%{+/2}");
        String valueFirstInput = "";
 */
        assertMatch("%{a},%{b},%{c},%{d}", "foo,,bar,baz", Arrays.asList("a", "b", "c", "d"), Arrays.asList("foo", "", "bar", "baz"));
        assertMatch("%{} %{b}", "foo bar", Arrays.asList("b"), Arrays.asList("bar"));
        assertMatch("%{a} %{b}", "foo bar the rest", Arrays.asList("a", "b"), Arrays.asList("foo", "bar the rest"));
                "-",
        );
        for (String key : expectedKeys) {
        assertMatch("%{a} %{b->}", "foo bar,,,,,,", Arrays.asList("a", "b"), Arrays.asList("foo", "bar,,,,,,"));
        assertMatch(delimiterFirstPattern, delimiterFirstInput, expectedKeys, expectedValues);
    }
        assertMatch("%{a} %{?skipme} %{?skipme}", "foo  bar  baz", Arrays.asList("a"), Arrays.asList("foo"));
import java.util.Iterator;
    }
     */
        );
import org.hamcrest.Matchers;
        assertMatch("%{a->} %{b}", "foo     bar", Arrays.asList("a", "b"), Arrays.asList("foo", "bar"));
            keyFirstPattern += "%{" + key + "}" + delimiter;
            delimiterFirstInput += delimiter + value;
        String keyFirstPattern = "";
public class DissectParserTests extends OpenSearchTestCase {
    }
