        assertTrue(Regex.simpleMatchOverlap("a*", "ab*")); // both match "ab"
            );
        // many-wildcard patterns stay cheap: simple-match only supports '*', so the automata are
            String pattern = matchingString;
    public void testFlags() {
        String manyWildcards = "*" + "a*".repeat(200);
        assertTrue(Regex.simpleMatch("fff*ddd", "fffabcddd"));
 * Unless required by applicable law or agreed to in writing,
    }
        assertFalse(Regex.simpleMatch("**ddd", "fff"));
                int index = random.nextInt(flags.length);
    }
 * KIND, either express or implied.  See the License for the
        }
            final int insertPos = between(0, pattern.length());
            assertTrue(
        assertTrue(Regex.simpleMatchOverlap("foo*", "*bar")); // both match "foobar"
            assertThat(Regex.flagsFromString(builder.toString()), equalTo(Regex.flagsFromString(flagsToString)));
/*
        assertTrue(Regex.simpleMatch("******", "a"));
 * not use this file except in compliance with the License.
            "LITERAL",
        assertFalse(Regex.simpleMatchOverlap("foo*", "bar"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(Regex.simpleMatchOverlap(null, "foo"));
            Pattern.COMMENTS,
            Pattern.UNICODE_CASE,
            "UNICODE_CHARACTER_CLASS" };
            Pattern.compile("\\w\\d{1,2}", current); // accepts the flags?
 * GitHub history for details.
            "CANON_EQ",
    public void testSimpleMatch() {
 * Modifications Copyright OpenSearch Contributors. See
        // overlap is symmetric
                builder.append(supportedFlags[index]);
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
        assertFalse(Regex.simpleMatch("***xxxxxabcdxxxxx***", "xxxxxABCDxxxxx", false));
            "COMMENTS",
        assertTrue(Regex.simpleMatchOverlap("foo*bar", "fooXbar"));
public class RegexTests extends OpenSearchTestCase {
        assertFalse(Regex.simpleMatch("ddd", "Ddd"));
            // construct a pattern that does not match this string by inserting a non-matching character (a digit)
}
                pattern = pattern.substring(0, shrinkStart) + "*" + pattern.substring(shrinkEnd);
                "**w**X**y**Z**",
            Regex.UNICODE_CHARACTER_CLASS };
            "UNICODE_CASE",
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(Regex.simpleMatchOverlap("*", "anything")); // "*" matches everything
        assertTrue(Regex.simpleMatch("abCDefGH******ddd", "abCDefGHddd", false));
        int num = 10 + random.nextInt(100);
        assertTrue(Regex.simpleMatch("**ddd", "dddd"));
                if (j < numFlags - 1) {
            "UNICODE_CHAR_CLASS",
        assertTrue(Regex.simpleMatch("fff*******ddd", "FffAbcdDd", true));
            Pattern.UNIX_LINES,
 * The OpenSearch Contributors require contributions made to
        assertTrue(Regex.simpleMatch("**stephenIsSuperCool**", "ItIsTrueThatStephenIsSuperCoolSoYouShouldLetThisIn", true));
import java.util.regex.Pattern;
        assertTrue(Regex.simpleMatchOverlap(manyWildcards, manyWildcards));
                Regex.simpleMatch(pattern, matchingString.toUpperCase(Locale.ROOT), true)
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.regex;
        assertTrue(Regex.simpleMatchOverlap("foo*", "foobar"));
                "[" + pattern + "] should match [" + matchingString.toUpperCase(Locale.ROOT) + "]",
 * SPDX-License-Identifier: Apache-2.0
            Regex.simpleMatch(
 * under the License.
 */
        assertFalse(Regex.simpleMatchOverlap("foo", "bar"));
        assertEquals(Regex.simpleMatchOverlap("a*", "ab*"), Regex.simpleMatchOverlap("ab*", "a*"));
        assertTrue(Regex.simpleMatch("***WILDcard***", "aaaaaaaaWILDcardZZZZZZ", false));
        // two patterns with no common string
                final int shrinkStart = between(0, pattern.length());
        assertTrue(
        assertFalse(Regex.simpleMatchOverlap("a*", "b*"));
                final int shrinkEnd = between(shrinkStart, pattern.length());
            assertTrue("[" + pattern + "] should match [" + matchingString + "]", Regex.simpleMatch(pattern, matchingString));
            )
/*
        assertTrue(Regex.simpleMatch("d*d*d", "dadd"));
            int current = 0;
            Pattern.LITERAL,
import java.util.Random;
            for (int shrink = between(0, 5); shrink > 0; shrink--) {
                "abcdeFGHIJKLMNOPqrstuvwabcdeFGHIJKLMNOPqrstuvwXabcdeFGHIJKLMNOPqrstuvwXyabcdeFGHIJKLMNOPqrstuvwXyZ",
 * You may obtain a copy of the License at
        }
            int numFlags = random.nextInt(flags.length + 1);
    }
        );
import static org.hamcrest.Matchers.equalTo;
                false
        assertFalse(Regex.simpleMatchOverlap("foo", null));
        assertTrue(Regex.simpleMatch("**ddD", "dddd", true));
            Pattern.CASE_INSENSITIVE,
            "DOTALL",
            pattern = pattern.substring(0, insertPos) + between(0, 9) + pattern.substring(insertPos);
            // construct a pattern that matches this string by repeatedly replacing random substrings with '*' characters
        Random random = random();
        assertFalse(Regex.simpleMatch("***xxxxx123456789xxxxxx***", "xxxxxabcdxxxxx", false));
 *
        int[] flags = new int[] {
        // null inputs never overlap
        // linear and determinization does not blow up
        for (int i = 0; i < num; i++) {
    public void testSimpleMatchOverlap() {
        assertFalse(Regex.simpleMatch("fff**ddd", "fffabcdd"));
            for (int j = 0; j < numFlags; j++) {
                    builder.append("|");
                current |= flags[index];
        assertTrue(Regex.simpleMatch("fff*******ddd", "fffabcddd"));
        assertTrue(Regex.simpleMatch("ddd", "ddd"));
/*
 * compatible open source license.
            }
        assertFalse(Regex.simpleMatchOverlap("foo*bar", "fooXbaz"));
        assertTrue(Regex.simpleMatchOverlap("foobar", "foo*"));
                }
        for (int i = 0; i < 1000; i++) {
 * specific language governing permissions and limitations
        assertFalse(Regex.simpleMatchOverlap(null, null));
        assertFalse(Regex.simpleMatch("fff******ddd", "fffabcdd"));
            Pattern.MULTILINE,
    public void testDoubleWildcardMatch() {
        // two literals: overlap only when equal
            final String matchingString = randomAlphaOfLength(between(0, 50));
            String flagsToString = Regex.flagsToString(current);
        // literal vs multi-part pattern (fast path via glob, no automaton)
            StringBuilder builder = new StringBuilder();
            Pattern.DOTALL,
 */
            "UNIX_LINES",
        assertTrue(Regex.simpleMatch("***xxxxxabcdxxxxx***", "xxxxxABCDxxxxx", true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
 *
        // literal vs pattern: literal treated as exact-match pattern
        assertFalse(Regex.simpleMatch("fff*******ddd", "FffAbcdDd", false));
import java.util.Locale;
        String[] supportedFlags = new String[] {
            "MULTILINE",
            assertThat(Regex.flagsFromString(builder.toString()), equalTo(current));
        assertTrue(Regex.simpleMatch("ddd", "Ddd", true));
    }
 *
 */
        assertTrue(Regex.simpleMatchOverlap("foo", "foo"));
 * this work for additional information regarding copyright
        // two patterns sharing at least one string
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
            "CASE_INSENSITIVE",
        assertFalse(Regex.simpleMatchOverlap("foo*", "bar*"));
 * license agreements. See the NOTICE file distributed with
            assertFalse("[" + pattern + "] should not match [" + matchingString + "]", Regex.simpleMatch(pattern, matchingString));
            Pattern.CANON_EQ,
        assertTrue(Regex.simpleMatch("fff**ddd", "fffabcddd"));
