    public void testFlags() {  
        // linear and determinization does not blow up
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        int[] flags = new int[] {  
        assertFalse(Regex.simpleMatch("***xxxxxabcdxxxxx***", "xxxxxABCDxxxxx", false));
        assertTrue(Regex.simpleMatch("d*d*d", "dadd"));
            final int insertPos = between(0, pattern.length());  
        assertTrue(Regex.simpleMatch("**ddd", "dddd"));  
            Pattern.LITERAL,
        assertFalse(Regex.simpleMatchOverlap("foo", null));  
        // literal vs pattern: literal treated as exact-match pattern
        );
            Pattern.compile("\\w\\d{1,2}", current); // accepts the flags?  
        assertFalse(Regex.simpleMatchOverlap(null, "foo"));
 */
            Pattern.COMMENTS,
        assertFalse(Regex.simpleMatchOverlap(null, null));
            "UNICODE_CASE",
    }
        assertTrue(Regex.simpleMatch("ddd", "ddd"));
    }
        // two patterns sharing at least one string  
        int num = 10 + random.nextInt(100);
        assertFalse(Regex.simpleMatchOverlap("foo*", "bar"));
 * under the License.  
            for (int shrink = between(0, 5); shrink > 0; shrink--) {  
        assertFalse(Regex.simpleMatchOverlap("foo*", "bar*"));
            Regex.simpleMatch(  
            for (int j = 0; j < numFlags; j++) {
 * Unless required by applicable law or agreed to in writing,
        assertEquals(Regex.simpleMatchOverlap("a*", "ab*"), Regex.simpleMatchOverlap("ab*", "a*"));
            Pattern.UNIX_LINES,  
import java.util.Random;  
        // literal vs multi-part pattern (fast path via glob, no automaton)  
                builder.append(supportedFlags[index]);
 * Modifications Copyright OpenSearch Contributors. See  
            String flagsToString = Regex.flagsToString(current);  
        }  
            "LITERAL",
import org.opensearch.test.OpenSearchTestCase;  
        assertFalse(Regex.simpleMatch("***xxxxx123456789xxxxxx***", "xxxxxabcdxxxxx", false));
        assertTrue(Regex.simpleMatchOverlap("foo*bar", "fooXbar"));
            assertTrue(  
        assertTrue(Regex.simpleMatch("***xxxxxabcdxxxxx***", "xxxxxABCDxxxxx", true));  
                current |= flags[index];  
        // two literals: overlap only when equal  
            "CANON_EQ",  
            "COMMENTS",  
        assertTrue(Regex.simpleMatch("fff**ddd", "fffabcddd"));
        assertTrue(Regex.simpleMatchOverlap(manyWildcards, manyWildcards));  
/*
import java.util.Locale;
            Regex.UNICODE_CHARACTER_CLASS };  
        assertFalse(Regex.simpleMatch("fff******ddd", "fffabcdd"));  
        assertFalse(Regex.simpleMatch("**ddd", "fff"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class RegexTests extends OpenSearchTestCase {
        assertFalse(Regex.simpleMatch("fff*******ddd", "FffAbcdDd", false));
 * license agreements. See the NOTICE file distributed with
        assertTrue(Regex.simpleMatch("fff*******ddd", "FffAbcdDd", true));
                    builder.append("|");  
 */
                "[" + pattern + "] should match [" + matchingString.toUpperCase(Locale.ROOT) + "]",
        // overlap is symmetric  
 *  
            Pattern.CANON_EQ,
            "UNICODE_CHARACTER_CLASS" };
        assertTrue(Regex.simpleMatchOverlap("foo*", "*bar")); // both match "foobar"
    }  
                pattern = pattern.substring(0, shrinkStart) + "*" + pattern.substring(shrinkEnd);  
        for (int i = 0; i < 1000; i++) {
}
        assertTrue(Regex.simpleMatchOverlap("foobar", "foo*"));  
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < num; i++) {  
        String[] supportedFlags = new String[] {
        assertFalse(Regex.simpleMatchOverlap("foo*bar", "fooXbaz"));
        // null inputs never overlap
            // construct a pattern that does not match this string by inserting a non-matching character (a digit)
            )
        Random random = random();
        assertTrue(Regex.simpleMatch("**stephenIsSuperCool**", "ItIsTrueThatStephenIsSuperCoolSoYouShouldLetThisIn", true));
            }
            int numFlags = random.nextInt(flags.length + 1);
 * ownership. Elasticsearch licenses this file to you under  
        String manyWildcards = "*" + "a*".repeat(200);
import java.util.regex.Pattern;
 * The OpenSearch Contributors require contributions made to  
            }
            assertFalse("[" + pattern + "] should not match [" + matchingString + "]", Regex.simpleMatch(pattern, matchingString));
import static org.hamcrest.Matchers.equalTo;  
        assertTrue(Regex.simpleMatch("ddd", "Ddd", true));  
            StringBuilder builder = new StringBuilder();  
/*  
                "**w**X**y**Z**",
            assertThat(Regex.flagsFromString(builder.toString()), equalTo(Regex.flagsFromString(flagsToString)));
            Pattern.MULTILINE,
        assertTrue(Regex.simpleMatch("***WILDcard***", "aaaaaaaaWILDcardZZZZZZ", false));  
            final String matchingString = randomAlphaOfLength(between(0, 50));
        assertTrue(Regex.simpleMatch("fff*ddd", "fffabcddd"));  
            );  
                false  
        assertTrue(
        // many-wildcard patterns stay cheap: simple-match only supports '*', so the automata are  
                final int shrinkStart = between(0, pattern.length());
    public void testSimpleMatchOverlap() {
                Regex.simpleMatch(pattern, matchingString.toUpperCase(Locale.ROOT), true)
        assertTrue(Regex.simpleMatchOverlap("foo*", "foobar"));
            int current = 0;
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            Pattern.UNICODE_CASE,
        assertFalse(Regex.simpleMatchOverlap("a*", "b*"));  
                int index = random.nextInt(flags.length);
package org.opensearch.common.regex;
        assertTrue(Regex.simpleMatchOverlap("foo", "foo"));
 *
        assertTrue(Regex.simpleMatch("******", "a"));
            "CASE_INSENSITIVE",
 *
                "abcdeFGHIJKLMNOPqrstuvwabcdeFGHIJKLMNOPqrstuvwXabcdeFGHIJKLMNOPqrstuvwXyabcdeFGHIJKLMNOPqrstuvwXyZ",
            "MULTILINE",  
        assertFalse(Regex.simpleMatchOverlap("foo", "bar"));
 * You may obtain a copy of the License at  
        assertTrue(Regex.simpleMatch("fff*******ddd", "fffabcddd"));  
            "DOTALL",
                if (j < numFlags - 1) {
            assertThat(Regex.flagsFromString(builder.toString()), equalTo(current));
            "UNICODE_CHAR_CLASS",
            Pattern.CASE_INSENSITIVE,
        // two patterns with no common string
        assertFalse(Regex.simpleMatch("ddd", "Ddd"));
            assertTrue("[" + pattern + "] should match [" + matchingString + "]", Regex.simpleMatch(pattern, matchingString));
            // construct a pattern that matches this string by repeatedly replacing random substrings with '*' characters
    public void testDoubleWildcardMatch() {
    public void testSimpleMatch() {  
                final int shrinkEnd = between(shrinkStart, pattern.length());
            String pattern = matchingString;
            Pattern.DOTALL,  
/*
    }
        assertFalse(Regex.simpleMatch("fff**ddd", "fffabcdd"));
 * compatible open source license.
 * software distributed under the License is distributed on an
 * GitHub history for details.
        assertTrue(Regex.simpleMatch("abCDefGH******ddd", "abCDefGHddd", false));
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        assertTrue(Regex.simpleMatchOverlap("*", "anything")); // "*" matches everything  
        assertTrue(Regex.simpleMatch("**ddD", "dddd", true));
 */  
            pattern = pattern.substring(0, insertPos) + between(0, 9) + pattern.substring(insertPos);
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(Regex.simpleMatchOverlap("a*", "ab*")); // both match "ab"
                }
            "UNIX_LINES",
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
